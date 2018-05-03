package com.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class jdbcUtils {
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
}
