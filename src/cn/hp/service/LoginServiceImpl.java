package cn.hp.service;

import org.springframework.transaction.annotation.Transactional;

import cn.hp.dao.LoginDao;
import cn.hp.dao.LoginDaoImpl;
import cn.hp.domain.Admin;

/**
 * @Description(登陆模块)
 * @Author 358143424@qq.com
 * @Date 2019年6月29日
 */
public class LoginServiceImpl implements LoginService {
	private static LoginDao loginDao;
	public static void setLoginDao(LoginDao loginDao) {
		LoginServiceImpl.loginDao = loginDao;
	}
	//验证登陆
	public  Admin findAdmin(Admin admin) {
		return loginDao.findAdmin(admin);
	}

}
