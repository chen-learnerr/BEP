package beans;

import java.sql.Date;

public class StuInfo {
	private	String stu_num;
	private String stu_acct;
	private String stu_name;
	private String stu_id_num;
	private String stu_sex;
	private String stu_political_status;
	private String stu_major;
	private String stu_mob_no;
	private String stu_mail;
	private String stu_nation;
	private String stu_grade;
	private Date stu_birthday;
	private int stu_dates;
	
	public StuInfo() {
		this.stu_num = "";
		this.stu_name = "";
		this.stu_id_num = "";
		this.stu_sex = "";
		this.stu_political_status = "";
		this.stu_major = "";
		this.stu_mob_no = "";
		this.stu_mail = "";
		this.stu_nation = "";
		this.stu_grade = "";
	}

	public StuInfo(String stu_num, String stu_acct, String stu_name, String stu_id_num, String stu_sex,
			String stu_political_status, String stu_major, String stu_mob_no, String stu_mail, String stu_nation,
			String stu_grade, Date stu_birthday, int stu_dates) {
		super();
		this.stu_num = stu_num;
		this.stu_acct = stu_acct;
		this.stu_name = stu_name;
		this.stu_id_num = stu_id_num;
		this.stu_sex = stu_sex;
		this.stu_political_status = stu_political_status;
		this.stu_major = stu_major;
		this.stu_mob_no = stu_mob_no;
		this.stu_mail = stu_mail;
		this.stu_nation = stu_nation;
		this.stu_grade = stu_grade;
		this.stu_birthday = stu_birthday;
		this.stu_dates = stu_dates;
	}

	@Override
	public String toString() {
		return "stu_info [stu_num=" + stu_num + ", stu_acct=" + stu_acct + ", stu_name=" + stu_name + ", stu_id_num="
				+ stu_id_num + ", stu_sex=" + stu_sex + ", stu_political_status=" + stu_political_status
				+ ", stu_major=" + stu_major + ", stu_mob_no=" + stu_mob_no + ", stu_mail=" + stu_mail + ", stu_nation="
				+ stu_nation + ", stu_grade=" + stu_grade + ", stu_birthday=" + stu_birthday + ", stu_dates="
				+ stu_dates + "]";
	}

	public String getStu_num() {
		return stu_num;
	}

	public void setStu_num(String stu_num) {
		this.stu_num = stu_num;
	}

	public String getStu_acct() {
		return stu_acct;
	}

	public void setStu_acct(String stu_acct) {
		this.stu_acct = stu_acct;
	}

	public String getStu_name() {
		return stu_name;
	}

	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
	}

	public String getStu_id_num() {
		return stu_id_num;
	}

	public void setStu_id_num(String stu_id_num) {
		this.stu_id_num = stu_id_num;
	}

	public String getStu_sex() {
		return stu_sex;
	}

	public void setStu_sex(String stu_sex) {
		this.stu_sex = stu_sex;
	}

	public String getStu_political_status() {
		return stu_political_status;
	}

	public void setStu_political_status(String stu_political_status) {
		this.stu_political_status = stu_political_status;
	}

	public String getStu_major() {
		return stu_major;
	}

	public void setStu_major(String stu_major) {
		this.stu_major = stu_major;
	}

	public String getStu_mob_no() {
		return stu_mob_no;
	}

	public void setStu_mob_no(String stu_mob_no) {
		this.stu_mob_no = stu_mob_no;
	}

	public String getStu_mail() {
		return stu_mail;
	}

	public void setStu_mail(String stu_mail) {
		this.stu_mail = stu_mail;
	}

	public String getStu_nation() {
		return stu_nation;
	}

	public void setStu_nation(String stu_nation) {
		this.stu_nation = stu_nation;
	}

	public String getStu_grade() {
		return stu_grade;
	}

	public void setStu_grade(String stu_grade) {
		this.stu_grade = stu_grade;
	}

	public Date getStu_birthday() {
		return stu_birthday;
	}

	public void setStu_birthday(Date stu_birthday) {
		this.stu_birthday = stu_birthday;
	}

	public int getStu_dates() {
		return stu_dates;
	}

	public void setStu_dates(int stu_dates) {
		this.stu_dates = stu_dates;
	}
	
	
}
