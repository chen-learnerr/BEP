package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.BidderInfo;
import db.DBUtil;

public class BidderInfoDao {
	public BidderInfo dispBidderInfo(String bidder_acct) throws Exception {
		// 连接信息
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = DBUtil.getConnection();
		
		// 输出结果
		BidderInfo bidder = null;
		
		String sql = "SELECT * FROM bidder_info WHERE bidder_acct = ?";
		ps = conn.prepareStatement(sql); 
		ps.setString(1, bidder_acct);
		rs = ps.executeQuery(); 
		
		if (rs.next()) {
			String num = rs.getString("bidder_num");
			String sacct =rs.getString("bidder_acct");
			String sname = rs.getString("bidder_name");
			String sid = rs.getString("bidder_id_num");
			String sex = rs.getString("bidder_sex");
			String political_status = rs.getString("bidder_political_status");
			String major = rs.getString("bidder_major");
			String mob_no = rs.getString("bidder_mob_no");
			String mail = rs.getString("bidder_mail");
			Date birthday = rs.getDate("bidder_birthday");
			String nation = rs.getString("bidder_nation");
			String grade = rs.getString("bidder_grade");
			int dates = rs.getInt("bidder_dates");
			bidder = new BidderInfo(num, sacct, sname, sid, sex, political_status, major, mob_no, mail, nation, grade, birthday, dates); //将提取出的数据做成实体类
		}
		// 用来释放资源的函数，不用改
		DBUtil.free(rs, ps, conn);
		//返回结果集
		return bidder;
	}
	
	public void updateInfo(String bidder_num, String bidder_acct,
			String bidder_name, String bidder_id_num, String bidder_sex,
			String bidder_political_status, String bidder_major, String bidder_mob_no,
			String bidder_mail, String bidder_nation, String bidder_grade,
			String bidder_birthday, String bidder_dates) throws Exception{
		//连接信息
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = DBUtil.getConnection();
		
		String sql ="UPDATE bidder_info SET bidder_name=?,bidder_id_num=?,bidder_sex=?,bidder_political_status=?,bidder_major=?,bidder_mob_no=?,"
				+ "bidder_mail=?,bidder_nation=?,bidder_grade=?,bidder_birthday=?,bidder_dates=? WHERE bidder_num=?;";
		ps=conn.prepareStatement(sql);
		ps.setString(1, bidder_name);
		ps.setString(2, bidder_id_num);
		ps.setString(3, bidder_sex);
		ps.setString(4, bidder_political_status);
		ps.setString(5, bidder_major);
		ps.setString(6, bidder_mob_no);
		ps.setString(7, bidder_mail);
		ps.setString(8, bidder_nation);
		ps.setString(9, bidder_grade);
		ps.setString(10, bidder_birthday);
		ps.setString(11, bidder_dates);
		ps.setString(12, bidder_num);
		
		int rowCount= ps.executeUpdate(); 
		if(rowCount==0) {
			throw new Exception("Insert Error:bidder number:"+bidder_num);
		}
		//释放资源
		DBUtil.free(rs, ps, conn);
	}

	public BidderInfo dispBidderDetail(String bidder_num) throws Exception {
		//下面是连接信息，不用改
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		BidderInfo bidder = null;
		conn = DBUtil.getConnection();
		//上面是连接信息，不用改
		
		String sql = "SELECT * FROM bidder_info WHERE bidder_num = ?"; //这是sql语句，其中的问号代表要插入的值
		ps = conn.prepareStatement(sql); //对语句进行预编译
		ps.setString(1, bidder_num); //向语句中插入值，第一个参数表示要插入值的位置，第二个表示要插入的值
		rs = ps.executeQuery(); //执行语句并返回结果集
		if (rs.next()) {
			String num = rs.getString("bidder_num");
			String sacct =rs.getString("bidder_acct");
			String sid = rs.getString("bidder_id_num");
			String sname = rs.getString("bidder_name");
			String sex = rs.getString("bidder_sex");
			String political_status = rs.getString("bidder_political_status");
			Date birthday = rs.getDate("bidder_birthday");
			String major = rs.getString("bidder_major");
			String mob_no = rs.getString("bidder_mob_no");
			String mail = rs.getString("bidder_mail");
			String nation = rs.getString("bidder_nation");
			String grade = rs.getString("bidder_grade");
			int dates = rs.getInt("bidder_dates");
			bidder = new BidderInfo(num, sacct, sname, sid, sex, political_status, major, mob_no, mail, nation, grade, birthday, dates); //将提取出的数据做成实体类
		}
		// 用来释放资源的函数，不用改
		DBUtil.free(rs, ps, conn);
		//返回结果集
		return bidder;
	}
	
	public List<BidderInfo> findCondBidderInfo(String bidder_num, String bidder_name, String bidder_grade) throws Exception {
		//下面是连接信息，不用改
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<BidderInfo> bidder_info = null;
		conn = DBUtil.getConnection();
		//上面是连接信息，不用改

		if(bidder_num == "" && bidder_name == "" && bidder_grade == "") {
			return null;
		}
		else {
			bidder_info = new ArrayList<BidderInfo>();
			String sql = "SELECT * FROM bidder_info WHERE bidder_num LIKE ? AND bidder_name LIKE ? AND bidder_grade LIKE ?"; //这是sql语句，其中的问号代表要插入的值
			ps = conn.prepareStatement(sql); //对语句进行预编译
			ps.setString(1, "%"+bidder_num+"%"); //向语句中插入值，第一个参数表示要插入值的位置，第二个表示要插入的值
			ps.setString(2, "%"+bidder_name+"%");
			ps.setString(3, "%"+bidder_grade+"%");
			rs = ps.executeQuery(); //执行语句并返回结果集
			while (rs.next()) { 
				String num = rs.getString("bidder_num");
				String sacct =rs.getString("bidder_acct");
				String sid = rs.getString("bidder_id_num");
				String sname = rs.getString("bidder_name");
				String sex = rs.getString("bidder_sex");
				String political_status = rs.getString("bidder_political_status");
				Date birthday = rs.getDate("bidder_birthday");
				String major = rs.getString("bidder_major");
				String mob_no = rs.getString("bidder_mob_no");
				String mail = rs.getString("bidder_mail");
				String nation = rs.getString("bidder_nation");
				String grade = rs.getString("bidder_grade");
				int dates = rs.getInt("bidder_dates");
				BidderInfo bidder = new BidderInfo(num,sacct,sname,sid,sex,political_status,major,mob_no,mail,nation,grade,birthday,dates);
				bidder_info.add(bidder);
			}
			// 用来释放资源的函数，不用改
			DBUtil.free(rs, ps, conn);
			//返回结果集
			return bidder_info;
		}
	}
	
	public void insertBidderInfo(String bidder_num, String bidder_acct,
			String bidder_name, String bidder_id_num, String bidder_sex,
			String bidder_political_status, String bidder_major, String bidder_mob_no,
			String bidder_mail, String bidder_nation, String bidder_grade,
			String bidder_birthday, String bidder_dates) throws Exception {
		//连接信息
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = DBUtil.getConnection();
		
		String sql="INSERT INTO bidder_info VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?);";
		ps=conn.prepareStatement(sql); 
		ps.setString(1, bidder_num);
		ps.setString(2, bidder_acct);
		ps.setString(3, bidder_name);
		ps.setString(4, bidder_id_num);
		ps.setString(5, bidder_sex);
		ps.setString(6, bidder_political_status);
		ps.setString(7, bidder_major);
		ps.setString(8, bidder_mob_no);
		ps.setString(9, bidder_mail);
		ps.setString(10, bidder_nation);
		ps.setString(11, bidder_grade);
		ps.setString(12, bidder_birthday);
		ps.setString(13, bidder_dates);
		
		int rowCount= ps.executeUpdate(); 
		if(rowCount==0) {
			throw new Exception("Insert Error:bidder number:"+bidder_num);
		}
		//释放资源
		DBUtil.free(rs, ps, conn);
	}

}
