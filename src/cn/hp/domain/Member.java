package cn.hp.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description(用户模块实体类)
 * @Author 358143424@qq.com
 * @Date 2019年6月29日
 */
public class Member {
	private String mid;
	private String mname;
	private int age;
	private int sex;
	private String phone;
	//1的一方有多的一方的集合
	private Set<Lenbook> lenbooks=new HashSet<>();
	public Set<Lenbook> getLenbooks() {
		return lenbooks;
	}
	public void setLenbooks(Set<Lenbook> lenbooks) {
		this.lenbooks = lenbooks;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "Member [mid=" + mid + ", mname=" + mname + ", age=" + age + ", sex=" + sex + ", phone=" + phone + "]";
	}
}
