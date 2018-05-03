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
	//定义数据库的用户名
	private final String USERNAME = "root";
	// 定义数据库的密码
	private final String PASSWORD = "1234";
	// 定义数据库的驱动信息
	private final String DRIVER = "com.mysql.jdbc.Driver";
	// 定义访问数据库的地址
	private final String URL = "jdbc:mysql://localhost:3306/java";
	// 定义访问数据库的连接
	private Connection connection;
	// 定义sql语句的执行对象
	private PreparedStatement pstmt;
	// 定义查询返回的结果集合
    private ResultSet resultSet;
    // 实现批处理的功能
 	private Statement stmt;

 	public JdbcUtils() {
 		try {
 			Class.forName(DRIVER);
 			System.out.println("注册驱动成功！！");
 		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("注册驱动失败！！");
		}
 	}
 	
    // 定义获得数据库的连接
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
	 * 查询返回单条记录
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
		resultSet = pstmt.executeQuery(); // 返回查询结果
		ResultSetMetaData metaData = pstmt.getMetaData(); // 获取 结果中，一行所有列的结果
		int cols_len = metaData.getColumnCount(); // 获得列的总数
		
		while (resultSet.next()) {
			for (int i = 0; i < cols_len; i++) {
				String col_name = metaData.getColumnName(i + 1); // 获得第i列的字段名称
				Object col_value = resultSet.getObject(col_name);// 返回 第i列的内容值
				if (col_value == null) {
					col_value = "";
				}
				map.put(col_name, col_value);
			}

		}
		
 		return map;
 		
 	}
 	
 	/**关闭数据库访问
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
