package cn.eight.homemaking.controller;

import cn.eight.homemaking.pojo.Company;
import cn.eight.homemaking.service.CompanyService;
import cn.eight.homemaking.service.ServiceImp.CompanyServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(value="/Homemaking/companysvl",initParams = {@WebInitParam(name="pageSize",value = "10")} )
public class CompanySvl extends HttpServlet {
    private CompanyService companyService=new CompanyServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String reqType = request.getParameter("reqType");
        if (reqType.equals("add")){
            addCompany(request,response);
        }else if (reqType.equals("find")){
            findCompany(request,response);
        }else if (reqType.equals("mod")){
            modCompany(request,response);
        }else if (reqType.equals("remove")){
            removeCompany(request,response);
        }
    }

    private void removeCompany(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String index=request.getParameter("index");
        String currentPage=request.getParameter("currentPage");
        String company_account = request.getParameter("company_account");
        String company_name = request.getParameter("company_name");
        Company company=new Company(0,company_account,company_name,null);
        boolean result = companyService.removeCompany(company);
        if (result){
            response.sendRedirect("ny/xtgl/gsgl.jsp");
        }else{
            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().print("<script>alert('删除失败');window.history.back();</script>");
            response.getWriter().flush();
    }
    }

    private void modCompany(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String index=request.getParameter("index");
        String company_account = request.getParameter("textarea");
        String company_name = request.getParameter("textarea1");
        String instruction = request.getParameter("textarea2");
        Company company=new Company(0,company_account,company_name,instruction);
        boolean result = companyService.modCompany(company);
        if (result){
            response.sendRedirect("ny/xtgl/gsgl_xg.jsp");
        }else{
            request.setAttribute("info","修改失败");
            request.getRequestDispatcher("ny/xtgl/gsgl_xg.jsp").forward(request,response);
        }
    }

    private void findCompany(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String company_account=request.getParameter("searchName");
        String company_name=request.getParameter("searchName2");
        int currentPage=Integer.valueOf(request.getParameter("currentPage"));
        int pageSize=Integer.valueOf(getServletConfig().getInitParameter("pageSize"));
        Company company=new Company(0,company_account,company_name,null);
        List<Company> companyList = companyService.findCompany(company,currentPage,pageSize);
        int totalRecord=companyService.findTotalRecord(company);
        int totalPages=0;
        if (totalRecord%pageSize==0){
            totalPages=totalRecord/pageSize;
        }else{
            totalPages=totalRecord/pageSize+1;
        }
        request.setAttribute("companyList",companyList);
        request.setAttribute("totalRecord",totalRecord);
        request.setAttribute("totalPages",totalPages);
        request.setAttribute("currentPage",currentPage);
        request.getRequestDispatcher("ny/xtgl/gsgl.jsp").forward(request,response);
    }

    private void addCompany(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String company_account = request.getParameter("textarea");
        String company_name = request.getParameter("textarea1");
        String instruction = request.getParameter("textarea2");
        Company company=new Company(0,company_account,company_name,instruction);
        boolean result = companyService.addCompany(company);
        if (result){
            response.sendRedirect("ny/xtgl/gsgl_xz.jsp");
        }else{
            request.setAttribute("info","添加失败");
            request.getRequestDispatcher("ny/xtgl/gsgl_xz.jsp").forward(request,response);
        }
    }
}
