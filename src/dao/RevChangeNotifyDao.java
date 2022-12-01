package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import db.DBUtil;
import tools.Tools;

public class RevChangeNotifyDao {
	public List<String> findRevChangeNotify(String stu_num) throws Exception {  
		//建立连接
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
		
		List<String> info_list = new ArrayList<String>();
		String sql = "SELECT rev_change_notify.review_info " + 
				"FROM rev_change_notify " + 
				"WHERE rev_change_notify.stu_num = ? " + 
				"AND rev_change_notify.expiry_date >= ?;";
		ps = conn.prepareStatement(sql);
		ps.setString(1, stu_num);
		ps.setString(2, sdf.format(sd));
		
		rs = ps.executeQuery();
		while(rs.next()) {
			String info = rs.getString("review_info");
			info_list.add(info);
		}
		DBUtil.free(rs, ps, conn);
		return info_list;
	}
	
	public void insertRevChangeNotify(String review_info, String stu_num, int proj_no) throws Exception{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = DBUtil.getConnection();
		
		//获取当前时间
		java.util.Date cur_date = new java.util.Date();
		cur_date = Tools.addDate(cur_date, 15);
		java.sql.Date sd;
		sd = new java.sql.Date(cur_date.getTime());
		
		String sql="INSERT INTO rev_change_notify(stu_num, proj_no, review_info, expiry_date) VALUES (?,?,?,?);";
		ps=conn.prepareStatement(sql); 
		ps.setString(1, stu_num);
		ps.setInt(2, proj_no);
		ps.setString(3, review_info);
		ps.setDate(4, sd);

		int rowCount= ps.executeUpdate(); 
		if(rowCount==0) {
			throw new Exception("Insert Error: RevChangeNotify");
		}
		DBUtil.free(rs, ps, conn);
	}
	
	public void delRevChangeNotify(String stu_num, int proj_no) throws Exception {
		//下面是连接信息，不用改
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = DBUtil.getConnection();
		//上面是连接信息，不用改
		
		String sql="DELETE FROM rev_change_notify WHERE stu_num=? AND proj_no=?;";
		ps=conn.prepareStatement(sql); 
		ps.setString(1, stu_num);
		ps.setInt(2, proj_no);
		
		//执行语句并返回结果集
		ps.executeUpdate(); 
		// 用来释放资源的函数，不用改
		DBUtil.free(rs, ps, conn);
	}
}
