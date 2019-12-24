package space.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import space.bean.Music_sheet;
import space.util.DBUtil;

public class getSheetByMusic {
	public static List<Music_sheet> music_sheetByMusic(int mid){
		String sql="select * from music_sheet m where m.id in (select sheet_id from `sheet-music` where music_id="+mid+");";
		ResultSet rs=DBUtil.executeQuery(sql, null);
		List<Music_sheet> list = new ArrayList<>();
		try {
			while (rs.next()) {
				int id=rs.getInt("id");
				int owner_id=rs.getInt("owner_id");
				String cover_url=rs.getString("cover_url");
				String name=rs.getString("name");
				String info=rs.getString("info");
				Date update_time=rs.getDate("update_time");
				int heat=rs.getInt("heat");
				Music_sheet album = new Music_sheet(id,  owner_id,  cover_url,  name,  info,  update_time,  heat);
				list.add(album);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
