package VEO;

import java.util.Date;

/**
* @Description: 
* @author: 铭
* @date 2024年2月29日 上午10:29:30
*/

public class ChartDCVO {
	private Date date;
	private Integer count;
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "ChartDCVO [date=" + date + ", count=" + count + "]";
	}
	public ChartDCVO(Date date, Integer count) {
		super();
		this.date = date;
		this.count = count;
	}
	public ChartDCVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
