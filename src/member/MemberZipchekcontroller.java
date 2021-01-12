package member;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.CompositeDao;
import VO.PostVo;
import common.SuperClass;


public class MemberZipchekcontroller extends SuperClass{
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dong = request.getParameter("dong") ;
		List<PostVo> lists = null ;
		CompositeDao dao = new CompositeDao() ;
		
		if ( dong != null ) {
			lists = dao.SelectDataZipcode(dong) ;
			System.out.println( "검색된 동네 개수 : " + lists.size() );
		}		 
		request.setAttribute( "lists", lists );
		request.setAttribute( "dong", dong );
		
		String gotopage = "member/zipCheck.jsp" ;
		RequestDispatcher dispatcher
			= request.getRequestDispatcher( gotopage ) ;
		dispatcher.forward(request, response); 		
	}
	
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		this.doGet(request, response); 
	}
	
}

