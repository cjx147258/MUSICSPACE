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

import space.bean.Page;
import space.bean.Singer;
import space.dao.SingerDao;
import space.dao.Query;
import space.service.del_item;
import space.service.update_item;


/**
 * Servlet implementation class SingerModServlet
 */
@WebServlet("/SingerModServlet")
public class SingerModServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
  
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		
		String flag=request.getParameter("flag");
        System.out.println(flag);
		if("del".equals(flag)) {			//如果是删除操作
			delsinger(request, response);		//调用删除的功能
		}
		if("ud".equals(flag)) {
			updatesinger(request,response);
		}
		if("search".equals(flag)) {
			searchsinger(request,response);
		}
		if("bypage".equals(flag)) {
			getStusByPage(request,response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("utf-8");
		
		String flag=request.getParameter("flag");
        System.out.println(flag);
		if("del".equals(flag)) {			//如果是删除操作
			delsinger(request, response);		//调用删除的功能
		}
		if("ud".equals(flag)) {
			updatesinger(request,response);
		}
		if("search".equals(flag)) {
			searchsinger(request,response);
		}
		if("bypage".equals(flag)) {
			getStusByPage(request,response);
		}
		
	}
	public void delsinger(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String id=request.getParameter("id");	
		 //接收歌手id
		int Id=-1;
		if(id!=null&&!"".equals(id)) {
			Id=Integer.parseInt(id);				//把字符串转换成数字
		}
	     
		del_item.delSinger(Id);
		
	
			request.getRequestDispatcher("SingerMod.jsp").forward(request, response);
		}
	public void updatesinger(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		
		request.setCharacterEncoding("utf-8");
		
		String id=request.getParameter("Id");
		
		String name=request.getParameter("title");//接收歌手name
		String img_url=request.getParameter("img");
		String s_info=request.getParameter("note");
       
		int Id=-1;
		if(id!=null&&!"".equals(id)) {
			Id=Integer.parseInt(id);				//把字符串转换成数字
		}
		Singer singer=new Singer(Id,name, img_url,s_info);
		 System.out.println(id);
		update_item.updateSinger(singer, Id);
//		String msg="";
//		if(result>0) {
//			msg="恭喜您，修改成功！";
//		}else {
//			msg="对不起，修改失败!";
//		}
//		request.setAttribute("msg", msg);
		request.getRequestDispatcher("SingerMod.jsp").forward(request, response);
		
	}
	public void searchsinger(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		
		request.setCharacterEncoding("utf-8");
		List<Singer> singerlist=new ArrayList<>();
		 singerlist=SingerDao.getAll();
		 request.setAttribute("singerList", singerlist);
		 
		 request.getRequestDispatcher("SingerMod.jsp").forward(request, response);
	   }
	

	public void getStusByPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int pageSize=5;			//每页固定显示5条
		int currentPage=0;
		String singer="singer";
		//获取当前页
		String current=request.getParameter("currentPage");
		if(current==null||"".equals(current)) {
			currentPage=1;
		}else {
			currentPage=Integer.parseInt(current);
		}
	System.out.println(currentPage);
		//对当前页做边界限制
		if(currentPage<1) {
			currentPage=1;
		}
		request.setAttribute("currentpage", currentPage);
		
		int current2=(currentPage-1)*pageSize+1;
		
		//修改完当前页之后，要给singer对象重新赋值
		List<Singer> singerlist=new ArrayList<>();
		 ResultSet rs=Query.getPage(singer,current2, pageSize);
		 try {
				while(rs.next()) {
					int id=rs.getInt("id");							// 歌手id
					String img_url=rs.getString("img_url"); 				// 头像地址
					String name=rs.getString("name"); 					// 用户名
					String s_info=rs.getString("s_info");               //歌手详情
					Singer singer2=new Singer(id, name,img_url,s_info);
					singerlist.add(singer2);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 request.setAttribute("singerList", singerlist);
		 System.out.println(singerlist);
		 request.getRequestDispatcher("SingerMod.jsp").forward(request, response);
	}
	
		
	}


