package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.Applicant;
import db.DBUtil;

public class ApplicantDao {
	public List<Applicant> applicantQuery(int proj_no) throws Exception {
		//连接信息
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = DBUtil.getConnection();
		
		List<Applicant> applicantList = new ArrayList<Applicant>();
		
		String sql="SELECT bidder_info.bidder_name, bidder_info.bidder_num, bidder_info.bidder_grade, bidder_info.bidder_sex, bidder_info.bidder_major, bidder_apply.apply_status, bidder_apply.apply_att_name " +
				"FROM bidder_info, bidder_apply " +
				"WHERE bidder_info.bidder_num = bidder_apply.bidder_num AND bidder_apply.proj_no = ?";
		ps=conn.prepareStatement(sql); 
		ps.setInt(1, proj_no);
		rs = ps.executeQuery();
		
		while (rs.next()) {
			String bidder_name = rs.getString("bidder_name");
			String bidder_num = rs.getString("bidder_num");
			String bidder_grade = rs.getString("bidder_grade");
			String bidder_sex = rs.getString("bidder_sex");
			String bidder_major = rs.getString("bidder_major");
			String apply_status = rs.getString("apply_status");
			String apply_att_name = rs.getString("apply_att_name");
			Applicant applicant = new Applicant(bidder_name, bidder_num, bidder_grade, bidder_sex, bidder_major, apply_status, apply_att_name);
			applicantList.add(applicant);
		}
		
		DBUtil.free(rs, ps, conn);
		//返回结果集
		return applicantList;
	}
	
	public List<Applicant> applicantCondQuery(int proj_no, String bidder_name, String bidder_num, String bidder_grade) throws Exception {
		//连接信息
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = DBUtil.getConnection();
		
		List<Applicant> list = new ArrayList<Applicant>();
		
		String sql="SELECT bidder_info.bidder_name, bidder_info.bidder_num, bidder_info.bidder_grade, bidder_info.bidder_sex, bidder_info.bidder_major, bidder_apply.apply_status, bidder_apply.apply_att_name " +
				"FROM bidder_info, bidder_apply " +
				"WHERE bidder_info.bidder_num = bidder_apply.bidder_num AND bidder_apply.proj_no = ? " +
				"AND bidder_info.bidder_num LIKE ? AND bidder_info.bidder_name LIKE ? AND bidder_info.bidder_grade LIKE ?";
		ps=conn.prepareStatement(sql); 
		ps.setInt(1, proj_no);
		ps.setString(2, "%"+bidder_num+"%");
		ps.setString(3, "%"+bidder_name+"%");
		ps.setString(4, "%"+bidder_grade+"%");
		rs = ps.executeQuery();
		
		while (rs.next()) {
			String sname = rs.getString("bidder_name");
			String snum = rs.getString("bidder_num");
			String sgrade = rs.getString("bidder_grade");
			String bidder_sex = rs.getString("bidder_sex");
			String bidder_major = rs.getString("bidder_major");
			String apply_status = rs.getString("apply_status");
			String apply_att_name = rs.getString("apply_att_name");
			Applicant applicant = new Applicant(sname, snum, sgrade, bidder_sex, bidder_major, apply_status, apply_att_name);
			list.add(applicant);
		}
		
		DBUtil.free(rs, ps, conn);
		//返回结果集
		return list;
	}
}
