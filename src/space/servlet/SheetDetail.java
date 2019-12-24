package space.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import space.bean.*;
import space.dao.*;
import space.service.*;


/**
 * Servlet implementation class Music_SheetxServlet
 */
@WebServlet("/SheetDetail")
public class SheetDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SheetDetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void open(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		request.setCharacterEncoding("UTF-8");
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		int id1=Integer.parseInt(request.getParameter("msid"));
		
		
		
		int id2=1;
		String t = (String) request.getSession().getAttribute("user_id");
		if(t!=null) {
			id2=Integer.parseInt(t);
		}
	
		Music_sheet music_sheet=(Music_sheet) Music_sheetDao.getItem(id1);
		User user=(User)UserDao.getItem(id2);
		User owner=(User) UserDao.getItem(music_sheet.getOwner_id());
		List<Music> list=Music_MusicSheet.SearchsongsByMusicsheet(id1);
		
		@SuppressWarnings("unchecked")
		List<Style_sheet> sslist=(List<Style_sheet>) style_sheetDao.getItem(id1);
		List<Content> cclist=getCommentAndUserBy.contentAndUserBySheet(id1);
		
		System.out.println(user);
		
		request.setAttribute("auser", user);
		request.setAttribute("style_sheet", sslist);
//		System.out.println(music_sheet);	
		request.setAttribute("acontent",cclist );
		request.setAttribute("amusic_sheet", music_sheet);
		request.setAttribute("owner", owner);
		request.setAttribute("amusic", list);
		
		response.setContentType("text/html;charset=UTF-8");//写在最后
		request.getRequestDispatcher("music_sheetdetail.jsp").forward(request, response);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		int flag=Integer.parseInt(request.getParameter("flag"));
		if(flag==1) {
			open(request,response);
		}
		else {

			int msid=Integer.parseInt(request.getParameter("msid"));
			
			int uid=1;
			if(request.getSession().getAttribute("user_id")!=null) {

				uid=Integer.parseInt((String) request.getSession().getAttribute("user_id"));
			}
			
			request.setAttribute("msid", msid);
			request.setAttribute("uid", uid);
			response.setContentType("text/html;charset=UTF-8");//写在最后
			request.getRequestDispatcher("music_sheethead.jsp").forward(request, response);
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
