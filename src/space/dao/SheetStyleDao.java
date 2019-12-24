package space.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import space.bean.Music_sheet;
import space.util.DBUtil;

public class SheetStyleDao {
	public static List<Music_sheet> getSheetByStyle(String s) {
		String sql="select m.* from `style-sheet` s,music_sheet m where s.sheet_id =m.id and s.style= ?;";
		Object[] objs= {s};
		ResultSet rs=DBUtil.executeQuery(sql, objs);
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
