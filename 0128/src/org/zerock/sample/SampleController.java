package org.zerock.sample;

import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.zerock.dao.StoreDAO;
import org.zerock.dao.TimeDAO;
import org.zerock.domain.Store;

/**
 * Servlet implementation class SampleController
 */
@WebServlet("/sample/*")
public class SampleController extends MultiController {
	private static final long serialVersionUID = 1L;
       
	private TimeDAO timeDAO;
	private StoreDAO storeDAO;
    /**
     * @see MultiController#MultiController()
     */
    public SampleController() {
        super();
        timeDAO = new TimeDAO();
        storeDAO = new StoreDAO();
    }

	public String listGET(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("list get method..................");
		
		String now = timeDAO.getNow();
		List<Store> storeList = storeDAO.getList();
		storeList.forEach(store -> System.out.println(store));
		System.out.println(now);
		
		return "sample/list";
	}
	
}














