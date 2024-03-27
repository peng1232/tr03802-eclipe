package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
* @Description: 
* @author: 铭
* @date 2023年7月5日 下午2:29:33
*/

public class BaseDAO {
	//连接对象
	protected Connection conn;
	//预编译执行对象
	protected PreparedStatement stmt;
	//结果集对象
	protected ResultSet rs;
	//第一个字符串：，MySQL驱动包的全类名
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	//第二个字符串，mysql的服务器地址
	private static final String URL ="jdbc:mysql://localhost:3306/demo?useSSL=false&serverTimezone=GMT&characterEncoding=utf-8";
	//3.用户名
	private static final String USER = "root";
	//4.密码
	private static final String PWD = "123456";	 
	//静态快,只执行一次
	static {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println("驱动加载失败");
			e.printStackTrace();
		}
	}
    //获取连接对象
	public Connection getConn() throws SQLException {
		if(conn==null || conn.isClosed()) {
			conn = DriverManager.getConnection(URL, USER,PWD);
		}
		return conn;
	}
	//关闭所有资源
	public void closeAll() {
		//关闭对象先创建后关闭
		//独立的try，可以保证任何一个报错，不会影响其他的对象关闭
		if(rs!=null) {
			try {
				rs.close();
				//System.out.println("结果集已关闭");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(stmt!=null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
} 
