package org.ismek;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * Servlet implementation class RehberIslem
 */
public class RehberIslem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	List<Rehber> rehberList = new ArrayList<Rehber>();
	Gson gson = new Gson();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RehberIslem() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	String rehberListAsJson = gson.toJson(rehberList);
    	resp.getWriter().write(rehberListAsJson);
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String isim = request.getParameter("isim");
		String tel = request.getParameter("tel");
		
		Rehber rehber = new Rehber();
		rehber.setId(new Long(rehberList.size() + 1));
		rehber.setIsim(isim);
		rehber.setTelefon(tel);
		rehberList.add(rehber);

		String rehberAsJson = gson.toJson(rehber);
		System.out.println(rehberAsJson);
		response.getWriter().write(rehberAsJson);
	}
}
