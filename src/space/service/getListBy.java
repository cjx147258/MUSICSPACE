package space.service;

import java.util.ArrayList;
import java.util.List;

import space.bean.Album;
import space.bean.Music;
import space.bean.Music_sheet;
import space.bean.User;
import space.dao.AlbumDao;
import space.dao.CommendDao;
import space.dao.MusicDao;
import space.dao.Music_sheetDao;


public class getListBy {
	
	public static List<Album>AlbumsBySingerID(int id){
		List<Album> list = new ArrayList<>();
		String[] field= {"singer_id"};
		String[] value= {""+id};
		list = AlbumDao.getListLimited(field,value);
		return list;
	}
	public static List<Music>MusicBySingerID(int id){
		List<Music> list=new ArrayList<>();
		String[] field= {"singer_id"};
		String[] value= {""+id};
		list=MusicDao.getListLimited(field, value);
		return list;
	}
	public static List<Music>MusicByAlbumID(int id){
		List<Music> list=new ArrayList<>();
		String[] field= {"album_id"};
		String[] value= {""+id};
		list=MusicDao.getListLimited(field, value);
		return list;
	}
	@SuppressWarnings("unchecked")
	public static List<Music_sheet>Music_sheetByOwnerID(int id){
		List<Music_sheet> list=new ArrayList<>();
		String[] field= {"owner_id"};
		String[] value= {""+id};
		list=(List<Music_sheet>) Music_sheetDao.getListLimited(field, value);
		return list;
	}
	public static List<Album>AlbumsBySingerName(String name){
		List<Album> list = new ArrayList<>();
		String[] field= {"singer_name"};
		String[] value= {name};
		list = AlbumDao.getListLimited(field,value);
		return list;
	}
	public static List<Music>MusicBySingerName(String name){
		List<Music> list=new ArrayList<>();
		String[] field= {"singer_name"};
		String[] value= {name};
		list=MusicDao.getListLimited(field, value);
		return list;
	}
	public static List<Music>MusicByAlbumName(String name){
		List<Music> list=new ArrayList<>();
		String[] field= {"album_name"};
		String[] value= {name};
		list=MusicDao.getListLimited(field, value);
		return list;
	}


}
