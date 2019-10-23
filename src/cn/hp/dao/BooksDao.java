package cn.hp.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.hp.domain.Books;
/**
 * @Description(图书模块)
 * @Author 358143424@qq.com
 * @Date 2019年6月29日
 */
@Transactional
public interface BooksDao {

	/**
	 * @Description(添加图书信息)
	 * @Author 358143424@qq.com
	 * @Date 2019年6月29日
	 */
	int addBooks(Books books);

	/**
	 * @Description(全查图书分页)
	 * @Author 358143424@qq.com
	 * @Date 2019年7月1日
	 */
	List<Books> listBooks(Integer currentPage, Integer lineSize);

	/**
	 * @Description(数据库中数据的总条数)
	 * @Author 358143424@qq.com
	 * @Date 2019年7月2日
	 */
	Integer findCount();

	/**
	 * @Description(单查图书列表信息)
	 * @Author 358143424@qq.com
	 * @Date 2019年7月4日
	 */
	Books oneBooks(Books books);

	/**
	 * @Description(修改图书信息)
	 * @Author 358143424@qq.com
	 * @Date 2019年7月4日
	 */
	void updateBooks(Books books);

}
