package com.javabullets.javaee8.http2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.PushBuilder;
import java.io.IOException;

//https://localhost:8443/javaee8/http2push
@WebServlet(value = { "/http2push" })
public class PushServlet extends HttpServlet {

	private static final long serialVersionUID = -5484204115724915963L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PushBuilder pushBuilder = req.newPushBuilder();
		if (pushBuilder != null) {
			pushBuilder
			   .path("images/jean-bach-559005-unsplash.jpg")
			   .addHeader("content-type", "image/jpg")
			   .push();
		}

		getServletContext().getRequestDispatcher("/push.jsp").forward(req, resp);
	}
}