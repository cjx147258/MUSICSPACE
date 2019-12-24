package space.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import space.bean.Music;
import space.dao.tools.Query;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import space.service.getMusicRankByHeat;

/**
 * Servlet implementation class RankServlet
 */
@WebServlet("/RankServlet")
public class RankServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RankServlet() {
 
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String style_id = request.getParameter("style_id");
//		style_id = "1";
//		String tablename="music";
//		int currentPage=3;
//		int pagesize=5;
	//	String tablename=request.getParameter("tablename");
	//	int currentPage=Integer.parseInt(request.getParameter("currentPage"));
	//	int pagesize=Integer.parseInt(request.getParameter("pagesize"));
		//System.out.println(pagesize);
//		List<Music> musics=quge(request,response,tablename,currentPage,pagesize);
		
		List<Music> list=getMusicRankByHeat.ByStyle(style_id);
		request.setAttribute("musics", list);
		System.out.println(list);
		//System.out.println("helloaaaaaaaaaaaaaaa");
		request.getRequestDispatcher("primary1.jsp").forward(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
	public List<Music> quge(HttpServletRequest request,HttpServletResponse response,String tablename,int currentPage,int pagesize) throws ServletException, IOException {
		
		ResultSet res=Query.getPage(tablename, currentPage, pagesize);
		List<Music> musics=new ArrayList<Music>();
		try {
			while(res.next()) {
				int heat=res.getInt("heat");
				int id=res.getInt("id");
				int singer_id=res.getInt("singer_id");
				ResultSetMetaData rsmd=res.getMetaData();
				//System.out.println(rsmd.getColumnName(9));
				int album_id=res.getInt("album_id");
				Date update_time=res.getDate("update_time");
				String name=res.getString("name"); 
				String music_url=res.getString("music_url");
				String time=res.getString("time");
				String album_name=res.getString("album_name");
				String cover_url=res.getString("cover_url");
				String singer_name=res.getString("singer_name");
				musics.add(new Music(  heat,  id,  name,  music_url,  singer_id,  album_id,  album_name,
						 time,  update_time,  singer_name,  cover_url));
//				musics.add(new Music(name,singer_name,cover_url));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return musics;
	}
}
