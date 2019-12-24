package space.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import space.bean.Style_sheet;
import space.dao.tools.Query;

public class style_sheetDao {

	public static List<?> getItem(int id) {
		// TODO Auto-generated method stub
		String[] field= {"sheet_id"};
		String[] value= {""+id};
		ResultSet rs = Query.getListLimited("`style-sheet`", field, value);
		List<Style_sheet> list = new ArrayList<>();
		try {
			while (rs.next()) {
				int sheet_id=rs.getInt("sheet_id");
				int style_id=rs.getInt("style_id");
				String style=rs.getString("style");
				Style_sheet ss=new Style_sheet(sheet_id, style_id, style);
				list.add(ss);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
