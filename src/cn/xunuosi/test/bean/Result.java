package cn.xunuosi.test.bean;

public class Result {
	private boolean isSuccess;
	private int resCode = -1;
	private Object retData;
	
	
	public Result() {
		super();
	}

	public Result(boolean isSuccess, int resCode) {
		super();
		this.isSuccess = isSuccess;
		this.resCode = resCode;
	}
	
	public Result(boolean isSuccess, int resCode, Object retData) {
		super();
		this.isSuccess = isSuccess;
		this.resCode = resCode;
		this.retData = retData;
	}

	public boolean isSuccess() {
		return isSuccess;
	}
	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	public Object getRetData() {
		return retData;
	}

	public void setRetData(Object retData) {
		this.retData = retData;
	}

	public int getResCode() {
		return resCode;
	}

	public void setResCode(int resCode) {
		this.resCode = resCode;
	}
}
