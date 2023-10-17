package common;

import java.sql.*;

public class DBService { 
    // JDBC Setting
    private String jdbcDriver  ;
    private String jdbcUrl     ;
    private String jdbcUserID  ;
    private String jdbcPassword;
    private int    initNumConnection;
    private int    maxNumConnection;

    private static ConnectionPool connectionPool;
    
    public DBService(String driver, String url, String user, String pwd, int initCon, int maxCon) {
        jdbcDriver        = driver;
        jdbcUrl           = url;
        jdbcUserID        = user;
        jdbcPassword      = pwd;
        initNumConnection = initCon;
        maxNumConnection  = maxCon;

        System.out.println("1. JDBC Driver Loading");

        try {
            Class.forName(jdbcDriver);
        } catch(Exception e) {
            System.out.println("__ Loading Fail: " + e.getMessage());
        }
    }
    
    public void startServer() {
        System.out.println("2. Connection Pool Init");
        
        try {
            connectionPool = new ConnectionPool(
                            jdbcUrl, jdbcUserID,  jdbcPassword, 
                            initNumConnection, maxNumConnection, 
                            true, 10000
                        );
        } catch(Exception e) {
            System.out.println("__ Pool Init Fail: " + e.getMessage());
        }
    }
    
    public void stopServer()  {
        System.out.println("#### Connection Pool Destruction");
        
        try {
            connectionPool.closeAll();
        } catch(Exception e) {
            System.out.println("#### Connection Pool Destruction Fail: " + e.getMessage());
        }
    }
    
    public static Connection getConnection() {
        try {            
            return connectionPool.getConnection();
        } catch(Exception e) {
            System.out.println("#### NO Connections: " + e.getMessage());
        }       
    
        return null;
    }

    public static void releaseConnection(Connection conn) {
        try{
            connectionPool.releaseConnection(conn);
        } catch(Exception e) {
            System.out.println("#### Connection Release Fail: " + e.getMessage());
        }
    }
}

    
