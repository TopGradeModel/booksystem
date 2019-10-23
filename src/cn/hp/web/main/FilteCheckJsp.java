package cn.hp.web.main;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Description(过滤器)
 * @Author 358143424@qq.com
 * @Date 2019年6月29日
 */
public class FilteCheckJsp implements Filter {

	public void destroy() {
	}
	
	
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {
				//把servletRequest构造成HttpServletRequest
				HttpServletRequest request=(HttpServletRequest) servletRequest;
				HttpServletResponse response=(HttpServletResponse) servletResponse;
				//解决中文乱码问题
				request.setCharacterEncoding("UTF-8");
				response.setCharacterEncoding("UTF-8");
				response.setContentType("text/html;charset=UTF-8");
				
				//检查用户是否登陆成功
				//获取根目录下所对应的绝对路径
				String uri = request.getRequestURI();
				//截取当前文件名比较
				String targetURL = uri.substring(uri.indexOf("/", 1), uri.length());
				//判断当前session域中是否有数据
				HttpSession session = request.getSession(false);
				//先判断当前页面是否为登陆界面防止出先死循环
				if(!"/login.jsp".equals(targetURL)){
					if(session==null||session.getAttribute("findAdmin")==null){
							//不是登陆界面则拦截
							response.sendRedirect(request.getContextPath()+"/login.jsp");
							return;
					}
				}
				//是登陆界面则放行
				chain.doFilter(request, response);
	}
	public void init(FilterConfig filterConfig) throws ServletException {
	}
}
