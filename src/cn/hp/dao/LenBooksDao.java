package cn.hp.dao;

import java.util.List;

import cn.hp.domain.Books;
import cn.hp.domain.Lenbook;

/**
 * @Description(借书模块)
 * @Author 358143424@qq.com
 * @Date 2019年7月3日
 */
public interface LenBooksDao {
	/**
	 * @Description(全查图书)
	 * @Author 358143424@qq.com
	 * @Date 2019年7月3日
	 */
	List<Books> listBooks();

	/**
	 * @Description(添加借书信息)
	 * @Author 358143424@qq.com
	 * @Date 2019年7月3日
	 */
	int addLenBook(Lenbook lenbook);

	/**
	 * @Description(全查借书信息)
	 * @Author 358143424@qq.com
	 * @Date 2019年7月3日
	 */
	List<Lenbook> findLenBook(Integer currentPage, Integer lineSize);

	/**
	 * @Description(单查借书信息)
	 * @Author 358143424@qq.com
	 * @Date 2019年7月4日
	 */
	Lenbook oneLenBook(int leids);

	/**
	 * @Description(修改借书状态的方法)
	 * @Author 358143424@qq.com
	 * @Date 2019年7月4日
	 */
	void updateStatus(Lenbook lenbook,int bid);

	/**
	 * @Description(查询总条数)
	 * @Author 358143424@qq.com
	 * @Date 2019年7月5日
	 */
	Integer findCount();

}
