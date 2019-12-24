package space.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import space.bean.Album;
import space.bean.Music;
import space.bean.Singer;
import space.dao.SingerDao;
import space.service.getListBy;

/**
 * Servlet implementation class SingerDetail
 */
@WebServlet("/SingerDetail")
public class SingerDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SingerDetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void info(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// TODO Auto-generated method stub
		
    			request.setCharacterEncoding("UTF-8");
    			response.setCharacterEncoding("UTF-8");

    			int id;
    			//获取传入servlet的歌手id值
    			id=Integer.parseInt(request.getParameter("id"));
    			//获取歌手详细信息
    			Singer singer = (Singer) SingerDao.getItem(id);
    			System.out.print(singer);
    			response.setContentType("text/html;charset=UTF-8");//写在最后
    			request.setAttribute("Singer_info", singer);
    			request.getRequestDispatcher("singer_info.jsp").forward(request, response);
	}
    protected void album(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// TODO Auto-generated method stub

    			request.setCharacterEncoding("UTF-8");
    			response.setCharacterEncoding("UTF-8");
    			
    			//获取传入servlet的歌手id值
    			int id=Integer.parseInt(request.getParameter("id"));

    			//获取歌手详细信息
    			Singer singer = (Singer) SingerDao.getItem(id);
    			response.setContentType("text/html;charset=UTF-8");//写在最后
    			request.setAttribute("Singer_album", singer);
    			//request.getRequestDispatcher("singer_song.jsp").forward(request, response);
    			
    			
    			List<Album> list = getListBy.AlbumsBySingerID(id);
    			request.setAttribute("AlbumList", list);
    			//System.out.println(list);
    			//request.setAttribute("title", "音乐列表");		
    			
    			request.getRequestDispatcher("singer_album.jsp").forward(request, response);	
//		request.getRequestDispatcher("singer_album.jsp").forward(request, response);
	}
    protected void song(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		//获取传入servlet的歌手id值
		int id=Integer.parseInt(request.getParameter("id"));

		//int id=request.getParameter("id");
		
		//List<Music> list=new ArrayList<Music>();
		//获取歌手详细信息
		Singer singer = (Singer) SingerDao.getItem(id);
		response.setContentType("text/html;charset=UTF-8");//写在最后
		request.setAttribute("Singer_song", singer);

		List<Music> list = getListBy.MusicBySingerID(id);
		request.setAttribute("MusicList", list);
		System.out.println(list);
		//request.setAttribute("title", "音乐列表");		
		request.getRequestDispatcher("singer_song.jsp").forward(request, response);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		int flag=Integer.parseInt(request.getParameter("flag"));
		if(flag==1) {
			info(request,response);
		}
		else if(flag==2) {
			album(request,response);
		}
		else if(flag==3) {
			song(request,response);
		}
		else if(flag==0) {

			int id=Integer.parseInt(request.getParameter("singer_id"));
			request.setAttribute("singer_id", id);

			request.getRequestDispatcher("singer_cope.jsp").forward(request, response);
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
