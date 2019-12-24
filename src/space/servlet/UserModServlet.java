package space.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import space.bean.Music;
import space.bean.Page;
import space.bean.User;
import space.dao.MusicDao;
import space.dao.tools.Query;
import space.service.del_item;
import space.service.update_item;
import space.util.DBUtil;


@WebServlet("/UserModServlet")
public class UserModServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String flag=request.getParameter("flag");
		if("search".equals(flag)) {			//如果是查询所有用户请求
			doPost(request,response);
		}
		if("delete".equals(flag)) {			//如果是删除操作
			delUser(request, response);		//调用删除的功能
		}
		if("update".equals(flag)) {	//更新用户信息	
			updateUser(request,response);
		}
		if("userByPage".equals(flag)) {			//分页获取用户信息
			getUsersByPage(request,response);
		}
	}

	
	//分页获取用户信息
		public void getUsersByPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			String tablename="user";
			int currentPage=Integer.parseInt(request.getParameter("currentPage"));
			System.out.println(currentPage);
			int pagesize=5;
			int start=0;
			
			
			if(currentPage<1) {
				currentPage=1;
				start=1;
			}else {
				start=(currentPage-1)*pagesize+1;
			}
			request.setAttribute("currentpage", currentPage);
			System.out.println(start);
			ResultSet res=Query.getPage(tablename, start, pagesize);
			List<User> users=new ArrayList<User>();
			try {
				while(res.next()) {
					int id=res.getInt("id");
					String name=res.getString("name"); 
					String icon_url=res.getString("icon_url");
					String introduction=res.getString("introduction");
					String password=res.getString("password");
					String gender=res.getString("gender");
					users.add(new User(id,introduction,icon_url,name,gender,password));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("userList", users);
			request.getRequestDispatcher("UserMod.jsp").forward(request, response);
		}
		
		
		
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//查询所有用户的信息
			Connection conn=DBUtil.getConn();
			//准备sql语句
			String sql="select * from user";
			//执行sql
			ResultSet rs=DBUtil.executeQuery(sql, null);
			//遍历结果集，存放到用户对象集合中取
			List<User> users=new ArrayList<>();
			try {
				while(rs.next()) {
					int id=rs.getInt("id");
					String name=rs.getString("name");
					String password=rs.getString("password");
					String gender=rs.getString("gender");
					String introduction=rs.getString("introduction");
					String icon_url=rs.getString("icon_url");
					User user=new User(id,introduction,icon_url,name,gender, password);
					users.add(user);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("userList", users);
			request.getRequestDispatcher("UserMod.jsp").forward(request, response);
		
		}

		/**
		 * 删除用户信息
		 * @param request
		 * @param response
		 * @throws IOException 
		 * @throws ServletException 
		 */
		public void delUser(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
			String id = request.getParameter("currentid");//接收用户id
			int userId=-1;
			if(id!=null&&!"".equals(id)) {
				userId=Integer.parseInt(id);				//把字符串转换成数字
			}
			int rs = del_item.delUser(userId);
			System.out.println(rs);
			
				
			request.getRequestDispatcher("UserMod.jsp").forward(request, response);
			
		}

		/**
		 * 通过用户id更新用户信息
		 * @param request
		 * @param response
		 * @throws ServletException
		 * @throws IOException
		 */
		public void updateUser(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
			String id = request.getParameter("currentid");
			System.out.println(id);
			int userId=-1;
			if(id!=null&&!"".equals(id)) {
				userId=Integer.parseInt(id);				//把字符串转换成数字
			}
			String name=request.getParameter("name");
			String introduction=request.getParameter("introduction");
			String icon_url=request.getParameter("image1");
			String password=request.getParameter("password");	
			String gender = request.getParameter("gender");
			User user = new User(userId, introduction, icon_url, name, gender,password);
			System.out.println(user);
			int rs = update_item.updateUser(user, userId);
			if(rs==0) {
				request.getRequestDispatcher("UserMod.jsp").forward(request, response);
			}
			
			
		}
		
		

}
