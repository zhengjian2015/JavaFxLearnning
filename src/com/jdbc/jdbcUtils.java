package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JdbcUtils  {
	//�������ݿ���û���
	private final String USERNAME = "root";
	// �������ݿ������
	private final String PASSWORD = "1234";
	// �������ݿ��������Ϣ
	private final String DRIVER = "com.mysql.jdbc.Driver";
	// ����������ݿ�ĵ�ַ
	private final String URL = "jdbc:mysql://localhost:3306/java";
	// ����������ݿ������
	private Connection connection;
	// ����sql����ִ�ж���
	private PreparedStatement pstmt;
	// �����ѯ���صĽ������
    private ResultSet resultSet;
    // ʵ��������Ĺ���
 	private Statement stmt;

 	public JdbcUtils() {
 		try {
 			Class.forName(DRIVER);
 			System.out.println("ע�������ɹ�����");
 		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("ע������ʧ�ܣ���");
		}
 	}
 	
    // ���������ݿ������
 	public Connection getConnection() {

 		try {
 			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

 		} catch (Exception e) {
 			// TODO: handle exception
 			System.out.println("Connection exception !");
 		}

 		return connection;

 	}
 	
 	/**
	 * ��ѯ���ص�����¼
	 * 
	 * @param sql
	 * @param params
	 * @return
	 * @throws SQLException
	 */
 	
 	public Map<String,Object> findSimpleResult(String sql,List<Object> params) throws SQLException{
 		Map<String, Object> map = new HashMap<String, Object>();
 		pstmt = connection.prepareStatement(sql);
 		int index = 1;
		if (params != null && !params.isEmpty()) {
			for (int i = 0; i < params.size(); i++) {
				pstmt.setObject(index++, params.get(i));
			}
		}
		resultSet = pstmt.executeQuery(); // ���ز�ѯ���
		ResultSetMetaData metaData = pstmt.getMetaData(); // ��ȡ ����У�һ�������еĽ��
		int cols_len = metaData.getColumnCount(); // ����е�����
		
		while (resultSet.next()) {
			for (int i = 0; i < cols_len; i++) {
				String col_name = metaData.getColumnName(i + 1); // ��õ�i�е��ֶ�����
				Object col_value = resultSet.getObject(col_name);// ���� ��i�е�����ֵ
				if (col_value == null) {
					col_value = "";
				}
				map.put(col_name, col_value);
			}

		}
		
 		return map;
 		
 	}
 	
 	/**�ر����ݿ����
	 * @throws SQLException
	 */
	public void releaseConn(){
		if (resultSet!=null) {
			try {
				resultSet.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
		}
		if(stmt!=null){
			
			try {
				stmt.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		if (pstmt!=null) {
			try {
				pstmt.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		if (connection!=null) {
			try {
				connection.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
}
