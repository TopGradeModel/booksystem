package cn.hp.domain;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/**
 * @Description(管理员实体类)
 * @Author 358143424@qq.com
 * @Date 2019年6月29日
 */
public class Admin {
	private  String aid;
	private  String password;
	private String lastdate;
	private String urls;
	private int flag;
	private int status;
	private Set<Books> books=new HashSet<>();
	public Set<Books> getBooks() {
		return books;
	}
	public void setBooks(Set<Books> books) {
		this.books = books;
	}
	public String getAid() {
		return aid;
	}
	public void setAid(String aid) {
		this.aid = aid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLastdate() {
		return lastdate;
	}
	public void setLastdate(String lastdate) {
		this.lastdate = lastdate;
	}
	public String getUrls() {
		return urls;
	}
	public void setUrls(String urls) {
		this.urls = urls;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Admin [aid=" + aid + ", password=" + password + ", lastdate=" + lastdate + ", urls=" + urls + ", flag="
				+ flag + ", status=" + status + ", books=" + books + "]";
	}
}
