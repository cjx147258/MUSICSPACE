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
import space.bean.Music_sheet;
import space.bean.Singer;
import space.dao.MusicDao;
import space.service.getMusicRank;
import space.service.getSheetRankByHeat;
import space.service.getSinger;

/**
 * Servlet implementation class indexServlet
 */
@WebServlet("/indexServlet")
public class indexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public indexServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

    	//response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
//		
//		//按这热度排序音乐
		List<Music> list=new ArrayList<Music>();
		List<Music> L=new ArrayList<Music>();
//		MusicDao dao=new MusicDao();
		L = getMusicRank.SortByHeat();
		for(int i = 0;i < 4;i++) {
			list.add(L.get(i));
		}
	
		
		//按热度排序歌单
		List<Music_sheet> list1=new ArrayList<Music_sheet>();
		List<Music_sheet> L1=new ArrayList<Music_sheet>();
//		MusicDao dao=new MusicDao();
		L1 = getSheetRankByHeat.SortByHeat();
		for(int i = 0;i < 12;i++) {
			list1.add(L1.get(i));
		}
		
		//按时间排序音乐
		List<Music> list2=new ArrayList<Music>();
		List<Music> L2=new ArrayList<Music>();
//		MusicDao dao=new MusicDao();
		L2 = getMusicRank.SortByTime();
		for(int i = 0;i < 12;i++) {
			list2.add(L2.get(i));
		}
		
		List<Music> list3=new ArrayList<Music>();
		List<Music> L3=new ArrayList<Music>();
//			?MusicDao dao=new MusicDao();
		L3 = getMusicRank.SortByTimeAStyle(2);
		System.out.println(L3);
		for(int i = 0;i < 4;i++) {
			list3.add(L3.get(i));
		}
		
		List<Music> list4=new ArrayList<Music>();
		List<Music> L4=new ArrayList<Music>();
			MusicDao dao=new MusicDao();
		L4 = getMusicRank.SortByTimeAStyle(1);
		System.out.println(L4.size());
		for(int i = 0;i < 4;i++) {
			list4.add(L4.get(i));
		}
		
		List<Music> list5=new ArrayList<Music>();
		List<Music> L5=new ArrayList<Music>();
//			?MusicDao dao=new MusicDao();
		L5 = getMusicRank.SortByTimeAStyle(7);
		for(int i = 0;i < 4;i++) {
			list5.add(L5.get(i));
		}
		
		List<Music> list6=new ArrayList<Music>();
		List<Music> L6=new ArrayList<Music>();
//			?MusicDao dao=new MusicDao();
		L6 = getMusicRank.SortByHeatAStyle(2);
		for(int i = 0;i < 4;i++) {
			list6.add(L6.get(i));
		}
		
		List<Music> list7=new ArrayList<Music>();
		List<Music> L7=new ArrayList<Music>();
////			?MusicDao dao=new MusicDao();
		L7 = getMusicRank.SortByHeatAStyle(1);
		for(int i = 0;i < 4;i++) {
			list7.add(L7.get(i));
		}
		
		List<Music> list8=new ArrayList<Music>();
		List<Music> L8=new ArrayList<Music>();
//			?MusicDao dao=new MusicDao();
		L8 = getMusicRank.SortByHeatAStyle(7);
		for(int i = 0;i < 4;i++) {
			list8.add(L8.get(i));
		}
		
		List<Singer> list9=new ArrayList<Singer>();
		List<Singer> L9=new ArrayList<Singer>();
//		MusicDao dao=new MusicDao();
		L9 = getSinger.getSingers();
		for(int i = 0;i < 8;i++) {
			list9.add(L9.get(i));
		}
		
		request.setAttribute("MusicList", list);
		request.setAttribute("MusicSheetList", list1);
		request.setAttribute("NewMusicList", list2);
		
		request.setAttribute("OMusicList", list3);
		request.setAttribute("HMusicList", list4);
		request.setAttribute("RMusicList", list5);
		request.setAttribute("HOMusicList", list6);
		request.setAttribute("HHMusicList", list7);
		request.setAttribute("HRMusicList", list8);
		request.setAttribute("SingerList", list9);
		
//		request.setAttribute("userid", );
		response.setContentType("text/html;charset=UTF-8");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
