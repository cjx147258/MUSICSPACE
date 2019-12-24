package space.servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import space.bean.Music;
import space.bean.Page;
import space.dao.Query;

/**
 * Servlet implementation class MusicModInitServlet
 */
@WebServlet("/MusicModInitServlet")
public class MusicModInitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MusicModInitServlet() {
      }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String tablename="music";
		int currentPage=Integer.parseInt(request.getParameter("currentPage"));
		int pagesize=5;
		int start=0;
		if(currentPage==1) {
			start=1;
		}else {
			start=(currentPage-1)*pagesize;
		}
		ResultSet res=Query.getPage(tablename, start, pagesize);
		List<Music> musics=new ArrayList<Music>();
		try {
			while(res.next()) {
				int heat=res.getInt("heat");
				int id=res.getInt("id");
				int singer_id=res.getInt("singer_id");
				int album_id=res.getInt("album_id");
				Date update_time=res.getDate("update_time");
				String name=res.getString("name"); 
				String music_url=res.getString("music_url");
				String time=res.getString("time");
				String album_name=res.getString("album_name");
				String cover_url=res.getString("cover_url");
				String singer_name=res.getString("singer_name");
				musics.add(new Music( heat,  id,  name,  music_url,  singer_id,   album_id,
						 album_name,  time,  update_time, singer_name, cover_url));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Page page=new Page();
		page=quye(request,response,tablename,currentPage,pagesize);
		request.setAttribute("musics", musics);
		request.setAttribute("page", page);
		request.getRequestDispatcher("MusicMod.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	public Page quye(HttpServletRequest request,HttpServletResponse response,String tablename,int currentPage,int pagesize) throws ServletException, IOException {
		int totalCount=Query.getPageCount(tablename);
		int count=-1;
		if(totalCount%pagesize>0)
			count=count/pagesize+1;
		else
			count=count/pagesize;
		Page page=new Page(currentPage, pagesize, totalCount,count);
		return page;
	}
}
