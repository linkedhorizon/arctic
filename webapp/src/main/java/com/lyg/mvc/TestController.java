package com.lyg.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2018/5/1 0001.
 */
@Controller
@RequestMapping("/")
public class TestController {
    @RequestMapping("mvc")
    public void indexTest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().print("sakura");
        DispatcherServlet dispatcherServlet = new DispatcherServlet();

    }

}
