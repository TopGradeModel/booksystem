package cn.hp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import cn.hp.domain.Admin;
import cn.hp.domain.Books;
import cn.hp.domain.Item;
import cn.hp.domain.Member;
import cn.hp.utils.Utils;

/**
 * @Description(用户模块)
 * @Author 358143424@qq.com
 * @Date 2019年6月29日
 */
public class UserDaoImpl implements UserDao{
	private static HibernateTemplate hibernateTemplate;
	private Connection conn=null;
	private PreparedStatement ptmt=null;
	private ResultSet rs=null;
	public static void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		UserDaoImpl.hibernateTemplate = hibernateTemplate;
	}
	//添加图书信息
	public int addMember(Member member) {
		try {
			hibernateTemplate.save(member);
		} catch (Exception e) {
			return 0;
		}
		return 1;
	}
	//查询用户
	public List<Member> findUser(Integer currentPage, Integer lineSize) {
		conn = Utils.getConnection();
		String sql="select * from member where mid limit ?,?;";
		try {
			ptmt = conn.prepareStatement(sql);
			ptmt.setInt(1,(currentPage-1)*lineSize);
			ptmt.setInt(2,lineSize);
			rs = ptmt.executeQuery();
			List<Member> listMember=new ArrayList<>();
			while(rs.next()){
				Member member=new Member();
				member.setMid(rs.getString("mid"));
				member.setMname(rs.getString("mname"));
				member.setAge(rs.getInt("age"));
				member.setSex(rs.getInt("sex"));
				member.setPhone(rs.getString("phone"));
				listMember.add(member);
			}
			return listMember;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Utils.closeConnection(conn, rs, ptmt);
		}
		return null;
	}
	//查询总条数
	public Integer findCount() {
		Connection conn = Utils.getConnection();
		String sql="select count(*) from member";
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ResultSet rs = ptmt.executeQuery();
			while(rs.next()){
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	//ajax 单查用户信息
	public Member oneMember(Member member) {
		Member oneMember = hibernateTemplate.get(Member.class, member.getMid());
		return oneMember;
	}
	//修改用户信息
	public void updateMember(Member member) {
		Member member2 = hibernateTemplate.get(Member.class, member.getMid());
		member2.setMname(member.getMname());
		member2.setAge(member.getAge());
		member2.setSex(member.getSex());
		member2.setPhone(member.getPhone());
		hibernateTemplate.update(member2);
	}
	
	//ajax验证用户编号是否存在
	public int userMid(String mid) {
			Member member = hibernateTemplate.get(Member.class,mid);
			if(member!=null) {
				return 1;
			}else {
				return 0;
			}
	}
}
