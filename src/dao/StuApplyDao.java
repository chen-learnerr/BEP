package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.StuApply;
import db.DBUtil;

public class StuApplyDao {
	public void insertStuApply(String stu_num, int proj_no, String apply_status, String apply_att_name) throws Exception{
		//下面是连接信息，不用改
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = DBUtil.getConnection();
		
		//上面是连接信息，不用改
		String sql="INSERT INTO stu_apply(stu_num, proj_no, apply_status, apply_att_name) VALUES (?,?,?,?);";
		ps=conn.prepareStatement(sql); 
		ps.setString(1, stu_num);
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
	
	public List<StuApply> findAllStuApply(String stu_num) throws Exception {
		//连接信息
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = DBUtil.getConnection();
		
		List<StuApply> proList = new ArrayList<StuApply>();
		
		String sql="SELECT * FROM stu_apply WHERE stu_num = ?;";
		ps=conn.prepareStatement(sql); 
		ps.setString(1, stu_num);
		rs = ps.executeQuery();
		
		while (rs.next()) {
			String stu_numb = rs.getString("stu_num");
			int proj_no = rs.getInt("proj_no");
			String apply_status = rs.getString("apply_status");
			String aprv_admin = rs.getString("aprv_admin");
			String apply_att_name = rs.getString("apply_att_name");
			
			StuApply stu_apply = new StuApply(stu_numb, proj_no, apply_status, aprv_admin, apply_att_name);
			proList.add(stu_apply);
			
		}
		
		return proList;
	}
	
	public void delStuApply(String stu_num, int proj_no) throws Exception {
		//下面是连接信息，不用改
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = DBUtil.getConnection();
		//上面是连接信息，不用改
		
		String sql="DELETE FROM stu_apply WHERE stu_num=? AND proj_no = ?;";
		ps=conn.prepareStatement(sql); 
		ps.setString(1, stu_num);
		ps.setInt(2, proj_no);
		
		//执行语句并返回结果集
		ps.executeUpdate(); 
		// 用来释放资源的函数，不用改
		DBUtil.free(rs, ps, conn);
	}
	
	public void delStuApply(int proj_no) throws Exception {
		//下面是连接信息，不用改
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = DBUtil.getConnection();
		//上面是连接信息，不用改
		
		String sql="DELETE FROM stu_apply WHERE proj_no = ?;";
		ps=conn.prepareStatement(sql); 
		ps.setInt(1, proj_no);
		
		//执行语句并返回结果集
		ps.executeUpdate(); 
		// 用来释放资源的函数，不用改
		DBUtil.free(rs, ps, conn);
	}
	
	public void updateApply(String stu_num, int proj_no, String proj_status, String aprv_admin) throws Exception{
		//连接信息
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = DBUtil.getConnection();
		
		String sql ="UPDATE stu_apply SET apply_status=?, aprv_admin=? WHERE stu_num=? AND proj_no=?;";
		ps=conn.prepareStatement(sql);
		ps.setString(1, proj_status);
		ps.setString(2, aprv_admin);
		ps.setString(3, stu_num);
		ps.setInt(4, proj_no);
		
		int rowCount= ps.executeUpdate(); 
		if(rowCount==0) {
			throw new Exception("Update Error: updateApply");
		}
		//释放资源
		DBUtil.free(rs, ps, conn);
	}
	
	public StuApply findStuApply(String stu_num, int proj_no) throws Exception {
		//连接信息
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = DBUtil.getConnection();
		
		//要返回的值
		StuApply stu_apply = null;
		
		//预编译sql语句
		String sql="SELECT * FROM stu_apply WHERE stu_num = ? AND proj_no = ?;";
		ps=conn.prepareStatement(sql); 
		ps.setString(1, stu_num);
		ps.setInt(2, proj_no);
		rs = ps.executeQuery();
		
		//获得结果
		if (rs.next()) {
			String apply_status = rs.getString("apply_status");
			String aprv_admin = rs.getString("aprv_admin");
			String apply_att_name = rs.getString("apply_att_name");
			
			stu_apply = new StuApply(stu_num, proj_no, apply_status, aprv_admin, apply_att_name);
		}
		
		return stu_apply;
	}
}
