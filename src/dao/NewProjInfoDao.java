package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import db.DBUtil;

public class NewProjInfoDao {
	public List<String> findNewProjNotify(String stu_numb) throws Exception {  
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
		
		List<String> projInfo = new ArrayList<String>();
		String sql = "SELECT info "
				+ "FROM new_proj_notify "
				+ "WHERE (new_proj_notify.country IN ( "
				+ "	SELECT pref_name "
				+ "	FROM stu_pref "
				+ "	WHERE stu_pref.stu_numb = ? AND stu_pref.pref_type = 'country' "
				+ ") OR new_proj_notify.school IN ( "
				+ "	SELECT pref_name "
				+ "	FROM stu_pref "
				+ "	WHERE stu_pref.stu_numb = ? AND stu_pref.pref_type = 'school'"
				+ ")) AND new_proj_notify.expiry_date >= ?;";
		ps = conn.prepareStatement(sql);
		ps.setString(1, stu_numb);
		ps.setString(2, stu_numb);
		ps.setString(3, sdf.format(sd));
		rs = ps.executeQuery();
		while(rs.next()) {
			String info = rs.getString("info");
			projInfo.add(info);
		}
		DBUtil.free(rs, ps, conn);
		return projInfo;
	}
	
	public void insertNewProjNotify(String info, String country, String school, Date expiry_date, int proj_id) throws Exception{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = DBUtil.getConnection();
		
		String sql="INSERT INTO new_proj_notify(info, country, school, expiry_date, proj_id) VALUES (?,?,?,?,?);";
		ps=conn.prepareStatement(sql); 
		ps.setString(1, info);
		ps.setString(2, country);
		ps.setString(3, school);
		ps.setDate(4, expiry_date);
		ps.setInt(5, proj_id);
		int rowCount= ps.executeUpdate(); 
		if(rowCount==0) {
			throw new Exception("Insert Error: NewProjInfo");
		}
		DBUtil.free(rs, ps, conn);
	}
	
	public void delNewProjNotify(int proj_no) throws Exception {
		//下面是连接信息，不用改
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = DBUtil.getConnection();
		//上面是连接信息，不用改
		
		String sql="DELETE FROM new_proj_notify WHERE proj_id=?;";
		ps=conn.prepareStatement(sql); 
		ps.setInt(1, proj_no);
		
		//执行语句并返回结果集
		ps.executeUpdate(); 
		// 用来释放资源的函数，不用改
		DBUtil.free(rs, ps, conn);
	}
}
