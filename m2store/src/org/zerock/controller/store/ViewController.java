//package org.zerock.controller.store;
//
//import java.io.IOException;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.zerock.dao.StoreDAO;
//import org.zerock.domain.Store;
//
///**
// * Servlet implementation class ViewController
// */
//@WebServlet("/store/view")
//public class ViewController extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//    
//	private StoreDAO storeDAO;
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public ViewController() {
//        super();
//        storeDAO = new StoreDAO();
//    }
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//		try {
//			Long sno = Long.parseLong(request.getParameter("sno"));
//			Store store = storeDAO.selectOne(sno);
//			
//			request.setAttribute("store", store);
//			
//			RequestDispatcher dispatcher
//			= request.getRequestDispatcher("/WEB-INF/store/view.jsp");
//			
//			
//			dispatcher.forward(request, response);
//			
//		}catch(Exception e) {
//			e.printStackTrace();
//			response.sendRedirect("/error");
//		}
//		
//	}
//
//}









