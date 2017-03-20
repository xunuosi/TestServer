package cn.xunuosi.test.util;

public interface I {
	int MSG_SUCCESS = 0;
	int MSG_ACCOUNT_ERROR = 1;
	int MSG_PASSWORD_ERROR = 2;
	int MSG_ACCOUNT_REPEAT_ERROR = 3;
	
	public static interface User {
		String TABLE_NAME							=		"t_testserver_user";
		String USER_NAME 							= 		"m_user_name";					//用户账号
		String PASSWORD 							= 		"m_user_password";				//用户密码
	}
}
