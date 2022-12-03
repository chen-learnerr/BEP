package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.BidderPref;
import db.DBUtil;

public class BidderPrefDao {
	public void delBidderPref(String bidder_num) throws Exception {
		//下面是连接信息，不用改
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = DBUtil.getConnection();
		//上面是连接信息，不用改
		
		String sql="DELETE FROM bidder_pref WHERE bidder_numb=?";
		ps=conn.prepareStatement(sql); 
		ps.setString(1, bidder_num);
		
		//执行语句并返回结果集
		ps.executeUpdate(); 

		// 用来释放资源的函数，不用改
		DBUtil.free(rs, ps, conn);
	}
	
	public List<BidderPref> findAllBidderPref(String bidder_num) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = DBUtil.getConnection();
		
		List<BidderPref> bidderPrefList = new ArrayList<BidderPref>();
		String sql = "SELECT * FROM bidder_pref WHERE bidder_numb=?";
		ps = conn.prepareStatement(sql);
		ps.setString(1, bidder_num);
		rs = ps.executeQuery();
		while(rs.next()) {
			int pref_id = rs.getInt("pref_id");
			String bidder_numb = rs.getString("bidder_numb");
			String pref_type = rs.getString("pref_type");
			String pref_name = rs.getString("pref_name");
			BidderPref bidder_pref = new BidderPref(pref_id, bidder_numb, pref_type, pref_name);
			bidderPrefList.add(bidder_pref);
		}
		DBUtil.free(rs, ps, conn);
		return bidderPrefList;
	}
	
	public void insertBidderPref(String bidder_num, String pref_type, String pref_name) throws Exception{
		//下面是连接信息，不用改
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = DBUtil.getConnection();
		//上面是连接信息，不用改
		String sql="INSERT INTO bidder_pref(bidder_numb, pref_type, pref_name) VALUES (?,?,?);";
		ps=conn.prepareStatement(sql); 
		ps.setString(1, bidder_num);
		ps.setString(2, pref_type);
		ps.setString(3, pref_name);
		int rowCount= ps.executeUpdate(); 
		if(rowCount==0) {
			throw new Exception("Insert Error Project:");
		}
		//释放资源
		DBUtil.free(rs, ps, conn);
	}
}
