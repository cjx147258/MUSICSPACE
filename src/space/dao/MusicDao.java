package space.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import space.bean.Music;
import space.bean.Singer;
import space.dao.tools.Query;
import space.util.DBUtil;


public class MusicDao {

	
	public static List<Music> getListLimited(String[] field, String[] value) {
		ResultSet rs=Query.getListLimited("music", field, value);
		List<Music> songs=new ArrayList<>();
		try {
			while(rs.next()) {
				int heat=rs.getInt("heat");							// 热度
				int id=rs.getInt("id");							// 歌曲id
				String name=rs.getString("name"); 			// 歌名
				String music_url=rs.getString("music_url"); 				// 歌曲地址
				int singer_id=rs.getInt("singer_id");			//歌手id
				int album_id=rs.getInt("album_id");							// 专辑id
				String album_name=rs.getString("album_name"); 					// 专辑名
				String time=rs.getString("time"); 					// 时长
				Date update_time=rs.getDate("update_time"); 	// 上传时间
				String singer_name=rs.getString("singer_name");
				String cover_url=rs.getString("cover_url"); 
				Music music=new Music(heat,id,name,music_url, singer_id, album_id,album_name,time,update_time, singer_name,cover_url); 
				songs.add(music);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return songs;
	}

	
	public static List<Music> getAll() {
		// TODO Auto-generated method stub
		ResultSet rs=Query.getAll("music");
		List<Music> songs=new ArrayList<>();
		try {
			while(rs.next()) {
				int heat=rs.getInt("heat");							// 热度
				int id=rs.getInt("id");							// 歌曲id
				String name=rs.getString("name"); 			// 歌名
				String music_url=rs.getString("music_url"); 				// 歌曲地址
				int singer_id=rs.getInt("singer_id");			//歌手id
				int album_id=rs.getInt("album_id");							// 专辑id
				String album_name=rs.getString("album_name"); 					// 专辑名
				String time=rs.getString("time"); 					// 时长
				Date update_time=rs.getDate("update_time"); 	// 上传时间
				String singer_name=rs.getString("singer_name");
				String cover_url=rs.getString("cover_url"); 
				Music music=new Music(heat,id,name,music_url, singer_id, album_id,album_name,time,update_time, singer_name,cover_url); 
				songs.add(music);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return songs;
	}

	
	public static Object getItem(int id) {
		// TODO Auto-generated method stub
		String[] send= {""+id};
		String[] t= {"id"};
		ResultSet rs=Query.getListLimited("music", t, send);
		Music music=new Music();
		try {
			while(rs.next()) {
				int heat=rs.getInt("heat");							// 热度
				int mid=rs.getInt("id");							// 歌曲id
				String name=rs.getString("name"); 			// 歌名
				String music_url=rs.getString("music_url"); 				// 歌曲地址
				int singer_id=rs.getInt("singer_id");			//歌手id
				int album_id=rs.getInt("album_id");							// 专辑id
				String album_name=rs.getString("album_name"); 					// 专辑名
				String time=rs.getString("time"); 					// 时长
				Date update_time=rs.getDate("update_time"); 	// 上传时间
				String singer_name=rs.getString("singer_name");
				String cover_url=rs.getString("cover_url"); 
				music=new Music(heat,id,name,music_url, singer_id, album_id,album_name,time,update_time, singer_name,cover_url); 
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return music;
	}
	
	public static Music getMusicByNandS(String name, String Sname) {
		// 使用JDBC连接数据库，判断用户名和密码是否正确
		// 1. 创建连接
		Connection conn = DBUtil.getConn();
		// 2. 准备sql
		String sql = "select * from music where name=? and singer_name = ?";
		// 3. 准备参数
		Object[] objs = { name, Sname};
		// 4.执行通用查询
		ResultSet rs = DBUtil.executeQuery(sql, objs);
		// 5.封装用户
		Music music = null;
		try {
			//int heat, int id, String name, String music_url, int singer_id, int album_id, String album_name,
			//String time, Date update_time, String singer_name
			if (rs.next()) {
				int musicId = rs.getInt("id");
				int musicHeat = rs.getInt("heat");
				String musicName = rs.getString("name");
				String musicUrl = rs.getString("music_url");
				int musicSingerId = rs.getInt("singer_id");
				int musicAlbumId = rs.getInt("album_id");
				String musicAlbumName = rs.getString("album_name");
				String musicTime = rs.getString("time");
				Date musicUpdateTime = rs.getDate("update_time");
				String musicSingerName = rs.getString("singer_name");
				String cover_url = rs.getString("cover_url");
				music = new Music(musicHeat, musicId, musicName, musicUrl, musicSingerId, musicAlbumId, musicAlbumName, musicTime, musicUpdateTime, musicSingerName, cover_url);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return music;
	}
	
	public static int addMusic(int heat, String name, String music_url, int singer_id, int album_id, String album_name,
			String time, Date update_time, String singer_name) {
		// 使用JDBC连接数据库，判断用户名和密码是否正确
		// 1. 创建连接
		Connection conn = DBUtil.getConn();
		// 2. 准备sql
		String sql = "insert into music(heat, name, music_url, singer_id, album_id, album_name, time, update_time, singer_name) values(?,?,?,?,?,?,?,?,?) ";
		// 3. 准备参数
		Object[] objs = {heat, name, music_url, singer_id, album_id, album_name, time, update_time, singer_name};
		// 4.执行通用增删改
		int result = DBUtil.executeUpdate(sql, objs);
		return result;
	}
	public static int addMusic(int heat, String name, String music_url, int singer_id, int album_id, String album_name,
			String time, Date update_time, String singer_name,String cover_url) {
		// 使用JDBC连接数据库，判断用户名和密码是否正确
		// 1. 创建连接
		Connection conn = DBUtil.getConn();
		// 2. 准备sql
		String sql = "insert into music(heat, name, music_url, singer_id, album_id, album_name, time, update_time, singer_name,cover_url) values(?,?,?,?,?,?,?,?,?,?) ";
		// 3. 准备参数
		Object[] objs = {heat, name, music_url, singer_id, album_id, album_name, time, update_time, singer_name,cover_url};
		// 4.执行通用增删改
		int result = DBUtil.executeUpdate(sql, objs);
		return result;
	}

}
