package cn.eight.homemaking.controller;

import cn.eight.homemaking.service.*;
import cn.eight.homemaking.service.ServiceImp.CompanyFormServiceImp;
import cn.eight.homemaking.service.ServiceImp.DataDictionaryServiceImp;
import cn.eight.homemaking.service.ServiceImp.OrderFormServiceImp;
import cn.eight.homemaking.service.ServiceImp.OrderServiceImp;
import cn.eight.homemaking.pojo.CompanyForm;
import cn.eight.homemaking.pojo.DataDictionary;
import cn.eight.homemaking.pojo.OrderForm;
import cn.eight.homemaking.pojo.OrderTest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

//处理订单查询的控制器
@WebServlet("/controller/orderservlet")
public class OrderServlet extends HttpServlet {
    private OrderService service=new OrderServiceImp();
    private OrderFormService formservice=new OrderFormServiceImp();
    private CompanyFormService companyformservice=new CompanyFormServiceImp();
    private DataDictionaryService datadictionaryservice=new DataDictionaryServiceImp();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf8");
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     String reqType=request.getParameter("reqType");
            if (reqType.equals("query")){
                query(request,response);
            }else if (reqType.equals("inquiry")){
                inquiry(request,response);
            }else if (reqType.equals("querycompany")){
                querycompany(request,response);
            }else if (reqType.equals("querydata")){
                querydata(request,response);

            }

        }

    private void querydata(HttpServletRequest request,  HttpServletResponse response) throws ServletException, IOException {
        List<DataDictionary> datadictionaryList=datadictionaryservice.findDataDictionaryList();
        request.setAttribute("datadictionaryList",datadictionaryList);
        request.getRequestDispatcher("../Homemaking/ny/xtgl/basedate_list.jsp").forward(request,response);
    }

    private void querycompany(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<CompanyForm> companyformList=companyformservice.findCompanyFormList();
        request.setAttribute("companyformList",companyformList);
        request.getRequestDispatcher("../Homemaking/ny/xtgl/gsgl.jsp").forward(request,response);
    }

    private void inquiry(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<OrderForm> orderformList = formservice.findOrderFormList();
        request.setAttribute("orderformList",orderformList);
        request.getRequestDispatcher("../Homemaking/ny/cwgl/bbcx.jsp").forward(request,response);
    }

    private void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<OrderTest> orderList = service.findOrderList();
        request.setAttribute("orderList",orderList);
        request.getRequestDispatcher("../Homemaking/ny/cwgl/sfgl.jsp").forward(request,response);
    }


}


