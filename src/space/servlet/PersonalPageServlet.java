package space.servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import space.bean.Music_sheet;
import space.bean.User;
import space.dao.UserDao;
import space.service.*;
import space.util.DBUtil;
/**
 * Servlet implementation class MusicSheetServlet
 */
@WebServlet("/PersonalPageServlet")
public class PersonalPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersonalPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void openself(HttpServletRequest request, HttpServletResponse response,int user_id) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	response.setCharacterEncoding("UTF-8");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		List<Music_sheet> list=getSheetByUserId.SortById(""+user_id);
//		System.out.println(list);
		
		User u=(User) UserDao.getItem(user_id);
		request.setAttribute("sheetlist", list);
		request.setAttribute("user", u);
//		request.setAttribute("title", "音乐列表");
		request.getRequestDispatcher("PersonalPage.jsp").forward(request, response);
	}
    protected void openother(HttpServletRequest request, HttpServletResponse response,int tid) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	response.setCharacterEncoding("UTF-8");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		List<Music_sheet> list=getSheetByUserId.SortById(""+tid);
		System.out.println(list);
		User u=(User) UserDao.getItem(tid);
		request.setAttribute("sheetlist", list);
		request.setAttribute("user", u);
//		request.setAttribute("title", "音乐列表");
		request.getRequestDispatcher("otherPage.jsp").forward(request, response);
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//    	response.setCharacterEncoding("UTF-8");
//		if(request.getParameter("out")!=null) {
//			request.getSession().setAttribute("user_id", null);
//			System.out.print("out");
//			request.getRequestDispatcher("indexServlet").forward(request, response);
//			return;
//		}
//		String sd=  (String) request.getAttribute("other");
//		if(sd==null) {
//			if(request.getSession().getAttribute("user_id")==null) {
//				request.getRequestDispatcher("login.jsp").forward(request, response);
//			}
//			else {
//				String t= (String) request.getSession().getAttribute("user_id");
//				int user_id = Integer.parseInt(t);
//				openself(request, response,user_id);
//			}
//		}
//		else {
//			if(request.getSession().getAttribute("user_id")==null) {
//				String t= (String) sd;
//				int tid = Integer.parseInt(t);
//				openother(request,response,tid);
//			}
//			else {
//				String tt= (String) request.getParameter("user_id");
//				int other_id = Integer.parseInt(tt);
//				String t= (String) request.getSession().getAttribute("user_id");
//				int user_id = Integer.parseInt(t);
//				if(other_id==user_id) {
//					openself(request, response,user_id);
//				}
//				else {
//					openother(request, response,other_id);
//				}
//			}
//		}
			doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	response.setCharacterEncoding("UTF-8");
		if(request.getParameter("out")!=null) {
			request.getSession().setAttribute("user_id", null);
			System.out.print("out");
			request.getRequestDispatcher("index.jsp").forward(request, response);
			return;
		}
		String sd=  (String) request.getAttribute("other");
		System.out.print(sd);
		if(sd==null) {
			if(request.getSession().getAttribute("user_id")==null) {
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
			else {
				String t= (String) request.getSession().getAttribute("user_id");
				int user_id = Integer.parseInt(t);
				openself(request, response,user_id);
			}
		}
		else {
			if(request.getSession().getAttribute("user_id")==null) {
				String t= (String) sd;
				int tid = Integer.parseInt(t);
				openother(request,response,tid);
			}
			else {
				String tt= (String) request.getParameter("user_id");
				int other_id = Integer.parseInt(tt);
				String t= (String) request.getSession().getAttribute("user_id");
				int user_id = Integer.parseInt(t);
				if(other_id==user_id) {
					openself(request, response,user_id);
				}
				else {
					openother(request, response,other_id);
				}
			}
		}
	}

}
