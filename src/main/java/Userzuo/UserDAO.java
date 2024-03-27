package Userzuo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
* @Description: 
* @author: 铭
* @date 2024年3月7日 上午11:09:02
*/

public class UserDAO extends BaseDAO{
	//登录
	public User dengLv(String name,String passwrod) {
		String sql = "select * from touuser where uname=? and upasswrod = ?";
		List<User> list = new ArrayList<User>();
		this.executeQuery(sql, new Mapper<User>() {

			@Override
			public List<User> map(ResultSet rs) throws SQLException {
				
				if(rs.next()) {
					list.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));
				}
				return list;
			}
		}, name,passwrod);
		if(list.size()>0) {
			return list.get(0);
		}else {
			return null;
		}
	}
	
	//修改图片路径
	public Integer headUpdate(Integer uid,String head) {
		String sql = "update touuser set head = ? where uid = ?";
		List<User> list = new ArrayList<User>();
		return this.executeUpdate(sql, head,uid);
	}
	public static void main(String[] args) {
		System.out.println(new UserDAO().dengLv("aa", "123"));
	}
	
	//添加用户
	public Integer insert(User user) {
		String sql = "INSERT INTO touuser VALUES (null,?,?,?,?,?)";
		List<User> list = new ArrayList<User>();
		return this.executeUpdate(sql,user.getUname(),user.getUpasswrod(),user.getPhone(),user.getAddress(),user.getHead());
	}
	
	public List<User> selectAll(){
		List<User> list = new ArrayList<User>();
		String sql = "select * from touuser order by uid desc";
		executeQuery(sql, new Mapper<User>() {
			
			@Override
			public List<User> map(ResultSet rs) throws SQLException {
				while(rs.next()) {
					list.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));
				}
				return list;
			}
		});
		return list;
	}
	
	//删除
	public Integer doDelete(Integer uid) {
		String sql = "delete from touuser where uid = ?";
		List<User> list = new ArrayList<User>();
		return this.executeUpdate(sql,uid);
	}
}
