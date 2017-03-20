package cn.xunuosi.test.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import cn.xunuosi.test.bean.Result;

public class JsonUtil {
	private static final Gson gson = new Gson();

	public static <T> void writeJsonToClient(T bean, HttpServletResponse response) {
		if (bean instanceof Result) {
			writeResultToClient((Result)bean,response);
		}
	}

	private static void writeResultToClient(Result result, HttpServletResponse response) {
		PrintWriter pw = null;
		try {
			pw = response.getWriter();
			pw.write(gson.toJson(result,Result.class));
			pw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (pw!=null) {
				pw.close();
			}
		}
	}
}
