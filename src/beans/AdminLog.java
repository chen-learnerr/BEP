package beans;

public class AdminLog {
	private String admin_acct;
	private String admin_pwd;
	
	public AdminLog() {
		// TODO Auto-generated constructor stub
	}

	public AdminLog(String admin_acct, String admin_pwd) {
		super();
		this.admin_acct = admin_acct;
		this.admin_pwd = admin_pwd;
	}

	@Override
	public String toString() {
		return "log [admin_acct=" + admin_acct + ", admin_pwd=" + admin_pwd + "]";
	}

	public String getAdmin_acct() {
		return admin_acct;
	}

	public void setAdmin_acct(String admin_acct) {
		this.admin_acct = admin_acct;
	}

	public String getAdmin_pwd() {
		return admin_pwd;
	}

	public void setAdmin_pwd(String admin_pwd) {
		this.admin_pwd = admin_pwd;
	}
	
	
}
