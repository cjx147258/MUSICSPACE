package space.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import space.bean.Album;
import space.bean.Music_sheet;
import space.bean.Singer;
import space.util.DBUtil;

public class getListByUserId {
	public static List<Album> getAlbumById(String uid){
		String sql="select * from album a where a.id in (select album_id from `user-album` where user_id=?);";
		Object[] objs = {uid};
		ResultSet rs=DBUtil.executeQuery(sql, objs);
		List<Album> list = new ArrayList<>();
		try {
			while(rs.next()) {
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
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
}
	public static List<Singer> getSingerById(String uid){
		String sql="select * from singer s where s.id in (select singer_id from `user-singer` where user_id=?);";
		Object[] objs = {uid};
		ResultSet rs=DBUtil.executeQuery(sql, objs);
		List<Singer> list = new ArrayList<>();
		try {
			while(rs.next()) {
				while(rs.next()) {
					int id=rs.getInt("id");		// 歌手id
					String img_url=rs.getString("img_url"); 				// 头像地址
					String name=rs.getString("name"); 					// 用户名
					String s_info=rs.getString("s_info");               //歌手详情
					Singer singer=new Singer(id,name, img_url,s_info);
					list.add(singer);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
}
}
