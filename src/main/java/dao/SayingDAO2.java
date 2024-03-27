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
import util.you.Mapper;


public class SayingDAO2 extends util.you.BaseDAO{
	public void insert(Saying s) {
		String sql = "insert into saying values(null,?,?,?)";
		executeUpdate(sql, s.getSuser(),s.getScontent(),new Timestamp(new Date().getTime()));
	}
	public void delete(int s) {
		String sql = "delete from saying where sid = ?";
		executeUpdate(sql,s);
		
	}
	public List<Saying> selectALl(){
		String sql = "select * from saying order by sid desc";
		return executeQuery(sql,new Mapper<Saying>() {
			@Override
			public List<Saying> map(ResultSet rs) {
				List<Saying> list = new ArrayList<Saying>();
				try {
					while(rs.next()) {
						list.add(new Saying(rs.getInt("sid"), rs.getString("suser"), rs.getString("scontent"), rs.getTimestamp("stime")));
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return list;
			}
		});
	}
	private Object name() {
		String sql = "select count(*) from saying";
		return (Object) singleObject(sql);
		
	}
	public static void main(String[] args) {

		//	new SayingDAO2().insert(new Saying("xx", "xx"));
		System.err.println(new SayingDAO2().name().getClass());
	}
	

}