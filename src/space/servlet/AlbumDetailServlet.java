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
import space.bean.Music_sheet;
import space.bean.Singer;
import space.dao.AlbumDao;
import space.dao.SingerDao;
import space.service.*;
/**
 * Servlet implementation class MusicSheetServlet
 */
@WebServlet("/AlbumDetailServlet")
public class AlbumDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlbumDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void open(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	//根据专辑ID获取专辑的详情信息
		//System.out.println(id);
		int aid=Integer.parseInt(request.getParameter("album_id"));
		Album album = AlbumDao.getItem(aid);
		response.setContentType("text/html;charset=UTF-8");//写在最后
		request.setAttribute("Album",album);
		
		//根据专辑ID获取专辑里面的歌曲列表
		List<Music> list = getListBy.MusicByAlbumID(aid);
		request.setAttribute("MusicList", list);
		//System.out.println(list);
		request.getRequestDispatcher("albumDetail.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

				request.setCharacterEncoding("UTF-8");
				response.setCharacterEncoding("UTF-8");

				//获取传入servlet的专辑id值
				int flag=Integer.parseInt(request.getParameter("flag"));
				if(flag==0) {
//					int aid=Integer.parseInt(request.getParameter("album_id"));
					int aid=Integer.parseInt(request.getParameter("album_id"));
					request.setAttribute("album_id", aid);

					request.getRequestDispatcher("album_cope.jsp").forward(request, response);
				}
				else {
					open(request,response);
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
