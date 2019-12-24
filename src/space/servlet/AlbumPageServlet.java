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
import space.service.getAlbumsbyStyle;


/**
 * Servlet implementation class AlbumPageServlet
 */
@WebServlet("/AlbumPageServlet")
public class AlbumPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AlbumPageServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		String style=request.getParameter("style");
		List<Album> list=getAlbumsbyStyle.getAlbumByStyle(style);
		System.out.println(list);
		request.setAttribute("Alist", list);
//		response.setContentType("text/html;charset=UTF-8");
		request.getRequestDispatcher("AlbumPage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
