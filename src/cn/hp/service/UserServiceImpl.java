package cn.hp.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.hp.dao.UserDao;
import cn.hp.dao.UserDaoImpl;
import cn.hp.domain.Member;
/**
 * @Description(用户模块)
 * @Author 358143424@qq.com
 * @Date 2019年6月29日
 */
public class UserServiceImpl implements UserService{
	private UserDao userDao;
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	//添加用户信息
	public int addMember(Member member) {
		return userDao.addMember(member);
	}
	//查询用户
	public List<Member> findUser(Integer currentPage, Integer lineSize) {
		return userDao.findUser(currentPage,lineSize);
	}
	//查询总条数
	public Integer findCount() {
		return userDao.findCount();
	}
	//Ajax单查用户信息
	public Member oneMember(Member member) {
		return userDao.oneMember(member);
	}
	//修改用户信息
	public void updateStatus(Member member) {
		userDao.updateMember(member);
	}
	
	//ajax验证编号是否存在
	public int userMid(String mid) {
		return userDao.userMid(mid);
	}
}
