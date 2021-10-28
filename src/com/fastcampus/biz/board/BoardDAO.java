package com.fastcampus.biz.board;

import com.fastcampus.biz.common.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// DAO(Data Access Object) 클래스 : 실질적인 DB 연동을 담당하는 클래스
public class BoardDAO {
    //JDBC 관련 변수 선언
    private Connection conn;
    private PreparedStatement stmt;
    private ResultSet rs;

    // BOARD 관련 SQL 명령어들
    private final String BOARD_INSERT = "insert into board(seq, title, writer, content)" +
            "values((select nvl(max(seq), 0)+ 1 from board), ?, ?, ?)";
    private final String BOARD_UPDATE = "update board set title = ?, content = ? where seq = ?";
    private final String BOARD_DELETE = "delete board where seq = ?";
    private final String BOARD_GET = "select * from board where seq = ? ";
    private final String BOARD_LIST = "select * from board order by seq desc ";

    // BOARD 관련 CRUD 메소드 구현
    // 글 등록
    public void insertBoard(BoardVO vo) {
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(BOARD_INSERT);
            stmt.setString(1, vo.getTitle());
            stmt.setString(2, vo.getWriter());
            stmt.setString(3, vo.getContent());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(stmt, conn);
        }

    }

    // 글 수정
    public void updateBoard(BoardVO vo) {

        try {
            conn = JDBCUtil.getConnection();

            stmt = conn.prepareStatement(BOARD_UPDATE);

            stmt.setString(1, vo.getTitle());
            stmt.setString(2, vo.getContent());
            stmt.setInt(3, vo.getSeq());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(stmt, conn);
        }
    }

    // 글 삭제
    public void deleteBoard(BoardVO vo) {
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(BOARD_DELETE);
            stmt.setInt(1, vo.getSeq());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(stmt, conn);
        }
    }

    // 글 상세조회
    public void getBoard(BoardVO vo) {
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(BOARD_GET);
            stmt.setInt(1, vo.getSeq());
            rs = stmt.executeQuery();

            if (rs.next()) {
                System.out.println("번호 : " + rs.getInt("SEQ"));
                System.out.println("제목 : " + rs.getString("TITLE"));
                System.out.println("작성자 : " + rs.getString("WRITER"));
                System.out.println("내용 : " + rs.getString("CONTENT"));
                System.out.println("등록일 : " + rs.getDate("REGDATE"));
                System.out.println("조회수 : " + rs.getInt("CNT"));
            } else {
                System.out.println(vo.getSeq() + "번 게시글은 존재하지 않습니다.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, stmt, conn);
        }

    }

    //글 목록 검색
    public List<BoardVO> getBoardList(BoardVO vo) {
        List<BoardVO> boardList = new ArrayList<BoardVO>();
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(BOARD_LIST);
            rs = stmt.executeQuery();
            while (rs.next()) {
                BoardVO board = new BoardVO();
                board.setSeq(rs.getInt("SEQ"));
                board.setTitle(rs.getString("TITLE"));
                board.setWriter(rs.getString("WRITER"));
                board.setContent(rs.getString("CONTENT"));
                board.setRegDate(rs.getDate("REGDATE"));
                board.setCnt(rs.getInt("CNT"));
                boardList.add(board);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, stmt, conn);
        }
        return boardList;
    }
}
