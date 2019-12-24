package space.service;

//import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import space.bean.Music;

import space.util.DBUtil;

public class Music_MusicSheet {
	public static List<Music> SearchsongsByMusicsheet(int shid){
//		Connection conn=DBUtil.getConn();
		String sql="select * from music m where m.id in (select music_id from `sheet-music` where sheet_id="+shid+");";
		ResultSet rs=DBUtil.executeQuery(sql, null);
		List<Music> list = new ArrayList<>();
		try {
			while (rs.next()) {
				int heat = rs.getInt("heat");
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int singerId = rs.getInt("singer_id");
				String singerName = rs.getString("singer_name");
				String musicUrl = rs.getString("music_url");
				int albumId = rs.getInt("album_id");
				String albumName = rs.getString("album_name");
				String time = rs.getString("time");
				Date updateTime = rs.getDate("update_time");
				Music music = new Music(heat, id, name, musicUrl, singerId, albumId, albumName,time,updateTime,singerName);
				list.add(music);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
