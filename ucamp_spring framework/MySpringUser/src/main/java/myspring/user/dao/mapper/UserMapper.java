package myspring.user.dao.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import myspring.user.vo.UserVO;

public interface UserMapper {
	//@Select("select * from users where userid=#{id}")
	//UserVO selectUserById(@Param("id") String id);
	
	// UserMapper.xml과 UserMapper 인터페이스의 메서드명 일치시키기 
	// UserMapper 인터페이스가 있을 경우 xml이 수정될 때마다 업데이트 필요 
	// UserMapeer과 SqlSession 부르기 위해 연결하기 위한 설정 필요 
	UserVO selectUserById(String id);
	List<UserVO> selectUserList();
	void insertUser(UserVO userVO);
	void updateUser(UserVO userVO);
	void deleteUser(String id);
}

