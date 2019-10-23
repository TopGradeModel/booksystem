package cn.hp.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description(分类模块实体类)
 * @Author 358143424@qq.com
 * @Date 2019年6月29日
 */
public class Item {
	private Integer iid;
	private String iname;
	private String note;
	private Set<Books> bookss=new HashSet<Books>();
	public Set<Books> getBookss() {
		return bookss;
	}
	public void setBookss(Set<Books> bookss) {
		this.bookss = bookss;
	}
	public Integer getIid() {
		return iid;
	}
	public void setIid(Integer iid) {
		this.iid = iid;
	}
	public String getIname() {
		return iname;
	}
	public void setIname(String iname) {
		this.iname = iname;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	@Override
	public String toString() {
		return "Item [iid=" + iid + ", iname=" + iname + ", note=" + note + ", bookss=" + bookss + "]";
	}
}
