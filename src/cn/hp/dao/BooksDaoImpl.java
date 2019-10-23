package cn.hp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import cn.hp.domain.Admin;
import cn.hp.domain.Books;
import cn.hp.domain.Item;
import cn.hp.utils.Utils;

/**
 * @Description(图书模块)
 * @Author 358143424@qq.com
 * @Date 2019年6月29日
 */
public class BooksDaoImpl implements BooksDao {
	private HibernateTemplate hibernateTemplate;
	private Connection conn=null;
	private PreparedStatement ptmt=null;
	private ResultSet rs=null;
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	//添加图书信息
	public int addBooks(Books books) {
			hibernateTemplate.save(books);
		return 1;
	}
	//全查图书分页
	public List<Books> listBooks(Integer currentPage, Integer lineSize) {
		conn = Utils.getConnection();
		String sql="select b.bid,b.name,b.credate,b.status,a.aid,i.iname from books b,admin a,item i where b.aid=a.aid and b.iid=i.iid limit ?,?;";
		try {
			ptmt = conn.prepareStatement(sql);
			ptmt.setInt(1,(currentPage-1)*lineSize);
			ptmt.setInt(2,lineSize);
			rs = ptmt.executeQuery();
			List<Books> listbooks=new ArrayList<>();
			while(rs.next()){
				Books books=new Books();
				books.setBid(rs.getInt("bid"));
				books.setName(rs.getString("name"));
				books.setCredate(rs.getString("credate"));
				books.setStatus(rs.getInt("status"));
				Admin admin=new Admin();
				admin.setAid(rs.getString("aid"));
				books.setAdmin(admin);
				Item item=new Item();
				item.setIname(rs.getString("iname"));
				books.setItem(item);
				listbooks.add(books);
			}
			return listbooks;
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
		String sql="select count(*) from books";
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
	//单查图书信息
	public Books oneBooks(Books books) {
		Books books2 = hibernateTemplate.get(Books.class, books.getBid());
		return books2;
	}
	//修改图书列表信息
	public void updateBooks(Books books) {
		Books books2 = hibernateTemplate.get(Books.class,books.getBid());
		books2.setName(books.getName());
		books2.setCredate(books.getCredate());
		books2.setNote(books.getNote());
		books2.setStatus(books.getStatus());
		hibernateTemplate.update(books2);
	}
}
