package cn.hp.web.main;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.hp.domain.Admin;
import cn.hp.service.LoginService;
import cn.hp.service.LoginServiceImpl;
import cn.hp.utils.MD5Code;

/**
 * @Description(登陆模块)
 * @Author 358143424@qq.com
 * @Date 2019年6月29日
 */
public class LoginAction extends ActionSupport implements ModelDriven<Admin> {
	//封装实体类
	private Admin admin=new Admin();
	private LoginService loginService;
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}
	public String login() {
		HttpServletRequest request = ServletActionContext.getRequest();
		//做一个MD5加密
		MD5Code md5Code=new MD5Code();
		String psw = md5Code.getMD5ofStr(admin.getPassword());
		admin.setPassword(psw);
		admin.setLastdate(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
		//验证登陆
		Admin findAdmin=loginService.findAdmin(admin);
		//创建session
		HttpSession session = request.getSession();
		if(findAdmin==null||findAdmin.getStatus()==0) {
			session.setAttribute("msg", "登陆失败");
			session.setAttribute("url", "/login.jsp");
		}else{
			session.setAttribute("findAdmin", findAdmin);
			session.setAttribute("msg", "登陆成功");
			session.setAttribute("url", "/pages/index.jsp");
		}
		return "forward";
	}
	//退出系统
	public String endSystem() {
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.invalidate();
		return "end";
	}
	@Override
	public Admin getModel() {
		return admin;
	}
}
