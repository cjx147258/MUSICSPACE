package space.service;

//import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import space.bean.Singer;
import space.util.DBUtil;

public class User_Singer {

	public static List<Singer> Userlink_Singer(int sid){
//		Connection conn=DBUtil.getConn();
		String sql="SELECT * FROM singer s WHERE s.id in (SELECT singer_id FROM `user-singer` WHERE user_id="+sid+");";
	    ResultSet rs=DBUtil.executeQuery(sql, null);
	    List<Singer> list = new ArrayList<>();
	    try {
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String img_url = rs.getString("img_url");
				String info = rs.getString("s_info");
				Singer singer = new Singer(id,name,img_url,info);
				list.add(singer);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    return list;
	}
}
