package com.brunorozendo.brewer.controllers.util;

import java.util.HashMap;
import java.util.Map;
import org.springframework.web.servlet.ModelAndView;

public class UtilController {

  private static final String LAYOUT = "layout";
  protected static final String MESSAGE_TYPE_SUCESS = "success";
  protected static final String MESSAGE_TYPE_ERROR = "alert";
  protected Map<String, Object> data = new HashMap<>();

  protected ModelAndView modelAndView(String view) {
    data.put("view", view);
    return new ModelAndView(LAYOUT, data);
  }

  protected ModelAndView modelAndView() {
    return new ModelAndView(LAYOUT, data);
  }

  protected ModelAndView redirect(String url) {
    return new ModelAndView("redirect:" + url);
  }


  protected void addModel(String key, Object value) {
    data.put(key, value);
  }


}
