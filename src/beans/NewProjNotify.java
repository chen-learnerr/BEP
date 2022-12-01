package beans;

import java.sql.Date;

public class NewProjNotify {
	private int id;
	private String info;
	private String country;
	private String school;
	private Date expiry_date;
	private int proj_id;
	public NewProjNotify(int id, String info, String country, String school, Date expiry_date, int proj_id) {
		super();
		this.id = id;
		this.info = info;
		this.country = country;
		this.school = school;
		this.expiry_date = expiry_date;
		this.proj_id = proj_id;
	}
	public NewProjNotify() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public Date getExpiry_date() {
		return expiry_date;
	}
	public void setExpiry_date(Date expiry_date) {
		this.expiry_date = expiry_date;
	}
	public int getProj_id() {
		return proj_id;
	}
	public void setProj_id(int proj_id) {
		this.proj_id = proj_id;
	}
}
