package cn.eight.homemaking.controller;

import cn.eight.homemaking.service.QueryOrdersService;
import cn.eight.homemaking.service.ServiceImp.QueryOrdersServiceImp;
import cn.eight.homemaking.pojo.QueryOrders;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@WebServlet("/controller/queryservlet")
public class QueryServlet extends HttpServlet {
    private QueryOrdersService queryordersservice=new QueryOrdersServiceImp();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf8");
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String reqType=request.getParameter("reqType");
        if (reqType.equals("queryorders")){
            queryorders(request,response);
    }
}

    private void queryorders(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<QueryOrders> queryordersList=queryordersservice.findQueryOrdersList();
        request.setAttribute("queryordersList",queryordersList);
        request.getRequestDispatcher("../Homemaking/ny/ywgl/ddgl_xz.jsp").forward(request,response);
    }
}
