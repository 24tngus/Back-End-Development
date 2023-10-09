/*------------------------------------------------------------------------------
 * Name : AbstractDao
 * DESC : DBService로부터 DB Connect을 얻어오고 반환하는 등의 기본적인 기능들을 모아둔 Dao 클래스
 * VER  : 1.0
 * PROJ : VCC SE Path
 * Copyright 2008 LG CNS All rights reserved
 *------------------------------------------------------------------------------
 *                   변        경        사        항
 *------------------------------------------------------------------------------
 *     DATE      AUTHOR                       DESCRIPTION
 *-------------  --------  ----------------------------------------------------- 
 * 2008. 01. 01.  기술대학원   Ver1.0 작성
 *----------------------------------------------------------------------------*/

package dao;

import java.sql.*;

import common.DBService;

/**
 * <PRE>
 * 
 * DBService로부터 DB Connect을 얻어오고 반환하는 등의 기본적인 기능들을 모아둔 Dao 클래스
 * 
 * </PRE>
 * 
 * @author LG CNS 기술대학원.
 * @version 1.0, 2006/01/01
 */
public abstract class AbstractDao {

    protected Connection conn;

    /**
     * DBService를 이용하여, Connection 객체를 얻어온다.
     */
    public AbstractDao() {

        try {
            conn = DBService.getConnection();
            conn.setAutoCommit( false );
        } catch ( SQLException e ) {
            System.out.println( "[DBWrapper.openConnection] : " + e.getMessage() );
            e.printStackTrace();
        }
    }

    /**
     * DB와 Connect되었는지 여부를 Return 한다.
     *  
     * @return DB와 Connect 되었는지 여부.
     */
    public boolean isConnected() {

        boolean validConnection = true;

        try {
            if ( conn == null || conn.isClosed() )
                validConnection = false;
        } catch ( SQLException e ) {
            validConnection = false;
            e.printStackTrace();
        }
        return validConnection;
    }

    /**
     * 멤버 attribute인 conn을 이용하여 현재 얻어져 있는 Connection 객체를 Return 한다.
     * 
     * @return Connection 객체.
     */
    public Connection getConnection() {

        if ( isConnected() )
            return conn;
        else {
            System.out.println( "[DBWrapper.getConnection] : conn is null!" );
            return null;
        }
    }

    /**
     * Connection 객체를 시스템에 반환한다.
     */
    public void releaseConnection() {

        if ( isConnected() ) {
            DBService.releaseConnection( conn );
            System.out.println( "[DBWrapper.releaseConnection] : DB Successfully Released!" );
        }
    }

    /**
     * Statement를 Close 한다.
     * 
     * @param stmt Statement 객체.
     */
    public void closeStatement( Statement stmt ) {

        try {
            if ( stmt != null )
                stmt.close();
        } catch ( SQLException e ) {
            e.printStackTrace();
        }
    }

    /**
     * ResultSet을 Close 한다.
     * 
     * @param result ResultSet 객체.
     */
    public void closeResultSet( ResultSet rset ) {

        try {
            if ( rset != null )
                rset.close();
        } catch ( SQLException e ) {
            e.printStackTrace();
        }
    }

    /**
     * 지금까지의 트랜잭션을 Commit 처리한다.
     */
    public void commit() {

        try {
            if ( isConnected() ) {
                conn.commit();
                System.out.println( "[DBWrapper.commit] : DB Successfully Committed!" );
            }
        } catch ( SQLException e ) {
            e.printStackTrace();
        }
    }

    /**
     * 지금까지의 트랜잭션을 Rollback 처한다.
     */
    public void rollback() {

        try {
            if ( isConnected() ) {
                conn.rollback();
                System.out.println( "[DBWrapper.rollback] : DB Successfully Rollbacked!" );
            }
        } catch ( SQLException e ) {
            e.printStackTrace();
        }
    }
}
