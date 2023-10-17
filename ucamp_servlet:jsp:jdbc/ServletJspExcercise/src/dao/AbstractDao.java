/*------------------------------------------------------------------------------
 * Name : AbstractDao
 * DESC : DBService�κ��� DB Connect�� ������ ��ȯ�ϴ� ���� �⺻���� ��ɵ��� ��Ƶ� Dao Ŭ����
 * VER  : 1.0
 * PROJ : VCC SE Path
 * Copyright 2008 LG CNS All rights reserved
 *------------------------------------------------------------------------------
 *                   ��        ��        ��        ��
 *------------------------------------------------------------------------------
 *     DATE      AUTHOR                       DESCRIPTION
 *-------------  --------  ----------------------------------------------------- 
 * 2008. 01. 01.  ������п�   Ver1.0 �ۼ�
 *----------------------------------------------------------------------------*/

package dao;

import java.sql.*;

import common.DBService;

/**
 * <PRE>
 * 
 * DBService�κ��� DB Connect�� ������ ��ȯ�ϴ� ���� �⺻���� ��ɵ��� ��Ƶ� Dao Ŭ����
 * 
 * </PRE>
 * 
 * @author LG CNS ������п�.
 * @version 1.0, 2006/01/01
 */
public abstract class AbstractDao {

    protected Connection conn;

    /**
     * DBService�� �̿��Ͽ�, Connection ��ü�� ���´�.
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
     * DB�� Connect�Ǿ����� ���θ� Return �Ѵ�.
     *  
     * @return DB�� Connect �Ǿ����� ����.
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
     * ��� attribute�� conn�� �̿��Ͽ� ���� ����� �ִ� Connection ��ü�� Return �Ѵ�.
     * 
     * @return Connection ��ü.
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
     * Connection ��ü�� �ý��ۿ� ��ȯ�Ѵ�.
     */
    public void releaseConnection() {

        if ( isConnected() ) {
            DBService.releaseConnection( conn );
            System.out.println( "[DBWrapper.releaseConnection] : DB Successfully Released!" );
        }
    }

    /**
     * Statement�� Close �Ѵ�.
     * 
     * @param stmt Statement ��ü.
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
     * ResultSet�� Close �Ѵ�.
     * 
     * @param result ResultSet ��ü.
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
     * ���ݱ����� Ʈ������� Commit ó���Ѵ�.
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
     * ���ݱ����� Ʈ������� Rollback ó�Ѵ�.
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
