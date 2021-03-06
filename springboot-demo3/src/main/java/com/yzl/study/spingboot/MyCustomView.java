package com.yzl.study.spingboot;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.View;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Map;

@Component("myCustomView")
public class MyCustomView implements View {

  public String getContentType() {
      return "text/html";
  }

  public void render(Map<String, ?> map, HttpServletRequest httpServletRequest,
                     HttpServletResponse httpServletResponse) throws Exception {
      PrintWriter writer = httpServletResponse.getWriter();
      writer.write("msg rendered in MyCustomView: " + map.get("msg"));
  }
}