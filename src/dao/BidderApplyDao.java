package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.BidderApply;
import db.DBUtil;

public class BidderApplyDao {
	public void insertBidderApply(String bidder_num, int proj_no, String apply_status, String apply_att_name) throws Exception{
		//下面是连接信息，不用改
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = DBUtil.getConnection();
		
		//上面是连接信息，不用改
		String sql="INSERT INTO bidder_apply(bidder_num, proj_no, apply_status, apply_att_name) VALUES (?,?,?,?);";
		ps=conn.prepareStatement(sql); 
		ps.setString(1, bidder_num);
		ps.setInt(2, proj_no);
		ps.setString(3, apply_status);
		ps.setString(4, apply_att_name);
		int rowCount= ps.executeUpdate(); 
		if(rowCount==0) {
			throw new Exception("Insert Error Apply:");
		}
		//释放资源
		DBUtil.free(rs, ps, conn);
	}
	
	public List<BidderApply> findAllBidderApply(String bidder_num) throws Exception {
		//连接信息
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = DBUtil.getConnection();
		
		List<BidderApply> proList = new ArrayList<BidderApply>();
		
		String sql="SELECT * FROM bidder_apply WHERE bidder_num = ?;";
		ps=conn.prepareStatement(sql); 
		ps.setString(1, bidder_num);
		rs = ps.executeQuery();
		
		while (rs.next()) {
			String bidder_numb = rs.getString("bidder_num");
			int proj_no = rs.getInt("proj_no");
			String apply_status = rs.getString("apply_status");
			String aprv_tender = rs.getString("aprv_tender");
			String apply_att_name = rs.getString("apply_att_name");
			
			BidderApply bidder_apply = new BidderApply(bidder_numb, proj_no, apply_status, aprv_tender, apply_att_name);
			proList.add(bidder_apply);
			
		}
		
		return proList;
	}
	
	public void delBidderApply(String bidder_num, int proj_no) throws Exception {
		//下面是连接信息，不用改
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = DBUtil.getConnection();
		//上面是连接信息，不用改
		
		String sql="DELETE FROM bidder_apply WHERE bidder_num=? AND proj_no = ?;";
		ps=conn.prepareStatement(sql); 
		ps.setString(1, bidder_num);
		ps.setInt(2, proj_no);
		
		//执行语句并返回结果集
		ps.executeUpdate(); 
		// 用来释放资源的函数，不用改
		DBUtil.free(rs, ps, conn);
	}
	
	public void delBidderApply(int proj_no) throws Exception {
		//下面是连接信息，不用改
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = DBUtil.getConnection();
		//上面是连接信息，不用改
		
		String sql="DELETE FROM bidder_apply WHERE proj_no = ?;";
		ps=conn.prepareStatement(sql); 
		ps.setInt(1, proj_no);
		
		//执行语句并返回结果集
		ps.executeUpdate(); 
		// 用来释放资源的函数，不用改
		DBUtil.free(rs, ps, conn);
	}
	
	public void updateApply(String bidder_num, int proj_no, String proj_status, String aprv_tender) throws Exception{
		//连接信息
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = DBUtil.getConnection();
		
		String sql ="UPDATE bidder_apply SET apply_status=?, aprv_tender=? WHERE bidder_num=? AND proj_no=?;";
		ps=conn.prepareStatement(sql);
		ps.setString(1, proj_status);
		ps.setString(2, aprv_tender);
		ps.setString(3, bidder_num);
		ps.setInt(4, proj_no);
		
		int rowCount= ps.executeUpdate(); 
		if(rowCount==0) {
			throw new Exception("Update Error: updateApply");
		}
		//释放资源
		DBUtil.free(rs, ps, conn);
	}
	
	public BidderApply findBidderApply(String bidder_num, int proj_no) throws Exception {
		//连接信息
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = DBUtil.getConnection();
		
		//要返回的值
		BidderApply bidder_apply = null;
		
		//预编译sql语句
		String sql="SELECT * FROM bidder_apply WHERE bidder_num = ? AND proj_no = ?;";
		ps=conn.prepareStatement(sql); 
		ps.setString(1, bidder_num);
		ps.setInt(2, proj_no);
		rs = ps.executeQuery();
		
		//获得结果
		if (rs.next()) {
			String apply_status = rs.getString("apply_status");
			String aprv_tender = rs.getString("aprv_tender");
			String apply_att_name = rs.getString("apply_att_name");
			
			bidder_apply = new BidderApply(bidder_num, proj_no, apply_status, aprv_tender, apply_att_name);
		}
		
		return bidder_apply;
	}
}
