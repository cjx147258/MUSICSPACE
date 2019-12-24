package space.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import space.bean.Music;
import space.dao.MusicDao;
import space.service.del_item;
import space.service.update_item;

/**
 * Servlet implementation class MusicAddServlet
 */
@WebServlet("/MusicAddServlet")
public class MusicAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public MusicAddServlet() {
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		System.out.println("bbbbss");
		String flag=request.getParameter("flag");
		if("add".equals(flag)) {
			String name=request.getParameter("name");
			System.out.println(name);
			int heat=Integer.parseInt(request.getParameter("heat"));
			int album_id=Integer.parseInt(request.getParameter("album_id"));
			String album_name=request.getParameter("album_name");
			String music_url=request.getParameter("music_url");
		//	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date update_time=new Date();
		//	try {
		//		update_time=sdf.parse(update_time);
		//	} catch (ParseException e) {
		//		// TODO Auto-generated catch block
		//		e.printStackTrace();
		//	}
			int singer_id=Integer.parseInt(request.getParameter("singer_id"));
			String singer_name=request.getParameter("singer_name");
			String time=request.getParameter("time");
			String img=request.getParameter("img");
		//	Object[] objs= {};
			MusicDao.addMusic(heat,name,music_url, singer_id, album_id, album_name,time,update_time, singer_name,img);
			request.getRequestDispatcher("MusicMod.jsp").forward(request, response);
			}
		else if("mod".equals(flag)) {
			
			String name=request.getParameter("name");
			int heat=Integer.parseInt(request.getParameter("heat"));
			int album_id=Integer.parseInt(request.getParameter("album_id"));
			String album_name=request.getParameter("album_name");
			String music_url=request.getParameter("music_url");
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String idd=request.getParameter("Id");
			//id=Integer.parseInt(request.getParameter("Idd"));System.out.println(id);
			int id;
			if(idd==null||"".equals(idd)) {
				id=1;
			}else {
				id=Integer.parseInt(idd);
			}
			System.out.println(flag);
			Date update_time=null;
			try {
				update_time=sdf.parse(request.getParameter("update_time"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int singer_id=Integer.parseInt(request.getParameter("singer_id"));
			String singer_name=request.getParameter("singer_name");
			String time=request.getParameter("time");
			String img=request.getParameter("img");
			Music music=new Music(heat,  id,  name,  music_url,  singer_id,  album_id,
					 album_name,  time,  update_time,  singer_name, img);
			update_item.updateMusic(music, 0);
			request.getRequestDispatcher("MusicMod.jsp").forward(request, response);
			//	
			
		}
		else if("del".equals(flag)) {
			String idd=request.getParameter("Id");
			//id=Integer.parseInt(request.getParameter("Idd"));System.out.println(id);
			int id;
			if(idd==null||"".equals(idd)) {
				id=1;
			}else {
				id=Integer.parseInt(idd);
			}
			int result=del_item.delMusic(id);
		//	System.out.println(result);
			if(result==0)
				System.out.println("删除成功");
			else
				System.out.println("删除失败");
			request.getRequestDispatcher("MusicMod.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	/*	request.setCharacterEncoding("utf-8");
		System.out.println("bbbbss");
		String flag=request.getParameter("flag");
		if("add".equals(flag)) {
			String name=request.getParameter("name");
			System.out.println(name);
			int heat=Integer.parseInt(request.getParameter("heat"));
			int album_id=Integer.parseInt(request.getParameter("album_id"));
			String album_name=request.getParameter("album_name");
			String music_url=request.getParameter("music_url");
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date update_time=null;
			try {
				update_time=sdf.parse(request.getParameter("update_time"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int singer_id=Integer.parseInt(request.getParameter("singer_id"));
			String singer_name=request.getParameter("singer_name");
			String time=request.getParameter("time");
			String img=request.getParameter("img");
		//	Object[] objs= {};
			MusicDao.addMusic(heat,name,music_url, singer_id, album_id, album_name,time,update_time, singer_name,img);
			}
		else if("mod".equals(flag)) {
		
			String name=request.getParameter("name");
			int heat=Integer.parseInt(request.getParameter("heat"));
			int album_id=Integer.parseInt(request.getParameter("album_id"));
			String album_name=request.getParameter("album_name");
			String music_url=request.getParameter("music_url");
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String idd=request.getParameter("Id");
			//id=Integer.parseInt(request.getParameter("Idd"));System.out.println(id);
			int id;
			if(idd==null||"".equals(idd)) {
				id=1;
			}else {
				id=Integer.parseInt(idd);
			}
			System.out.println(name);
			Date update_time=null;
			try {
				update_time=sdf.parse(request.getParameter("update_time"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int singer_id=Integer.parseInt(request.getParameter("singer_id"));
			String singer_name=request.getParameter("singer_name");
			String time=request.getParameter("time");
			String img=request.getParameter("img");
			Music music=new Music(heat,id,name,music_url,singer_id,album_id, album_name,time,update_time,singer_name,img);
			update_item.updateMusic(music, 0);
			//	System.out.println(id);
			
		}
		else if("del".equals(flag)) {
			String idd=request.getParameter("Id");
			//id=Integer.parseInt(request.getParameter("Idd"));System.out.println(id);
			int id;
			if(idd==null||"".equals(idd)) {
				id=1;
			}else {
				id=Integer.parseInt(idd);
			}
			int result=del_item.delMusic(id);
			if(result==1)
				System.out.println("删除成功");
			else
				System.out.println("删除失败");
			
		}*/
	}

}
