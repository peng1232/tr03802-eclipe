package Userzuo;

/**
* @Description: 
* @author: 铭
* @date 2024年3月7日 上午11:08:52
*/

public class User {
	private Integer uid;
	private String uname;
	private String upasswrod;
	private String phone;
	private String address;
	private String head;
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpasswrod() {
		return upasswrod;
	}
	public void setUpasswrod(String upasswrod) {
		this.upasswrod = upasswrod;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getHead() {
		return head;
	}
	public void setHead(String head) {
		this.head = head;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", uname=" + uname + ", upasswrod=" + upasswrod + ", phone=" + phone + ", address="
				+ address + ", head=" + head + "]";
	}
	public User(Integer uid, String uname, String upasswrod, String phone, String address, String head) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.upasswrod = upasswrod;
		this.phone = phone;
		this.address = address;
		this.head = head;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
