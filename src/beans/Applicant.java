package beans;

public class Applicant {
	private String stu_name;
	private String stu_num;
	private String stu_grd;
	private String stu_sex;
	private String stu_major;
	private String apply_status;
	private String apply_att_name;
	public Applicant() {
		// TODO Auto-generated constructor stub
	}
	public Applicant(String stu_name, String stu_num, String stu_grd, String stu_sex, String stu_major,
			String apply_status, String apply_att_name) {
		super();
		this.stu_name = stu_name;
		this.stu_num = stu_num;
		this.stu_grd = stu_grd;
		this.stu_sex = stu_sex;
		this.stu_major = stu_major;
		this.apply_status = apply_status;
		this.apply_att_name = apply_att_name;
	}
	public String getStu_name() {
		return stu_name;
	}
	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
	}
	public String getStu_num() {
		return stu_num;
	}
	public void setStu_num(String stu_num) {
		this.stu_num = stu_num;
	}
	public String getStu_grd() {
		return stu_grd;
	}
	public void setStu_grd(String stu_grd) {
		this.stu_grd = stu_grd;
	}
	public String getStu_sex() {
		return stu_sex;
	}
	public void setStu_sex(String stu_sex) {
		this.stu_sex = stu_sex;
	}
	public String getStu_major() {
		return stu_major;
	}
	public void setStu_major(String stu_major) {
		this.stu_major = stu_major;
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
