package json;

import java.sql.Array;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.alibaba.fastjson2.annotation.JSONField;

/**
* @Description: 
* @author: 铭
* @date 2024年3月11日 上午9:09:51
*/

public class json {
	private Integer sid;
	private String suser;
	//改名称的注解
	@JSONField (name = "s")
	private String scontent;
	//格式化日期的注解
	@JSONField(format = "yyyy-MM-dd")
	private Timestamp stime;
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public String getSuser() {
		return suser;
	}
	public void setSuser(String suser) {
		this.suser = suser;
	}
	public String getScontent() {
		return scontent;
	}
	public void setScontent(String scontent) {
		this.scontent = scontent;
	}
	public Timestamp getStime() {
		return stime;
	}
	public void setStime(Timestamp stime) {
		this.stime = stime;
	}
	public json(Integer sid, String suser, String scontent, Timestamp stime) {
		super();
		this.sid = sid;
		this.suser = suser;
		this.scontent = scontent;
		this.stime = stime;
	}
	public json() {
		super();
		// TODO Auto-generated constructor stub
	}
	public json(String suser, String scontent) {
		super();
		this.suser = suser;
		this.scontent = scontent;
	}
	public static void main(String[] args) {
		json a1 = new json(1, "1", "1", new Timestamp(1));
		json a2 = new json(2, "2", "2", new Timestamp(2));
		System.out.println(JSONObject.toJSONString(a1));
		List<json> list =new ArrayList<json>();
		list.add(a1);
		list.add(a2);
		System.out.println(JSONArray.toJSONString(list));
		
		Map<Integer, json> map = new HashMap<Integer, json>();
		map.put(1, a1);
		map.put(2, a2);
		System.err.println(JSONArray.toJSONString(map));
		
		json[] j = {a1,a2};
		System.out.println(JSONObject.toJSONString(j));
		
	}
}
