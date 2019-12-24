package space.servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import space.bean.Album;

import space.dao.AlbumDao;
import space.dao.Query;

import space.service.del_item;
import space.service.update_item;

/**
 * Servlet implementation class AlbumAddServlet
 */
@WebServlet("/AlbumModServlet")
public class AlbumModServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String flag=request.getParameter("flag");
        System.out.println(flag);
		if("del".equals(flag)) {			//如果是删除操作
			Del(request, response);		//调用删除的功能
		}
		if("update".equals(flag)) {
			Update(request,response);
		}
		if("search".equals(flag)) {
			GetAlbum(request,response);
		}
		if("bypage".equals(flag)) {
			GetByPage(request,response);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置请求字符集
		request.setCharacterEncoding("utf-8");
			
			String flag=request.getParameter("flag");
	        System.out.println(flag);
			if("del".equals(flag)) {			//如果是删除操作
				Del(request, response);		//调用删除的功能
			}
			if("update".equals(flag)) {
				Update(request,response);
			}
			if("search".equals(flag)) {
				GetAlbum(request,response);
			}
			if("bypage".equals(flag)) {
				GetByPage(request,response);
			}
					
			
	}
	protected void GetAlbum(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		List<Album> albumlist=new ArrayList<>();
		albumlist=(List<Album>) AlbumDao.getAll();
		System.out.println(albumlist);
		request.setAttribute("albumList", albumlist);
		request.getRequestDispatcher("AlbumMod.jsp").forward(request, response);
	 }

		
	
	protected void Update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置请求字符集
				request.setCharacterEncoding("utf-8");
				//接收参数
				
				int singer_id=Integer.parseInt(request.getParameter("singer_id"));
				String name = request.getParameter("name");
				SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss");
				String idd=request.getParameter("Id");
				//id=Integer.parseInt(request.getParameter("Idd"));System.out.println(id);
				int id;
				if(idd==null||"".equals(idd)) {
					id=102;
				}else {
					id=Integer.parseInt(idd);
				}
				Date issue_time=null;
				try {
					issue_time=formatter.parse(request.getParameter("update_time"));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//	String img=request.getParameter("img");
				String img="test";
				String info=request.getParameter("info");
				String singer_name = request.getParameter("singer_name");
				//System.out.println("singer_name");
				
				Album album = new Album(id,name, singer_id, singer_name, issue_time, img, info);
				update_item.updateAlbum(album, 0);
				System.out.println(id);
				request.getRequestDispatcher("AlbumMod.jsp").forward(request, response);
			
	}
	protected void Del(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idd=request.getParameter("id");
		int id;
		if(idd==null||"".equals(idd)) {
			id=102;
		}else {
			id=Integer.parseInt(idd);
		}
		int result=del_item.delAlbum(id);
		System.out.println(result);
		if(result==0)
			System.out.println("删除成功");
		else
			System.out.println("删除失败");
		
		request.getRequestDispatcher("AlbumMod.jsp").forward(request, response);
	}
	
protected void GetByPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		String tablename="album";
		int currentPage=Integer.parseInt(request.getParameter("currentPage"));
		if(currentPage < 1)
		{
			currentPage = 1;
		}
		request.setAttribute("currentpage", currentPage);
		int pagesize=5;
		int number = (currentPage-1)*pagesize+1;
		ResultSet res=Query.getPage(tablename, number, pagesize);
		
		List<Album> albums=new ArrayList<>();
		try {
			while(res.next()) {
				int id=res.getInt("id");
				int singer_id=res.getInt("singer_id");
				String name=res.getString("name");
				Date issue_time=res.getDate("update_time");
				String img=res.getString("cover_url");
				String info=res.getString("info");
				String singer_name=res.getString("singer_name");
				Album album=new Album(id,name, singer_id, singer_name, issue_time, img, info);
				albums.add(album);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		request.setAttribute("albumList", albums);
		
		request.getRequestDispatcher("AlbumMod.jsp").forward(request, response);
		
	}
	

}


