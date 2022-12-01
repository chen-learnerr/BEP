package db;
import java.sql.*;
public class DBUtil {
	
	//设计获得连接对象的方法getConnection()
	public static Connection getConnection() throws Exception{
		String driver = "com.mysql.cj.jdbc.Driver";            //驱动程序名
		String user = "root";                               //数据库用户名
		String password = "123456";                        //数据库用户密码
		String dbName = "siemis";              //数据库名
		String url1 = "jdbc:mysql://127.0.0.1:3306/" + dbName;
		String url2 = "?user=" + user + "&password=" + password;
		String url3 = "&useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC";
		String url = url1 + url2 + url3;          //形成带数据库读写编码的数据库连接字
		Class.forName(driver);             //加载并注册驱动程序
		Connection conn = DriverManager.getConnection(url); //创建连接对象
		return conn;
	}
	
	//设计释放结果集、执行语句和连接对象的方法free()
	public static void free(ResultSet rs, Statement st, Connection conn) throws Exception {
		 if (rs != null){ rs.close();}
		 if (st != null) {st.close();}
		 if (conn != null){ conn.close();}
	}
}