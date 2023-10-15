package myspring.user;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import myspring.user.dao.mapper.UserMapper;
import myspring.user.service.UserService;
import myspring.user.vo.UserVO;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:spring-beans-user.xml")
public class UserDBTest {
	@Autowired
	DataSource dataSource;
	
	@Autowired
	SqlSessionFactory sessionFactory;
	
	@Autowired
	SqlSession sqlSession;
	
	@Autowired
	UserMapper userMapper;
	
	@Autowired
	UserService userService;
	
	@Test
	public void service() {
		UserVO user = userService.getUser("dooly");
		System.out.println(user);
	}
	
	@Test @Disabled
	public void mapper() {
		// id가 메서드 이름이 되어 argument 전달 
		UserVO user = userMapper.selectUserById("dooly"); 
		System.out.println(user);
	}
	
	@Test @Disabled
	public void session() {
		// mapper인터페이스를 사용하지 않아 sqlsession의 메서드의 인자에 문자열로 namespace.SQL id 입력 
		UserVO user = sqlSession.selectOne("userNS.selectUserById", "dooly");
		System.out.println(user);
	}
	
	@Test
	public void sessionFactory() {
		System.out.println(sessionFactory.getClass().getName()); // injection 잘 되었는지 확인 org.apache.ibatis.session.defaults.DefaultSqlSessionFactory

	}
	
	@Test
	public void conn() {
		try {
			Connection connection = dataSource.getConnection();
			DatabaseMetaData metaData = connection.getMetaData();
			System.out.println("DB Product Name : " + metaData.getDatabaseProductName()); //MariaDB
			System.out.println("DB Driver : " + metaData.getDriverName()); // MariaDB Connector/J
			System.out.println("DB URL : " + metaData.getURL()); // jdbc:mariadb://127.0.0.1/boot_db?user=boot&password=***&...
			System.out.println("DB Username : " + metaData.getUserName()); // boot
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} // conn
	
}
