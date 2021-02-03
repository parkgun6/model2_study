package store.controller;

import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.controller.MultiController;
import store.dao.StoreDAO;
import store.domain.Store;

@WebServlet("/store/*")
public class StoreController extends MultiController {
	
	private StoreDAO dao = new StoreDAO();
	
	public String listGET(HttpServletRequest req, 
			HttpServletResponse res)throws Exception{
		
		List<Store> stores = dao.getAll();
		
		req.setAttribute("stores", stores);
		
		return "store/list";
		
	}
	
	
}
