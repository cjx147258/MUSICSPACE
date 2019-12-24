package space.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import space.util.DBUtil;

public class Query {
	public static ResultSet getListLimited(String tablename, String[] field, String[] value) {
		// TODO Auto-generated method stub
		String sql="select * from "+tablename+" where ";
		for(int i=0;i<field.length-1;i++) {
			sql = sql+field[i]+'='+value[i]+" and ";
		}
		sql = sql + field[field.length-1] + '=' + value[value.length-1];
		sql = sql+';';
		ResultSet res=DBUtil.executeQuery(sql, null);
		return res;
	}

	public static ResultSet getAll(String tablename) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		String sql="select * from "+tablename+";";
		ResultSet res=DBUtil.executeQuery(sql, null);
		return res;
	}
	
	public static ResultSet getPage(String tablename, int currentPage, int pagesize) {
		String sql="select * from "+tablename+" limit "+(currentPage-1)+','+pagesize+';';
		ResultSet res=DBUtil.executeQuery(sql, null);
		return res;
	}
	public static int getPageCount(String tablename) {
		
		String sql="select count(id) from "+tablename;
		ResultSet rs=DBUtil.executeQuery(sql, null);
		int count=-1;
		try {
			if(rs.next()) {
				count=rs.getInt(1);
		  }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
}
