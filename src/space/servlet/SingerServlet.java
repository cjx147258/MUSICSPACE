package space.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import space.bean.Music;
import space.bean.Singer;
import space.dao.MusicDao;
import space.dao.SingerDao;
import space.service.Singer_label;

/**
 * Servlet implementation class SingerServlet
 */
@WebServlet("/SingerServlet")
public class SingerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public SingerServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("UTF-8");

		String label=request.getParameter("label");
		int alabel=3;
		if(label!=null) {
			alabel=Integer.parseInt(label);
		}
			
		System.out.println(label);
		List<Singer> list = new ArrayList<>();
		list = Singer_label.SearchsingerByLabel(alabel);
		System.out.println(list);
		
		request.setAttribute("slist", list);
		response.setContentType("text/html;charset=UTF-8");
		request.getRequestDispatcher("singers.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
