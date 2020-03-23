package cn.eight.homemaking.controller;

import cn.eight.homemaking.pojo.RechargeQuery;
import cn.eight.homemaking.pojo.Xfcx;
import cn.eight.homemaking.service.RechargeService;
import cn.eight.homemaking.service.ServiceImp.RechargeServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/Homemaking/rechargeServlet")
public class RechargeServlet extends HttpServlet {
    RechargeService service = new RechargeServiceImp();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf8");
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String reqType = request.getParameter("reqType");
        HttpSession session = request.getSession();
        if (reqType.equals("czgl")){
            queryRecharge(request,response,session);
        }else if (reqType.equals("cz")){
            intoC(request,response,session);
        }else if (reqType.equals("chongzhi")){
            updateR(request,response,session);
        }else if (reqType.equals("xfcx")){
            queryRecord(request,response,session);
        }else if (reqType.equals("other")){
            queryRechargeByOther(request,response,session);
        }else if (reqType.equals("other_")){
            queryRecordByOther(request,response,session);
        }
    }

    private void queryRecordByOther(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
        String company = request.getParameter("searchName");
        String account = request.getParameter("searchName3");
        String time_in = request.getParameter("searchName2");
        String time_out = request.getParameter("searchName4");
        List<Xfcx> list=service.queryRecordByOther(company,account,time_in,time_out);
        session.setAttribute("record",list);
        response.sendRedirect("ny/xtgl/xfcx.jsp");
    }

    private void queryRechargeByOther(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
        String company = request.getParameter("searchName");
        String account = request.getParameter("searchName3");
        List<RechargeQuery> rq = service.queryRechargeByOther(company,account);
        session.setAttribute("rq",rq);
        response.sendRedirect("ny/xtgl/czgl.jsp");
    }

    private void queryRecord(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
        String page1 = request.getParameter("page");
        int page = 0;
        if (page1 != null) {
            String pageSelect = request.getParameter("paginationAction");
            String pageLast = request.getParameter("paginationAction2");
            if (page1.equals("first")) {
                page = 0;
            } else if (page1.equals("old")&&pageSelect!=null) {
                if (Integer.valueOf(pageSelect) != 0) {
                    page = Integer.valueOf(pageSelect) - 1;
                } else {
                    page = 0;
                }
            } else if (page1.equals("new")) {
                if (Integer.valueOf(pageSelect) != Integer.valueOf(pageLast)-1) {
                    page = Integer.valueOf(pageSelect) + 1;
                } else {
                    page = Integer.valueOf(pageSelect);
                }
            } else if (page1.equals("last")&&pageLast!=null) {
                page = Integer.valueOf(pageLast)-1;
            } else if (page1.equals("jump")) {
                String pageSelect1 = request.getParameter("pageSelect");
                int count = (int)session.getAttribute("count");
                if (pageSelect1 != "") {
                    if (Integer.valueOf(pageSelect1) <= Integer.valueOf(pageLast)) {
                        int integer = Integer.valueOf(pageSelect1) - 1;
                        page = integer;
                    }
                }
            }
        }
        List<Xfcx> list=service.queryRecord(page*5);
        int c =((RechargeServiceImp)service).getCount();
        session.setAttribute("page",page);
        session.setAttribute("reqType","xfcx");
        session.setAttribute("count", c);
        session.setAttribute("record",list);
        response.sendRedirect("ny/xtgl/xfcx.jsp");
    }

    private void updateR(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
        String money = request.getParameter("textarea4");
        String explain = request.getParameter("textarea35");
        String company_name = request.getParameter("name");
        String  operator = (String) session.getAttribute("operator");
        service.insertRecrod(money,explain,company_name,operator);
        service.updateRecrod(money,company_name);
        response.sendRedirect("rechargeServlet?reqType=czgl");
    }

    private void intoC(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
        String name = request.getParameter("name");
        session.setAttribute("name",name);
        response.sendRedirect("ny/xtgl/czgl_xz.jsp");
    }

    private void queryRecharge(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
        String page1 = request.getParameter("page");
        int page = 0;
        if (page1 != null) {
            String pageSelect = request.getParameter("paginationAction");
            String pageLast = request.getParameter("paginationAction2");
            if (page1.equals("first")) {
                page = 0;
            } else if (page1.equals("old")&&pageSelect!=null) {
                if (Integer.valueOf(pageSelect) != 0) {
                    page = Integer.valueOf(pageSelect) - 1;
                } else {
                    page = 0;
                }
            } else if (page1.equals("new")&&pageSelect!=null) {
                if (Integer.valueOf(pageSelect) != Integer.valueOf(pageLast)-1) {
                    page = Integer.valueOf(pageSelect) + 1;
                } else {
                    page = Integer.valueOf(pageSelect);
                }
            } else if (page1.equals("last")&&pageLast!=null) {
                page = Integer.valueOf(pageLast)-1;
            } else if (page1.equals("jump")) {
                String pageSelect1 = request.getParameter("pageSelect");
                int count = (int)session.getAttribute("count");
                if (pageSelect1 != "") {
                    if (Integer.valueOf(pageSelect1) <= Integer.valueOf(pageLast)) {
                        int integer = Integer.valueOf(pageSelect1) - 1;
                        page = integer;
                    }
                }
            }
        }
        List<RechargeQuery> rq=service.queryRecharge(page*5);
        int c =((RechargeServiceImp)service).getCount();
        session.setAttribute("page",page);
        session.setAttribute("reqType","czgl");
        session.setAttribute("count", c);
        session.setAttribute("rq",rq);
        response.sendRedirect("ny/xtgl/czgl.jsp");
    }
}
