package space.service;


import com.mysql.jdbc.Connection;

import space.util.DBUtil;

public class add_link {
	//用户和歌单
	public static int user_sheet(int user_id,int sheet_id) {
		Connection conn=(Connection) DBUtil.getConn();
		String sql="insert into `user-sheet` (user_id,sheet_id) values (?,?) ";
		Object[] objs= {user_id,sheet_id};
		int rs=DBUtil.executeUpdate(sql, objs);
		return rs;		
	}
	//音乐和歌单
	public static int music_sheet(int sheet_id,int music_id) {
		Connection conn=(Connection) DBUtil.getConn();
		String sql="insert into `sheet-music` (sheet_id,music_id) values (?,?)";
		Object[] objs= {sheet_id,music_id};
		int rs=DBUtil.executeUpdate(sql, objs);
		return rs;
	}
	//歌单和风格
	public static int music_style(int sheet_id,String style) {
		Connection conn=(Connection) DBUtil.getConn();
		String sql="insert into `music-style` (sheet_id,style) values (?,'?')";
		Object[] objs= {sheet_id,style};
		int rs=DBUtil.executeUpdate(sql, objs);
		return rs;
	}
	//用户和歌手
	public static int user_singer(int user_id,int singer_id) {
		Connection conn=(Connection) DBUtil.getConn();
		String sql="insert into `user-singer` (user_id,singer_id) values (?,?)";
		Object[] objs= {user_id,singer_id};
		int rs=DBUtil.executeUpdate(sql, objs);
		return rs;
	}
	//用户和专辑
	public static int user_album(int user_id,int album_id) {
		Connection conn=(Connection) DBUtil.getConn();
		String sql="insert into `user-album` (user_id,album_id) values (?,?)";
		Object[] objs= {user_id,album_id};
		int rs=DBUtil.executeUpdate(sql, objs);
		return rs;
	}
	//
	public static int album_style(int album_id,String style) {
		Connection conn=(Connection) DBUtil.getConn();
		String sql="insert into `album-style` (album_id,style) values (?,'?')";
		Object[] objs= {album_id,style};
		int rs=DBUtil.executeUpdate(sql, objs);
		return rs;
	}
}
