package space.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import space.bean.Music;
import space.bean.Singer;
import space.util.DBUtil;

public class Singer_label {
	public static List<Singer> SearchsingerByLabel(int l){
		
		String sql="select * from singer s where s.id in (select singer_id from `singer-label` where label_id=?);";
		Object[] objs= {l};
		ResultSet rs=DBUtil.executeQuery(sql, objs);
		List<Singer> list = new ArrayList<>();
		try {
			while (rs.next()) {
				int id=rs.getInt("id");							// 歌手id
				String img_url=rs.getString("img_url"); 				// 头像地址
				String name=rs.getString("name"); 					// 用户名
				String s_info=rs.getString("s_info");               //歌手详情
				Singer singer=new Singer(id, name,img_url,s_info); 
				list.add(singer);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
