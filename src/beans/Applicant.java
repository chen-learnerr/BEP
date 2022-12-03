package beans;

public class Applicant {
	private String bidder_name;
	private String bidder_num;
	private String bidder_grd;
	private String bidder_sex;
	private String bidder_major;
	private String apply_status;
	private String apply_att_name;
	public Applicant() {
		// TODO Auto-generated constructor stub
	}
	public Applicant(String bidder_name, String bidder_num, String bidder_grd, String bidder_sex, String bidder_major,
			String apply_status, String apply_att_name) {
		super();
		this.bidder_name = bidder_name;
		this.bidder_num = bidder_num;
		this.bidder_grd = bidder_grd;
		this.bidder_sex = bidder_sex;
		this.bidder_major = bidder_major;
		this.apply_status = apply_status;
		this.apply_att_name = apply_att_name;
	}
	public String getBidder_name() {
		return bidder_name;
	}
	public void setBidder_name(String bidder_name) {
		this.bidder_name = bidder_name;
	}
	public String getBidder_num() {
		return bidder_num;
	}
	public void setBidder_num(String bidder_num) {
		this.bidder_num = bidder_num;
	}
	public String getBidder_grd() {
		return bidder_grd;
	}
	public void setBidder_grd(String bidder_grd) {
		this.bidder_grd = bidder_grd;
	}
	public String getBidder_sex() {
		return bidder_sex;
	}
	public void setBidder_sex(String bidder_sex) {
		this.bidder_sex = bidder_sex;
	}
	public String getBidder_major() {
		return bidder_major;
	}
	public void setBidder_major(String bidder_major) {
		this.bidder_major = bidder_major;
	}
	public String getApply_status() {
		return apply_status;
	}
	public void setApply_status(String apply_status) {
		this.apply_status = apply_status;
	}
	public String getApply_att_name() {
		return apply_att_name;
	}
	public void setApply_att_name(String apply_att_name) {
		this.apply_att_name = apply_att_name;
	}
	
	
}
