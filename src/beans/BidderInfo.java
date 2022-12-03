package beans;

import java.sql.Date;

public class BidderInfo {
	private	String bidder_num;
	private String bidder_acct;
	private String bidder_name;
	private String bidder_id_num;
	private String bidder_sex;
	private String bidder_political_status;
	private String bidder_major;
	private String bidder_mob_no;
	private String bidder_mail;
	private String bidder_nation;
	private String bidder_grade;
	private Date bidder_birthday;
	private int bidder_dates;
	
	public BidderInfo() {
		this.bidder_num = "";
		this.bidder_name = "";
		this.bidder_id_num = "";
		this.bidder_sex = "";
		this.bidder_political_status = "";
		this.bidder_major = "";
		this.bidder_mob_no = "";
		this.bidder_mail = "";
		this.bidder_nation = "";
		this.bidder_grade = "";
	}

	public BidderInfo(String bidder_num, String bidder_acct, String bidder_name, String bidder_id_num, String bidder_sex,
					  String bidder_political_status, String bidder_major, String bidder_mob_no, String bidder_mail, String bidder_nation,
					  String bidder_grade, Date bidder_birthday, int bidder_dates) {
		super();
		this.bidder_num = bidder_num;
		this.bidder_acct = bidder_acct;
		this.bidder_name = bidder_name;
		this.bidder_id_num = bidder_id_num;
		this.bidder_sex = bidder_sex;
		this.bidder_political_status = bidder_political_status;
		this.bidder_major = bidder_major;
		this.bidder_mob_no = bidder_mob_no;
		this.bidder_mail = bidder_mail;
		this.bidder_nation = bidder_nation;
		this.bidder_grade = bidder_grade;
		this.bidder_birthday = bidder_birthday;
		this.bidder_dates = bidder_dates;
	}

	@Override
	public String toString() {
		return "bidder_info [bidder_num=" + bidder_num + ", bidder_acct=" + bidder_acct + ", bidder_name=" + bidder_name + ", bidder_id_num="
				+ bidder_id_num + ", bidder_sex=" + bidder_sex + ", bidder_political_status=" + bidder_political_status
				+ ", bidder_major=" + bidder_major + ", bidder_mob_no=" + bidder_mob_no + ", bidder_mail=" + bidder_mail + ", bidder_nation="
				+ bidder_nation + ", bidder_grade=" + bidder_grade + ", bidder_birthday=" + bidder_birthday + ", bidder_dates="
				+ bidder_dates + "]";
	}

	public String getBidder_num() {
		return bidder_num;
	}

	public void setBidder_num(String bidder_num) {
		this.bidder_num = bidder_num;
	}

	public String getBidder_acct() {
		return bidder_acct;
	}

	public void setBidder_acct(String bidder_acct) {
		this.bidder_acct = bidder_acct;
	}

	public String getBidder_name() {
		return bidder_name;
	}

	public void setBidder_name(String bidder_name) {
		this.bidder_name = bidder_name;
	}

	public String getBidder_id_num() {
		return bidder_id_num;
	}

	public void setBidder_id_num(String bidder_id_num) {
		this.bidder_id_num = bidder_id_num;
	}

	public String getBidder_sex() {
		return bidder_sex;
	}

	public void setBidder_sex(String bidder_sex) {
		this.bidder_sex = bidder_sex;
	}

	public String getBidder_political_status() {
		return bidder_political_status;
	}

	public void setBidder_political_status(String bidder_political_status) {
		this.bidder_political_status = bidder_political_status;
	}

	public String getBidder_major() {
		return bidder_major;
	}

	public void setBidder_major(String bidder_major) {
		this.bidder_major = bidder_major;
	}

	public String getBidder_mob_no() {
		return bidder_mob_no;
	}

	public void setBidder_mob_no(String bidder_mob_no) {
		this.bidder_mob_no = bidder_mob_no;
	}

	public String getBidder_mail() {
		return bidder_mail;
	}

	public void setBidder_mail(String bidder_mail) {
		this.bidder_mail = bidder_mail;
	}

	public String getBidder_nation() {
		return bidder_nation;
	}

	public void setBidder_nation(String bidder_nation) {
		this.bidder_nation = bidder_nation;
	}

	public String getBidder_grade() {
		return bidder_grade;
	}

	public void setBidder_grade(String bidder_grade) {
		this.bidder_grade = bidder_grade;
	}

	public Date getBidder_birthday() {
		return bidder_birthday;
	}

	public void setBidder_birthday(Date bidder_birthday) {
		this.bidder_birthday = bidder_birthday;
	}

	public int getBidder_dates() {
		return bidder_dates;
	}

	public void setBidder_dates(int bidder_dates) {
		this.bidder_dates = bidder_dates;
	}
	
	
}
