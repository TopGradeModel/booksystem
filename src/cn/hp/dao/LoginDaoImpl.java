package cn.hp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import cn.hp.domain.Admin;
import cn.hp.utils.Utils;

/**
 * @Description(登陆模块)
 * @Author 358143424@qq.com
 * @Date 2019年6月29日
 */
public class LoginDaoImpl implements LoginDao  {
	private HibernateTemplate hibernateTemplate;
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	//验证登陆
	public  Admin findAdmin(Admin admin) {
		//连接数据库
		String sql="from Admin where aid=? and password=?";
		List<Admin> list = (List<Admin>) hibernateTemplate.find(sql, admin.getAid(),admin.getPassword());
		if(list!=null && list.size()>0){
			addDate(admin);
			return list.get(0);
		}
		return null;
	}
	//添加上一次登陆的方法
	public void addDate(Admin admin) {
		String sql="update admin set lastdate=? where aid=?";
		Admin admin2 = hibernateTemplate.get(Admin.class, admin.getAid());
		//第二种方法，需要导入jstl标签中的fmt标签库，然后在jsp页面格式化一下时间
		//System.out.println(new Timestamp(new Date().getTime()););
		admin2.setLastdate(admin.getLastdate());
		hibernateTemplate.update(admin2);
	}
}
