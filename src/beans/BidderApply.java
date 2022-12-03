package beans;

public class BidderApply {
	private String bidder_num;
	private int proj_no;
	private String apply_status;
	private String aprv_tender;
	private String apply_att_name;
	public BidderApply() {
		
	}
	public BidderApply(String bidder_num, int proj_no, String apply_status, String aprv_tender,
					   String apply_att_name) {
		super();
		this.bidder_num = bidder_num;
		this.proj_no = proj_no;
		this.apply_status = apply_status;
		this.aprv_tender = aprv_tender;
		this.apply_att_name = apply_att_name;
	}
	public String getBidder_num() {
		return bidder_num;
	}
	public void setBidder_num(String bidder_num) {
		this.bidder_num = bidder_num;
	}
	public int getProj_no() {
		return proj_no;
	}
	public void setProj_no(int proj_no) {
		this.proj_no = proj_no;
	}
	public String getApply_status() {
		return apply_status;
	}
	public void setApply_status(String apply_status) {
		this.apply_status = apply_status;
	}
	public String getAprv_tender() {
		return aprv_tender;
	}
	public void setAprv_tender(String aprv_tender) {
		this.aprv_tender = aprv_tender;
	}
	public String getApply_att_name() {
		return apply_att_name;
	}
	public void setApply_att_name(String apply_att_name) {
		this.apply_att_name = apply_att_name;
	}
	
}
