package cn.hp.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.hp.domain.Member;

/**
 * @Description(用户模块)
 * @Author 358143424@qq.com
 * @Date 2019年6月29日
 */
@Transactional
public interface UserService {
	/**
	 * @Description(添加用户)
	 * @Author .zhangqiang
	 * @Date 2019年6月29日
	 */
	public int addMember(Member member);

	/**
	 * @Description(查询用户)
	 * @Author 358143424@qq.com
	 * @Date 2019年7月5日
	 */
	public List<Member> findUser(Integer currentPage, Integer lineSize);

	/**
	 * @Description(查询总条数)
	 * @Author 358143424@qq.com
	 * @Date 2019年7月6日
	 */
	public Integer findCount();

	/**
	 * @Description(ajax单查用户信息)
	 * @Author 358143424@qq.com
	 * @Date 2019年7月6日
	 */
	public Member oneMember(Member member);

	/**
	 * @Description(修改用户信息)
	 * @Author 358143424@qq.com
	 * @Date 2019年7月6日
	 */
	public void updateStatus(Member member);

	/**
	 * @Description(ajax验证用户编号是否存在)
	 * @Author 358143424@qq.com
	 * @Date 2019年7月6日
	 */
	public int userMid(String mid); 
}
