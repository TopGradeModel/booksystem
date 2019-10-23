package cn.hp.dao;

import java.util.List;

import cn.hp.domain.Admin;
/**
 * @Description(超级管理员)
 * @Author 285330499@qq.com
 * @Date 2019年7月3日
 */
public interface AdminDao {
	//添加管理员
	int addAdmin(Admin admin);
	//查询全部管理员
	List<Admin> findAdmin();
	//单查管理员信息
	Admin oneAdmin(Admin admin);
	//更新管理员信息
	void updateAdmin(Admin admin);

}
