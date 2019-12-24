package space.service;

import space.bean.Album;
import space.bean.Music;
import space.bean.Music_sheet;
import space.bean.User;
import space.bean.Singer;
import space.util.DBUtil;

public class update_item {
////value表示的是id值，传入对象和id值，将album对象写入id所在行
//	public static int updateAlbum(Album album, int value) {
//		// TODO Auto-generated method stub
//		String sql = "update album set singer_id = " + album.singer_id + ", name = '" + album.name + 
//				"', singer_name = '" + album.singer_name + "', update_time = " + album.issue_time + 
//				", info = '" + album.info + "', cover_url = '" + album.cover_url + "' where id = " + value +";";
//		
//		//System.out.println(sql);
//		int res=DBUtil.executeUpdate(sql, null);
//		
//		 if( res==0 ){
//	         System.out.print("更改未成功");
//	      }else{
//	         System.out.print("更改成功！");
//	      }
//		return 0;
//	}
		
//value表示的是id值，传入对象和id值，将album对象写入id所在行
	public static int updateAlbum(Album album, int value) {
		// TODO Auto-generated method stub
		String sql = "update album set singer_id =?, name =?, singer_name =?, update_time =?, info =?, cover_url =? where id =?;";
		Object[] object = {album.singer_id, album.name, album.singer_name, album.issue_time, album.info, album.cover_url, album.id};
		
		int res=DBUtil.executeUpdate(sql, object);
		
		 if( res==0 ){
	         System.out.print("更改未成功");
	      }else{
	         System.out.print("更改成功！");
	      }
		return 0;
	}

//value表示的是id值，传入对象和id值，将Music_sheet对象写入id所在行
	public static int updateMusicSheet(Music_sheet Sheet, int value) {
		// TODO Auto-generated method stub
		String sql = "update music_sheet set owner_id =?, name =?, heat =?, info =?, cover_url =? where id =?;";		
		Object[] object = {Sheet.getOwner_id(), Sheet.getName(), Sheet.getHeat(), Sheet.getInfo(), Sheet.getCover_url(), Sheet.getId()};
		
		int res=DBUtil.executeUpdate(sql, object);
		
		 if( res==0 ){
	         System.out.print("更改未成功");
	      }else{
	         System.out.print("更改成功！");
	      }
		return 0;
	}
	
//value表示的是id值，传入对象和id值，将Music_sheet对象写入id所在行
	public static int updateSinger(Singer Singer, int value) {
		// TODO Auto-generated method stub
		String sql = "update singer set name =?, s_info =?, img_url =? where id =?;";	
		Object[] object = {Singer.getName(), Singer.getInfo(), Singer.getImg_url(), Singer.getId()};
		
		int res=DBUtil.executeUpdate(sql, object);
		
		 if( res==0 ){
	         System.out.print("更改未成功");
	      }else{
	         System.out.print("更改成功！");
	      }
		return 0;
	}
	
	public static int updateUser(User user, int value) {
		// TODO Auto-generated method stub
		String sql = "update user set introduction =?, icon_url =?, name =?, gender=?, password=? where id =?;";
		Object[] object = {user.getIntroduction(), user.getIcon_url(), user.getName(), user.getGender(), user.getPassword(), user.getId()};

		int res=DBUtil.executeUpdate(sql, object);
		
		 if( res==0 ){
	         System.out.print("更改未成功");
	      }else{
	         System.out.print("更改成功！");
	      }
		return 0;
	}
	
	public static int updateMusic(Music music, int value) {
		// TODO Auto-generated method stub
		String sql = "update music set heat =?, name =?, music_url =?, singer_id=?, singer_name=?, album_id=?, album_name=?, time=?, update_time=? ,cover_url=? where id =?;";
		Object[] object = {music.getHeat(), music.getName(), music.getMusic_url(), music.getSinger_id(), music.getSinger_name(), music.getAlbum_id(), music.getAlbum_name(), music.getTime(), music.getUpdate_time(),music.getCover_url(), music.getId()};
		
		int res=DBUtil.executeUpdate(sql, object);
		 if( res==0 ){
	         System.out.print("更改未成功");
	      }else{
	         System.out.print("更改成功！");
	      }
		return 0;
	}
}
