package cn.eight.homemaking.controller;

import cn.eight.homemaking.pojo.*;
import cn.eight.homemaking.service.EmploymentService;
import cn.eight.homemaking.service.ServiceImp.EmploymentServiceImp;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/Homemaking/employmentServlet")
public class EmploymentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf8");
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String reqType = request.getParameter("reqType");
        HttpSession session = request.getSession();
        if (reqType.equals("insert")){
            insert(request,response,session);
        }else if (reqType.equals("select")){
            select(request,response,session);
        }else if (reqType.equals("ddxz")){
            addContract(request,response);
        }else if (reqType.equals("query")){
            queryDd(request,response,session);
        }else if (reqType.equals("ddgl_ck")){
            queryAll(request,response,session);
        }else if(reqType.equals("ddgl_xg")){
            updateAll(request,response,session);
        }else if (reqType.equals("update")){
            update(request,response);
        }else if (reqType.equals("selectB")){
            selectByOther(request,response,session);
        }else if (reqType.equals("selectWorker")){
            selectWorker(request,response,session);
        }
    }

    private void selectWorker(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
        String name = request.getParameter("textarea2");
        String gender = request.getParameter("radio");
        String age1 = request.getParameter("age1");
        String age2 = request.getParameter("age2");
        String worker_time = request.getParameter("textarea7");
        String education = request.getParameter("radio1");
        String[] hobby = request.getParameterValues("checkbox");
        String hobby_sql="";
        if (hobby!=null){
            for (int i = 0; i < hobby.length; i++) {
                hobby_sql +="hobby like "+"'%"+hobby[i]+"%' and ";
            }
        }
        String[] lauge = request.getParameterValues("checkbox2");
        String lauge_sql="";
        if (lauge!=null){
            for (int i = 0; i < lauge.length; i++) {
                lauge_sql +=" language like "+"'%"+lauge[i]+"%' and";
            }
        }
        String otherLauge = request.getParameter("textarea16");
        String status = request.getParameter("radio3");
        String status_ = request.getParameter("textarea17");
        String marriage = request.getParameter("radio4");
        String marriage_ = request.getParameter("textarea18");
        String[]  license= request.getParameterValues("checkbox4");
        String license_sql="";
        if (license!=null){
            for (int i = 0; i < license.length; i++) {
                license_sql +="license like "+"'%"+license[i]+"%' and";
            }
        }
        String[] skills = request.getParameterValues("checkbox6");
        String skills_sql="";
        if (skills!=null){
            for (int i = 0; i < skills.length; i++) {
                skills_sql +="skill like "+"'%"+skills[i]+"%' and";
            }
        }
        EmploymentService service = new EmploymentServiceImp();
        List<Worker> workers = service.selectWorker(name, gender, age1, age2, worker_time, education, hobby_sql, lauge_sql, otherLauge, status, status_, marriage, marriage_, license_sql, skills_sql);
        request.setAttribute("workerlist", workers);
        List<Worker> workerlist = (List<Worker>) request.getAttribute("workerlist");
        for (int i = 0; i < workerlist.size(); i++) {
            System.out.println(workerlist.get(i).getWorker_name());
        }
        request.getRequestDispatcher("ny/rlzy/grxx.jsp").forward(request,response);


    }

    private void selectByOther(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
        session.removeAttribute("ddgl");
        String employer = request.getParameter("searchName");
        String check_in_time = request.getParameter("searchName2");
        String c_time = request.getParameter("searchName3");
        String worker = request.getParameter("searchName4");
        String select = request.getParameter("select");
        EmploymentService service = new EmploymentServiceImp();
        List<Ddgl> list= service.selectByOther(employer,check_in_time,c_time,worker,select);
        session.setAttribute("ddgl",list);
        response.sendRedirect("ny/ywgl/ddgl.jsp");

    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String c_number = request.getParameter("c_number");
        if (c_number==""){
            c_number=null;
        }
        String company_number = request.getParameter("company_number");
        if (company_number == "") {
            company_number = null;
        }
        String employer_number = request.getParameter("employer_number");
        if (employer_number == "") {
            employer_number = null;
        }
        String worker_number = request.getParameter("worker_number");
        if (worker_number == "") {
            worker_number = null;
        }
        String manager_number = request.getParameter("manager_number");
        if (manager_number == "") {
            manager_number = null;
        }
        String yxDate = request.getParameter("textarea500");
        if (yxDate == "") {
            yxDate = null;
        }
        String status = request.getParameter("status");
        String pay = request.getParameter("pay");
        if (pay == "") {
            pay = null;
        }
        String[] e_types = request.getParameterValues("e_type");
        String claim = "";
        if (e_types != null) {
            for (String e_type : e_types) {
                claim += e_type + " ";
            }
        }
        String fee = request.getParameter("fee");
        if (fee == "") {
            fee = null;
        }
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String check_in_time = df.format(new Date());
        Contract contract = new Contract(c_number, company_number, employer_number, worker_number, manager_number, null, yxDate, status, pay, claim, fee, check_in_time);
        EmploymentService service = new EmploymentServiceImp();
        service.updateContract(contract);
        response.sendRedirect("employmentServlet?reqType=query");
    }

    private void updateAll(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
        String name = request.getParameter("name");
        String workername = request.getParameter("workername");
        EmploymentService service = new EmploymentServiceImp();
        EmployerDd employerDd = service.queryAll(name);
        Worker worker_ = service.getWorker(workername);
        session.setAttribute("e_Dd",employerDd);
        session.setAttribute("worker",worker_);
        List<Object> worker = service.getNameByWorker();
        session.removeAttribute("W_name");
        session.setAttribute("w_name",worker);
        response.sendRedirect("ny/ywgl/ddgl_xg.jsp");
    }

    private void queryAll(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
        String name = request.getParameter("name");
        EmploymentService service = new EmploymentServiceImp();
        EmployerDd employerDd = service.queryAll(name);
        session.setAttribute("e_Dd",employerDd);
        response.sendRedirect("ny/ywgl/ddgl_ck.jsp");
    }

    private void queryDd(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
       EmploymentService service = new EmploymentServiceImp();
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
        List<Ddgl> list= service.queryContract(page*5);
        session.setAttribute("ddgl",list);
        int c =((EmploymentServiceImp)service).getCount();
        session.setAttribute("page",page);
        session.setAttribute("reqType","query");
        session.setAttribute("count", c);
        response.sendRedirect("ny/ywgl/ddgl.jsp");
    }

    private void addContract(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String company_number = request.getParameter("company_number");
        if (company_number == "") {
            company_number = null;
        }
        String employer_number = request.getParameter("employer_number");
        if (employer_number == "") {
            employer_number = null;
        }
        String worker_number = request.getParameter("worker_number");
        if (worker_number == "") {
            worker_number = null;
        }
        String manager_number = request.getParameter("manager_number");
        if (manager_number == "") {
            manager_number = null;
        }
        String yxDate = request.getParameter("textarea500");
        if (yxDate == "") {
            yxDate = null;
        }
        String status = request.getParameter("status");
        String pay = request.getParameter("pay");
        if (pay == "") {
            pay = null;
        }
        String[] e_types = request.getParameterValues("e_type");
        String claim = "";
        if (e_types != null) {
            for (String e_type : e_types) {
                claim += e_type + " ";
            }
        }
        String fee = request.getParameter("fee");
        if (fee == "") {
            fee = null;
        }
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String check_in_time = df.format(new Date());
        Contract contract = new Contract(null, company_number, employer_number, worker_number, manager_number, null, yxDate, status, pay, claim, fee, check_in_time);
        EmploymentService service = new EmploymentServiceImp();
        service.insertContract(contract);
        response.sendRedirect("employmentServlet?reqType=query");
    }

    private void select(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String check = request.getParameter("check");
        String name = request.getParameter("name");
        EmploymentService service = new EmploymentServiceImp();
        Map<String,Object> map = new HashMap<String, Object>();
        if (check.equals("employer")){
            Employer employer =  service.getEmployer(name);
            map.put("E",employer);
        }else if (check.equals("worker")){
            Worker worker = service.getWorker(name);
            map.put("W",worker);
        }
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(response.getWriter(),map);
    }

    private void insert(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
        EmploymentService service = new EmploymentServiceImp();
        List<Object> employer = service.getNameByEmployer();
        List<Object> worker = service.getNameByWorker();
        session.removeAttribute("w_name");
        session.removeAttribute("e_name");
        session.setAttribute("e_name",employer);
        session.setAttribute("w_name",worker);
        response.sendRedirect("ny/ywgl/ddgl_xz.jsp");
    }
}
