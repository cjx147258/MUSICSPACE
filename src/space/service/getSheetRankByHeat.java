package space.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//import com.mysql.jdbc.Connection;

import space.bean.Music_sheet;
import space.util.DBUtil;

public class getSheetRankByHeat {
	public static List<Music_sheet> SortByHeat(){
//		Connection conn=(Connection) DBUtil.getConn();
		String sql="select * from music_sheet order by heat desc;";
		ResultSet rs=DBUtil.executeQuery(sql, null);
		List<Music_sheet> list = new ArrayList<>();
		try {
			while(rs.next()) {
				
				int id=rs.getInt("id");							// 歌单id
				int owner_id=rs.getInt("owner_id");							// 创建者id	
				String cover_url=rs.getString("cover_url"); 				// 封面图
				String name=rs.getString("name");			//歌单姓名
				String info=rs.getString("info"); 					// 专辑名
				Date update_time=rs.getDate("update_time"); 	// 上传时间
				int heat=rs.getInt("heat");							// 热度
				Music_sheet music_sheet=new Music_sheet(id,owner_id,cover_url, name, info, update_time,heat); 
				list.add(music_sheet);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
}
}
