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

@WebServlet("/editdeveloper")
public class EditDeveloperController extends HttpServlet {
//for edit we use ServletRespone 
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		DeveloperService service = new DeveloperService();
		Developer d = service.getDeveloperById(id);
		if (d != null) {
			request.setAttribute("per", d);
			RequestDispatcher dispatcher = request.getRequestDispatcher("UpdateDeveloper.jsp");
			dispatcher.forward(request, response);
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("EditDeveloper.jsp");
			dispatcher.include(request, response);

		}
	}

}
