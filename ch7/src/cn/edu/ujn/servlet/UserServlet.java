package cn.edu.ujn.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.ujn.dao.UserDaoImpl;
import cn.edu.ujn.dao.UserDaoInterface;
import cn.edu.ujn.model.User;

//javaservice implenments
/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String sex=request.getParameter("sex");
		UserDaoInterface usDao = new UserDaoImpl();
		String action = request.getParameter("action");
		
//-------------------------------------------------------------------------------------
		if(action.equals("register")) {
			PrintWriter out = response.getWriter();
			User temp=new User();
			temp.setUsername(username);
			temp.setPassword(password);
			temp.setSex("");
			String surePassword=request.getParameter("surePassword");
			if(surePassword.equals(password))
			{
				if (usDao.register(temp)) {
					response.sendRedirect("login.jsp");			
				} else
					out.println("娉ㄥ唽澶辫触");
			}else {
				HttpSession session = request.getSession();
				session.setAttribute("temp", temp);
				response.sendRedirect("Reg_Fail.jsp");
			}
		}
		
//--------------------------------------------------------------------------------------		
		if(action.equals("Dim")) {
			String dimName = request.getParameter("dimName");
			ArrayList<User> results=usDao.Dim(dimName);
			HttpSession session= request.getSession();
			session.setAttribute("result", results);
			System.out.println(results);
			response.sendRedirect("result.jsp");
			System.out.println(dimName);
		}
		
//-------------------------------------------------------------------------------------	
		HttpSession session = request.getSession();
		if (action.equals("login")) {
			User user = usDao.login(username, password);
			if (user != null) {
				session.setAttribute("user", user);
				//HttpSession session = request.getSession();
				response.sendRedirect("loginSuccess.jsp");
			} else
				response.sendRedirect("login.jsp");
		}
		
//-------------------------------------------------------------------------------------
		if(action.equals("findUser")) {
			ArrayList<User> users=usDao.findUser();
			//HttpSession session= request.getSession();
			if (session.getAttribute("user")==null) {
				response.sendRedirect("login.jsp");
			}
			else {
				session.setAttribute("list", users);
				System.out.println(users);
				response.sendRedirect("findUser.jsp");	
			}
		}
		
//-------------------------------------------------------------------------------------		
		if(action.equals("Info")) {
			//ArrayList<User> users=usDao.findUser();
			//HttpSession session= request.getSession();
			//session.setAttribute("list", users);
			String selectUser = request.getParameter("select_user");
			session.setAttribute("select_user",selectUser);
			System.out.println(selectUser);
			response.sendRedirect("Info.jsp");
		}
		
//-------------------------------------------------------------------------------------	
		if(action.contentEquals("Delete")) {
			User us = new User();
			String selectUser = request.getParameter("select_user");
			us.setUsername(selectUser);
			if(usDao.Delete(us)) {
				response.sendRedirect("deleteSuccess.jsp");
			}else {
				System.out.println("鍒犻櫎閿欒锛岃閲嶈瘯");
			}
		}
		
//-------------------------------------------------------------------------------------
		if(action.contentEquals("AlterPage")) {
			String selectUser = request.getParameter("select_user");
			User userSelect = usDao.AlterPage(selectUser);
			System.out.println("杩欓噷鏄細"+userSelect.getId());
			System.out.println("杩欓噷鏄細"+userSelect.getUsername());
			//HttpSession session = request.getSession();
			session.setAttribute("alter", userSelect);
			response.sendRedirect("alter.jsp");
		}
		
//-------------------------------------------------------------------------------------
		if(action.contentEquals("Alter")) {
			User us=new User();
			String selectId = request.getParameter("id");
			us.setId(Integer.parseInt(selectId));
			System.out.println("鎴戠殑ID涓�"+us.getId());
			us.setUsername(username);
			us.setPassword(password);
			us.setSex(sex);
			if (usDao.Alter(us)) {			
				response.sendRedirect("alterSuccess.jsp");
			}else {
				System.out.println("淇敼閿欒锛岃閲嶈瘯");
			}
		}
//-------------------------------------------------------------------------------------
		if(action.contentEquals("Exit")) {
			session.removeAttribute("user");
			if (session.getAttribute("user")==null) {
				response.sendRedirect("login.jsp");
			}
		}

//--------------------------------------------------------------------------------------
		
}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
