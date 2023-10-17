
package chap06;

import javax.servlet.*;

public class ProductListListener implements ServletContextListener {

    public void contextInitialized( ServletContextEvent sce ) {

        ServletContext context = sce.getServletContext();
        context.setAttribute( "product1", "냉장고" );
        context.setAttribute( "product2", "세탁기" );
        context.setAttribute( "product3", "전자렌지" );

        String str = context.getInitParameter( "myName" );
        context.setAttribute( "myName", str );

        System.out.println( "ProductListListener.." );
        System.out.println( "contextInit메소드가 수행되었음" );
    }

    public void contextDestroyed( ServletContextEvent sce ) {

    }
}
