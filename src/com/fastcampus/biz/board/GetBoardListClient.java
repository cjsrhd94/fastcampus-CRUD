package com.fastcampus.biz.board;

import java.util.List;

public class GetBoardListClient {
    public static void main(String[] args) {
        // DAO 생성한다.
        BoardDAO boardDAO = new BoardDAO();
        BoardVO vo = new BoardVO();

        // 글 목록을 조회한다.
        List<BoardVO> boardList = boardDAO.getBoardList(vo);

        //CASE - 1
        System.out.println(boardList.size() + "건의 데이터가 검색됨");

        //CASE - 2
        System.out.println("게시글 목록");
        for (BoardVO boardVO: boardList){
            System.out.println("---> " + boardVO.toString());
        }

        //CASE - 3
        System.out.println("게시글 목록");
        for (BoardVO board : boardList){
            System.out.println(board.getSeq() + " : " + board.getTitle());
        }
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
//            String sql = "select * from board order by seq desc ";
//            stmt = conn.prepareStatement(sql);
//
//            // 3단계 : SQL 전송
//            rs = stmt.executeQuery();
//
//            // 4단계 : 검색 결과 처리
//            while (rs.next()) {
//                System.out.print(rs.getInt("SEQ") + " : ");
//                System.out.print(rs.getString("TITLE") + " : ");
//                System.out.print(rs.getString("WRITER") + " : ");
//                System.out.print(rs.getString("CONTENT") + " : ");
//                System.out.print(rs.getDate("REGDATE") + " : ");
//                System.out.println(rs.getInt("CNT"));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            //5단계 : Connection 종료
//            JDBCUtil.close(rs, stmt, conn);
//        }

    }
}
