package cn.xunuosi.test.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.xunuosi.test.bean.Result;
import cn.xunuosi.test.biz.ITestServerBiz;
import cn.xunuosi.test.biz.TestServerBiz;
import cn.xunuosi.test.pojo.User;
import cn.xunuosi.test.util.I;
import cn.xunuosi.test.util.JsonUtil;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ITestServerBiz biz = new TestServerBiz();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		Map<String, String[]> params = request.getParameterMap();
		// 1、接收用户传来的参数
		String username = params.get(I.User.USER_NAME)[0];
		String password = params.get(I.User.PASSWORD)[0];
		User user = new User(username, password);
		Result result = biz.register(user, request);
		JsonUtil.writeJsonToClient(result, response);
	}

}
