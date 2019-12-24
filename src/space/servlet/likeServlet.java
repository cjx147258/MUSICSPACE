package space.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import space.service.add_link;

@WebServlet("/likeServlet")
public class likeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public likeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置字符集编码
    	doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置字符集编码
    	request.setCharacterEncoding("utf-8");
    	System.out.println("likeseaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaarvletflag");
		String flag=request.getParameter("flag");
		int aflag=Integer.parseInt(flag);
		System.out.println("likeseaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaarvletflag"+aflag);
		if(aflag==0) {//收藏歌单
			likeSheet(request, response);
		}
		if(aflag==1) {//收藏专辑
			likeAlbum(request,response);
		}
		if(aflag==2) {//关注歌手
			likeSinger(request,response);
		}
		if(aflag==3) {
			sheetGetMusic(request,response);
		}
	}


	//收藏歌单
	protected void likeSheet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int uid=Integer.parseInt(request.getParameter("uid"));
		int itemId=Integer.parseInt(request.getParameter("itemId"));
		
		add_link.user_sheet(uid, itemId);
	}
	
	//收藏专辑
	protected void likeAlbum(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int uid=Integer.parseInt(request.getParameter("uid"));
		int itemId=Integer.parseInt(request.getParameter("itemId"));
		
		add_link.user_album(uid, itemId);
		
	}
	
	//关注歌手
	protected void likeSinger(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int uid=Integer.parseInt(request.getParameter("uid"));
		int itemId=Integer.parseInt(request.getParameter("itemId"));
		add_link.user_singer(uid, itemId);
	}
	protected void sheetGetMusic(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int sheetId=Integer.parseInt(request.getParameter("sheetId"));
		int itemId=Integer.parseInt(request.getParameter("itemId"));
		add_link.music_sheet(sheetId, itemId);
	}
}
