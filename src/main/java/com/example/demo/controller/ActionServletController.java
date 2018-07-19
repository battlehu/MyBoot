package com.example.demo.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.mapper.EmpDao;
import com.example.demo.mapper.UserDao;
import com.example.demo.entity.Emp;
import com.example.demo.entity.FenYe;
import com.example.demo.entity.PageBean;
import com.example.demo.entity.User;

@Controller
@RequestMapping("/action")
public class ActionServletController {
	@Autowired
    private UserDao userDao;
	
	@Autowired
	private EmpDao empDao;

	@RequestMapping("/addEmp")
	public String addEmp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String name = request.getParameter("name");
		String salary1 = request.getParameter("salary");
		String age1 = request.getParameter("age");
		try {
			if(name!="" && salary1!="" && age1!=""){
				double salary = Double.parseDouble(salary1);
				int age = Integer.parseInt(age1);
				Emp emp = new Emp(name, salary, age);
				empDao.savaEmp(emp);
				return "redirect:/action/list";
			}
			session.setAttribute("add_error", "姓名、薪水和年龄不能为空!!!");
			return "redirect:/redirect/addEmp";
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}
	
	@RequestMapping("/list")
	public ModelAndView listEmp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		try {
			PageBean pageBean = new PageBean();
			//获得数据库的总记录数
			int totalCount = empDao.getTotalCount();
			int totalPage = pageBean.getTotalPage();
			//总页数
			totalPage = (totalCount + pageBean.getPageCount() - 1) / pageBean.getPageCount();
			
			// 第一次访问，设置当前页为1;
			String currPage = request.getParameter("currentPage");
			if (currPage == null || "".equals(currPage.trim())){
				currPage = "1";  	
			}
			int currentPage = Integer.parseInt(currPage);
			if (currentPage<1) {
				currentPage = 1;
			} 
		
			// 把当前页设置为最大页数
			if (currentPage >= totalPage){
				pageBean.setCurrentPage(totalPage);		
			} else {
				pageBean.setCurrentPage(currentPage);
			}
			//分页查询到的记录
			int index = (pageBean.getCurrentPage() -1 ) * pageBean.getPageCount();		// 查询的起始行
			int count = pageBean.getPageCount();
			FenYe fenYe = new FenYe();
			fenYe.setIndex(index);
			fenYe.setCount(count);
			List<Emp> emps = empDao.findAll(fenYe);
			pageBean.setTotalCount(totalCount);
			pageBean.setTotalPage(totalPage);
			session.setAttribute("pageBean", pageBean);
			
			//将emps集合转发给listEmp.jsp
			/**
			 * 如何转发  3步
			 * 1、在请求对象上绑定需要转发的数据
			 * 2、获得转发器对象
			 * 3、转发
			 * setAttribute(绑定名, 绑定值)
			 */
			session.setAttribute("emps", emps);
			ModelAndView mv = new ModelAndView("listEmp");
			return  mv;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}
	
	@RequestMapping("/deleteEmp")
	public String deleteEmp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		int sid = Integer.parseInt(request.getParameter("sid"));
		try {
			empDao.deleteEmpById(sid);
			return "redirect:/action/list";
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}	
	}
	
	@RequestMapping("/findEmp")
	public String findEmp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		int sid = Integer.parseInt(request.getParameter("sid"));
		try {
			Emp emp = empDao.findById(sid);
			session.setAttribute("emp", emp);
			return "redirect:/redirect/updateEmp";
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}	
	}
	
	@RequestMapping("/updateEmp")
	public String updateEmp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		int sid = Integer.parseInt(request.getParameter("sid"));
		String name = request.getParameter("name");
		double salary = Double.parseDouble(request.getParameter("salary"));
		int age = Integer.parseInt(request.getParameter("age"));
		try {
			Emp emp = new Emp(sid, name, salary, age);
			empDao.updateEmp(emp);
			return "redirect:/action/list";
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}	
	}
	
	@RequestMapping("/login")
	public String login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String inputUsername = request.getParameter("username");
		try {
			User user = userDao.findUserInfo(inputUsername);
			if (user==null) {
				session.setAttribute("inputUsername", inputUsername);
				session.setAttribute("login_error", "用户名或秘密错误!!!");
				return "redirect:/redirect/login";
			}
			String inputPwd = request.getParameter("password");
			if (user.getPassword().equals(inputPwd)) {
				//获得Session
				session.setAttribute("user", user);
				return "redirect:/action/list";
			}
			session.setAttribute("inputUsername", inputUsername);
			session.setAttribute("login_error", "用户名或秘密错误!!!");
			return "redirect:/redirect/login";
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}		
	}
	
	@RequestMapping("/regist")
	public String regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String inputUsername = request.getParameter("username");
		String inputPassword = request.getParameter("password");
		String inputRealname = request.getParameter("realname");
		String inputSex = request.getParameter("sex");
		String number = (String)session.getAttribute("rand");
		String code = request.getParameter("code");
		try {
			if (number.equals(code) && code!= "" ) {
				User user = userDao.findUserInfo(inputUsername);
				if (user!=null) {
					session.setAttribute("regist_error", "用户名已存在!!!");
					return "redirect:/redirect/regist";
				}
				if (inputUsername=="" || inputPassword=="" || inputRealname=="") {
					session.setAttribute("regist_error", "用户名、密码、真实姓名不能为空!!!");
					return "redirect:/redirect/regist";
				}
				User reUser = new User(inputUsername, inputPassword, inputRealname, inputSex);
				userDao.regist(reUser);
				session.setAttribute("inputUsername", inputUsername);
				return "redirect:/redirect/login";
			}
			session.setAttribute("code_error", "验证码错误!!!");
			session.setAttribute("inputUsername", inputUsername);
			session.setAttribute("inputRealname", inputRealname);
			return "redirect:/redirect/regist";
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}	
	}
}
