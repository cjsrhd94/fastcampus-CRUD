package com.fastcampus.biz.board;

import com.fastcampus.biz.common.JDBCUtil;

import java.sql.*;

public class InsertBoardClient {
    public static void main(String[] args) {
        // JDBC 관련 변수 선언
        // Connection과 Statement는 인터페이스다. 우리는 코드를 통해 JDBC API와 통신을 하고, (= JDBC는 DBMS에 비종속적이다.)
        // API는 해당 DB jar파일내의 driver와 통신을 한다. driver는 DBMS와 통신을 하여 데이터에 접근한다.
        Connection conn = null;
        PreparedStatement stmt = null;

        try{
            // JDBC 1단계: 드라이버 로딩
            // JDBC 2단계 : Connection 연결(획득) : Connection은 고속도로다.
            conn = JDBCUtil.getConnection();

            //JDBC 3단계 : Statement 생성 : Statement는 고속버스다.
            String sql = "insert into board(seq, title, writer, content)" +
                    "values((select nvl(max(seq), 0)+ 1 from board), ?, ?, ?)";
            stmt = conn.prepareStatement(sql);

            // ?(파라미터)에 값을 동적으로 할당한다.
            stmt.setString(1, "JDBC테스트");
            stmt.setString(2, "김광현");
            stmt.setString(3, "테스트중");

            // JDBC 4단계 : SQL(승객) 전송
            // executeUpdate
            int count = stmt.executeUpdate();
            System.out.println(count + "건의 데이터 처리 성공!!!");
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            //JDBC 5단계 : Connection 종료
            // 고속버스 먼저 없애고, 고속도로를 없애야 한다.
            try{
                stmt.close();
            } catch (SQLException e){
                e.printStackTrace();
            } finally {
                stmt = null;
            }

            try{
                conn.close();
            } catch (SQLException e){
                e.printStackTrace();
            } finally {
                conn = null;
            }
        }

    }
}
