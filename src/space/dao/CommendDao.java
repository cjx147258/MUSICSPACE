package space.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import space.dao.tools.Query;
import space.util.DBUtil;


public class CommendDao {
    //通过用户和具体类型查询
    public static List<String> getContentLimit(int uid,int tid,int type) {//type 1.音乐 2.专辑 3.歌单
    	String[] field= {"user_id","target_id","type"};
    	String[] value= {""+uid,""+tid,""+type};
    	ResultSet rs=Query.getListLimited("commend", field, value);
    	List<String> contents=new ArrayList<>();
    	try {
			while(rs.next()) {
				String content = rs.getString("content");
				contents.add(content);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return contents;
    }
    //查询所有
    public static List<String> getAllContent(){
    	ResultSet rs=Query.getAll("commend");
    	List<String> contents=new ArrayList<>();
    	try {
			while(rs.next()) {
				String content = rs.getString("content");
				contents.add(content);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return contents;
    }
    //通过具体类型查询评论
    public static List<String> getContentByType(int tid,int type) {//type 1.音乐 2.专辑 3.歌单
    	String[] field= {"target_id","type"};
    	String[] value= {""+tid,""+type};
    	ResultSet rs=Query.getListLimited("commend", field, value);
    	List<String> contents=new ArrayList<>();
    	try {
			while(rs.next()) {
				String content = rs.getString("content");
				contents.add(content);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return contents;
    }
    
    //增加评论
    public static int addContent(int uid,int tid,int type,String content) {
		// 使用JDBC连接数据库，判断用户名和密码是否正确
		// 1. 创建连接
		Connection conn = DBUtil.getConn();
		// 2. 准备sql
		String sql = "insert into commend(user_id,target_id,type,content) values(?,?,?,?) ";
		// 3. 准备参数
		Object[] objs = {uid, tid, type, content};
		// 4.执行通用增删改
		int result = DBUtil.executeUpdate(sql, objs);
		return result;
	}
    
    //根据用户id删除评论
    public static int deleteContentByUid(int uid) {
    	//1.创建连接
    	Connection conn=DBUtil.getConn();
		//准备sql语句
		String sql="DELETE from commend where user_id=?;";
		//准备参数
		Object[] objs= {uid};
		//执行sql
		int result=DBUtil.executeUpdate(sql, objs);
		
		return result;
    }
    
    //根据类型删除评论
    public static int deleteContentByType(int tid,int type) {
    	//1.创建连接
    	Connection conn=DBUtil.getConn();
		//准备sql语句
		String sql="DELETE from commend where target_id=? and type=?;";
		//准备参数
		Object[] objs= {tid,type};
		//执行sql
		int result=DBUtil.executeUpdate(sql, objs);
		return result;
    }
    
    //根据用户id和类型删除评论
    public static int deleteContentByLimit(int uid,int tid,int type) {
    	//1.创建连接
    	Connection conn=DBUtil.getConn();
		//准备sql语句
		String sql="DELETE from commend where user_id=? and target_id=? and type=?;";
		//准备参数
		Object[] objs= {uid,tid,type};
		//执行sql
		int result=DBUtil.executeUpdate(sql, objs);
		return result;
    }
    
}
