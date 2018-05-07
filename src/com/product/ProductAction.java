package com.product;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.util.UUIDTools;

/**
 * Servlet implementation class ProductAction
 */
@WebServlet("/ProductAction")
public class ProductAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductService service;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductAction() {
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
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		
		String action_flag = request.getParameter("action_flag");
		if (action_flag.equals("add")) {
			addProduct(request,response);
		}else if(action_flag.equals("search")) {
			listProduct(request,response);
		}
	}

	private void listProduct(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		String productName = request.getParameter("proname");
		String pageNum = request.getParameter("pageNum");
		System.out.println("参数 pageNum :"+pageNum);
		if (productName == null) {
			productName = "";
		}
		int totalRecord = service.getItemCount(productName); //获取总的记录数
		
	}
	
	
	private void addProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// TODO Auto-generated method stub
		
		String  path = request.getContextPath();
		System.out.println("8*88888");
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
		servletFileUpload.setFileSizeMax(3*1024*1024);//单个文件大小限制3M
		servletFileUpload.setSizeMax(6*1024*1024);//上传文件总大小
		
		List<FileItem> list = null;
		List<Object> params = new ArrayList<Object>();
		params.add(UUIDTools.getUUID()); // 参数传 product表的主键
		
		try {
			//解析request的请求
			list = servletFileUpload.parseRequest(request);	//取出所有表单的值，判断非文本字段和文本字段
			for(FileItem fileItem : list){
				if (fileItem.isFormField()) {//是文本字段
					
					String fileItemName = fileItem.getFieldName(); //获取 <input>控件的 名称
					String fileItemValue = fileItem.getString("utf-8");//获取<input>控件的值
					if (fileItemName.equals("proname")) {
						params.add(fileItemValue); //参数传入 proname
					}else if (fileItemName.equals("proprice")) {
						params.add(fileItemValue);//参数传入 proprice
					}else if (fileItemName.equals("proaddress")) {
						params.add(fileItemValue);////参数传入 proaddress
					}	
					
				} else{ //非文本字段	
					
					String imageName = fileItem.getName(); //获取文件名称
					params.add(imageName);//参数传入  proimage	
					//String path = request.getRealPath("/upload");
					String upload_dir = request.getServletContext().getRealPath("/upload");//获取服务器端 /upload 路径
					//File uploadFile = new File(upload_dir+"/"+imageName);
					File uploadFile = new File("G:/learnspace/FruitProject/WebContent/touxiang/" + imageName);  
					System.out.println("---upload_dir--->>"+uploadFile);
					fileItem.write(uploadFile);	
				}
				
			}
			
			
			// 把产品加入数据库
			boolean flag = service.addProduct(params);
			if (flag) {
				
				response.sendRedirect(path+"/main.jsp");
			}
						
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
		service = new ProductDao();
	}


}
