package cn.xunuosi.test.biz;

import javax.servlet.http.HttpServletRequest;

import cn.xunuosi.test.bean.Result;
import cn.xunuosi.test.dao.ITestServerDao;
import cn.xunuosi.test.dao.TestServerDao;
import cn.xunuosi.test.pojo.User;
import cn.xunuosi.test.util.I;

public class TestServerBiz implements ITestServerBiz {
	private ITestServerDao dao;
	
	public TestServerBiz() {
		dao = new TestServerDao();
	}
	@Override
	public Result register(User user, HttpServletRequest request) {
		Result res = new Result();
		User u = dao.findUserByName(user.getUsername());
		if (u == null) {
			if (dao.addUser(user)) {
				res.setResCode(I.MSG_SUCCESS);
				res.setSuccess(true);
				res.setRetData(user);
			} else {
				res.setSuccess(false);
			}			
		} else {
			res.setSuccess(false);
			res.setResCode(I.MSG_ACCOUNT_REPEAT_ERROR);
		}
		return res;
	}
	
	@Override
	public Result login(User user, HttpServletRequest request) {
		Result res = new Result();
		User u = dao.findUserByName(user.getUsername());
		if (u!=null) {
			if(u.getPassword().equals(user.getPassword())) {
				res.setSuccess(true);
				res.setResCode(I.MSG_SUCCESS);
				res.setRetData(user);
			} else {
				res.setSuccess(false);
				res.setResCode(I.MSG_PASSWORD_ERROR);
			}
		} else {
			res.setSuccess(false);
			res.setResCode(I.MSG_ACCOUNT_ERROR);
		}
		return res;
	}

}
