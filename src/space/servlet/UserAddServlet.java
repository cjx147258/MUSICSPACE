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



import space.service.add_item;

import space.service.regService;



@WebServlet("/UserAddServlet")
public class UserAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String flag=request.getParameter("flag");
		if("user".equals(flag)) {
			userAdd(request,response);
		}
		
		if("singer".equals(flag)) {
			singerAdd(request,response);
		}
		if("album".equals(flag)) {
			albumAdd(request,response);
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置请求字符集
		request.setCharacterEncoding("utf-8");
		String flag=request.getParameter("flag");
		if("user".equals(flag)) {
			userAdd(request,response);
		}
		
		if("singer".equals(flag)) {
			singerAdd(request,response);
		}
		if("album".equals(flag)) {
			albumAdd(request,response);
		}
		
		
	}
		protected void userAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//设置请求字符集
			request.setCharacterEncoding("utf-8");
			//接收参数
			String name=request.getParameter("name");
			String gender = request.getParameter("gender");
			String introduction = request.getParameter("introduction");
			String img=request.getParameter("img");
			String password=request.getParameter("password");
			int rs = regService.regUser(name, introduction, password, img, gender);
			if(rs>0) {
				request.setAttribute("msg", "恭喜您，注册用户成功");
				request.getRequestDispatcher("UserAdd.jsp").forward(request, response);
			}else {
				request.setAttribute("msg", "对不起，注册用户失败");
				request.getRequestDispatcher("UserAdd.jsp").forward(request, response);
			}
	}
		protected void albumAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//设置请求字符集
					request.setCharacterEncoding("utf-8");
					//接收参数
					int singer_id=Integer.parseInt(request.getParameter("singer_id"));
					String name = request.getParameter("name");
					SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss");
					Date issue_time=null;
					try {
						issue_time= sdf.parse(request.getParameter("update_time"));
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(issue_time);
					String img=request.getParameter("img");
					
					String info=request.getParameter("info");
					String singer_name = request.getParameter("singer_name");
					System.out.println("singer_name");
					int rs = add_item.insertAlbum(name, singer_id, singer_name, issue_time, img, info);
					if(rs>0) {
						request.setAttribute("msg", "恭喜您，专辑添加成功");
						request.getRequestDispatcher("UserAdd.jsp").forward(request, response);
					}else {
						request.setAttribute("msg", "对不起，专辑添加失败");
						request.getRequestDispatcher("AlbumAdd.jsp").forward(request, response);
					}
					
		}
		protected void singerAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			request.setCharacterEncoding("utf-8");
			String name=request.getParameter("title");//接收歌手name
			String img_url=request.getParameter("img");
			String s_info=request.getParameter("note");
			
			int result=add_item.insertSinger(name, img_url, s_info);
			
			System.out.println(result);
			
			
		     request.getRequestDispatcher("SingerAdd.jsp").forward(request, response);
			
			
		}
	
}
