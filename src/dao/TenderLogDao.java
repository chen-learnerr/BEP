package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.TenderLog;
import db.DBUtil;

public class TenderLogDao {
	public void updateTenderPwd(String tender_acct, String tender_pwd) throws Exception {
		// 连接信息
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = DBUtil.getConnection();
		
		// 预编译语句
		String sql="UPDATE tender_log SET tender_pwd=? WHERE tender_acct=?";
		ps=conn.prepareStatement(sql); 
		ps.setString(1, tender_pwd);
		ps.setString(2, tender_acct);
		
		// 获取数据
		int rowCount = ps.executeUpdate(); 
		if(rowCount == 0) {
			throw new Exception("Update Error->TenderLog->Pwd");
		}
		
		// 释放资源
		DBUtil.free(rs, ps, conn);	
	}
	
	public List<TenderLog> findAllTenderLog() throws Exception{
		// 连接信息
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = DBUtil.getConnection();
		
		// 要返回的数据
		List<TenderLog> tenderList = new ArrayList<TenderLog>();
		
		// 预编译语句
		String sql = "SELECT * FROM tender_log";
		ps = conn.prepareStatement(sql);
		rs = ps.executeQuery();
		
		// 获取数据
		while(rs.next()) {
			String tender_acct = rs.getString("tender_acct");
			String tender_pwd = rs.getString("tender_pwd");
			TenderLog tender = new TenderLog(tender_acct, tender_pwd);
			tenderList.add(tender);
		}
		
		// 释放资源
		DBUtil.free(rs, ps, conn);
		return tenderList;
	}
	
	public void insertTenderLog(String tender_acct, String tender_pwd) throws Exception {
		// 连接信息
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = DBUtil.getConnection();
		
		// 预编译语句
		String sql="INSERT INTO tender_log VALUES (?,?);";
		ps=conn.prepareStatement(sql); 
		ps.setString(1, tender_acct);
		ps.setString(2, tender_pwd);
		
		// 获取数据
		int rowCount= ps.executeUpdate(); 
		if(rowCount==0) {
			throw new Exception("Insert Error->TenderLog");
		}
		
		//释放资源
		DBUtil.free(rs, ps, conn);
	}
	
	public TenderLog findTenderLog(String tender_acct) throws Exception {
		// 连接信息
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = DBUtil.getConnection();
		
		// 要返回的数据
		TenderLog tender_log = null;
		
		// 预编译语句
		String sql = "SELECT * FROM tender_log WHERE tender_acct = ?";
		ps = conn.prepareStatement(sql);
		ps.setString(1, tender_acct);
		rs = ps.executeQuery(); 
		
		// 获取数据
		if (rs.next()) {
			String tender_pwd = rs.getString("tender_pwd");
			tender_log = new TenderLog(tender_acct, tender_pwd);
		}
		
		// 释放资源
		DBUtil.free(rs, ps, conn);
		return tender_log;
	}
}
