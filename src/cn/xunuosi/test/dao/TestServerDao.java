package cn.xunuosi.test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.xunuosi.test.pojo.User;
import cn.xunuosi.test.util.I;
import cn.xunuosi.test.util.JdbcUtils;

public class TestServerDao implements ITestServerDao {

	@Override
	public boolean addUser(User user) {
		PreparedStatement statement = null;
		Connection connection = JdbcUtils.getConnection();
		try {
			String sql = "insert into " + I.User.TABLE_NAME + "(" + I.User.USER_NAME + "," + I.User.PASSWORD + ")values(?,?)";
			System.out.println("addUser:"+sql);
			statement = connection.prepareStatement(sql);
			statement.setString(1, user.getUsername());
			statement.setString(2, user.getPassword());
			statement.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			JdbcUtils.closeAll(null, statement, connection);
		}
	}

	@Override
	public User findUserByName(String username) {
		ResultSet set = null;
		PreparedStatement statement = null;
		Connection connection = JdbcUtils.getConnection();
		try {
			String sql = "select * from " + I.User.TABLE_NAME + " where " + I.User.USER_NAME + "=?";
			System.out.println("findUserByName:"+sql);
			statement = connection.prepareStatement(sql);
			statement.setString(1, username);
			set = statement.executeQuery();
			if (set.next()) {
				User user = new User();
				user.setPassword(set.getString(I.User.PASSWORD));
				return user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.closeAll(null, statement, connection);
		}
		return null;
	}

}
