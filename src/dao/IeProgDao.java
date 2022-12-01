package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import beans.IeProg;
import db.DBUtil;

public class IeProgDao {
	public int insertIeProg(String proj_name,String proj_sch,Date proj_apply_ddl, Date proj_start_time,String proj_lang,String proj_country,String proj_pub_acct,int proj_credict,String proj_time,String proj_info,String proj_file) throws Exception{
		//下面是连接信息，不用改
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = DBUtil.getConnection();
		//上面是连接信息，不用改
		String sql="INSERT INTO ie_prog(proj_name, proj_sch, proj_apply_ddl, proj_start_time, proj_lang, proj_country, proj_pub_acct, proj_credict,proj_time,proj_info, proj_file) VALUES (?,?,?,?,?,?,?,?,?,?,?);";
		ps=conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); 
		ps.setString(1, proj_name);
		ps.setString(2, proj_sch);
		ps.setDate(3, proj_apply_ddl);
		ps.setDate(4, proj_start_time);
		ps.setString(5, proj_lang);
		ps.setString(6, proj_country);
		ps.setString(7, proj_pub_acct);
		ps.setInt(8, proj_credict);
		ps.setString(9, proj_time);
		ps.setString(10, proj_info);
		ps.setString(11, proj_file);
		ps.executeUpdate(); 
		rs = ps.getGeneratedKeys();
		int autoIncKey;
		if (rs.next()) {
			autoIncKey = rs.getInt(1);//取得ID
		} else {
			throw new Exception("Insert Error Project");
		}
		//释放资源
		DBUtil.free(rs, ps, conn);
		return autoIncKey;
	}
	
	public List<IeProg> curProgQuery(Date cur_date, String proj_name, String proj_sch, String proj_country) throws Exception {
		//连接信息
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = DBUtil.getConnection();
		
		List<IeProg> proList = new ArrayList<IeProg>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		String sql="SELECT * FROM ie_prog WHERE proj_start_time >= ? AND  proj_name LIKE ? AND proj_sch LIKE ? AND proj_country LIKE ?;";
		ps=conn.prepareStatement(sql); 
		ps.setString(1, sdf.format(cur_date));
		ps.setString(2, "%"+proj_name+"%");
		ps.setString(3, "%"+proj_sch+"%");
		ps.setString(4, "%"+proj_country+"%");
		rs = ps.executeQuery();
		
		while (rs.next()) {
			int proj_no = rs.getInt("proj_no");
			String name = rs.getString("proj_name");
			String sch = rs.getString("proj_sch");
			Date proj_apply_ddl = rs.getDate("proj_apply_ddl");
			Date proj_start_time = rs.getDate("proj_start_time");
			String proj_lang = rs.getString("proj_lang");
			String country = rs.getString("proj_country");
			String proj_pub_acct = rs.getString("proj_pub_acct");
			int proj_credict = rs.getInt("proj_credict");
			String proj_time = rs.getString("proj_time");
			String proj_info = rs.getString("proj_info");
			String proj_file = rs.getString("proj_file");
			IeProg proj = new IeProg(proj_no, name, sch, proj_apply_ddl, proj_start_time,
					proj_lang, country, proj_pub_acct, proj_credict, proj_time,
					proj_info, proj_file);
			proList.add(proj);
		}
		
		DBUtil.free(rs, ps, conn);
		//返回结果集
		return proList;
	}
	
	public List<IeProg> histProgQuery(Date cur_date, String proj_name, String proj_sch, String proj_country) throws Exception {
		//连接信息
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = DBUtil.getConnection();
		
		List<IeProg> proList = new ArrayList<IeProg>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if(proj_name == "" && proj_sch == "" && proj_country == "") {
			return null;
		}
		else {
			String sql="SELECT * FROM ie_prog WHERE proj_apply_ddl < ? AND proj_name LIKE ? AND proj_sch LIKE ? AND proj_country LIKE ?";
			ps=conn.prepareStatement(sql); 
			ps.setString(1, sdf.format(cur_date));
			ps.setString(2, "%"+proj_name+"%");
			ps.setString(3, "%"+proj_sch+"%");
			ps.setString(4, "%"+proj_country+"%");
			rs = ps.executeQuery();
			
			while (rs.next()) {
				int proj_no = rs.getInt("proj_no");
				String name = rs.getString("proj_name");
				String sch = rs.getString("proj_sch");
				Date proj_apply_ddl = rs.getDate("proj_apply_ddl");
				Date proj_start_time = rs.getDate("proj_start_time");
				String proj_lang = rs.getString("proj_lang");
				String country = rs.getString("proj_country");
				String proj_pub_acct = rs.getString("proj_pub_acct");
				int proj_credict = rs.getInt("proj_credict");
				String proj_time = rs.getString("proj_time");
				String proj_info = rs.getString("proj_info");
				String proj_file = rs.getString("proj_file");
				IeProg proj = new IeProg(proj_no, name, sch, proj_apply_ddl, proj_start_time,
						proj_lang, country, proj_pub_acct, proj_credict, proj_time,
						proj_info, proj_file);
				proList.add(proj);
			}
			
			DBUtil.free(rs, ps, conn);
			//返回结果集
			return proList;
		}
	}
	
	public List<IeProg> allCurProgFind(Date cur_date) throws Exception {
		//连接信息
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = DBUtil.getConnection();
		
		List<IeProg> proList = new ArrayList<IeProg>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String sql="SELECT * FROM ie_prog WHERE proj_start_time >= ?";
		ps=conn.prepareStatement(sql); 
		ps.setString(1, sdf.format(cur_date));
		rs = ps.executeQuery();
		
		while (rs.next()) {
			int proj_no = rs.getInt("proj_no");
			String name = rs.getString("proj_name");
			String sch = rs.getString("proj_sch");
			Date proj_apply_ddl = rs.getDate("proj_apply_ddl");
			Date proj_start_time = rs.getDate("proj_start_time");
			String proj_lang = rs.getString("proj_lang");
			String country = rs.getString("proj_country");
			String proj_pub_acct = rs.getString("proj_pub_acct");
			int proj_credict = rs.getInt("proj_credict");
			String proj_time = rs.getString("proj_time");
			String proj_info = rs.getString("proj_info");
			String proj_file = rs.getString("proj_file");
			IeProg proj = new IeProg(proj_no, name, sch, proj_apply_ddl, proj_start_time,
					proj_lang, country, proj_pub_acct, proj_credict, proj_time,
					proj_info, proj_file);
			proList.add(proj);
		}
		
		DBUtil.free(rs, ps, conn);
		//返回结果集
		return proList;
	}
	
	public void delIeProg(int proj_no) throws Exception {
		//下面是连接信息，不用改
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = DBUtil.getConnection();
		//上面是连接信息，不用改
		
		String sql="DELETE FROM ie_prog WHERE proj_no=?;";
		ps=conn.prepareStatement(sql); 
		ps.setInt(1, proj_no);
		
		//执行语句并返回结果集
		ps.executeUpdate(); 
		// 用来释放资源的函数，不用改
		DBUtil.free(rs, ps, conn);
	}
	
	public IeProg dispProjDetail(int proj_no) throws Exception{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = DBUtil.getConnection();
		
		IeProg proj = null;
		String sql = "SELECT * FROM ie_prog WHERE proj_no = ?"; //这是sql语句，其中的问号代表要插入的值
		ps = conn.prepareStatement(sql); //对语句进行预编译
		ps.setInt(1, proj_no); //向语句中插入值，第一个参数表示要插入值的位置，第二个表示要插入的值
		rs = ps.executeQuery(); //执行语句并返回结果集
		
		if (rs.next()) {
			int pNum = rs.getInt("proj_no");
			String pName =rs.getString("proj_name");
			String pSch = rs.getString("proj_sch"); 
			Date pApplyDdl = rs.getDate("proj_apply_ddl");
			Date pStartTime = rs.getDate("proj_start_time");
			String pLang = rs.getString("proj_lang");
			String pCountry = rs.getString("proj_country");
			String pPubAcct = rs.getString("proj_pub_acct");
			int pCredict = rs.getInt("proj_credict");
			String pTime = rs.getString("proj_time");
			String pInfo = rs.getString("proj_info");
			String pFile = rs.getString("proj_file");
			proj = new IeProg(pNum,pName,pSch,pApplyDdl,pStartTime,pLang,pCountry,pPubAcct,pCredict,pTime,pInfo,pFile); //将提取出的数据做成实体类
		}
		// 用来释放资源的函数，不用改
		DBUtil.free(rs, ps, conn);
		//返回结果集
		return proj;
	}
	
	public void updateIeProg(int proj_no, String proj_name,String proj_sch,Date proj_apply_ddl, 
			Date proj_start_time,String proj_lang,String proj_country,
			String proj_pub_acct,int proj_credict,String proj_time,
			String proj_info,String proj_file) throws Exception{
		//连接信息
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = DBUtil.getConnection();
		
		String sql="UPDATE ie_prog SET proj_name=?,proj_sch=?,proj_apply_ddl=?,proj_start_time=?,proj_lang=?,"
				+ "proj_country=?,proj_pub_acct=?,proj_credict=?,proj_time=?,proj_info=?,proj_file=? WHERE proj_no=?;";
		ps=conn.prepareStatement(sql);
		ps.setString(1, proj_name);
		ps.setString(2, proj_sch);
		ps.setDate(3, proj_apply_ddl);
		ps.setDate(4, proj_start_time);
		ps.setString(5, proj_lang);
		ps.setString(6, proj_country);
		ps.setString(7, proj_pub_acct);
		ps.setInt(8, proj_credict);
		ps.setString(9, proj_time);
		ps.setString(10, proj_info);
		ps.setString(11, proj_file);
		ps.setInt(12, proj_no);
		
		int rowCount= ps.executeUpdate(); 
		if(rowCount==0) {
			throw new Exception("Update Error: Ieprog");
		}
		//释放资源
		DBUtil.free(rs, ps, conn);
	}
}
