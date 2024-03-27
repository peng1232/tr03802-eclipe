package dao.news;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* @Description: 
* @author: 铭
* @date 2024年3月5日 上午11:00:17
*/

public class NewsDAO extends BaseDAO{
	//添加
	public Integer insert(News n) {
		String sql = "insert into news values(null,?,?,?)";
		return executeUpdate(sql, n.getNtitle(),n.getNsource(),new Timestamp(new Date().getTime()));
	}
	public List<News> rtnList(ResultSet rs){
		List<News> list = new ArrayList<>();
		try {
			while(rs.next()) {
				News News = new News(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getTimestamp(4));
				list.add(News);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	} 
	//查询详细
	public List<News> selectAll() {
		String sql = "select * from news order by nid desc";
		return executeQuery(sql, new Mapper<News>() {
			@Override
			public List<News> map(ResultSet rs) throws SQLException {
				return rtnList(rs);
			}
		});
	}
	//分页查询
	public Map<String, Object> selectPage(Integer curpage,Integer pagesize){
		String sql = "select * from news order by nid desc limit ?,?";
		List<News> list = executeQuery(sql,new Mapper<News>() {
			@Override
			public List<News> map(ResultSet rs) throws SQLException {
				return rtnList(rs);
			}
		}, (curpage - 1) * pagesize, pagesize);
		sql = "select count(*) from news";
		Object obj = singleObject(sql);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		map.put("total", obj);
		return map;
	}
	//删除近一个月的新闻
	public Integer deleteMonth() {
		String sql  ="delete from news where ntime < DATE_SUB(NOW(), INTERVAL 1 MONTH)";
		return executeUpdate(sql);
	}
	public static void main(String[] args) {
		NewsDAO n = new NewsDAO();
		//添加
		System.out.println("添加："+n.insert(new News("标题", "湖南")));
		//查询所有
		System.out.println(n.selectAll());
		//分页查询
		System.err.println(n.selectPage(1, 5));
		//删除近一个月的新闻
		System.out.println("删除："+n.deleteMonth());
	}
}
