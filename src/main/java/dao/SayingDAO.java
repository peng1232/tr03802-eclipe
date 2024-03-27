package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import VEO.ChartDCVO;
import entity.Saying;
import util.BaseDAO;


public class SayingDAO extends BaseDAO{
	public void insert(Saying s) {
		String sql = "insert into saying values(null,?,?,?)";
		try {
			stmt = getConn().prepareStatement(sql);
			stmt.setObject(1, s.getSuser());
			stmt.setObject(2, s.getScontent());
			stmt.setObject(3, new Timestamp(new Date().getTime()));
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeAll();
		}
	}
	public static void main(String[] args) {

		System.out.println(new SayingDAO().charDC());
	}
	
	public List<Saying> selectAll(){
		String sql = "select * from saying order by sid desc";
		try {
			stmt = getConn().prepareStatement(sql);
			rs = stmt.executeQuery();
			List<Saying> list = map(rs);
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeAll();
		}
		return null;
	}
	
	//分页
	public Map<String,Object> selectByPage(int curpage,int pagesize){
		String sql = "select * from saying order by sid desc limit ?,? ";
		try {
			stmt = getConn().prepareStatement(sql);
			stmt.setObject(1, (curpage -1) * pagesize);
			stmt.setObject(2, pagesize);
			rs = stmt.executeQuery();
			List<Saying> list = map(rs);
			//将list添加到map集合
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("list", list);
			//记录合计条数
			sql = "select count(*) from saying";
			stmt = getConn().prepareStatement(sql);
			rs = stmt.executeQuery();
			Integer total = 0;
			if(rs.next()) {
				total = rs.getInt(1);
			}
			map.put("total", total);
			return map;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeAll();
		}
		return null;
	}
	
	private List<Saying> map(ResultSet rs) throws SQLException{
		List<Saying> list = new ArrayList<Saying>();
		while(rs.next()) {
			list.add(new Saying(rs.getInt("sid"), rs.getString("suser"), rs.getString("scontent"), rs.getTimestamp("stime")));
		}
		return list;
	}
	
	//删除留言
	public Integer doDelete(Integer id) {
		String sql = "delete from saying where sid = ?";
		try {
			stmt = getConn().prepareStatement(sql);
			stmt.setObject(1, id);
			return stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeAll();
		}
		return null;
	}
	
	//修改数据
	public Integer doupdate(String zhi1,String zhi2,Integer id) {
		String sql = "update saying set scontent=?, suser=? where sid = ?";
		try {
			stmt = getConn().prepareStatement(sql);
			stmt.setObject(1, zhi1);
			stmt.setObject(2, zhi2);
			stmt.setObject(3, id);
			System.out.println(stmt);
			return stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeAll();
		}
		return null;
	}
	
	//查询访问数
	public List<ChartDCVO> charDC(){
		String sql = "SELECT DATE_FORMAT(stime,'%Y-%m-%d') a,COUNT(*) b FROM saying GROUP BY DATE_FORMAT(stime,'%Y-%m-%d') order by DATE_FORMAT(stime,'%Y-%m-%d') desc";
		try {
			stmt = getConn().prepareStatement(sql);
			rs = stmt.executeQuery();
			List<ChartDCVO> list = new ArrayList<ChartDCVO>();
			while(rs.next()) {
				list.add(new ChartDCVO(rs.getDate("a"),rs.getInt("b")));
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeAll();
		}
		return null;
	
	}
}