package dao.news;

import java.sql.Timestamp;

/**
* @Description: 
* @author: 铭
* @date 2024年3月5日 上午11:00:55
*/

public class News {
	private Integer nid;
	private String ntitle;
	private String nsource;
	private Timestamp ntime;
	public Integer getNid() {
		return nid;
	}
	public void setNid(Integer nid) {
		this.nid = nid;
	}
	public String getNtitle() {
		return ntitle;
	}
	public void setNtitle(String ntitle) {
		this.ntitle = ntitle;
	}
	public String getNsource() {
		return nsource;
	}
	public void setNsource(String nsource) {
		this.nsource = nsource;
	}
	public Timestamp getNtime() {
		return ntime;
	}
	public void setNtime(Timestamp ntime) {
		this.ntime = ntime;
	}
	@Override
	public String toString() {
		return "News [nid=" + nid + ", ntitle=" + ntitle + ", nsource=" + nsource + ", ntime=" + ntime + "]";
	}
	public News(Integer nid, String ntitle, String nsource, Timestamp ntime) {
		super();
		this.nid = nid;
		this.ntitle = ntitle;
		this.nsource = nsource;
		this.ntime = ntime;
	}
	public News() {
		super();
		// TODO Auto-generated constructor stub
	}
	public News(String ntitle, String nsource) {
		super();
		this.ntitle = ntitle;
		this.nsource = nsource;
	}
	
}
