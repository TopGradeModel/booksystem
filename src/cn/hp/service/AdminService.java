package cn.hp.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.hp.domain.Admin;


/**
 * @Description(超级管理员)
 * @Author 285330499@qq.com
 * @Date 2019年7月3日
 */
@Transactional
public interface AdminService {
	/**
	 * @Description(添加管理员)
	 * @Author 285330499@qq.com
	 * @Date 2019年7月3日
	 */
	public int addAdmin(Admin admin);

	/**
	 * @Description(查询全部管理员信息)
	 * @Author 358143424@qq.com
	 * @Date 2019年7月6日
	 */
	public List<Admin> findAdmin();

	/**
	 * @Description(单查管理员信息)
	 * @Author 358143424@qq.com
	 * @Date 2019年7月6日
	 */
	public Admin oneAdmin(Admin admin);

	/**
	 * @Description(跟新管理员信息)
	 * @Author 358143424@qq.com
	 * @Date 2019年7月6日
	 */
	public void updateAdmin(Admin admin);
}
