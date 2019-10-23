package cn.hp.service;
/**
 * @Description(超级管理员模块)
 * @Author 358143424@qq.com
 * @Date 2019年6月29日
 */

import java.util.List;

import cn.hp.dao.AdminDao;
import cn.hp.domain.Admin;
/**
 * @Description(超级管理员)
 * @Author 285330499@qq.com
 * @Date 2019年7月3日
 */
public class AdminServiceImpl implements AdminService{
		private AdminDao adminDao;

		public void setAdminDao(AdminDao adminDao) {
			this.adminDao = adminDao;
		}

		//添加管理员信息
		public int addAdmin(Admin admin) {
			
			return adminDao.addAdmin(admin);
		}

		
		/* @Description(查询全部管理员信息)
		 * @Author 358143424@qq.com
		 * @Date 2019年7月6日
		 */
		public List<Admin> findAdmin() {
			return adminDao.findAdmin();
		}

		
		/* @Description(单查管理信息)
		 * @Author 358143424@qq.com
		 * @Date 2019年7月6日
		 */
		public Admin oneAdmin(Admin admin) {
			return adminDao.oneAdmin(admin);
		}

		/* @Description(更新管理员信息)
		 * @Author 358143424@qq.com
		 * @Date 2019年7月6日
		 */
		public void updateAdmin(Admin admin) {
			adminDao.updateAdmin(admin);
		}
		
}
