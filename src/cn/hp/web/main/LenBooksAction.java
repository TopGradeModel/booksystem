package cn.hp.web.main;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.hp.domain.Books;
import cn.hp.domain.Lenbook;
import cn.hp.domain.Member;
import cn.hp.service.LenBooksService;

/**
 * @Description(借书信息类) @Author 358143424@qq.com
 * @Date 2019年7月3日
 */
public class LenBooksAction extends ActionSupport implements ModelDriven<Lenbook> {
	private LenBooksService lenBooksService;
	private Lenbook lenbook = new Lenbook();

	public void setLenBooksService(LenBooksService lenBooksService) {
		this.lenBooksService = lenBooksService;
	}

	// 全查图书信息表将图书名字显示在添加借书信息界面
	public String listBooks() {
		HttpServletRequest request = ServletActionContext.getRequest();
		// 查询数出来的数据
		List<Books> findBook = lenBooksService.listBooks();
		request.getSession().setAttribute("findBook", findBook);
		return "findBook";
	}

	// 添加借书信息
	public String add() {
		System.out.println(lenbook);
		HttpServletRequest request = ServletActionContext.getRequest();
		String mid = request.getParameter("mid");
		String str = request.getParameter("bid");
		int bid = Integer.parseInt(str);
		// 添加外键值
		Member member = new Member();
		member.setMid(mid);
		Books books = new Books();
		books.setBid(bid);
		books.setStatus(0);
		lenbook.setMember(member);
		lenbook.setBooks(books);
		try {
			int flag = lenBooksService.addLenBook(lenbook);
			request.setAttribute("msg", "添加成功!");
		} catch (Exception e) {
			request.setAttribute("msg", "添加失败!");
		} finally {
			return "add";
		}
	}
	// 全查借书信息
	public String findLenBook() {
		HttpServletRequest request = ServletActionContext.getRequest();
		// 当前页
		Integer currentPage = 1;
		// 每次查询多少条
		Integer lineSize = 5;
		try {
			// 当前页面
			currentPage = Integer.parseInt(request.getParameter("cp"));
			// 每次查询多少条
			lineSize = Integer.parseInt(request.getParameter("ls"));
		} catch (Exception e) {
		}
		// 查询数出来的数据
		List<Lenbook> listLenBook = lenBooksService.findLenBook(currentPage,lineSize);
		for (Lenbook lenbook : listLenBook) {
			time(request, lenbook);
		}
		// 总条数
		Integer allRecorders = lenBooksService.findCount();
		request.getSession().setAttribute("listLenBook", listLenBook);
		request.setAttribute("allRecorders", allRecorders);
		request.setAttribute("url", "/lenBook_findLenBook");
		return "listLenBook";
	}

	// 写一个判断借书时间是否超时的方法
	public void time(HttpServletRequest request, Lenbook lenbook) {
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String currentTime = format.format(date);
		if (currentTime.equals(lenbook.getRetdate())) {
			lenbook.setFlag(0);
		} else {
			lenbook.setFlag(1);
		}
		try {
			if (date.after(format.parse(lenbook.getRetdate()))) {
				if (currentTime.equals(lenbook.getRetdate())) {
					lenbook.setFlag(0);
				} else {
					lenbook.setFlag(2);
				}
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 修改借书状态的方法
	public String update() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String str = request.getParameter("bid");
		int bid = Integer.parseInt(str);
		lenBooksService.updateStatus(lenbook,bid);
		return "update";
	}

	// 单查借书信息的方法
	public String oneBook() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		String leid = request.getParameter("leid");
		int leids = Integer.parseInt(leid);
		Lenbook oneLen = lenBooksService.oneLenBook(leids);
		System.out.println(oneLen);
		session.setAttribute("oneLen", oneLen);
		return "oneLen";
	}

	public Lenbook getModel() {
		return lenbook;
	}
}
