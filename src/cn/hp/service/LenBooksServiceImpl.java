package cn.hp.service;

import java.util.List;

import cn.hp.dao.LenBooksDao;
import cn.hp.domain.Books;
import cn.hp.domain.Lenbook;

/**
 * @Description(借书模块)
 * @Author 358143424@qq.com
 * @Date 2019年7月3日
 */
public class LenBooksServiceImpl implements LenBooksService {
	private LenBooksDao lenBooksDao;
	public void setLenBooksDao(LenBooksDao lenBooksDao) {
		this.lenBooksDao = lenBooksDao;
	}
	/* @Description(全查图书)
	 * @Author 358143424@qq.com
	 * @Date 2019年7月3日
	 */
	public List<Books> listBooks() {
		return lenBooksDao.listBooks();
	}
	
	/* @Description(添加借书信息)
	 * @Author 358143424@qq.com
	 * @Date 2019年7月3日
	 */
	public int addLenBook(Lenbook lenbook) {
		return lenBooksDao.addLenBook(lenbook);
	}
	/* @Description(全查借书信息)
	 * @Author 358143424@qq.com
	 * @Date 2019年7月3日
	 */
	public List<Lenbook> findLenBook(Integer currentPage, Integer lineSize) {
		
		return lenBooksDao.findLenBook(currentPage,lineSize);
	}
	/* @Description(单查借书信息的方法)
	 * @Author 358143424@qq.com
	 * @Date 2019年7月4日
	 */
	public Lenbook oneLenBook(int leids) {
		return lenBooksDao.oneLenBook(leids);
	}
	/* @Description(修改借书状态)
	 * @Author 358143424@qq.com
	 * @Date 2019年7月4日
	 */
	public void updateStatus(Lenbook lenbook,int bid) {
		lenBooksDao.updateStatus(lenbook,bid);
		
	}
	/* @Description(查询总条数)
	 * @Author 358143424@qq.com
	 * @Date 2019年7月5日
	 */
	public Integer findCount() {
		return lenBooksDao.findCount();
	}
}
