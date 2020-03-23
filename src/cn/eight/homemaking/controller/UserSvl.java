package cn.eight.homemaking.controller;

import cn.eight.homemaking.pojo.Account;
import cn.eight.homemaking.service.AccountService;
import cn.eight.homemaking.service.ServiceImp.AccountServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/Homemaking/usersvl",initParams = {@WebInitParam(name = "pageSize",value = "10")})
public class UserSvl extends HttpServlet {
    private AccountService accountService = new AccountServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String reqType = request.getParameter("reqType");
        if (reqType.equals("add")) {
            addUser(request, response);
        }else if (reqType.equals("find")) {
            findUser(request, response);
        }else if (reqType.equals("mod")) {
            modUser(request, response);
        }else if (reqType.equals("delete")) {
            deleteUser(request, response);
        }
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response) {
        Integer account_id = Integer.valueOf(request.getParameter("account_id"));
        int currentPage=Integer.valueOf(request.getParameter("currentPage"));

    }

    //修改
    private void modUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer account_id = Integer.valueOf(request.getParameter("account_id"));
        String accountcode = request.getParameter("accountcode");
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String level = request.getParameter("select");//所属级别
        String password = request.getParameter("password");
        String confirm_password = request.getParameter("confirm_password");
        String enable = request.getParameter("radio");//是否可用
        Integer belong = -1;
        if (request.getParameter("belong")!="") {
            belong = Integer.valueOf(request.getParameter("belong"));
        }
        int currentPage=Integer.valueOf(request.getParameter("currentPage"));
        Account account = new Account(account_id,accountcode, username, email, password, enable, level, belong);
        boolean result = accountService.modUser(account);
        if (result){
            request.getRequestDispatcher("ny/xtgl/yhgl.jsp").forward(request,response);
        }else{
            response.setCharacterEncoding("utf-8");
            response.setContentType("text/html;charset=utf-8;");
            response.getWriter().print("<script>alert('修改失败)</script>");
            request.getRequestDispatcher("ny/xtgl/yhgl_xg.jsp").forward(request,response);
        }
    }

    //查看
    private void findUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int currentPage=Integer.valueOf(request.getParameter("currentPage"));
        if (currentPage<1){
            currentPage=1;
        }
        int pageSize=Integer.valueOf(getServletConfig().getInitParameter("pageSize"));
        String username=request.getParameter("searchValue");
        Account account=new Account(0,null,username,null,null,null,null,0);
        List<Account> accountList = accountService.findUser(account, currentPage, pageSize);
        int totalRecord=accountService.totalRecord(account);
        int totalPages=1;
        if (totalRecord%pageSize==0){
            totalPages=totalRecord/pageSize;
        }else{
            totalPages=totalRecord/pageSize+1;
        }
        request.setAttribute("accountList", accountList);
        request.setAttribute("totalRecord", totalRecord);
        request.setAttribute("totalPages", totalPages);
        request.setAttribute("currentPage", currentPage);
        request.getRequestDispatcher("ny/xtgl/yhgl.jsp").forward(request,response);
    }
    //新增
    private void addUser(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String accountcode = request.getParameter("accountcode");
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String level = request.getParameter("select");//所属级别
        String password = request.getParameter("password");
        String confirm_password = request.getParameter("confirm_password");
        String enable = request.getParameter("radio");//是否可用
        Integer belong = Integer.valueOf(request.getParameter("belong"));
        Account account = new Account(0,accountcode, username, email, password, enable, level, belong);
        boolean result = accountService.addUser(account);
        if (result) {
            response.sendRedirect("ny/xtgl/yhgl.jsp");
        } else {
            request.setAttribute("info", "添加失败");
            request.getRequestDispatcher("ny/xtgl/yhgl_xz.jsp").forward(request, response);
        }
    }
}
