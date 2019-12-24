package space.service;

//import java.sql.ResultSet;

import space.util.DBUtil;


public class delete_link {
	//专辑and风格
	public static int delectAlbum_style(int album_id,String style) {
		String sql="delect from album-style where album_id=? and style=?";
		Object[] objs= {album_id,style};
		int rs=DBUtil.executeUpdate(sql, objs);
		return rs;
	}
	

	public static int delAlbum_styleByAlbumID(int album_id) {
		String sql="delect from album-style where album_id=?";
		Object[] objs= {album_id};
		int rs=DBUtil.executeUpdate(sql, objs);	
		return rs;
	}
	
	public static int delectAlbum_styleByStyle(String style) {
		String sql="delect from album-style where style=?";
		Object[] objs= {style};
		int rs=DBUtil.executeUpdate(sql, objs);	
		return rs;
	}
	//歌单and音乐
	public static int delectSheet_music(int sheet_id,int music_id) {
		String sql="delect from sheet-music where sheet_id=? and music_id=?";
		Object[] objs= {sheet_id,music_id};
		int rs=DBUtil.executeUpdate(sql, objs);
		return rs;
	}
	public static int delSheet_musicBySheetID(int sheet_id) {
		String sql="delect from sheet-music where sheet_id=?";
		Object[] objs= {sheet_id };
		int rs=DBUtil.executeUpdate(sql, objs);	
		return rs;
	}
	
	public static int delSheet_musicByMusicID(int music_id) {
		String sql="delect from sheet-music where music_id=?";
		Object[] objs= {music_id};
		int rs=DBUtil.executeUpdate(sql, objs);	
		return rs;
	}
	
	//歌单and风格
	public static int delectStyle_sheet(int sheet_id,String style) {
		String sql="delect from style-sheet where sheet_id=? and style=?";
		Object[] objs= {sheet_id,style};
		int rs=DBUtil.executeUpdate(sql, objs);
		return rs;
	}
	public static int delStyle_sheetBySheetID(int sheet_id) {
		String sql="delect from style-sheet where sheet_id=?";
		Object[] objs= {sheet_id };
		int rs=DBUtil.executeUpdate(sql, objs);	
		return rs;
	}
	
	public static int delStyle_sheetByStyle(String style) {
		String sql="delect from style-sheet where style=?";
		Object[] objs= {style};
		int rs=DBUtil.executeUpdate(sql, objs);	
		return rs;
	}
	//用户and专辑
	public static int delectUser_album(int user_id,int album_id) {
		String sql="delect from user-album where user_id=? and album_id=?";
		Object[] objs= {user_id,album_id};
		int rs=DBUtil.executeUpdate(sql, objs);
		return rs;
	}
	public static int delUser_albumByAlbumID(int album_id) {
		String sql="delect from user-album where album_id=?";
		Object[] objs= {album_id };
		int rs=DBUtil.executeUpdate(sql, objs);	
		return rs;
	}
	
	public static int delUser_albumByUserID(int user_id) {
		String sql="delect from user-album where user_id=?";
		Object[] objs= {user_id};
		int rs=DBUtil.executeUpdate(sql, objs);	
		return rs;
	}
	//用户and歌单
	public static int delectUser_sheet(int user_id,int sheet_id) {
		String sql="delect from user-sheet where user_id=? and sheet_id=?";
		Object[] objs= {user_id,sheet_id};
		int rs=DBUtil.executeUpdate(sql, objs);
		return rs;
	}
	public static int delUser_sheetByUserID(int user_id) {
		String sql="delect from user-sheet where user_id=?";
		Object[] objs= {user_id };
		int rs=DBUtil.executeUpdate(sql, objs);	
		return rs;
	}
	
	public static int delUser_sheetBySheetID(int sheet_id) {
		String sql="delect from user-sheet where sheet_id=?";
		Object[] objs= {sheet_id};
		int rs=DBUtil.executeUpdate(sql, objs);	
		return rs;
	}
	//用户and歌手
	public static int delectUser_singer(int user_id,int singer_id) {
			String sql="delect from user-singer where user_id=? and singer_id=?";
			Object[] objs= {user_id,singer_id};
			int rs=DBUtil.executeUpdate(sql, objs);
			return rs;
	}
	public static int delUser_singerByUserID(int user_id) {
		String sql="delect from user-singer where user_id=?";
		Object[] objs= {user_id };
		int rs=DBUtil.executeUpdate(sql, objs);	
		return rs;
	}
	
	public static int delUser_singerBySingerID(int singer_id) {
		String sql="delect from user-singer where singer_id=?";
		Object[] objs= {singer_id};
		int rs=DBUtil.executeUpdate(sql, objs);	
		return rs;
	}

}
