package com.fastcampus.biz.board;

import com.fastcampus.biz.common.JDBCUtil;

import java.sql.*;

public class DeleteBoardClient {
    public static void main(String[] args) {
        // DAO 생성한다.
        BoardVO vo = new BoardVO();
        BoardDAO boardDAO = new BoardDAO();

        //글 삭제를 요청한다.
        vo.setSeq(7);
        boardDAO.deleteBoard(vo);

        // 글 목록을 조회한다.
        boardDAO.getBoardList(vo);

//        // JDBC 관련 변수 선언
//        Connection conn = null;
//        PreparedStatement stmt = null;
//
//        try {
//            // JDBC 1단계: 드라이버 로딩
//            // JDBC 2단계 : Connection 연결(획득) : Connection은 고속도로다.
//            conn = JDBCUtil.getConnection();
//
//            //JDBC 3단계 : Statement 생성 : Statement는 고속버스다.
//            String sql = "delete board where seq = ?";
//            stmt = conn.prepareStatement(sql);
//            // ?(파라미터) 값 설정A
//            stmt.setInt(1, 3);
//            // JDBC 4단계 : SQL(승객) 전송
//            int count = stmt.executeUpdate();
//            System.out.println(count + "건의 데이터 처리 성공!!!");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            //JDBC 5단계 : Connection 종료
//            JDBCUtil.close(stmt, conn);
//        }

    }
}
