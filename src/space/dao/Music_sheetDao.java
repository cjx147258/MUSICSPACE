package space.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import space.bean.Music_sheet;
import space.dao.tools.Query;
import space.util.DBUtil;



public class Music_sheetDao   {

	
	public static List<?> getListLimited(String[] field, String[] value) {
		ResultSet rs = Query.getListLimited("music_sheet", field, value);
		List<Music_sheet> list = new ArrayList<>();
		try {
			while (rs.next()) {
				int id=rs.getInt("id");
				int owner_id=rs.getInt("owner_id");
				String cover_url=rs.getString("cover_url");
				String name=rs.getString("name");
				String info=rs.getString("info");
				Date update_time=rs.getDate("update_time");
				int heat=rs.getInt("heat");
				Music_sheet album = new Music_sheet(id,  owner_id,  cover_url,  name,  info,  update_time,  heat);
				list.add(album);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	
	public static List<?> getAll() {
		// TODO Auto-generated method stub		
		ResultSet rs = Query.getAll("music_sheet");
		List<Music_sheet> list = new ArrayList<>();
		try {
			while (rs.next()) {
				int id=rs.getInt("id");
				int owner_id=rs.getInt("owner_id");
				String cover_url=rs.getString("cover_url");
				String name=rs.getString("name");
				String info=rs.getString("info");
				Date update_time=rs.getDate("update_time");
				int heat=rs.getInt("heat");
				Music_sheet album = new Music_sheet(id,  owner_id,  cover_url,  name,  info,  update_time,  heat);
				list.add(album);
			}
		} catch (SQLException e) {;
			e.printStackTrace();
		}
		return list;
	}

	
	public static Object getItem(int id) {
		// TODO Auto-generated method stub
		String[] field= {"id"};
		String[] value= {""+id};
		ResultSet rs = Query.getListLimited("music_sheet", field, value);
		Music_sheet sheet = new Music_sheet();
		try {
			while(rs.next()) {
			int owner_id = rs.getInt("owner_id");		
			String cover_url=rs.getString("cover_url");
			String name=rs.getString("name");
			String info=rs.getString("info");
			Date update_time=rs.getDate("update_time");
			int heat=rs.getInt("heat");
			sheet = new Music_sheet(id,  owner_id,  cover_url,  name,  info,  update_time,  heat);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sheet;
	}
	
	public static int addMusicSheet(int owner_id, String cover_url, String name, String info, Date update_time, int heat) {
		// 使用JDBC连接数据库，判断用户名和密码是否正确
		// 1. 创建连接
		Connection conn = DBUtil.getConn();
		// 2. 准备sql
		String sql = "insert into music_sheet(owner_id, cover_url, name, info, update_time, heat) values(?,?,?,?,?,?) ";
		// 3. 准备参数
		Object[] objs = {owner_id, cover_url, name, info, update_time, heat};
		// 4.执行通用增删改
		int result = DBUtil.executeUpdate(sql, objs);
		return result;
	}

}
