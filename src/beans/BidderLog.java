package beans;

public class BidderLog {
	private String bidder_acct;
	private String bidder_pwd;
	public BidderLog() {
		
	}
	public BidderLog(String bidder_acct, String bidder_pwd) {
		super();
		this.bidder_acct = bidder_acct;
		this.bidder_pwd = bidder_pwd;
	}
	public String getBidder_acct() {
		return bidder_acct;
	}
	public void setBidder_acct(String bidder_acct) {
		this.bidder_acct = bidder_acct;
	}
	public String getBidder_pwd() {
		return bidder_pwd;
	}
	public void setBidder_pwd(String bidder_pwd) {
		this.bidder_pwd = bidder_pwd;
	}
}
