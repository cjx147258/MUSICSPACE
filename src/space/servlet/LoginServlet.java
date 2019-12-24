package space.servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import space.bean.User;
import space.util.DBUtil;
import space.dao.UserDao;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		System.out.println("登录");
		String id=request.getParameter("id");
		String pass=request.getParameter("pass");
		if(id==null||pass==null) {
			String message="请输入账户密码";
            request.setAttribute("message", message);
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		String[] field= {"id"};
		String[] value= {id};
		List<User> userlist=(List<User>) UserDao.getListLimited(field,value);
		System.out.println(userlist);
		if(userlist.size()==0) {

			String message="用户不存在";
            request.setAttribute("message", message);
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		else if(userlist.get(0).getPassword().equals(pass)) {
			String message="登录成功";
            request.setAttribute("message", message);
			request.getSession().setAttribute("user_id", id);
			if(Integer.parseInt(id)==0) {
				request.getRequestDispatcher("backindex.jsp").forward(request, response);
				return;
			}
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		else {
			String message="密码错误";
            request.setAttribute("message", message);
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

}
