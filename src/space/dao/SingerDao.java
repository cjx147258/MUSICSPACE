package space.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import space.bean.Singer;
import space.bean.User;
import space.dao.tools.Query;
import space.util.DBUtil;

public class SingerDao  {

	
	public static List<Singer> getListLimited(String[] field, String[] value) {
		ResultSet rs=Query.getListLimited("singer", field, value);
		List<Singer> singers=new ArrayList<>();
		try {
			while(rs.next()) {
				int id=rs.getInt("id");							// 歌手id
				String img_url=rs.getString("img_url"); 				// 头像地址
				String name=rs.getString("name"); 					// 用户名
				String s_info=rs.getString("s_info");               //歌手详情
				Singer singer=new Singer(id, name,img_url,s_info);
				singers.add(singer);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return singers;
	}

	
	public static List<Singer> getAll() {
		// TODO Auto-generated method stub
		ResultSet rs=Query.getAll("singer");
		List<Singer> singers=new ArrayList<>();
		try {
			while(rs.next()) {
				int id=rs.getInt("id");							// 歌手id
				String img_url=rs.getString("img_url"); 				// 头像地址
				String name=rs.getString("name"); 					// 用户名
				String s_info=rs.getString("s_info");               //歌手详情
				Singer singer=new Singer(id, name,img_url,s_info);
				singers.add(singer);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return singers;
	}

	
	public static Object getItem(int id) {
		// TODO Auto-generated method stub
		String[] send= {""+id};
		String[] t= {"id"};
		ResultSet rs=Query.getListLimited("singer", t, send);
		Singer singer=new Singer();
		try {
			while(rs.next()) {
				int sid=rs.getInt("id");							// 歌手id
				String img_url=rs.getString("img_url"); 				// 头像地址
				String name=rs.getString("name"); 					// 用户名
				String s_info=rs.getString("s_info");               //歌手详情
				singer=new Singer(sid, name,img_url,s_info);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return singer;
	}
	public static Singer getSingerByName(String name) {
		// 使用JDBC连接数据库，判断用户名和密码是否正确
		// 1. 创建连接
		Connection conn = DBUtil.getConn();
		// 2. 准备sql
		String sql = "select * from singer where name=? ";
		// 3. 准备参数
		Object[] objs = { name };
		// 4.执行通用查询
		ResultSet rs = DBUtil.executeQuery(sql, objs);
		// 5.封装用户
		Singer singer = null;
		try {
			if (rs.next()) {
				int singerId = rs.getInt("id");
				String singerUrl = rs.getString("img_url");
				String singerName = rs.getString("name");
				String singerInfo = rs.getString("s_info");
				singer = new Singer(singerId,  singerName,singerUrl, singerInfo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return singer;
	}
	
	public static int addSinger(String name, String img_url, String s_info) {
		// 使用JDBC连接数据库，判断用户名和密码是否正确
		// 1. 创建连接
		Connection conn = DBUtil.getConn();
		// 2. 准备sql
		String sql = "insert into singer(name, img_url, s_info) values(?,?,?) ";
		// 3. 准备参数
		Object[] objs = {name, img_url, s_info};
		// 4.执行通用增删改
		int result = DBUtil.executeUpdate(sql, objs);
		return result;
	}

}