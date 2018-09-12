package com.brunorozendo.brewer.controllers;

import com.brunorozendo.brewer.controllers.util.UtilController;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SuppressWarnings("unused")
@Controller
public class DataSourceController extends UtilController {

  private final Logger logger = LoggerFactory.getLogger(DataSourceController.class);

  /**
   * Teste de datasource.
   *
   * @return String dizendo se o datasrouce está acessivel
   */
  @GetMapping("/check/datasource")
  public @ResponseBody
  ResponseEntity<String> check() {

    Context initContext = null;
    DataSource ds = null;
    String status = "error";

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
      String query = "SELECT version()";
      try (ResultSet rs = ((ds.getConnection()).createStatement()).executeQuery(query)) {
        while (rs.next()) {
          status = rs.getString("version");
        }
      } catch (SQLException e) {
        logger.debug(e.getMessage());
      }

    }
    return ResponseEntity.ok(status);
  }


}