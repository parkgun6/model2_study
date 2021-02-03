package org.zerock.controller.store;



import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.zerock.dao.ReviewDAO;
import org.zerock.dao.StoreDAO;
import org.zerock.domain.Store;
import org.zerock.dto.Review;

/**
 * Servlet implementation class SampleController
 */
@WebServlet("/store/*")
public class SampleController extends MultiController {
	private static final long serialVersionUID = 1L;
	StoreDAO storeDAO;
	ReviewDAO reviewDAO;
	
	/**
	 * @see MultiController#MultiController()
	 */
	public SampleController() {
		super();
		storeDAO = new StoreDAO();
		reviewDAO = new ReviewDAO();
	}

	public String listGET(HttpServletRequest request, HttpServletResponse response) throws Exception {

		request.setAttribute("stores", storeDAO.selectAll());
		
		return "store/list";
	}

	public String viewGET(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Long sno = Long.parseLong(request.getParameter("sno"));
		
		Store store = storeDAO.selectOne(sno);	
		List<Review> list = reviewDAO.selectAll(sno);
		
		request.setAttribute("reviews", list);
		request.setAttribute("store", store);
		return "store/view";
	}

	public String registerGET(HttpServletRequest request, HttpServletResponse response) {
		return "store/register";
	}

	public String registerPOST(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String name = request.getParameter("name");
		double lat = Double.parseDouble(request.getParameter("lat"));
		double lng = Double.parseDouble(request.getParameter("lng"));
		String menu = request.getParameter("menu");

		Store store = Store.builder().name(name).lat(lat).lng(lng).menu(menu).build();

		storeDAO.insert(store);
		return "re:/store/list";
	}

	public String modifyGET(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Long sno = Long.parseLong(request.getParameter("sno"));

		Store store = storeDAO.selectOne(sno);
		request.setAttribute("store", store);
		return "store/modify";
	}

	public String modifyPOST(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Long sno = Long.parseLong(request.getParameter("sno"));
		String name = request.getParameter("name");
		double lat = Double.parseDouble(request.getParameter("lat"));
		double lng = Double.parseDouble(request.getParameter("lng"));
		String menu = request.getParameter("menu");
		Store store = Store.builder().sno(sno).name(name).lat(lat).lng(lng).menu(menu).build();
		
		storeDAO.update(store);
		
		return "re:/store/view?sno="+sno;
	}

	public String removePOST(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Long sno = Long.parseLong(request.getParameter("sno"));		
		storeDAO.delete(sno);


		return "re:/store/list";
	}
}
