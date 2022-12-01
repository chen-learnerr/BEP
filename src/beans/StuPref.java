package beans;

public class StuPref {
	private int pref_id;
	private String stu_numb;
	private String pref_type;
	private String pref_name;
	public StuPref() {
		
	}
	public StuPref(int pref_id, String stu_numb, String pref_type, String pref_name) {
		super();
		this.pref_id = pref_id;
		this.stu_numb = stu_numb;
		this.pref_type = pref_type;
		this.pref_name = pref_name;
	}
	public int getPref_id() {
		return pref_id;
	}
	public void setPref_id(int pref_id) {
		this.pref_id = pref_id;
	}
	public String getStu_numb() {
		return stu_numb;
	}
	public void setStu_numb(String stu_numb) {
		this.stu_numb = stu_numb;
	}
	public String getPref_type() {
		return pref_type;
	}
	public void setPref_type(String pref_type) {
		this.pref_type = pref_type;
	}
	public String getPref_name() {
		return pref_name;
	}
	public void setPref_name(String pref_name) {
		this.pref_name = pref_name;
	}
}
