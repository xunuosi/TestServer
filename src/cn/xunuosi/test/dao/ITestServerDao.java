package cn.xunuosi.test.dao;

import cn.xunuosi.test.pojo.User;

public interface ITestServerDao {
	boolean addUser(User user);

	User findUserByName(String username);
}
