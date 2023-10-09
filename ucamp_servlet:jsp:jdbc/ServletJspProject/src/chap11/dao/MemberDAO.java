package chap11.dao;

import chap11.entity.Member;
import common.DBService;
import java.sql.*;

public class MemberDAO {
    public boolean insertMember(Member member) {
        boolean result = false;
        int rowcnt = 0;
        Connection conn = null;
        Statement stmt = null;

        // 1. Connection Pool에서 connection 얻기
        conn = DBService.getConnection();
        try {          
            //2. Statememt 객체 생성하기
            stmt = conn.createStatement();
            
            //3. Query 작성
            String query = "INSERT INTO CS_MEMBER VALUES('" + 
                           member.getTfMemberID() + "','" + 
                           member.getTfName() + "','" +
                           member.getTfPassword() + "','" + 
                           member.getTfAddress() + "','" + 
                           member.getTfPhone()  + "','" + 
                           member.getSelPasswordQuestion() + "','" +
                           member.getTfPasswordAnswer() + "','" + 
                           member.getRdMarriage() + "','" +
                           member.getChkHobby()   + "','" + 
                           member.getEtc() +"')";
            
            //4. SQL문전송하기
            rowcnt =  stmt.executeUpdate( query );
            
            //5. 결과 처리 
            if ( rowcnt > 0 )
                result = true;
            else
                System.out.println ( "insert시 에러발생" );   
         
        }
        catch( Exception e ) {
            System.out.println( e );
        }
        finally {
            // 6. Statement close
            if ( stmt != null ) {
                try {
                    stmt.close();
                } catch ( SQLException e ) {
                    e.printStackTrace();
                }
            } 
            //7. DBService에게 connection 반환하기
            DBService.releaseConnection( conn );
        }
        
        return result;
    }
}
