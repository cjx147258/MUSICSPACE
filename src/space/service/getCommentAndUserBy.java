package space.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import space.bean.Content;
import space.bean.Music_sheet;
import space.bean.User;
import space.dao.tools.Query;
import space.util.DBUtil;

public class getCommentAndUserBy{
	public static List<Content> contentAndUserByMusic(int target_id){//type 1.音乐 2.专辑 3.歌单
		int type=1;
		String sql="select * from commend where target_id=? and type=?;";
		Object[] objs= {""+target_id,""+type};
		ResultSet rs=DBUtil.executeQuery(sql, objs);
		List<Content> contents=new ArrayList<>();
		try {
			while(rs.next()) {
				int uid=rs.getInt("user_id");
				int tid=rs.getInt("target_id");
				int ctype=rs.getInt("type");
				String content=rs.getString("content");
				String u_name=rs.getString("user_name");
				String u_url=rs.getString("user_url");
				Content list=new Content(uid, tid, ctype, content, u_name, u_url);
				contents.add(list);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return contents;
	}
	
	public static List<Content> contentAndUserByAlbum(int target_id){
		int type=2;
		String sql="select * from commend where target_id=? and type=?;";
		Object[] objs= {""+target_id,""+type};
		ResultSet rs=DBUtil.executeQuery(sql, objs);
		List<Content> contents=new ArrayList<>();
		try {
			while(rs.next()) {
				int uid=rs.getInt("user_id");
				int tid=rs.getInt("target_id");
				int ctype=rs.getInt("type");
				String content=rs.getString("content");
				String u_name=rs.getString("user_name");
				String u_url=rs.getString("user_url");
				Content list=new Content(uid, tid, ctype, content, u_name, u_url);
				contents.add(list);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return contents;
	}
	
	public static List<Content> contentAndUserBySheet(int target_id){
		int type=3;
		String sql="select * from commend where target_id=? and type=?;";
		Object[] objs= {""+target_id,""+type};
		ResultSet rs=DBUtil.executeQuery(sql, objs);
		List<Content> contents=new ArrayList<>();
		try {
			while(rs.next()) {
				int uid=rs.getInt("user_id");
				int tid=rs.getInt("target_id");
				int ctype=rs.getInt("type");
				String content=rs.getString("content");
				String u_name=rs.getString("user_name");
				String u_url=rs.getString("user_url");
				Content list=new Content(uid, tid, ctype, content, u_name, u_url);
				contents.add(list);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return contents;
	}
	
}
