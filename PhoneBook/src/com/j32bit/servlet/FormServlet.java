package com.j32bit.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.j32bit.bean.Person;
import com.j32bit.service.ServiceFacade;

/**
 * Form verilerinin alındığı servlet
 * 
 * @author serkan
 *
 */

@SuppressWarnings("serial")
public class FormServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Formdan alınan kullanıcı verileri
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String phone = request.getParameter("phone");
		String tcno = request.getParameter("tcno");
		String choice = request.getParameter("choice");
		
		PrintWriter writer = response.getWriter();
		StringBuilder htmlResponse = new StringBuilder("<html>");

		try {
			
			// Alınan veriler beane yazılır ve DAO içinde person dataları databaseye save edilir.
			
			Person person = new Person(tcno, firstname, lastname, phone);
			ServiceFacade.getInstance().getPersonDAO().savePerson(person,choice);
			
			//Başarılı kayıt durumunda gösterilecek sayfa
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login-success.html");
			dispatcher.forward(request, response);

		} catch (SQLIntegrityConstraintViolationException e) { // Kayıtlı telefon numarasının tekrar eklenmesi durumu
			htmlResponse.append("<h3> This phone number is already exist! <br/>");
		} catch (Exception e) {
			htmlResponse.append(e.getMessage());
			htmlResponse.append("<form action=\"index.jsp\">\n <input type=\"submit\" value=\"Create a new record\" />\n </form>");
		} finally {
			writer.println(htmlResponse.toString());
		}

	}
	
}