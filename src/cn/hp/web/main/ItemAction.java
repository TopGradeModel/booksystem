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

import cn.hp.domain.Item;
import cn.hp.domain.Lenbook;
import cn.hp.service.ItemService;

/**
 * @Description(这是图书分类模块) @Author 358143424@qq.com
 * @Date 2019年6月29日
 */
public class ItemAction extends ActionSupport implements ModelDriven<Item> {
	private ItemService itemService;
	private Item item = new Item();

	public void setItemService(ItemService itemService) {
		this.itemService = itemService;
	}

	/**
	 * @Description(添加分类) @Author 358143424@qq.com
	 * @Date 2019年6月29日
	 */
	public String addItem() {
		HttpServletRequest request = ServletActionContext.getRequest();
		try {
			int flag = itemService.addItem(item);
			if (flag != 0) {
				request.setAttribute("msg", "添加成功!");
			} else {
				request.setAttribute("msg", "添加失败!");
			}
		} catch (Exception e) {
			request.setAttribute("msg", "分类名重复，重新输入");
			request.setAttribute("url", "/pages/item/addItem.jsp");
		}
		return "addItem";
	}

	/**
	 * @Description(查询全部分类A:Item单查;B:Books单查)
	 * @Author 358143424@qq.com
	 * @Date 2019年6月29日
	 */
	public String findItem() {
		List<Item> listItem = itemService.findItem();
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		session.setAttribute("listItem", listItem);
		/**
		 * 跟新分类的时候也做了一次判断item
		 * 是全查分类的一个
		 * 添加图书时一个
		 */
		String item = (String) session.getAttribute("item");
		String tag = request.getParameter("tag");
		if ("A".equals(tag)||"A".equals(item)) {
			session.removeAttribute("item");
			return "listItem";
		} else {
			return "listIid";
		}
	}

	/**
	 * @Description(单查图书分类) @Author 358143424@qq.com
	 * @Date 2019年7月4日
	 */
	public String oneItem() {
		System.out.println("1111");
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		// 获取页面值iid
		String leid = request.getParameter("iid");
		int iid = Integer.parseInt(leid);
		Item oneItem = itemService.oneItem(iid);
		try {
			response.getWriter().write(JSON.toJSONString(oneItem));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @Description(更新分类) @Author 358143424@qq.com
	 * @Date 2019年7月4日
	 */
	// 修改借书状态的方法
	public String updateItem() {
		HttpServletRequest request = ServletActionContext.getRequest();
		itemService.updateItem(item);
		request.getSession().setAttribute("item", "A");
		return "updateItem";
	}
	//ajax验证图书分类是否存在
	public String inameItem() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		//获取iname分类名称
		String iname = request.getParameter("iname");
		int flag=1;
		//如果为iname为空直接返回
		if(iname==null||"".equals(iname)) {
		}else {
			flag=itemService.inameItem(iname);
		}
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
	public Item getModel() {
		return item;
	}
}
