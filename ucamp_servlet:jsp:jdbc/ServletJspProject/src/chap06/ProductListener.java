
package chap06;

import javax.servlet.*;
/**
 * @author 기술대학원 
 *
 */
public class ProductListener implements ServletContextListener {
    
    public void contextInitialized( ServletContextEvent sce ) {
        ServletContext context = sce.getServletContext();
        
        String str = context.getInitParameter( "myName" );
        context.setAttribute( "myName", str );
      
        context.setAttribute( "product1", "냉장고2" );   
        context.setAttribute( "product2", "세탁기" );
        context.setAttribute( "product3", "전자렌지" );   
        
        System.out.println( "ProductListener.." );
        System.out.println( "context가 시작되었습니다.." );   
        System.out.println( "myName is " +  (String)context.getAttribute( "myName" ) );  
  }     
  public void contextDestroyed( ServletContextEvent sce ) {
        System.out.println( "context가 종료되었습니다.." );
 }   
}

