package common;

import javax.servlet.ServletContextListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContext;

public class InitializeConnectionPool implements ServletContextListener {
    DBService pool = null;

    public void contextInitialized(ServletContextEvent sce)  {
        ServletContext context = sce.getServletContext();

        System.out.println("\n##### ["+ context.getInitParameter("SystemName") +"] Initial Parameter Reading");

        String jdbcDriver = context.getInitParameter("jdbcDriver");
        String jdbcURL = context.getInitParameter("jdbcURL");
        String jdbcUserID = context.getInitParameter("jdbcUserID");
        String jdbcPassword = context.getInitParameter("jdbcPassword");
        int    initNumConnection = getInitNumConnection(context);
        int    maxNumConnection = getMaxNumConnection(context);

        System.out.println("\n##### Connection Pool Init \n");

        pool = new DBService(jdbcDriver, jdbcURL, jdbcUserID, jdbcPassword, initNumConnection, maxNumConnection);
        pool.startServer();

        System.out.println("\n##### Connection Pool Started \n");
    }
    
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("\n##### Connection Pool will be Stopped \n");

        pool.stopServer();

        System.out.println("\n##### Connection Pool Stopped \n");
    }
    
    private int getInitNumConnection(ServletContext context) {
        System.out.print("##### getInitNumConnection: ");
        String s = context.getInitParameter("initNumConnection");
        
        int result=0;
        
        try {
            int i = Integer.parseInt(s);
            
            if(i < 0) {
                throw new Exception("Number of Connection should be >= 0");
            }
            
            result = i;
            
            System.out.println("OK");
        } catch(Exception e) {
            System.out.println("FAIL - "+ e.getMessage());
        }
        
        return result;
    }
    
    private int getMaxNumConnection(ServletContext context) {
        System.out.print("##### getMaxNumConnection: ");
        String s = context.getInitParameter("maxNumConnection");
        
        int result=0;
        
        try {
            int i = Integer.parseInt(s);
            
            if(i < 0) {
                throw new Exception("Number of Connection should be >= 0");
            }
            
            result = i;
            
            System.out.println("OK");
        } catch(Exception e) {
            System.out.println("FAIL - "+ e.getMessage());
        }
        
        return result;
    }
}
