package com.brunorozendo.brewer.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@WebServlet("/JDBCDataSourceExample")
public class JdbcDataSourceExample extends HttpServlet {

  private final Logger logger = LoggerFactory.getLogger(JdbcDataSourceExample.class);

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)   {

    response.setContentType("text/html");

    PrintWriter out = null;
    try {
      out = response.getWriter();
    } catch (IOException e) {
      logger.debug(e.getMessage());
    }

    Context initContext = null;
    DataSource ds = null;

    try {
      initContext = new InitialContext();
    } catch (NamingException e) {
      logger.debug(e.getExplanation());
    }


    try {
      if (initContext != null) {
        ds = (DataSource) initContext.lookup("java:/comp/env/jdbc/brewer");
      }
    } catch (NamingException e) {
      logger.debug(e.getExplanation());
    } catch (Exception e) {
      try {
        ds = (DataSource) initContext.lookup("jdbc/brewer");
      } catch (NamingException e2) {
        logger.debug(e2.getExplanation());
      }
    }
    if (ds != null) {
      try (Connection conn = ds.getConnection()) {
        if (out != null) {
          out.print("<h2>" + conn.getSchema() + "</h2>");
        }
      } catch (SQLException e) {
        logger.debug(e.getMessage());
      }

    }


  }

}