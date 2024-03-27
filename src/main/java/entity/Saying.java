package entity;

import java.sql.Timestamp;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.annotation.JSONField;

import Userzuo.BaseDAO;
import dao.news.News;

/**
* @Description: 
* @author: 铭
* @date 2024年2月27日 上午9:07:22
*/

public class Saying {
	private Integer sid;
	private String suser;
	private String scontent;
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
	public Saying(Integer sid, String suser, String scontent, Timestamp stime) {
		super();
		this.sid = sid;
		this.suser = suser;
		this.scontent = scontent;
		this.stime = stime;
	}
	public Saying() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Saying(String suser, String scontent) {
		super();
		this.suser = suser;
		this.scontent = scontent;
	}
	@Override
	public String toString() {
		return "Saying [sid=" + sid + ", suser=" + suser + ", scontent=" + scontent + ", stime=" + stime + "]";
	}

}
