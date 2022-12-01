package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.AdminLog;
import db.DBUtil;

public class AdminLogDao {
	public void updateAdminPwd(String admin_acct, String admin_pwd) throws Exception {
		// 连接信息
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = DBUtil.getConnection();
		
		// 预编译语句
		String sql="UPDATE admin_log SET admin_pwd=? WHERE admin_acct=?";
		ps=conn.prepareStatement(sql); 
		ps.setString(1, admin_pwd);
		ps.setString(2, admin_acct);
		
		// 获取数据
		int rowCount = ps.executeUpdate(); 
		if(rowCount == 0) {
			throw new Exception("Update Error->AdminLog->Pwd");
		}
		
		// 释放资源
		DBUtil.free(rs, ps, conn);	
	}
	
	public List<AdminLog> findAllAdminLog() throws Exception{
		// 连接信息
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = DBUtil.getConnection();
		
		// 要返回的数据
		List<AdminLog> adminList = new ArrayList<AdminLog>();
		
		// 预编译语句
		String sql = "SELECT * FROM admin_log";
		ps = conn.prepareStatement(sql);
		rs = ps.executeQuery();
		
		// 获取数据
		while(rs.next()) {
			String admin_acct = rs.getString("admin_acct");
			String admin_pwd = rs.getString("admin_pwd");
			AdminLog admin = new AdminLog(admin_acct, admin_pwd);
			adminList.add(admin);
		}
		
		// 释放资源
		DBUtil.free(rs, ps, conn);
		return adminList;
	}
	
	public void insertAdminLog(String admin_acct, String admin_pwd) throws Exception {
		// 连接信息
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = DBUtil.getConnection();
		
		// 预编译语句
		String sql="INSERT INTO admin_log VALUES (?,?);";
		ps=conn.prepareStatement(sql); 
		ps.setString(1, admin_acct);
		ps.setString(2, admin_pwd);
		
		// 获取数据
		int rowCount= ps.executeUpdate(); 
		if(rowCount==0) {
			throw new Exception("Insert Error->AdminLog");
		}
		
		//释放资源
		DBUtil.free(rs, ps, conn);
	}
	
	public AdminLog findAdminLog(String admin_acct) throws Exception {
		// 连接信息
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = DBUtil.getConnection();
		
		// 要返回的数据
		AdminLog admin_log = null;
		
		// 预编译语句
		String sql = "SELECT * FROM admin_log WHERE admin_acct = ?"; 
		ps = conn.prepareStatement(sql);
		ps.setString(1, admin_acct); 
		rs = ps.executeQuery(); 
		
		// 获取数据
		if (rs.next()) {
			String admin_pwd = rs.getString("admin_pwd");
			admin_log = new AdminLog(admin_acct, admin_pwd);
		}
		
		// 释放资源
		DBUtil.free(rs, ps, conn);
		return admin_log;
	}
}
