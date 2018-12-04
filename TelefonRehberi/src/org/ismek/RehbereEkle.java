package org.ismek;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * Servlet implementation class RehbereEkle
 */
@WebServlet("/RehbereEkle")
public class RehbereEkle extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	List<Rehber> rehberList = null;
       
    /**
     * 
     * @see HttpServlet#HttpServlet()
     */
    public RehbereEkle() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    public void init() throws ServletException {
    	// TODO Auto-generated method stub
    	super.init();
    	rehberList = new ArrayList<>();
    }
    
    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Gson gson = new Gson();
		String rehberListAsJson = gson.toJson(rehberList);
		//response.setContentType("application/json");
		response.getWriter().write(rehberListAsJson);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String isim = request.getParameter("isim");
		String telefon = request.getParameter("telefon");
		Rehber rehber = new Rehber(isim, telefon);
		rehberList.add(rehber);
		String htmlTable = "<table>";
		for (Rehber rehber2 : rehberList) {
			htmlTable += "<tr><td>" + rehber2.getIsim() + "</td><td>" + rehber2.getTelefon() + "</td></tr>";
		}
		htmlTable += "</table>";
		response.getWriter().write("Kayıt Eklendi");
		response.getWriter().write(htmlTable);
		response.setContentType("text/html");
		request.getRequestDispatcher("rehber.html").include(request, response);
	}
}
