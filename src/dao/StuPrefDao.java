package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.StuPref;
import db.DBUtil;

public class StuPrefDao {
	public void delStuPref(String stu_num) throws Exception {
		//下面是连接信息，不用改
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = DBUtil.getConnection();
		//上面是连接信息，不用改
		
		String sql="DELETE FROM stu_pref WHERE stu_numb=?";
		ps=conn.prepareStatement(sql); 
		ps.setString(1, stu_num);
		
		//执行语句并返回结果集
		ps.executeUpdate(); 

		// 用来释放资源的函数，不用改
		DBUtil.free(rs, ps, conn);
	}
	
	public List<StuPref> findAllStuPref(String stu_num) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = DBUtil.getConnection();
		
		List<StuPref> stuPrefList = new ArrayList<StuPref>();
		String sql = "SELECT * FROM stu_pref WHERE stu_numb=?";
		ps = conn.prepareStatement(sql);
		ps.setString(1, stu_num);
		rs = ps.executeQuery();
		while(rs.next()) {
			int pref_id = rs.getInt("pref_id");
			String stu_numb = rs.getString("stu_numb");
			String pref_type = rs.getString("pref_type");
			String pref_name = rs.getString("pref_name");
			StuPref stu_pref = new StuPref(pref_id, stu_numb, pref_type, pref_name);
			stuPrefList.add(stu_pref);
		}
		DBUtil.free(rs, ps, conn);
		return stuPrefList;
	}
	
	public void insertStuPref(String stu_num, String pref_type, String pref_name) throws Exception{
		//下面是连接信息，不用改
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = DBUtil.getConnection();
		//上面是连接信息，不用改
		String sql="INSERT INTO stu_pref(stu_numb, pref_type, pref_name) VALUES (?,?,?);";
		ps=conn.prepareStatement(sql); 
		ps.setString(1, stu_num);
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
