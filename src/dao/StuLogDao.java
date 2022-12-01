package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.StuLog;
import db.DBUtil;

public class StuLogDao {
	//这是一个根据学生账号修改密码函数，返回值是修改是否成功的状态
	public void updateAdminPwd(String stu_acct, String stu_pwd) throws Exception {
		//下面是连接信息，不用改
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = DBUtil.getConnection();
		//上面是连接信息，不用改
		
		String sql="UPDATE stu_log SET stu_pwd=? WHERE stu_acct=?";
		ps=conn.prepareStatement(sql); 
		ps.setString(1, stu_pwd);
		ps.setString(2, stu_acct);
		
		//执行语句并返回结果集
		int rowCount = ps.executeUpdate(); 
		if(rowCount == 0) {
			throw new Exception("Update Error:Student acct:" + stu_acct);
		}
		// 用来释放资源的函数，不用改
		DBUtil.free(rs, ps, conn);
	}
	
	public List<StuLog> findAllStuLog() throws Exception{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = DBUtil.getConnection();
		
		List<StuLog> stuList = new ArrayList<StuLog>();
		String sql = "SELECT * FROM  stu_log";
		ps = conn.prepareStatement(sql);
		rs = ps.executeQuery();
		while(rs.next()) {
			String sacct = rs.getString("stu_acct");
			String spwd = rs.getString("stu_pwd");
			StuLog stu = new StuLog(sacct,spwd);
			stuList.add(stu);
		}
		DBUtil.free(rs, ps, conn);
		return stuList;
	}
	
	public void insertStuLog(String stu_acct, String stu_pwd) throws Exception {
		//下面是连接信息，不用改
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = DBUtil.getConnection();
		//上面是连接信息，不用改
		
		String sql="INSERT INTO stu_log VALUES (?,?);";
		ps=conn.prepareStatement(sql); 
		ps.setString(1, stu_acct);
		ps.setString(2, stu_pwd);
		
		int rowCount= ps.executeUpdate(); 
		if(rowCount==0) {
			throw new Exception("Insert Error:Student Account:"+stu_acct);
		}
		//释放资源
		DBUtil.free(rs, ps, conn);
	}
	
	public StuLog findStuLog(String stu_acct) throws Exception {
		//下面是连接信息，不用改
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		StuLog stu_log = null;
		conn = DBUtil.getConnection();
		//上面是连接信息，不用改
		
		String sql = "SELECT * FROM stu_log WHERE stu_acct = ?"; //这是sql语句，其中的问号代表要插入的值
		ps = conn.prepareStatement(sql); //对语句进行预编译
		ps.setString(1, stu_acct); //向语句中插入值，第一个参数表示要插入值的位置，第二个表示要插入的值
		rs = ps.executeQuery(); //执行语句并返回结果集
		if (rs.next()) {
			String sacct = rs.getString("stu_acct");
			String spwd = rs.getString("stu_pwd");
			stu_log = new StuLog(sacct, spwd); //将提取出的数据做成实体类
		}
		// 用来释放资源的函数，不用改
		DBUtil.free(rs, ps, conn);
		//返回结果集
		return stu_log;
	}
}
