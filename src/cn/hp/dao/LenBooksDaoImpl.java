package cn.hp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;

import cn.hp.domain.Admin;
import cn.hp.domain.Books;
import cn.hp.domain.Item;
import cn.hp.domain.Lenbook;
import cn.hp.domain.Member;
import cn.hp.utils.Utils;

/**
 * @Description(借书模块) @Author 358143424@qq.com
 * @Date 2019年7月3日
 */
public class LenBooksDaoImpl implements LenBooksDao {
	private HibernateTemplate hibernateTemplate;
	private Connection conn = null;
	private PreparedStatement ptmt = null;
	private ResultSet rs = null;

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	/*
	 * @Description(全查图书)
	 * 
	 * @Author 358143424@qq.com
	 * 
	 * @Date 2019年7月3日
	 */
	public List<Books> listBooks() {
		List<Books> list = (List<Books>) hibernateTemplate.find("from Books");
		return list;
	}

	// 添加借书信息
	public int addLenBook(Lenbook lenbook) {
		try {
			Books books = hibernateTemplate.get(Books.class,lenbook.getBooks().getBid());
			books.setStatus(0);
			hibernateTemplate.update(books);
			hibernateTemplate.save(lenbook);
		} catch (Exception e) {
			return 0;
		}
		return 1;
	}

	/*
	 * @Description(全查借书信息)
	 * 
	 * @Author 358143424@qq.com
	 * 
	 * @Date 2019年7月3日
	 */
	public List<Lenbook> findLenBook(Integer currentPage, Integer lineSize) {
		conn = Utils.getConnection();
		String sql = "select l.leid,l.credate,l.retdate,l.returnbook,b.name,b.bid,m.mname,m.phone from lenbook l,books b,member m where l.bid=b.bid and l.mid=m.mid limit ?,?;";
		try {
			ptmt = conn.prepareStatement(sql);
			ptmt.setInt(1, (currentPage - 1) * lineSize);
			ptmt.setInt(2, lineSize);
			rs = ptmt.executeQuery();
			List<Lenbook> listLenBooks = new ArrayList<>();
			while (rs.next()) {
				Lenbook lenbooks=new Lenbook();
				lenbooks.setLeid(rs.getInt("leid"));
				lenbooks.setCredate(rs.getString("credate"));
				lenbooks.setRetdate(rs.getString("retdate"));
				lenbooks.setReturnbook(rs.getInt("returnbook"));
				Books books=new Books();
				books.setName(rs.getString("name"));
				books.setBid(rs.getInt("bid"));
				lenbooks.setBooks(books);
				Member member=new Member();
				member.setMname(rs.getString("mname"));
				member.setPhone(rs.getString("phone"));
				lenbooks.setMember(member);
				listLenBooks.add(lenbooks);
			}
			return listLenBooks;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Utils.closeConnection(conn, rs, ptmt);
		}
		return null;
	}

	/*
	 * @Description(单查借书信息)
	 * 
	 * @Author 358143424@qq.com
	 * 
	 * @Date 2019年7月4日
	 */
	public Lenbook oneLenBook(int leids) {
		Lenbook lenbook = hibernateTemplate.get(Lenbook.class, leids);
		return lenbook;
	}

	//更新借书表
	public void updateStatus(Lenbook lenbook,int bid) {
		Lenbook lenbook2 = hibernateTemplate.get(Lenbook.class,lenbook.getLeid());
		Books books = hibernateTemplate.get(Books.class, bid);
		books.setStatus(lenbook.getReturnbook());
		lenbook2.setReturnbook(lenbook.getReturnbook());
		lenbook2.setCredate(lenbook.getCredate());
		lenbook2.setRetdate(lenbook.getRetdate());
		hibernateTemplate.delete(lenbook2);
		hibernateTemplate.update(books);
	}

	//查询总条数
	public Integer findCount() {
		Connection conn = Utils.getConnection();
		String sql="select count(*) from Lenbook";
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
}
