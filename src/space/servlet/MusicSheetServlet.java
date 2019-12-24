package space.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import space.bean.Music_sheet;
import space.dao.Music_sheetDao;
import space.service.getSheetRankByHeat;

/**
 * Servlet implementation class MusicSheetServlet
 */
@WebServlet("/MusicSheetServlet")
public class MusicSheetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public MusicSheetServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		List<Music_sheet> list=new ArrayList<>();
		list=getSheetRankByHeat.SortByHeat();
		System.out.println(list);
		request.setAttribute("musicsheet",list);
		request.getRequestDispatcher("musicsheet.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
