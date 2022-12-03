package beans;

public class BidderPref {
	private int pref_id;
	private String bidder_numb;
	private String pref_type;
	private String pref_name;
	public BidderPref() {
		
	}
	public BidderPref(int pref_id, String bidder_numb, String pref_type, String pref_name) {
		super();
		this.pref_id = pref_id;
		this.bidder_numb = bidder_numb;
		this.pref_type = pref_type;
		this.pref_name = pref_name;
	}
	public int getPref_id() {
		return pref_id;
	}
	public void setPref_id(int pref_id) {
		this.pref_id = pref_id;
	}
	public String getBidder_numb() {
		return bidder_numb;
	}
	public void setBidder_numb(String bidder_numb) {
		this.bidder_numb = bidder_numb;
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
