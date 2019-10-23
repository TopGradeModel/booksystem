package cn.hp.web.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.hp.domain.Admin;
import cn.hp.domain.Books;
import cn.hp.service.AdminService;
import cn.hp.utils.MD5Code;
/**
 * @Description(超级管理员)
 * @Author 285330499@qq.com
 * @Date 2019年7月3日
 */
public class AdminAction extends ActionSupport implements ModelDriven<Admin>{
	private Admin admin=new Admin();
	private AdminService adminService;
	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}
	
	
	/**
	 * 反序列化
	 */
	private static final long serialVersionUID = 1L;
	private File upload;
	private String uploadContentType;
	private String uploadFileName;
	private String savePath;

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String getSavePath() {
		return savePath;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	//添加管理员
	public String addAdmin() {
		//保存图片到指定路径下
		byte[] buffer = new byte[1024];
		try {
			FileInputStream fileInputStream = new FileInputStream(getUpload());
			FileOutputStream fileOutputStream = new FileOutputStream(getSavePath() + "\\" + this.getUploadFileName());
			int read = fileInputStream.read(buffer);
			while (read > 0) {
				fileOutputStream.write(buffer, 0, read);
				read = fileInputStream.read(buffer);
			}
			fileOutputStream.flush();
			fileOutputStream.close();
			fileInputStream.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		HttpServletRequest request = ServletActionContext.getRequest();
		//做个加密
		MD5Code md5Code = new MD5Code();
		String pwd = md5Code.getMD5ofStr(admin.getPassword());
		admin.setPassword(pwd);
		//存上次登陆时间
		admin.setLastdate(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
		admin.setUrls("assets/img/"+uploadFileName);
		//补捉约束异常
		try {
			int flag = adminService.addAdmin(admin);
			if(flag!=0) {
				request.setAttribute("msg", "管理员添加成功");
			}else {
				request.setAttribute("msg", "管理员添加失败");
			}
		} catch (Exception e) {
			request.setAttribute("msg", "用户名重复，重新输入");
			request.setAttribute("url", "/pages/admin/addAdmin.jsp");
		}
		return "addAdmin";
	}
	//不是超级管理员
	public String noSuperAdmin() {
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("msg", "你不是超级管理员");
		return "addAdmin";
	}
	
	//查询全部数据
	public String findAdmin() {
	HttpSession session = ServletActionContext.getRequest().getSession();
	
	//查询全部数据
	List<Admin>	listAdmin=adminService.findAdmin();
	session.setAttribute("listAdmin", listAdmin);
		return "listAdmin";
	}
	//单查管理员信息
	public String oneAdmin() {
		HttpServletResponse response = ServletActionContext.getResponse();
		 response.setCharacterEncoding("utf-8");
		Admin oneAdmin=adminService.oneAdmin(admin);
		try {
			response.getWriter().write(JSON.toJSONString(oneAdmin));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	//更新管理员信息
	public String updateAdmin() {
		adminService.updateAdmin(admin);
		return "updateAdmin";
	}
	@Override
	public Admin getModel() {
		return admin;
	}
	
}
