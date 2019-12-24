package space.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import space.bean.Music_sheet;
import space.dao.SheetStyleDao;

/**
 * Servlet implementation class MusicStyleServlet
 */
@WebServlet("/MusicStyleServlet")
public class MusicStyleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public MusicStyleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String style=request.getParameter("style");
		List<Music_sheet> list=SheetStyleDao.getSheetByStyle(style);
		for(Music_sheet m:list) {
			System.out.println(m);
		}
		request.setAttribute("musicsheet",list);
		request.getRequestDispatcher("musicsheet.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
