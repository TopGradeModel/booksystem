package cn.hp.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.hp.dao.ItemDao;
import cn.hp.domain.Item;


/**
 * @Description(分类模块)
 * @Author 358143424@qq.com
 * @Date 2019年6月29日
 */
public class ItemServiceImpl implements ItemService {
	private ItemDao itemDao;
	public void setItemDao(ItemDao itemDao) {
		this.itemDao = itemDao;
	}
	//添加分类
	public int addItem(Item item) {
		
		return itemDao.addItem(item);
	}
	//查询全部分类
	public List<Item> findItem() {
		return itemDao.findItem();
	}
	//单查分类
	public Item oneItem(int iid) {
		return itemDao.oneItem(iid);
	}
	//更新图书分类
	public void updateItem(Item item) {
		itemDao.updateItem(item);
	}
	//获取分类名称
	public int inameItem(String iname) {
		return itemDao.inameItem(iname);
	}
}
