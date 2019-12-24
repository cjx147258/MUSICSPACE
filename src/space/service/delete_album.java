package space.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import space.util.DBUtil;

import space.bean.Album;
import space.dao.tools.Query;
//import space.util.DBUtil;
public class delete_album   {

	public static List<Album> getListLimited(String[] field, String[] value) {
		ResultSet rs = Query.getListLimited("album", field, value);
		List<Album> list = new ArrayList<>();
		try {
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int singerId = rs.getInt("singer_id");
				String singerName = rs.getString("singer_name");
				Date updateTime = rs.getDate("update_time");
				String coverUrl = rs.getString("cover_url");
				String info = rs.getString("info");
				Album album = new Album(id, name, singerId, singerName, updateTime, coverUrl, info);
				list.add(album);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public static List<?> getAll() {
		ResultSet rs = Query.getAll("album");
		List<Album> list = new ArrayList<>();
		try {
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int singerId = rs.getInt("singer_id");
				String singerName = rs.getString("singer_name");
				Date updateTime = rs.getDate("update_time");
				String coverUrl = rs.getString("cover_url");
				String info = rs.getString("info");
				Album album = new Album(id, name, singerId, singerName, updateTime, coverUrl, info);
				list.add(album);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public static Object getItem(int id) {
		String[] field = new String[1];
		field[0] = "id";
		String[] value = new String[1];
		String id1 = Integer.toString(id);
		value[0] = id1;
		return getListLimited(field, value);
	}
	public static int delAlbum(int id) {
		
		Connection conn=DBUtil.getConn();
		//准备sql语句
		String sql1="DELETE from album where id=?;";
		//准备参数
		Object[] objs1= {id};
		//执行sql
		int result1=DBUtil.executeUpdate(sql1, objs1);
		
	
		
		
//		Connection conn2=DBUtil.getConn();
		//准备sql语句
		String sql2="DELETE from album-style where album_id=?;";
		//准备参数
		Object[] objs2= {id};
		//执行sql
		int result2=DBUtil.executeUpdate(sql2, objs2);
		
	
		
		
//		Connection conn3=DBUtil.getConn();
		//准备sql语句
		String sql3="DELETE from user-album where album_id=?;";
		//准备参数
		Object[] objs3= {id};
		//执行sql
		int result3=DBUtil.executeUpdate(sql3, objs3);
		
	
		
	
	    int result=0;
	    if(result1==1&&result2==1&&result3==1)
	    {
	    	result=1;
	    }
		
		return result;
	}
	public static void main(String[] args) {
		delAlbum(4);
	}
}
