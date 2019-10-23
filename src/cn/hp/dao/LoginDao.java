package cn.hp.dao;

import org.springframework.transaction.annotation.Transactional;

import cn.hp.domain.Admin;

/**
 * @Description(登陆模块)
 * @Author 358143424@qq.com
 * @Date 2019年6月29日
 */
@Transactional
public interface LoginDao {
	/**
	 * @Description(验证登陆)
	 * @Author .zhangqiang
	 * @Date 2019年6月29日
	 */
	public  Admin findAdmin(Admin admin);
	/**
	 * @Description(添加上一次登陆的方法)
	 * @Author .zhangqiang
	 * @Date 2019年6月29日
	 */
	public void addDate(Admin admin);
}
