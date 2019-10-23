package cn.hp.web.main;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.hp.domain.Admin;
import cn.hp.domain.Books;
import cn.hp.domain.Item;
import cn.hp.domain.Lenbook;
import cn.hp.service.BooksService;

/**
 * @Description(图书模块)
 * @Author 358143424@qq.com
 * @Date 2019年6月29日
 */
public class BooksAction extends ActionSupport implements ModelDriven<Books>{
	private BooksService booksService;
	private Books books=new Books();
	public void setBooksService(BooksService booksService) {
		this.booksService = booksService;
	}
	//添加图书
	public String addBooks() {
		Item item=new Item();
		Admin admin=new Admin();
		HttpServletRequest request = ServletActionContext.getRequest();
		books.setStatus(1);
		item.setIid(Integer.parseInt(request.getParameter("iid")));
		admin.setAid(request.getParameter("aid"));
		books.setAdmin(admin);
		books.setItem(item);
		books.setCredate(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
		int flag=booksService.addBooks(books);
		request.setAttribute("msg","添加成功");
		return "addBooks";
	}
	//全查图书分页
	public String listBooks() {
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
		List<Books> findBooks=booksService.listBooks(currentPage,lineSize);
		//总条数
		Integer allRecorders=booksService.findCount();
		request.setAttribute("listBooks", findBooks);	
		request.setAttribute("allRecorders", allRecorders);
		request.setAttribute("url","/book_listBooks");
		return "listBooks";
	}
	
	//单查图书列表信息的方法
		public String oneBook() {
			 HttpServletResponse response = ServletActionContext.getResponse();
			 response.setCharacterEncoding("utf-8");
			Books oneBooks=booksService.oneBooks(books);
			try {
				response.getWriter().write(JSON.toJSONString(oneBooks));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		//修改图书列表信息
		public String update() {
			booksService.updateStatus(books);
			return "updateBooks";
		}
	@Override
	public Books getModel() {
		return books;
	}
}
