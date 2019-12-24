package space.dao;

//import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import space.bean.User;
import space.dao.tools.Query;
import space.util.DBUtil;

public class UserDao  {

	
	public static List<User> getListLimited(String[] field, String[] value) {
		ResultSet rs=Query.getListLimited("user", field, value);
		List<User> users=new ArrayList<>();
		try {
			while(rs.next()) {
				int id=rs.getInt("id");							// 用户id
				String introduction=rs.getString("introduction"); 			// 个人签名
				String icon_url=rs.getString("icon_url"); 				// 头像地址
				String name=rs.getString("name"); 					// 用户名
				String gender=rs.getString("gender"); 					// 性别
				String password=rs.getString("password"); 	// 密码
				User user=new User(id, introduction, icon_url, name, gender, password);
				users.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return users;
	}

	
	public static List<User> getAll() {
		// TODO Auto-generated method stub
		ResultSet rs=Query.getAll("user");
		List<User> users=new ArrayList<>();
		try {
			while(rs.next()) {
				int id=rs.getInt("id");							// 用户id
				String introduction=rs.getString("introduction"); 			// 个人签名
				String icon_url=rs.getString("icon_url"); 				// 头像地址
				String name=rs.getString("name"); 					// 用户名
				String gender=rs.getString("gender"); 					// 性别
				String password=rs.getString("password"); 	// 密码
				User user=new User(id, introduction, icon_url, name, gender, password);
				users.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return users;
	}

	
	public static Object getItem(int id) {
		// TODO Auto-generated method stub
		String[] send= {String.valueOf(id)};
		String[] t= {"id"};
		ResultSet rs=Query.getListLimited("user", t, send);
		User user=new User();
		try {
			while(rs.next()) {
				int uid=rs.getInt("id");							// 用户id
				String introduction=rs.getString("introduction"); 			// 个人签名
				String icon_url=rs.getString("icon_url"); 				// 头像地址
				String name=rs.getString("name"); 					// 用户名
				String gender=rs.getString("gender"); 					// 性别
				String password=rs.getString("password"); 	// 密码
				user=new User(uid, introduction, icon_url, name, gender, password);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return user;
	}

	public static User getUserByCond(String name, String password) {
		// 使用JDBC连接数据库，判断用户名和密码是否正确
		// 1. 创建连接
//		Connection conn = DBUtil.getConn();
		// 2. 准备sql
		String sql = "select * from user where name=? and pass=?";
		// 3. 准备参数
		Object[] objs = { name, password };
		// 4.执行通用查询
		ResultSet rs = DBUtil.executeQuery(sql, objs);
		// 5.封装用户
		User user = null;
		try {
			if (rs.next()) {
				int userId = rs.getInt("id");
				String userUrl = rs.getString("icon_url");
				String userName = rs.getString("name");
				String userPass = rs.getString("password");
				String userGender = rs.getString("gender");
				String info = rs.getString("introduction");
				user = new User(userId, info, userUrl, userName, userPass, userGender);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	
	public static User getUserByName(String name) {
		// 使用JDBC连接数据库，判断用户名和密码是否正确
		// 1. 创建连接
//		Connection conn = DBUtil.getConn();
		// 2. 准备sql
		String sql = "select * from user where name=? ";
		// 3. 准备参数
		Object[] objs = { name };
		// 4.执行通用查询
		ResultSet rs = DBUtil.executeQuery(sql, objs);
		// 5.封装用户
		User user = null;
		try {
			if (rs.next()) {
				int userId = rs.getInt("id");
				String userUrl = rs.getString("icon_url");
				String userName = rs.getString("name");
				String userPass = rs.getString("password");
				String userGender = rs.getString("gender");
				String info = rs.getString("introduction");
				user = new User(userId, info, userUrl, userName, userPass, userGender);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	
	public static int addUser(String name,String info, String password, String icon_url, String gender) {
		// 使用JDBC连接数据库，判断用户名和密码是否正确
		// 1. 创建连接
//		Connection conn = DBUtil.getConn();
		// 2. 准备sql
		String sql = "insert into user(icon_url, introduction, name, password, gender) values(?,?,?,?,?) ";
		// 3. 准备参数
		Object[] objs = {icon_url, info, name, password, gender};
		// 4.执行通用增删改
		int result = DBUtil.executeUpdate(sql, objs);
		return result;
	}
}
