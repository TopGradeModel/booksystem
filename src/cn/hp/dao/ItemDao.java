package cn.hp.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.hp.domain.Item;
/**
 * @Description(分类模块)
 * @Author 358143424@qq.com
 * @Date 2019年6月29日
 */
@Transactional
public interface ItemDao {
	/**
	 * @Description(添加分类)
	 * @Author .zhangqiang
	 * @Date 2019年6月29日
	 */
	int addItem(Item item);

	/**
	 * @Description(查询分类)
	 * @Author 358143424@qq.com
	 * @Date 2019年6月29日
	 */
	List<Item> findItem();

	/**
	 * @Description(单查分类)
	 * @Author 358143424@qq.com
	 * @Date 2019年7月4日
	 */
	Item oneItem(int iid);

	/**
	 * @Description(跟新分类)
	 * @Author 358143424@qq.com
	 * @Date 2019年7月4日
	 */
	void updateItem(Item item);

	/**
	 * @Description(验证分类名称是否存在)
	 * @Author 358143424@qq.com
	 * @Date 2019年7月6日
	 */
	int inameItem(String iname);

}
