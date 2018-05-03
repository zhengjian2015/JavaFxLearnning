package com.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginAction
 */
@WebServlet("/LoginAction")
public class LoginAction extends HttpServlet {
	private LoginService service;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginAction() {
        super();
        // TODO Auto-generated constructor stub
    }

    
    public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String path = request.getContextPath();
		System.out.println("path"+path);
		String username = request.getParameter("username");
		String pswd = request.getParameter("pswd");
		
		List<Object> params = new ArrayList<Object>();
		params.add(username);
		params.add(pswd);
		System.out.println(params);
		boolean flag = service.login(params);
		System.out.println(flag);
        if (flag) {
			
			request.getSession().setAttribute("username", username);
			response.sendRedirect(path+"/main.jsp");
		}else{
						
			response.sendRedirect(path+"/index.jsp");
		}
        out.flush();
		out.close();
	}
    
	public void init() throws ServletException {
		// Put your code here
		service = new LoginDao();
	}
}
