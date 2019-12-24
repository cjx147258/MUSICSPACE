package space.service;

import java.util.Date;

import space.bean.Music;
import space.bean.Singer;
import space.bean.User;
import space.dao.AlbumDao;
import space.dao.MusicDao;
import space.dao.Music_sheetDao;
import space.dao.SingerDao;
import space.dao.UserDao;

public class add_item {
	
	public static int insertSinger(String name, String img_url, String s_info) {
		Singer singer = SingerDao.getSingerByName(name);
		if(singer != null) {
			return -1;			//代表歌手存在，无法添加
		}else {			//代表歌手不存在，可以添加
		  int result = SingerDao.addSinger(name, img_url, s_info);
		  return result;		//返回添加的结果
		}
	}
	
	public static int insertMusic(int heat, String name, String music_url, int singer_id, int album_id, String album_name,
			String time, Date update_time, String singer_name) {
		Music music = MusicDao.getMusicByNandS(name, singer_name);
		if(music != null) {
			return -1;
		}else {	
		  int result = MusicDao.addMusic(heat, name, music_url, singer_id, album_id, album_name, time, update_time, singer_name);
		  return result;
		}
	}
	
	public static int insertMusicSheet(int owner_id, String cover_url, String name, String info, Date update_time, int heat) {
			
		  int result = Music_sheetDao.addMusicSheet(owner_id, cover_url, name, info, update_time, heat);
		  return result;
	}
	
	public static int insertAlbum(String name, int singer_id, String singer_name, Date issue_time, String cover_url,
			String info) {
		int result = AlbumDao.addAlbum(name, singer_id, singer_name, issue_time, cover_url, info);
		return result;
	}
	
}
