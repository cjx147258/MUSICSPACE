package space.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import space.bean.Album;
import space.bean.Music_sheet;
import space.bean.Singer;
import space.service.getListByUserId;
import space.service.getSheetByUserId;


@WebServlet("/MyMusicServlet")
public class MyMusicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MyMusicServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置字符集编码
    	request.setCharacterEncoding("utf-8");
    	System.out.println("flag=");
		String label=request.getParameter("label");
		int aflag=Integer.parseInt(label);
		
//       int aflag=2;
		System.out.println("flag="+aflag);
		if(aflag==0) {//显示收藏歌单
			ShowlikeSheet(request, response);
//			return aflag;
		}
		if(aflag==1) {//显示收藏专辑
			ShowlikeAlbum(request,response);
//			return aflag;
		}
		if(aflag==2) {//显示关注歌手
			ShowlikeSinger(request,response);
			
		}
	}

	//显示收藏歌单	
	protected void ShowlikeSheet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
//		String	uid=request.getParameter("1");
		int flag=0;
		List<Music_sheet> list = getSheetByUserId.SortById("1");
		request.setAttribute("slist", list);
		request.setAttribute("flag", flag);
		
		System.out.println("flag="+flag);
		System.out.println("list="+list);
		response.setContentType("text/html;charset=UTF-8");
		request.getRequestDispatcher("likeInfo.jsp").forward(request, response);
	}
	//显示收藏专辑
	protected void ShowlikeAlbum(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
//		String uid=request.getParameter("uid");
		int flag=1;
		String uid="1";
		System.out.println(uid);
		List<Album> list = getListByUserId.getAlbumById(uid);
		System.out.println("list="+list);
		request.setAttribute("slist", list);
		request.setAttribute("flag", flag);
		response.setContentType("text/html;charset=UTF-8");
		request.getRequestDispatcher("likeInfo.jsp").forward(request, response);
		
	}
	
	//显示关注歌手
	protected void ShowlikeSinger(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
//		String uid=request.getParameter("uid");
		int flag=2;
		System.out.println("flag="+flag);
		
		List<Singer> list = getListByUserId.getSingerById("1");
		System.out.println("list="+list);
		
		request.setAttribute("slist", list);
		request.setAttribute("flag", flag);
		
		response.setContentType("text/html;charset=UTF-8");
		request.getRequestDispatcher("likeInfo.jsp").forward(request, response);
	}

}
