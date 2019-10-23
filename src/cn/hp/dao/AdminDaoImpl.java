package cn.hp.dao;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;

import cn.hp.domain.Admin;

/**
 * @Description(超级管理员)
 * @Author 285330499@qq.com
 * @Date 2019年7月3日
 */
public class AdminDaoImpl implements AdminDao{
	private static HibernateTemplate hibernateTemplate;

	public static void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		AdminDaoImpl.hibernateTemplate = hibernateTemplate;
	}

	//添加管理员
	public int addAdmin(Admin admin) {
		try {
			hibernateTemplate.save(admin);
		} catch (Exception e) {
			return 0;
		}
		return 1;
	}

	//查询管理员
	public List<Admin> findAdmin() {
		List<Admin> listAdmin = (List<Admin>) hibernateTemplate.find("from Admin");
		return listAdmin;
	}

	//单查管理员信息
	public Admin oneAdmin(Admin admin) {
		Admin oneAdmin = hibernateTemplate.get(Admin.class, admin.getAid());
		return oneAdmin;
	}

	//更新管理员信息
	public void updateAdmin(Admin admin) {
		Admin admin2 = hibernateTemplate.get(Admin.class, admin.getAid());
		admin2.setFlag(admin.getFlag());
		admin2.setStatus(admin.getStatus());
		hibernateTemplate.update(admin2);
	}
	
	
}
