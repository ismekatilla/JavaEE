package org.ismek;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * Servlet implementation class ContollerServlet
 */
@WebServlet("/ContollerServlet")
public class ContollerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	List<Rehber> rehberList = new ArrayList<Rehber>();
	Gson gson = new Gson();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContollerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String metod = request.getParameter("method");
		switch (metod) {
		case "EKLE":
			ekle(request, response);
			break;
		case "GETIR":
			getir(request, response);
			break;
		default:
			break;
		}
	

	}
	
	private void ekle(HttpServletRequest request, HttpServletResponse response) throws IOException {
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
	
	private void getir(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String rehberListAsJson = gson.toJson(rehberList);
		response.getWriter().write(rehberListAsJson);
	}
}