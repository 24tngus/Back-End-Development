package myspring.di.strategy1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import myspring.di.strategy1.dao.UserDao;
import myspring.user.vo.UserVO;

public class UserServiceImpl implements UserService {
	UserDao userdao;	

	// setter
	public void setUserDao(UserDao dao) {
		this.userdao = dao;
	}
	
	public List<UserVO> getUserList() {
		return userdao.readAll();
	}
	
	@Override
	public UserVO getUser(int index) {
		return userdao.read(index);
	}
	
}
