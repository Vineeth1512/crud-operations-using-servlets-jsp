package com.example.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.dto.Developer;
import com.example.service.DeveloperService;

@WebServlet("/savedeveloper")
public class SaveDeveloper extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Developer developer = new Developer();
		developer.setDeveloperName(request.getParameter("developerName"));
		developer.setCompanyName(request.getParameter("companyName"));
		developer.setSalary(Double.parseDouble(request.getParameter("salary")));
		DeveloperService service = new DeveloperService();
		Developer saveDeveloper = service.addDeveloper(developer);
		if (saveDeveloper != null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
			dispatcher.forward(request, response);
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("SaveDeveloper.jsp");
			dispatcher.include(request, response);

		}

	}
}
