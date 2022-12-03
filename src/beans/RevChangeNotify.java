package beans;

public class RevChangeNotify {
	private String bidder_num;
	private int proj_no;
	private String review_info;
	public RevChangeNotify() {
		// TODO Auto-generated constructor stub
	}
	public RevChangeNotify(String bidder_num, int proj_no, String review_info) {
		super();
		this.bidder_num = bidder_num;
		this.proj_no = proj_no;
		this.review_info = review_info;
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
	public String getReview_info() {
		return review_info;
	}
	public void setReview_info(String review_info) {
		this.review_info = review_info;
	}
	
}
