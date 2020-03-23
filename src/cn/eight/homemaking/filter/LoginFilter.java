package cn.eight.homemaking.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//对首页面进行过滤
//@WebFilter("/Homemaking/ny/index.htm")
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request= (HttpServletRequest) req;
        HttpServletResponse response= (HttpServletResponse) resp;
        HttpSession session = request.getSession(false);
        if (session==null||session.getAttribute("accountcode")==null){
            response.sendRedirect(request.getContextPath());
        }else {
            chain.doFilter(req, resp);
        }
        /*chain.doFilter(req, resp);*/
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
