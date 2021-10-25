package com.fastcampus.biz.board;

import com.fastcampus.biz.common.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateBoardClient {
    public static void main(String[] args) {
        // DAO 생성한다.
        BoardVO vo = new BoardVO();
        BoardDAO boardDAO = new BoardDAO();

        // 글 업데이트 요청
        vo.setTitle("낭만");
        vo.setContent("고냥이");
        vo.setSeq(4);
        boardDAO.updateBoard(vo);

        // 글 목록을 조회한다.
        boardDAO.getBoard(vo);

//        // JDBC 관련 변수 선언
//        Connection conn = null;
//        PreparedStatement stmt = null;
//
//        try {
//            // 1단계: Connection 연결
//            conn = JDBCUtil.getConnection();
//
//            // 2단계 : Statement 생성
//            String sql = "update board set title = ?, content = ? where seq = ?";
//            stmt = conn.prepareStatement(sql);
//
//            // ?(파라미터)에 값을 동적으로 할당한다.
//            stmt.setString(1, "--제목 수정");
//            stmt.setString(2, "--작성자 수정");
//            stmt.setInt(3, 4);
//
//            // 3단계 : SQL 전송
//            int count = stmt.executeUpdate();
//            System.out.println(count + "건의 데이터 처리 성공!!!");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            // 4단계 : Connection 종료
//            JDBCUtil.close(stmt, conn);
//        }

    }
}
