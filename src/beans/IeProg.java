package beans;
import java.sql.Date;

public class IeProg {
	private int proj_no;
	private String proj_name;
	private String proj_sch;
	private Date proj_apply_ddl;
	private Date proj_start_time;
	private String proj_lang;
	private String proj_country;
	private String proj_pub_acct;
	private int proj_credict;
	private String proj_time;
	private String proj_info;
	private String proj_file;
	public IeProg() {
		// TODO 自动生成的构造函数存根
	}
	public IeProg(int proj_no, String proj_name, String proj_sch, Date proj_apply_ddl, Date proj_start_time,
			String proj_lang, String proj_country, String proj_pub_acct, int proj_credict, String proj_time,
			String proj_info, String proj_file) {
		super();
		this.proj_no = proj_no;
		this.proj_name = proj_name;
		this.proj_sch = proj_sch;
		this.proj_apply_ddl = proj_apply_ddl;
		this.proj_start_time = proj_start_time;
		this.proj_lang = proj_lang;
		this.proj_country = proj_country;
		this.proj_pub_acct = proj_pub_acct;
		this.proj_credict = proj_credict;
		this.proj_time = proj_time;
		this.proj_info = proj_info;
		this.proj_file = proj_file;
	}
	@Override
	public String toString() {
		return "ie_prog [proj_no=" + proj_no + ", proj_name=" + proj_name + ", proj_sch=" + proj_sch
				+ ", proj_apply_ddl=" + proj_apply_ddl + ", proj_start_time=" + proj_start_time + ", proj_lang="
				+ proj_lang + ", proj_country=" + proj_country + ", proj_pub_acct=" + proj_pub_acct + ", proj_credict="
				+ proj_credict + ", proj_time=" + proj_time + ", proj_info=" + proj_info + ", proj_file=" + proj_file
				+ "]";
	}
	public int getProj_no() {
		return proj_no;
	}
	public void setProj_no(int proj_no) {
		this.proj_no = proj_no;
	}
	public String getProj_name() {
		return proj_name;
	}
	public void setProj_name(String proj_name) {
		this.proj_name = proj_name;
	}
	public String getProj_sch() {
		return proj_sch;
	}
	public void setProj_sch(String proj_sch) {
		this.proj_sch = proj_sch;
	}
	public Date getProj_apply_ddl() {
		return proj_apply_ddl;
	}
	public void setProj_apply_ddl(Date proj_apply_ddl) {
		this.proj_apply_ddl = proj_apply_ddl;
	}
	public Date getProj_start_time() {
		return proj_start_time;
	}
	public void setProj_start_time(Date proj_start_time) {
		this.proj_start_time = proj_start_time;
	}
	public String getProj_lang() {
		return proj_lang;
	}
	public void setProj_lang(String proj_lang) {
		this.proj_lang = proj_lang;
	}
	public String getProj_country() {
		return proj_country;
	}
	public void setProj_country(String proj_country) {
		this.proj_country = proj_country;
	}
	public String getProj_pub_acct() {
		return proj_pub_acct;
	}
	public void setProj_pub_acct(String proj_pub_acct) {
		this.proj_pub_acct = proj_pub_acct;
	}
	public int getProj_credict() {
		return proj_credict;
	}
	public void setProj_credict(int proj_credict) {
		this.proj_credict = proj_credict;
	}
	public String getProj_time() {
		return proj_time;
	}
	public void setProj_time(String proj_time) {
		this.proj_time = proj_time;
	}
	public String getProj_info() {
		return proj_info;
	}
	public void setProj_info(String proj_info) {
		this.proj_info = proj_info;
	}
	public String getProj_file() {
		return proj_file;
	}
	public void setProj_file(String proj_file) {
		this.proj_file = proj_file;
	}
}