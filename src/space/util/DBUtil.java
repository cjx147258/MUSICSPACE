package space.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class DBUtil {
	public static final String url="jdbc:mysql://39.96.2.191:3306/music?useUnicode=true&characterEncoding=utf-8";
	public static final String user="root";
	public static final String pass="321cxp";

	
	public static Connection getConn() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(url, user, pass);
		}
		catch(Exception e){
			e.printStackTrace();
		}

//		System.out.println("getConn");
		return conn;
	}
	public static void closeAll(Connection conn,PreparedStatement pstmt, ResultSet res) {
		try {
			if(conn != null)
				conn.close();
			if(pstmt != null)
				pstmt.close();
			if(res != null)
				res.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public static PreparedStatement getPstmt(String sql, Object[] objs) {
		Connection conn=DBUtil.getConn();
		PreparedStatement pstmt=null;
		try {
			pstmt = conn.prepareStatement(sql);
			if(objs!=null) {
				for(int i=0;i<objs.length;i++) {
					pstmt.setObject(i+1, objs[i]);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
//			closeAll(conn,null,null);
		}
//		System.out.println("preparedStatement");
		return pstmt;
	}
	
	public static ResultSet executeQuery(String sql,Object[] objs) {
		PreparedStatement pstmt=DBUtil.getPstmt(sql,objs);
		ResultSet res=null;
		try {
			res=pstmt.executeQuery();
//			pstmt.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally {
//			closeAll(null,pstmt,null);
		}
		return res;
	}
	public static int executeUpdate(String sql,Object[] objs) {
		PreparedStatement pstmt=getPstmt(sql,objs);
		int result=-1;
		try {
			result=pstmt.executeUpdate();
//			pstmt.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
//			closeAll(null,pstmt,null);
		}
		return result;
	}
}
