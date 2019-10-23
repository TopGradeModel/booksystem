package cn.hp.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @Description(图书模块实体类)
 * @Author 358143424@qq.com
 * @Date 2019年6月29日
 */
public class Books {
	private int  bid; //图书编号
	private String name; //图书名称
	private String credate; //上架时间
	private int status;//状态
	private String note;//备注
	private Admin admin;
	private Item item;
	private Set<Lenbook> lenbooks=new HashSet<>(); 
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public Set<Lenbook> getLenbooks() {
		return lenbooks;
	}
	public void setLenbooks(Set<Lenbook> lenbooks) {
		this.lenbooks = lenbooks;
	}
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCredate() {
		return credate;
	}
	public void setCredate(String credate) {
		this.credate = credate;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
}
