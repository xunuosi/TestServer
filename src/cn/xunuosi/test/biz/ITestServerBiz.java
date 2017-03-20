package cn.xunuosi.test.biz;

import javax.servlet.http.HttpServletRequest;

import cn.xunuosi.test.bean.Result;
import cn.xunuosi.test.pojo.User;

public interface ITestServerBiz {
	Result register(User user,HttpServletRequest request);

	Result login(User user, HttpServletRequest request);
}
