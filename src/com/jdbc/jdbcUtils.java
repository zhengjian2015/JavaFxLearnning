package com.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class jdbcUtils {
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
}
