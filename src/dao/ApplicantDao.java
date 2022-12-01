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
		
		String sql="SELECT stu_info.stu_name, stu_info.stu_num, stu_info.stu_grade, stu_info.stu_sex, stu_info.stu_major, stu_apply.apply_status, stu_apply.apply_att_name " + 
				"FROM stu_info, stu_apply " + 
				"WHERE stu_info.stu_num = stu_apply.stu_num AND stu_apply.proj_no = ?";
		ps=conn.prepareStatement(sql); 
		ps.setInt(1, proj_no);
		rs = ps.executeQuery();
		
		while (rs.next()) {
			String stu_name = rs.getString("stu_name");
			String stu_num = rs.getString("stu_num");
			String stu_grade = rs.getString("stu_grade");
			String stu_sex = rs.getString("stu_sex");
			String stu_major = rs.getString("stu_major");
			String apply_status = rs.getString("apply_status");
			String apply_att_name = rs.getString("apply_att_name");
			Applicant applicant = new Applicant(stu_name, stu_num, stu_grade, stu_sex, stu_major, apply_status, apply_att_name);
			applicantList.add(applicant);
		}
		
		DBUtil.free(rs, ps, conn);
		//返回结果集
		return applicantList;
	}
	
	public List<Applicant> applicantCondQuery(int proj_no, String stu_name, String stu_num, String stu_grade) throws Exception {
		//连接信息
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = DBUtil.getConnection();
		
		List<Applicant> list = new ArrayList<Applicant>();
		
		String sql="SELECT stu_info.stu_name, stu_info.stu_num, stu_info.stu_grade, stu_info.stu_sex, stu_info.stu_major, stu_apply.apply_status, stu_apply.apply_att_name " + 
				"FROM stu_info, stu_apply " + 
				"WHERE stu_info.stu_num = stu_apply.stu_num AND stu_apply.proj_no = ? " + 
				"AND stu_info.stu_num LIKE ? AND stu_info.stu_name LIKE ? AND stu_info.stu_grade LIKE ?";
		ps=conn.prepareStatement(sql); 
		ps.setInt(1, proj_no);
		ps.setString(2, "%"+stu_num+"%");
		ps.setString(3, "%"+stu_name+"%");
		ps.setString(4, "%"+stu_grade+"%");
		rs = ps.executeQuery();
		
		while (rs.next()) {
			String sname = rs.getString("stu_name");
			String snum = rs.getString("stu_num");
			String sgrade = rs.getString("stu_grade");
			String stu_sex = rs.getString("stu_sex");
			String stu_major = rs.getString("stu_major");
			String apply_status = rs.getString("apply_status");
			String apply_att_name = rs.getString("apply_att_name");
			Applicant applicant = new Applicant(sname, snum, sgrade, stu_sex, stu_major, apply_status, apply_att_name);
			list.add(applicant);
		}
		
		DBUtil.free(rs, ps, conn);
		//返回结果集
		return list;
	}
}
