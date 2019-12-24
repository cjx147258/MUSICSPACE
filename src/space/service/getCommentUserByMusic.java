package space.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import space.bean.Music_sheet;
import space.bean.User;
import space.dao.tools.Query;
import space.util.DBUtil;

public class getCommentUserByMusic {
	public static List<User> userByMusic(int id){
		String sql="select * from user u where u.id in (select user_id from commend where target_id=? and type=1);";
		Object[] objs= {id+""};
		
		ResultSet rs=DBUtil.executeQuery(sql, objs);
		List<User> users=new ArrayList<>();
		try {
			while(rs.next()) {
				int uid=rs.getInt("id");							// 用户id
				String introduction=rs.getString("introduction"); 			// 个人签名
				String icon_url=rs.getString("icon_url"); 				// 头像地址
				String name=rs.getString("name"); 					// 用户名
				String gender=rs.getString("gender"); 					// 性别
				String password=rs.getString("password"); 	// 密码
				User user=new User(uid, introduction, icon_url, name, gender, password);
				users.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return users;
	}
	
}
