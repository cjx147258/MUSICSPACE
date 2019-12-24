package space.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//import space.bean.Music;
import space.bean.Singer;
import space.util.DBUtil;

public class getSinger {

	public static List<Singer> getSingers(){
		String sql="select * from singer";
		ResultSet rs=DBUtil.executeQuery(sql, null);
		List<Singer> list = new ArrayList<>();
		try {
			while(rs.next()) {
				int id=rs.getInt("id");							// 歌曲id
				String name=rs.getString("name"); 			// 歌名
				String img_url=rs.getString("img_url"); 				// 歌曲地址
				String s_info=rs.getString("s_info");			//歌手id
				Singer singer = new Singer(id,name,img_url, s_info); 
				list.add(singer);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
