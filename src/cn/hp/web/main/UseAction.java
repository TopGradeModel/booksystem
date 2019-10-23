package cn.hp.web.main;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.hp.domain.Books;
import cn.hp.domain.Member;
import cn.hp.service.UserService;
import cn.hp.service.UserServiceImpl;
import cn.hp.utils.MobileAuthentication;

/**
 * @Description(用户模块)
 * @Author 358143424@qq.com
 * @Date 2019年6月29日
 */
public class UseAction extends ActionSupport implements ModelDriven<Member>{
	private Member member=new Member();
	private UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	//添加用户信息
	public String addMember() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		//获取验证码
		int sendCode =(int) session.getAttribute("sendCode");
		String code = request.getParameter("code");
		int codes = Integer.parseInt(code);
		if(sendCode==codes) {
			int flag=userService.addMember(member);
			if(flag!=0) {
				session.setAttribute("msg", "添加成功!");
			}else {
				session.setAttribute("msg", "添加失败!");
			}
		}else {
			session.setAttribute("msg", "验证码错误!");
			session.setAttribute("url", "/pages/member/addMember.jsp");
		}
		return "addMember";
	}
	//发起验证码
	public String getVCode() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String phone = request.getParameter("pe");
		//调短信接口的方法
		int sendCode = MobileAuthentication.SendCode(phone);
		HttpSession session = request.getSession();
		session.setAttribute("sendCode", sendCode);
		return null;
	}
	//查看所有用户
	  public String findUser() {
			//当前页
			Integer currentPage=1;
			//每次查询多少条
			Integer lineSize=5;
			HttpServletRequest request = ServletActionContext.getRequest();
			try {
				//当前页面
				currentPage=Integer.parseInt(request.getParameter("cp"));
				//每次查询多少条
				lineSize=Integer.parseInt(request.getParameter("ls"));
			} catch (Exception e) {
			}
			//查询数出来的数据
			List<Member> listMember=userService.findUser(currentPage,lineSize);
			//总条数
			Integer allRecorders=userService.findCount();
			request.setAttribute("listMember", listMember);	
			request.setAttribute("allRecorders", allRecorders);
			request.setAttribute("url","/member_findUser");
		return "listMember";
	}
	  //ajax单查信息
	  public String oneMember() {
			 HttpServletResponse response = ServletActionContext.getResponse();
			 response.setCharacterEncoding("utf-8");
			Member oneMember=userService.oneMember(member);
			try {
				response.getWriter().write(JSON.toJSONString(oneMember));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
	 //修改用户信息
	public String updateMember() {
		userService.updateStatus(member);
		return "updateMember";
	}
	//ajax验证用户编号是否存在
	public String userMid() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		//获取页面的mid
		String mid = request.getParameter("mid");
		int flag=userService.userMid(mid);
		try {
		if(flag==0) {
			response.getWriter().write("0");
		}else {
			response.getWriter().write("1");
		}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	//这个是封装member实体
	public Member getModel() {
		return member;
	}
}
