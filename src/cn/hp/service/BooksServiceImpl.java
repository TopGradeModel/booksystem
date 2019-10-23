package cn.hp.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.hp.dao.BooksDao;
import cn.hp.domain.Books;

/**
 * @Description(图书模块)
 * @Author 358143424@qq.com
 * @Date 2019年6月29日
 */
public class BooksServiceImpl implements BooksService {
	private BooksDao booksDao;
	public void setBooksDao(BooksDao booksDao) {
		this.booksDao = booksDao;
	}
	//添加图书信息
	public int addBooks(Books books) {
		return booksDao.addBooks(books);
	}
	//全查图书分页
	public List<Books> listBooks(Integer currentPage, Integer lineSize) {
		
		
		return booksDao.listBooks(currentPage,lineSize);
	}
	//数据总条数
	public Integer findCount() {
		// TODO Auto-generated method stub
		return booksDao.findCount();
	}
	//单查图书列表信息
	public Books oneBooks(Books books) {
		return booksDao.oneBooks(books);
	}
	//修改图书信息
	public void updateStatus(Books books) {
		booksDao.updateBooks(books);
	}
}
