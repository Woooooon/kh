package com.kh.app.common.db;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class JDBCTemplate {
	//커넥션 준비(마이바티스)
	public static SqlSession getSqlSession() {
		
		SqlSession ss = null;
		
		try {
			String resource = "/config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			ss = sqlSessionFactory.openSession(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ss;
	}
	
	public static Connection getConnection() {
		
		Connection conn = null;
		
		try {
			
			//드라이버 등록
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url ="jdbc:oracle:thin:@localhost:1521:xe";
			String username = "C##MYBATIS";
			String password = "MYBATIS";
			
			//커넥션얻기(url, username, pwd)
			conn = DriverManager.getConnection(url, username, password);
			
			//오토커밋 끄기
			conn.setAutoCommit(false);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("JDBC 연결실패");
		}
		
		return conn;
	}
	
	public static void commit(Connection conn) {
		try {
			if(conn != null && !conn.isClosed()) {
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void rollback(Connection conn) {
		try {
			if(conn != null && !conn.isClosed()) {
				conn.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Connection conn) {
		try {
			if(conn != null && !conn.isClosed()) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Statement pstmt) {
		try {
			if(pstmt != null && !pstmt.isClosed()) {
				pstmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(ResultSet rs) {
		try {
			if(rs != null && !rs.isClosed()) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
