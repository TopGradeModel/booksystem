package cn.hp.dao;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import cn.hp.domain.Item;
import cn.hp.domain.Member;

/**
 * @Description(分类模块)
 * @Author 358143424@qq.com
 * @Date 2019年6月29日
 */
public class ItemDaoImpl implements ItemDao{
	private HibernateTemplate hibernateTemplate;
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	//添加分类
	public int addItem(Item item) {
		try {
			hibernateTemplate.save(item);
		} catch (Exception e) {
			return 0;
		}
		return 1;
	}
	//查询分类
	public List<Item> findItem() {
		List<Item> listItem = (List<Item>) hibernateTemplate.find("from Item", null);
		return listItem;
	}
	//单查分类
	public Item oneItem(int iid) {
		Item item = hibernateTemplate.get(Item.class, iid);
		return item;
	}
	//跟新分类
	public void updateItem(Item item) {
		//先查后改
		Item item2 = hibernateTemplate.get(Item.class,item.getIid());
		item2.setIname(item.getIname());
		item2.setNote(item.getNote());
		hibernateTemplate.update(item2);
	}
	//查看分类名称是否存在
	public int inameItem(String iname) {
		List<Item> list = (List<Item>) hibernateTemplate.find("from Item where iname = ?", iname);
		if(list!=null&&list.size()>0) {
			return 1;
		}
		return 0;
	}
}
