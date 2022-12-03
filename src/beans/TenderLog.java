package beans;

public class TenderLog {
	private String tender_acct;
	private String tender_pwd;
	
	public TenderLog() {
		// TODO Auto-generated constructor stub
	}

	public TenderLog(String tender_acct, String tender_pwd) {
		super();
		this.tender_acct = tender_acct;
		this.tender_pwd = tender_pwd;
	}

	@Override
	public String toString() {
		return "log [admin_acct=" + tender_acct + ", tender_pwd=" + tender_pwd + "]";
	}

	public String getTender_acct() {
		return tender_acct;
	}

	public void setTender_acct(String tender_acct) {
		this.tender_acct = tender_acct;
	}

	public String getTender_pwd() {
		return tender_pwd;
	}

	public void setTender_pwd(String tender_pwd) {
		this.tender_pwd = tender_pwd;
	}

}
