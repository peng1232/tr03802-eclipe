package tag;


import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * @Description:
 * @author: 铭
 * @date 2024年1月23日 上午9:28:27
 */

public class PageTag extends SimpleTagSupport {
	private String controller; // Web 组件名
	private int curpage; // 当前页
	private int pagesize; // 页大小
	private int total; // 总记录数
	private String where = "";// 其他请求参数

	
	
	//总页数
	
	public String getController() {
		return controller;
	}

	public void setController(String controller) {
		this.controller = controller;
	}

	public int getCurpage() {
		return curpage;
	}

	public void setCurpage(int curpage) {
		this.curpage = curpage;
	}

	public int getPagesize() {
		return pagesize;
	}

	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public String getWhere() {
		return where;
	}

	public void setWhere(String where) {
		this.where = where;
	}

	private int pages() {
		return (this.total - 1) / this.pagesize + 1;
	}

	@Override
	public void doTag() throws JspException, IOException {
		super.doTag();
		String url = "<a href='%s?curpage=%d&pagesize=%d&%s' class='tiao'>%s</a>";
		
		// 上一页
		String pre = null;
		if (this.curpage == 1) {
			pre = "<a class='shang tiao'>上一页</a>";
		} else {
			pre = String.format(url, this.controller, this.curpage - 1, this.pagesize, this.where, "上一页");
		}
		// 下一页
		String next = null;
		if (this.curpage == this.pages()) {
			next = "<a class='xia tiao'>下一页</a>";
		} else {
			next = String.format(url, this.controller, this.curpage + 1, this.pagesize, this.where, "下一页");
		}
		
		String info = String.format(" 第<span id='ye'>%d</span>页/共%d 页 共%d 条", this.curpage, this.pages(), this.total);
		// 拼出最后的结果
		StringBuffer sb = new StringBuffer();
		sb.append("<div class='fen'>");
		sb.append(pre);
		sb.append("<select id ='select'>");
		String url2 ="'%s?curpage=%d&pagesize=%d&%s'";
			for(int i=1;i<=pages();i++) {
				String zhi =  String.format(url2, this.controller, i, this.pagesize, this.where, i+"");
				sb.append("<option value="+zhi+" "+(curpage==i?"selected":"")+">");
				sb.append(i+"");
				sb.append("</option>");
			}
		sb.append("</select>");
		sb.append(next);
		sb.append(info);
		sb.append("</div>");
		// 输出
		JspWriter out = this.getJspContext().getOut();
		out.print(sb);
		out.print("<script>");
		out.print("$(function(){");
		out.print("$('#select').change(function(){");
		out.print("	window.location.replace($(this).val());");
		out.print("})");
		out.print("})");
		out.print("</script>");
	}
}
