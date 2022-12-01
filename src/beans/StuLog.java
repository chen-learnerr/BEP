package beans;

public class StuLog {
	private String stu_acct;
	private String stu_pwd;
	public StuLog() {
		
	}
	public StuLog(String stu_acct, String stu_pwd) {
		super();
		this.stu_acct = stu_acct;
		this.stu_pwd = stu_pwd;
	}
	public String getStu_acct() {
		return stu_acct;
	}
	public void setStu_acct(String stu_acct) {
		this.stu_acct = stu_acct;
	}
	public String getStu_pwd() {
		return stu_pwd;
	}
	public void setStu_pwd(String stu_pwd) {
		this.stu_pwd = stu_pwd;
	}
}
