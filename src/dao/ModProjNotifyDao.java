package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import db.DBUtil;
import tools.Tools;

public class ModProjNotifyDao {
	public List<String> findModProjNotify(String stu_numb) throws Exception {  
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = DBUtil.getConnection();
		
		//获取当前时间
		java.util.Date cur_date = new java.util.Date();
		System.out.print(cur_date);
		java.sql.Date sd;
		sd = new java.sql.Date(cur_date.getTime());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		List<String> delProjInfo = new ArrayList<String>();
		String sql = "SELECT info " + 
				"FROM mod_proj_notify " + 
				"WHERE mod_proj_notify.proj_id IN ( " + 
				"	SELECT proj_no " + 
				"	FROM stu_apply " + 
				"	WHERE stu_apply.stu_num = ? " + 
				") AND mod_proj_notify.expiry_date >= ?;";
		ps = conn.prepareStatement(sql);
		ps.setString(1, stu_numb);
		ps.setString(2, sdf.format(sd));
		rs = ps.executeQuery();
		while(rs.next()) {
			String info = rs.getString("info");
			delProjInfo.add(info);
		}
		DBUtil.free(rs, ps, conn);
		return delProjInfo;
	}
	
	public void insertModProjNotify(String info, int proj_id) throws Exception{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = DBUtil.getConnection();
		
		//获取当前时间
		java.util.Date cur_date = new java.util.Date();
		cur_date = Tools.addDate(cur_date, 15);
		java.sql.Date sd;
		sd = new java.sql.Date(cur_date.getTime());
				
		String sql="INSERT INTO mod_proj_notify(info, expiry_date, proj_id) VALUES (?,?,?);";
		ps=conn.prepareStatement(sql); 
		ps.setString(1, info);
		ps.setDate(2, sd);
		ps.setInt(3, proj_id);
		int rowCount= ps.executeUpdate(); 
		if(rowCount==0) {
			throw new Exception("Insert Error: NewProjInfo");
		}
		DBUtil.free(rs, ps, conn);
	}
	
	public void delModProjNotify(int proj_id) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = DBUtil.getConnection();
				
		String sql="DELETE FROM mod_proj_notify WHERE proj_id=?;";
		ps=conn.prepareStatement(sql); 
		ps.setInt(1, proj_id);
		
		ps.executeUpdate(); 
		DBUtil.free(rs, ps, conn);
	}
}
