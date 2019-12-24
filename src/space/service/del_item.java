package space.service;

import java.sql.Connection;

import space.util.DBUtil;

public class del_item {

	public static int delSinger(int id) {
		Connection conn=DBUtil.getConn();
		//准备sql语句
		String sql1="DELETE from singer where id=?";
		//准备参数
		Object[] objs1= {id};
		//执行sql
		int result1=DBUtil.executeUpdate(sql1, objs1);
		
	
		
		
		Connection conn2=DBUtil.getConn();
		//准备sql语句
		String sql2="DELETE from `user-singer` where singer_id=?";
		//准备参数
		Object[] objs2= {id};
		//执行sql
		int result2=DBUtil.executeUpdate(sql2, objs2);
		
		
	
	    int result=0;
	    if(result1==1&&result2==1)
	    {
	    	result=1;
	    }
		
		return result;
	}

	public static int delUser(int id) {
		
		Connection conn=DBUtil.getConn();
		//准备sql语句
		String sql1="delete from user where id=?";
		//准备参数
		Object[] objs1= {id};
		//执行sql
		int result1=DBUtil.executeUpdate(sql1, objs1);
		
	
		
		
		Connection conn2=DBUtil.getConn();
		//准备sql语句
		String sql2="delete from `user-album` where user_id=?";
		//准备参数
		Object[] objs2= {id};
		//执行sql
		int result2=DBUtil.executeUpdate(sql2, objs2);
		
	
		
		
		Connection conn3=DBUtil.getConn();
		//准备sql语句
		String sql3="delete from `user-sheet` where user_id=?";
		//准备参数
		Object[] objs3= {id};
		//执行sql
		int result3=DBUtil.executeUpdate(sql3, objs3);
		
		Connection conn4=DBUtil.getConn();
		//准备sql语句
		String sql4="delete from `user-singer` where user_id=?";
		//准备参数
		Object[] objs4= {id};
		//执行sql
		int result4=DBUtil.executeUpdate(sql4, objs4);
		
	
	    int result=0;
	    if(result1==1&&result2==1&&result3==1&&result4==1)
	    {
	    	result=1;
	    }
		
		return result;
	}
	public static int delMusic(int id) {
		
		Connection conn=DBUtil.getConn();
		//准备sql语句
		String sql1="DELETE from music where id=?";
		//准备参数
		Object[] objs1= {id};
		//执行sql
		int result1=DBUtil.executeUpdate(sql1, objs1);
		
	
		
		
		Connection conn2=DBUtil.getConn();
		//准备sql语句
		String sql2="DELETE from `sheet-music` where music_id=?";
		//准备参数
		Object[] objs2= {id};
		//执行sql
		int result2=DBUtil.executeUpdate(sql2, objs2);
		
		
	
	    int result=0;
	    if(result1==1&&result2==1)
	    {
	    	result=1;
	    }
		
		return result;
	}
	public static int delAlbum(int id) {
		
		Connection conn=DBUtil.getConn();
		//准备sql语句
		String sql1="DELETE from album where id=?";
		//准备参数
		Object[] objs1= {id};
		//执行sql
		int result1=DBUtil.executeUpdate(sql1, objs1);
		
	
		
		
		Connection conn2=DBUtil.getConn();
		//准备sql语句
		String sql2="DELETE from `album-style` where album_id=?";
		//准备参数
		Object[] objs2= {id};
		//执行sql
		int result2=DBUtil.executeUpdate(sql2, objs2);
		
	
		
		
		Connection conn3=DBUtil.getConn();
		//准备sql语句
		String sql3="DELETE from `user-album` where album_id=?";
		//准备参数
		Object[] objs3= {id};
		//执行sql
		int result3=DBUtil.executeUpdate(sql3, objs3);
		
	
		
	
	    int result=0;
	    if(result1==1&&result2==1&&result3==1)
	    {
	    	result=1;
	    }
		
		return result;
	}
public static int delMusic_sheet(int id) {
		
		Connection conn=DBUtil.getConn();
		//准备sql语句
		String sql1="delete from `music-sheet` where id=?";
		//准备参数
		Object[] objs1= {id};
		//执行sql
		int result1=DBUtil.executeUpdate(sql1, objs1);
		
	
		
		
		Connection conn2=DBUtil.getConn();
		//准备sql语句
		String sql2="delete from `sheet-music` where sheet_id=?";
		//准备参数
		Object[] objs2= {id};
		//执行sql
		int result2=DBUtil.executeUpdate(sql2, objs2);
		
	
		
		
		Connection conn3=DBUtil.getConn();
		//准备sql语句
		String sql3="delete from `user-sheet` where sheet_id=?";
		//准备参数
		Object[] objs3= {id};
		//执行sql
		int result3=DBUtil.executeUpdate(sql3, objs3);
		
		Connection conn4=DBUtil.getConn();
		//准备sql语句
		String sql4="delete from `style-sheet` where sheet_id=?";
		//准备参数
		Object[] objs4= {id};
		//执行sql
		int result4=DBUtil.executeUpdate(sql4, objs4);
		
	
	    int result=0;
	    if(result1==1&&result2==1&&result3==1&&result4==1)
	    {
	    	result=1;
	    }
		
		return result;
	}
}
