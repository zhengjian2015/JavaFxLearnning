package com.register;

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
 * Servlet implementation class sss
 */
@WebServlet("/RegisterAction")
public class RegisterAction extends HttpServlet {
	private RegisterService service;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterAction() {
        super();
        // TODO Auto-generated constructor stub
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
		System.out.println("**");
		System.out.println(out);
		String username = request.getParameter("username");
		String pswd = request.getParameter("pswd");
		
		List<Object> params = new ArrayList<Object>();
		params.add(username);
		params.add(pswd);
		boolean flag = service.registerUser(params);
		System.out.println(flag);
		if(flag) {
			response.sendRedirect(path+"/index.jsp");
		}
		
		out.flush();
		out.close();
	}
	
	public void init() throws ServletException {
		
		service = new RegisterDao();
	}

}
