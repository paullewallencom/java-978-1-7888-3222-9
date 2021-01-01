package com.javabullets.java9.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import javax.transaction.Transactional;

// https://localhost:9080/javabullets/dbServlet
@WebServlet(value = { "/dbServlet" })
public class DatabaseServlet extends HttpServlet {

	private static final long serialVersionUID = -5484204115724915963L;

	@Resource
	DataSource defaultDatasource;
    
    @PersistenceContext
    private EntityManager entityManager;
	
	@Override
	@Transactional
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		StringBuilder sb = new StringBuilder();
		sb.append("<html>");
		if (defaultDatasource == null) {
		    sb.append("<p>defaultDatasource == null</p>");	
		} else {
		    sb.append("<p>defaultDatasource != null</p>");
		}

		if (entityManager == null) {
		    sb.append("<p>entityManager == null</p>");	
		} else {
		    sb.append("<p>entityManager != null</p>");
		}		
		
		// Lets use the defaultDatasource
		try {
			sb.append("<p>getting connection</p>");
			Connection connection = defaultDatasource.getConnection();
			sb.append("<p>got connection</p>");
			
			sb.append("<p>get statement</p>");
	        Statement statement = connection.createStatement();

			sb.append("<p>got statement</p>");
			sb.append("<p>retrieve ");
	        sb.append("<p>create table</p>");
	        statement.executeUpdate("create table names (id int not null primary key, forename varchar(30))");
	        
	        sb.append("<p>insert value</p>");
	        statement.executeUpdate("insert into names values (1, 'martin')");
	        
	        ResultSet result = statement.executeQuery("select forename from app.names where id = 1");
	        result.next();
	        sb.append("<p>retrieve *");
	        sb.append(result.getString("forename"));
	        sb.append("*</p>");

	        sb.append("<p>before drop table</p>");
            statement.executeUpdate("drop table names");
            sb.append("<p>after drop table</p>");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		sb.append("</html>");
		
        try(PrintWriter respWriter = resp.getWriter();){
            respWriter.write(sb.toString());
        }
	}
}