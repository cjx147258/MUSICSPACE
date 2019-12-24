package space.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import space.bean.Content;
import space.bean.Music;
import space.bean.Music_sheet;
import space.bean.User;
import space.dao.CommendDao;
import space.dao.MusicDao;
import space.dao.UserDao;
import space.service.getCommentAndUserBy;
import space.service.getListBy;
import space.service.getSheetByMusic;

@WebServlet("/MusicInfoServlet")
public class MusicInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MusicInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void open(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		int mid=Integer.parseInt(request.getParameter("mid"));

		request.setAttribute("mid", mid);
		response.setContentType("text/html;charset=UTF-8");
		request.getRequestDispatcher("songInfo.jsp").forward(request, response);
	
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		if(request.getParameter("comment")!=null) {
			comment(request,response);
			return;
		}
		int flag=Integer.parseInt(request.getParameter("flag"));
		if(flag==1) {
			open(request,response);
		}
		else {
			//得到传的参数
			
			String mid=request.getParameter("mid");
			//强制类型转换
			int mid1=Integer.parseInt(mid);
			int uid1=1;
//			int uid1=Integer.parseInt(uid);
			String t = (String) request.getSession().getAttribute("user_id");
			if(t!=null) {
				uid1=Integer.parseInt(t);
				List<Music_sheet> msl=getListBy.Music_sheetByOwnerID(uid1);
				request.setAttribute("sheet_list", msl);
			}
			//建立需要的空对象
			Music music=new Music();
			User user=new User();
			List<Content> contents=new ArrayList<>();
			List<Music_sheet> sheet=new ArrayList<>();
			//调用查询函数
			music=(Music) MusicDao.getItem(mid1);//得到音乐对象
			user=(User) UserDao.getItem(uid1);//得到用户对象
			sheet=getSheetByMusic.music_sheetByMusic(mid1);//得到收藏此歌曲的歌单
			contents=getCommentAndUserBy.contentAndUserByMusic(70);//得到歌曲对应评论
			//测试
			System.out.println(music);
			System.out.println(user);
			System.out.println(contents);
			System.out.println(sheet);
			//传值
			request.setAttribute("amusic", music);
			request.setAttribute("auser", user);
			request.setAttribute("acontent", contents);
			request.setAttribute("asheet", sheet);
			//响应请求返回页面
			response.setContentType("text/html;charset=UTF-8");
			request.getRequestDispatcher("musicinfo_body.jsp").forward(request, response);
		}
		
	}
	protected void comment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int uid=Integer.parseInt((String) request.getAttribute("user_id"));
		int mid=Integer.parseInt((String) request.getAttribute("music_id"));
		String content=(String) request.getAttribute("com");
		CommendDao.addContent(uid, mid, 1, content);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if( request.getAttribute("t")!=null){
			comment(request,response);
		}
	}

}
