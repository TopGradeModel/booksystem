package cn.hp.domain;

import java.util.Date;

public class Lenbook {
	private int leid;
	private String credate;
	private String retdate;
	private int flag;
	private int returnbook;
	//多的一方有1的一方的对象
	private Member member;
	private Books books;
	public int getReturnbook() {
		return returnbook;
	}
	public void setReturnbook(int returnbook) {
		this.returnbook = returnbook;
	}
	public Books getBooks() {
		return books;
	}
	public void setBooks(Books books) {
		this.books = books;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public int getLeid() {
		return leid;
	}
	public void setLeid(int leid) {
		this.leid = leid;
	}
	public String getCredate() {
		return credate;
	}
	public void setCredate(String credate) {
		this.credate = credate;
	}
	public String getRetdate() {
		return retdate;
	}
	public void setRetdate(String retdate) {
		this.retdate = retdate;
	}
	public String toString() {
		return "Lenbook [leid=" + leid + ", credate=" + credate + ", retdate=" + retdate + ", flag=" + flag
				+ ", returnbook=" + returnbook + ", member=" + member + ", books=" + books + "]";
	}
}
