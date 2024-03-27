package Userzuo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 * 父类DAO,为抽象类
 */

public class BaseDAO {
	// 连接对象
	protected Connection conn;
	// 预编译执行对象
	protected PreparedStatement stmt;
	// 结果集对象
	protected ResultSet rs;
	// 第一个字符串：，MySQL驱动包的全类名
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	// 第二个字符串，mysql的服务器地址
	private static final String URL = "jdbc:mysql://localhost:3306/demo?useSSL=false&serverTimezone=GMT&characterEncoding=utf-8";
	// 3.用户名
	private static final String USER = "root";
	// 4.密码
	private static final String PWD = "123456";
	// 静态快,只执行一次
	static {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println("驱动加载失败");
			e.printStackTrace();
		}
	}

	// 获取连接对象
	public Connection getConn(){
		try {
			if (conn == null || conn.isClosed()) {
				conn = DriverManager.getConnection(URL, USER, PWD);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}

	// 关闭所有资源
	public void closeAll() {
		// 关闭对象先创建后关闭
		try {
			// 独立的try，可以保证任何一个报错，不会影响其他的对象关闭
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 释放资源 
	 */
	public void close(ResultSet rs, PreparedStatement stmt, Connection conn) {
		try {
			if(rs != null) {
				rs.close();
			}
			if(stmt != null) {
				stmt.close();
			}
			if(conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 释放资源 
	 * @param stmt
	 * @param conn
	 */
	public void close(PreparedStatement stmt, Connection conn) {
		this.close(null, stmt, conn);
	}


	public void bindParameters(PreparedStatement stmt, Object... params) {
		if (params != null) {
			for (int i = 0; i < params.length; i++) {
				try {
					stmt.setObject(i + 1, params[i]);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	} 

	/**
	 * 执行insert、update和delete语句
	 * @param sql
	 * @param params
	 * @return
	 */
	public int executeUpdate(String sql, Object...params) {
		try {
			//获取连接对象
			Connection conn = this.getConn();
			//创建语句对象
			PreparedStatement stmt = conn.prepareStatement(sql);
			//绑定参数
			this.bindParameters(stmt, params);
			//执行SQL语句
			int v = stmt.executeUpdate();
			//释放资源 
			this.close(stmt, conn);
			//返回影响的行数 
			return v;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	/**
	 * 执行select语句，返回List集合
	 * @param <E>
	 * @param sql
	 * @param mapper
	 * @param params
	 * @return
	 */
	public <E> List<E> executeQuery(String sql, Mapper<E> mapper, 
			Object...params){
		try {
			//获取连接对象
			Connection conn = this.getConn();
			//创建语句对象
			PreparedStatement stmt = conn.prepareStatement(sql);
			//绑定参数
			this.bindParameters(stmt, params);
			//执行SQL语句
			ResultSet rs = stmt.executeQuery();
			//将ResultSet转换成List
			List<E> list = mapper.map(rs);
			//释放资源 
			this.close(rs, stmt, conn);
			//返回影响的行数 
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 执行select语句，返回单个值
	 * @param <E>
	 * @param sql
	 * @param mapper
	 * @param params
	 * @return
	 */
	public Object singleObject(String sql, Object...params) {
		List<Object> list = this.executeQuery(sql, new Mapper<Object>() {
			@Override
			public List<Object> map(ResultSet rs) throws SQLException {
				List<Object> list = new ArrayList<>();
				while(rs.next()) {
					Object obj = rs.getObject(1);
					list.add(obj);
				}
				return list;
			}
		}, params);
		
		return list.get(0);//只需要List集合中的第0个元素
	}

}
	

