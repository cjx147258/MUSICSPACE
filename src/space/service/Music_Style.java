package space.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import space.bean.Music;
import space.util.DBUtil;

public class Music_Style {
	public static List<Music> SearchsongsByMusicstyle(String s){
//		Integer s1=Integer.valueOf(s);
		//	int s1=Integer.parseInt(s);				//把字符串转换成数字
		String sql="select * from music m where m.id in (select music_id from `style-music` where style=?);";
		Object[] objs= {s};
		ResultSet rs=DBUtil.executeQuery(sql, objs);
		List<Music> list = new ArrayList<>();
		try {
			while (rs.next()) {
				int heat=rs.getInt("heat");							// 热度
				int id=rs.getInt("id");							// 歌曲id
				String name=rs.getString("name"); 			// 歌名
				String music_url=rs.getString("music_url"); 				// 歌曲地址
				int singer_id=rs.getInt("singer_id");			//歌手id
				String singer_name=rs.getString("singer_name");//歌手姓名
				int album_id=rs.getInt("album_id");							// 专辑id
				String album_name=rs.getString("album_name"); 					// 专辑名
				String time=rs.getString("time"); 					// 时长
				Date update_time=rs.getDate("update_time"); 	// 上传时间
				Music music=new Music(heat,id,name,music_url, singer_id, album_id,album_name,time,update_time,singer_name); 
//				Music music=new Music(); 
				
				list.add(music);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
