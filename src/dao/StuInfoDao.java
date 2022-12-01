package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.StuInfo;
import db.DBUtil;

public class StuInfoDao {
	public StuInfo dispStuInfo(String stu_acct) throws Exception {
		// 连接信息
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = DBUtil.getConnection();
		
		// 输出结果
		StuInfo stu = null;
		
		String sql = "SELECT * FROM stu_info WHERE stu_acct = ?"; 
		ps = conn.prepareStatement(sql); 
		ps.setString(1, stu_acct); 
		rs = ps.executeQuery(); 
		
		if (rs.next()) {
			String num = rs.getString("stu_num");
			String sacct =rs.getString("stu_acct");
			String sname = rs.getString("stu_name");
			String sid = rs.getString("stu_id_num"); 
			String sex = rs.getString("stu_sex");
			String political_status = rs.getString("stu_political_status");
			String major = rs.getString("stu_major");
			String mob_no = rs.getString("stu_mob_no");
			String mail = rs.getString("stu_mail");
			Date birthday = rs.getDate("stu_birthday");
			String nation = rs.getString("stu_nation");
			String grade = rs.getString("stu_grade");
			int dates = rs.getInt("stu_dates");
			stu = new StuInfo(num, sacct, sname, sid, sex, political_status, major, mob_no, mail, nation, grade, birthday, dates); //将提取出的数据做成实体类
		}
		// 用来释放资源的函数，不用改
		DBUtil.free(rs, ps, conn);
		//返回结果集
		return stu;
	}
	
	public void updateInfo(String stu_num, String stu_acct, 
			String stu_name, String stu_id_num, String stu_sex, 
			String stu_political_status, String stu_major, String stu_mob_no,
			String stu_mail, String stu_nation, String stu_grade,
			String stu_birthday, String stu_dates) throws Exception{
		//连接信息
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = DBUtil.getConnection();
		
		String sql ="UPDATE stu_info SET stu_name=?,stu_id_num=?,stu_sex=?,stu_political_status=?,stu_major=?,stu_mob_no=?,"
				+ "stu_mail=?,stu_nation=?,stu_grade=?,stu_birthday=?,stu_dates=? WHERE stu_num=?;";
		ps=conn.prepareStatement(sql);
		ps.setString(1, stu_name);
		ps.setString(2, stu_id_num);
		ps.setString(3, stu_sex);
		ps.setString(4, stu_political_status);
		ps.setString(5, stu_major);
		ps.setString(6, stu_mob_no);
		ps.setString(7, stu_mail);
		ps.setString(8, stu_nation);
		ps.setString(9, stu_grade);
		ps.setString(10, stu_birthday);
		ps.setString(11, stu_dates);
		ps.setString(12, stu_num);
		
		int rowCount= ps.executeUpdate(); 
		if(rowCount==0) {
			throw new Exception("Insert Error:Student number:"+stu_num);
		}
		//释放资源
		DBUtil.free(rs, ps, conn);
	}

	public StuInfo dispStuDetail(String stu_num) throws Exception {
		//下面是连接信息，不用改
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		StuInfo stu = null;
		conn = DBUtil.getConnection();
		//上面是连接信息，不用改
		
		String sql = "SELECT * FROM stu_info WHERE stu_num = ?"; //这是sql语句，其中的问号代表要插入的值
		ps = conn.prepareStatement(sql); //对语句进行预编译
		ps.setString(1, stu_num); //向语句中插入值，第一个参数表示要插入值的位置，第二个表示要插入的值
		rs = ps.executeQuery(); //执行语句并返回结果集
		if (rs.next()) {
			String num = rs.getString("stu_num");
			String sacct =rs.getString("stu_acct");
			String sid = rs.getString("stu_id_num"); 
			String sname = rs.getString("stu_name");
			String sex = rs.getString("stu_sex");
			String political_status = rs.getString("stu_political_status");
			Date birthday = rs.getDate("stu_birthday");
			String major = rs.getString("stu_major");
			String mob_no = rs.getString("stu_mob_no");
			String mail = rs.getString("stu_mail");
			String nation = rs.getString("stu_nation");
			String grade = rs.getString("stu_grade");
			int dates = rs.getInt("stu_dates");
			stu = new StuInfo(num, sacct, sname, sid, sex, political_status, major, mob_no, mail, nation, grade, birthday, dates); //将提取出的数据做成实体类
		}
		// 用来释放资源的函数，不用改
		DBUtil.free(rs, ps, conn);
		//返回结果集
		return stu;
	}
	
	public List<StuInfo> findCondStuInfo(String stu_num, String stu_name, String stu_grade) throws Exception {
		//下面是连接信息，不用改
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<StuInfo> stu_info = null;
		conn = DBUtil.getConnection();
		//上面是连接信息，不用改

		if(stu_num == "" && stu_name == "" && stu_grade == "") {
			return null;
		}
		else {
			stu_info = new ArrayList<StuInfo>();
			String sql = "SELECT * FROM stu_info WHERE stu_num LIKE ? AND stu_name LIKE ? AND stu_grade LIKE ?"; //这是sql语句，其中的问号代表要插入的值
			ps = conn.prepareStatement(sql); //对语句进行预编译
			ps.setString(1, "%"+stu_num+"%"); //向语句中插入值，第一个参数表示要插入值的位置，第二个表示要插入的值
			ps.setString(2, "%"+stu_name+"%");
			ps.setString(3, "%"+stu_grade+"%");
			rs = ps.executeQuery(); //执行语句并返回结果集
			while (rs.next()) { 
				String num = rs.getString("stu_num");
				String sacct =rs.getString("stu_acct");
				String sid = rs.getString("stu_id_num"); 
				String sname = rs.getString("stu_name");
				String sex = rs.getString("stu_sex");
				String political_status = rs.getString("stu_political_status");
				Date birthday = rs.getDate("stu_birthday");
				String major = rs.getString("stu_major");
				String mob_no = rs.getString("stu_mob_no");
				String mail = rs.getString("stu_mail");
				String nation = rs.getString("stu_nation");
				String grade = rs.getString("stu_grade");
				int dates = rs.getInt("stu_dates");
				StuInfo stu = new StuInfo(num,sacct,sname,sid,sex,political_status,major,mob_no,mail,nation,grade,birthday,dates); 
				stu_info.add(stu);
			}
			// 用来释放资源的函数，不用改
			DBUtil.free(rs, ps, conn);
			//返回结果集
			return stu_info;
		}
	}
	
	public void insertStuInfo(String stu_num, String stu_acct, 
			String stu_name, String stu_id_num, String stu_sex, 
			String stu_political_status, String stu_major, String stu_mob_no,
			String stu_mail, String stu_nation, String stu_grade,
			String stu_birthday, String stu_dates) throws Exception {
		//连接信息
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = DBUtil.getConnection();
		
		String sql="INSERT INTO stu_info VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?);";
		ps=conn.prepareStatement(sql); 
		ps.setString(1, stu_num);
		ps.setString(2, stu_acct);
		ps.setString(3, stu_name);
		ps.setString(4, stu_id_num);
		ps.setString(5, stu_sex);
		ps.setString(6, stu_political_status);
		ps.setString(7, stu_major);
		ps.setString(8, stu_mob_no);
		ps.setString(9, stu_mail);
		ps.setString(10, stu_nation);
		ps.setString(11, stu_grade);
		ps.setString(12, stu_birthday);
		ps.setString(13, stu_dates);
		
		int rowCount= ps.executeUpdate(); 
		if(rowCount==0) {
			throw new Exception("Insert Error:Student number:"+stu_num);
		}
		//释放资源
		DBUtil.free(rs, ps, conn);
	}

}
