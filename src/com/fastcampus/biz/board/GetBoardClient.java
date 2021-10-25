package com.fastcampus.biz.board;

import com.fastcampus.biz.common.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetBoardClient {
    //명령행 매개변수를 받아서 해당 게시글의 상세 정보를 출력하는 프로그램
    public static void main(String[] args) {
        // DAO 생성한다.
        BoardVO vo = new BoardVO();
        BoardDAO boardDAO = new BoardDAO();
        // 글 조회
        vo.setSeq(6);
        boardDAO.getBoard(vo);

//        // JDBC 관련 변수 선언
//        Connection conn = null;
//        PreparedStatement stmt = null;
//        ResultSet rs = null;
//
//        try {
//            // 1단계: Connection 연결
//            conn = JDBCUtil.getConnection();
//
//            // 2단계 : Statement 생성
//            String sql = "select * from board where seq = ? ";
//            stmt = conn.prepareStatement(sql);
//
//            // ?값 설정
//            stmt.setInt(1, Integer.parseInt(args[0]));
//
//            // 3단계 : SQL 전송
//            rs = stmt.executeQuery();
//
//            // 4단계 : 검색 결과 처리
//
//            if (rs.next()) {
//                System.out.println("번호 : " + rs.getInt("SEQ"));
//                System.out.println("제목 : " + rs.getString("TITLE"));
//                System.out.println("작성자 : " + rs.getString("WRITER"));
//                System.out.println("내용 : " + rs.getString("CONTENT"));
//                System.out.println("등록일 : " + rs.getDate("REGDATE"));
//                System.out.println("조회수 : " + rs.getInt("CNT"));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            //5단계 : Connection 종료
//            JDBCUtil.close(rs, stmt, conn);
//        }

    }
}
