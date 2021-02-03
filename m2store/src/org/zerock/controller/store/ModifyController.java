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
// * Servlet implementation class ModifyController
// */
//@WebServlet("/store/modify")
//public class ModifyController extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//	private StoreDAO storeDAO;
//       
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public ModifyController() {
//        super();
//        storeDAO = new StoreDAO();
//    }
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		try {
//			Long sno = Long.parseLong(request.getParameter("sno"));
//			
//			Store store = storeDAO.selectOne(sno);
//			request.setAttribute("store", store);
//			request.getRequestDispatcher("/WEB-INF/store/modify.jsp")
//			.forward(request, response);
//			
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//	
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//	
//		
//		
//		Long sno = Long.parseLong(request.getParameter("sno"));
//		String name = request.getParameter("name");
//		double lat = Double.parseDouble(request.getParameter("lat"));
//		double lng = Double.parseDouble(request.getParameter("lng"));
//		String menu = request.getParameter("menu");
//
//		
//			Store store = Store.builder()
//					.name(name)
//					.lat(lat)
//					.lng(lng)
//					.menu(menu)
//					.build();
//		
//			StoreDAO dao = new StoreDAO();
//			try {
//			dao.update(store);
//			
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//			response.sendRedirect("/store/view?sno="+sno);
//	}
//
//}