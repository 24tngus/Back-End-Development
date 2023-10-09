package chap12.dao;


import java.sql.*;

import common.DBService;

import chap12.entity.Member;


public class MemberDAO {
    public boolean insertMember(Member member) {
        boolean result = false;
        
        //2. DBService에게 connection 얻기
        Connection conn = DBService.getConnection();
             
        try {          
            //3. Statememt 객체 생성하기
            Statement stmt = conn.createStatement();
            
            //4. SQL문전송하기
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
            
            int rowcnt =  stmt.executeUpdate( query );
            
            //5. 결과 보기 
            if ( rowcnt > 0 )
                result = true;
            else
                System.out.println ( "insert시 에러발생" );   
              
            stmt.close();
         
        }
        catch( Exception e )
        {
            System.out.println( e );
        }
        finally
        {
            //6. DBService에게 connection 반환하기
            DBService.releaseConnection( conn );
        }
        
        return result;
    }
}
