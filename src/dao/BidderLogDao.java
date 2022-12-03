package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.BidderLog;
import db.DBUtil;

public class BidderLogDao {
	//这是一个根据学生账号修改密码函数，返回值是修改是否成功的状态
	public void updateTenderPwd(String bidder_acct, String bidder_pwd) throws Exception {
		//下面是连接信息，不用改
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = DBUtil.getConnection();
		//上面是连接信息，不用改
		
		String sql="UPDATE bidder_log SET bidder_pwd=? WHERE bidder_acct=?";
		ps=conn.prepareStatement(sql); 
		ps.setString(1, bidder_pwd);
		ps.setString(2, bidder_acct);
		
		//执行语句并返回结果集
		int rowCount = ps.executeUpdate(); 
		if(rowCount == 0) {
			throw new Exception("Update Error:bidder acct:" + bidder_acct);
		}
		// 用来释放资源的函数，不用改
		DBUtil.free(rs, ps, conn);
	}
	
	public List<BidderLog> findAllBidderLog() throws Exception{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = DBUtil.getConnection();
		
		List<BidderLog> bidderList = new ArrayList<BidderLog>();
		String sql = "SELECT * FROM  bidder_log";
		ps = conn.prepareStatement(sql);
		rs = ps.executeQuery();
		while(rs.next()) {
			String sacct = rs.getString("bidder_acct");
			String spwd = rs.getString("bidder_pwd");
			BidderLog bidder = new BidderLog(sacct,spwd);
			bidderList.add(bidder);
		}
		DBUtil.free(rs, ps, conn);
		return bidderList;
	}
	
	public void insertBidderLog(String bidder_acct, String bidder_pwd) throws Exception {
		//下面是连接信息，不用改
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = DBUtil.getConnection();
		//上面是连接信息，不用改
		
		String sql="INSERT INTO bidder_log VALUES (?,?);";
		ps=conn.prepareStatement(sql); 
		ps.setString(1, bidder_acct);
		ps.setString(2, bidder_pwd);
		
		int rowCount= ps.executeUpdate(); 
		if(rowCount==0) {
			throw new Exception("Insert Error:Bidder Account:"+bidder_acct);
		}
		//释放资源
		DBUtil.free(rs, ps, conn);
	}
	
	public BidderLog findBidderLog(String bidder_acct) throws Exception {
		//下面是连接信息，不用改
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		BidderLog bidder_log = null;
		conn = DBUtil.getConnection();
		//上面是连接信息，不用改
		
		String sql = "SELECT * FROM bidder_log WHERE bidder_acct = ?"; //这是sql语句，其中的问号代表要插入的值
		ps = conn.prepareStatement(sql); //对语句进行预编译
		ps.setString(1, bidder_acct); //向语句中插入值，第一个参数表示要插入值的位置，第二个表示要插入的值
		rs = ps.executeQuery(); //执行语句并返回结果集
		if (rs.next()) {
			String sacct = rs.getString("bidder_acct");
			String spwd = rs.getString("bidder_pwd");
			bidder_log = new BidderLog(sacct, spwd); //将提取出的数据做成实体类
		}
		// 用来释放资源的函数，不用改
		DBUtil.free(rs, ps, conn);
		//返回结果集
		return bidder_log;
	}
}
