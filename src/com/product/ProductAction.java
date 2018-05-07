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
		System.out.println("���� pageNum :"+pageNum);
		if (productName == null) {
			productName = "";
		}
		int totalRecord = service.getItemCount(productName); //��ȡ�ܵļ�¼��
		
	}
	
	
	private void addProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// TODO Auto-generated method stub
		
		String  path = request.getContextPath();
		System.out.println("8*88888");
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
		servletFileUpload.setFileSizeMax(3*1024*1024);//�����ļ���С����3M
		servletFileUpload.setSizeMax(6*1024*1024);//�ϴ��ļ��ܴ�С
		
		List<FileItem> list = null;
		List<Object> params = new ArrayList<Object>();
		params.add(UUIDTools.getUUID()); // ������ product�������
		
		try {
			//����request������
			list = servletFileUpload.parseRequest(request);	//ȡ�����б���ֵ���жϷ��ı��ֶκ��ı��ֶ�
			for(FileItem fileItem : list){
				if (fileItem.isFormField()) {//���ı��ֶ�
					
					String fileItemName = fileItem.getFieldName(); //��ȡ <input>�ؼ��� ����
					String fileItemValue = fileItem.getString("utf-8");//��ȡ<input>�ؼ���ֵ
					if (fileItemName.equals("proname")) {
						params.add(fileItemValue); //�������� proname
					}else if (fileItemName.equals("proprice")) {
						params.add(fileItemValue);//�������� proprice
					}else if (fileItemName.equals("proaddress")) {
						params.add(fileItemValue);////�������� proaddress
					}	
					
				} else{ //���ı��ֶ�	
					
					String imageName = fileItem.getName(); //��ȡ�ļ�����
					params.add(imageName);//��������  proimage	
					//String path = request.getRealPath("/upload");
					String upload_dir = request.getServletContext().getRealPath("/upload");//��ȡ�������� /upload ·��
					//File uploadFile = new File(upload_dir+"/"+imageName);
					File uploadFile = new File("G:/learnspace/FruitProject/WebContent/touxiang/" + imageName);  
					System.out.println("---upload_dir--->>"+uploadFile);
					fileItem.write(uploadFile);	
				}
				
			}
			
			
			// �Ѳ�Ʒ�������ݿ�
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
