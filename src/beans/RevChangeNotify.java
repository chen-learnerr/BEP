package beans;

public class RevChangeNotify {
	private String stu_num;
	private int proj_no;
	private String review_info;
	public RevChangeNotify() {
		// TODO Auto-generated constructor stub
	}
	public RevChangeNotify(String stu_num, int proj_no, String review_info) {
		super();
		this.stu_num = stu_num;
		this.proj_no = proj_no;
		this.review_info = review_info;
	}
	public String getStu_num() {
		return stu_num;
	}
	public void setStu_num(String stu_num) {
		this.stu_num = stu_num;
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
