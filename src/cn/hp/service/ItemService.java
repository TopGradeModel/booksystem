package cn.hp.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.hp.domain.Item;

/**
 * @Description(分类模块)
 * @Author 358143424@qq.com
 * @Date 2019年6月29日
 */
@Transactional
public interface ItemService {
	/**
	 * @Description(添加分类)
	 * @Author .zhangqiang
	 * @Date 2019年6月29日
	 */
	int addItem(Item item);

	/**
	 * @Description(查询全部分类)
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
	 * @Description(更新图书分类)
	 * @Author 358143424@qq.com
	 * @Date 2019年7月4日
	 */
	void updateItem(Item item);

	/**
	 * @Description(获取分类名称)
	 * @Author 358143424@qq.com
	 * @Date 2019年7月6日
	 */
	int inameItem(String iname);

}
