package beans;

import java.sql.Date;

public class ModProjNotify {
	private int id;
	private String info;
	private Date expiry_date;
	private int proj_id;
	public ModProjNotify() {
		// TODO Auto-generated constructor stub
	}
	public ModProjNotify(int id, String info, Date expiry_date, int proj_id) {
		super();
		this.id = id;
		this.info = info;
		this.expiry_date = expiry_date;
		this.proj_id = proj_id;
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
