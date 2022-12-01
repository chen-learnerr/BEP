package beans;

public class StuApply {
	private String stu_num;
	private int proj_no;
	private String apply_status;
	private String aprv_admin;
	private String apply_att_name;
	public StuApply() {
		
	}
	public StuApply(String stu_num, int proj_no, String apply_status, String aprv_admin,
			String apply_att_name) {
		super();
		this.stu_num = stu_num;
		this.proj_no = proj_no;
		this.apply_status = apply_status;
		this.aprv_admin = aprv_admin;
		this.apply_att_name = apply_att_name;
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
	public String getApply_status() {
		return apply_status;
	}
	public void setApply_status(String apply_status) {
		this.apply_status = apply_status;
	}
	public String getAprv_admin() {
		return aprv_admin;
	}
	public void setAprv_admin(String aprv_admin) {
		this.aprv_admin = aprv_admin;
	}
	public String getApply_att_name() {
		return apply_att_name;
	}
	public void setApply_att_name(String apply_att_name) {
		this.apply_att_name = apply_att_name;
	}
	
}
