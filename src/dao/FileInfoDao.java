package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import beans.FileInfo;
import db.DBUtil;

public class FileInfoDao {
	public void insertFileInfo(String file_save_name, String file_disp_name, String file_path) throws Exception {
		//下面是连接信息，不用改
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = DBUtil.getConnection();
		//上面是连接信息，不用改
		
		String sql="INSERT INTO file_info VALUES (?,?,?);";
		ps=conn.prepareStatement(sql); 
		ps.setString(1, file_save_name);
		ps.setString(2, file_disp_name);
		ps.setString(3, file_path);
		
		int rowCount= ps.executeUpdate(); 
		if(rowCount==0) {
			throw new Exception("Insert File Error");
		}
		//释放资源
		DBUtil.free(rs, ps, conn);
	}
	
	public void delFileInfo(String file_save_name) throws Exception {
		//下面是连接信息，不用改
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = DBUtil.getConnection();
		//上面是连接信息，不用改
		
		String sql="DELETE FROM file_info WHERE file_save_name=?;";
		ps=conn.prepareStatement(sql); 
		ps.setString(1, file_save_name);
		
		//执行语句并返回结果集
		ps.executeUpdate(); 
		// 用来释放资源的函数，不用改
		DBUtil.free(rs, ps, conn);
	}
	
	public FileInfo findFileInfo(String file_save_name) throws Exception {
		//连接信息
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = DBUtil.getConnection();
		
		FileInfo file_info = null;
		
		String sql="SELECT * FROM file_info WHERE file_save_name = ?;";
		ps=conn.prepareStatement(sql); 
		ps.setString(1, file_save_name);
		rs = ps.executeQuery();
		
		if (rs.next()) {
			String fsave_name = rs.getString("file_save_name");
			String file_disp_name = rs.getString("file_disp_name");
			String file_path = rs.getString("file_path");
			file_info = new FileInfo(fsave_name, file_disp_name, file_path);
		}
		
		DBUtil.free(rs, ps, conn);
		//返回结果集
		return file_info;
	}
}
