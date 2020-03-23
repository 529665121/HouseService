package cn.eight.homemaking.controller;

import cn.eight.homemaking.pojo.Account;
import cn.eight.homemaking.service.AccountService;
import cn.eight.homemaking.service.ServiceImp.AccountServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/Homemaking/loginsvl")
public class LoginSvl extends HttpServlet {
    private AccountService service=new AccountServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accountcode = request.getParameter("j_username");
        String password=request.getParameter("j_password");
        Account account=new Account(0,accountcode,null,null,password,null,null,1);
        boolean result = service.checkAccount(account);
        if (result){
            HttpSession session = request.getSession();
            session.setAttribute("accountcode",accountcode);
            session.setAttribute("company_number",(int)1);
            response.sendRedirect("ny/index.htm");
        }else {
            request.setAttribute("info","登录失败");
            request.getRequestDispatcher("ny/login.jsp").forward(request,response);
        }
    }
    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {

    }
}
