package space.service;

//import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import space.bean.Album;
import space.util.DBUtil;

public class getAlbumsbyStyle {
	public static List<Album> getAlbumByStyle(String value){
//		Connection conn=DBUtil.getConn();
		
		String sql="select * from album a WHERE a.id in (SELECT album_id FROM `album-style` WHERE style=?) ;";
		Object[] objs = {value};
		ResultSet rs=DBUtil.executeQuery(sql, objs);
		
//		String sql="select * from album order by issue_time desc";
//		ResultSet rs=DBUtil.executeQuery(sql, null);
		
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
}
