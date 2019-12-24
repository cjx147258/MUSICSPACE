package space.dao;

//import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import space.bean.Album;
import space.dao.tools.Query;
import space.util.DBUtil;
//import space.util.DBUtil;
public class AlbumDao   {

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

//	public static Object getItem(int id) {
//		String[] field = new String[1];
//		field[0] = "id";
//		String[] value = new String[1];
//		String id1 = Integer.toString(id);
//		value[0] = id1;
//		return getListLimited(field, value);
//	}
	public static Album getItem(int id) {
		// TODO Auto-generated method stub		
		String[] field= {"id"};
		String[] value= {""+id};
		ResultSet rs = Query.getListLimited("album", field, value);
		System.out.println(100);
		Album album = new Album();
		try {
			while (rs.next()) {
				int ID=rs.getInt("id");
				int singer_id=rs.getInt("singer_id");
				String cover_url=rs.getString("cover_url");
				String name=rs.getString("name");
				String singer_name=rs.getString("singer_name");
				String info=rs.getString("info");
				Date issue_time=rs.getDate("update_time");
				album = new Album(ID,  name,  singer_id, singer_name, issue_time, cover_url, info);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return album;
	}
//	public static getAlbumbyStyle() {
//		
//	}
	
	public static int addAlbum(String name, int singer_id, String singer_name, Date issue_time, String cover_url,
			String info) {
		// 使用JDBC连接数据库，判断用户名和密码是否正确
		// 1. 创建连接
//		Connection conn = DBUtil.getConn();
		// 2. 准备sql
		String sql = "insert into album(name, singer_id, singer_name, update_time, cover_url, info) values(?,?,?,?,?,?) ";
		// 3. 准备参数
		Object[] objs = {name, singer_id, singer_name, issue_time, cover_url, info};
		// 4.执行通用增删改
		int result = DBUtil.executeUpdate(sql, objs);
		return result;
	}
}
