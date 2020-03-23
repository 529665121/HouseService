package cn.eight.homemaking.controller;

import cn.eight.homemaking.pojo.Worker;
import cn.eight.homemaking.service.WorkerService;
import cn.eight.homemaking.service.ServiceImp.WorkerServiceImpl;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/Homemaking/workersvl", initParams={@WebInitParam(name = "pageSize",value = "12")})
public class WorkerSvl extends HttpServlet {
    private WorkerService workerService=new WorkerServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //对请求正文进行转码
        request.setCharacterEncoding("UTF-8");
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String reqType = request.getParameter("reqType");
        if (reqType.equals("addWorker")) {
            addWorker(request, response);
        } else if (reqType.equals("find")) {
            findWorker(request, response);
        } else if (reqType.equals("higherfind")) {
            higherFind(request, response);
        } else if (reqType.equals("see")) {
            seeWorker(request, response);
        }else if (reqType.equals("seen")) {
            seenWorker(request, response);
        }else if (reqType.equals("mod")) {
            modWorker(request, response);
        }
    }

    private void modWorker(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String index=request.getParameter("index");
        int worker_number=Integer.valueOf(request.getParameter("textarea1"));
        int company_number=Integer.valueOf(request.getParameter("textarea2"));
        String worker_name=request.getParameter("textarea3");
        String gender=request.getParameter("radio");
        String idnumber=request.getParameter("textarea4");
        String birthday=request.getParameter("textarea5");
        int age=Integer.valueOf(request.getParameter("textarea6"));
        int height=Integer.valueOf(request.getParameter("textarea7"));
        String mobile_phone=request.getParameter("textarea8");
        String telephone=request.getParameter("textarea9");
        String work_type=request.getParameter("textarea10");
        String work_time=request.getParameter("textarea11");
        String disadvantage=request.getParameter("textarea12");
        String photo=request.getParameter("photo");
        String address=request.getParameter("textarea13");
        String current_address=request.getParameter("textarea14");
        String bankcard=request.getParameter("textarea15");
        String insurance=request.getParameter("textarea16");
        String language=request.getParameter("checkbox2");
        String status=request.getParameter("radio1");
        String martial=request.getParameter("radio2");
        String license=request.getParameter("checkbox3");
        String check_up=request.getParameter("checkbox5");
        String check_up_time=request.getParameter("textarea17");
        String skill=request.getParameter("checkbox6");
        String introduction=request.getParameter("textarea35");
        String req_time=request.getParameter("textarea36");
        String req_pay=request.getParameter("textarea38");
        String stay_room=request.getParameter("textarea37");
        String food=request.getParameter("textarea39");
        Worker worker=new Worker(worker_number,company_number,worker_name,gender,idnumber,birthday,age,height,mobile_phone,
                telephone, work_type,work_time,disadvantage,photo,address,current_address,bankcard,insurance,language,status,
                martial,license,check_up, check_up_time,skill,introduction,req_time,req_pay,stay_room,food,null,
                null);
        boolean result = workerService.modWorker(worker);
        if (result){
            request.getRequestDispatcher("ny/rlzy/grxx.jsp").forward(request,response);
        }else{
            response.setCharacterEncoding("utf-8");
            response.setContentType("text/html;charset=utf-8;");
            response.getWriter().print("<script>alert('修改失败)</script>");
            request.getRequestDispatcher("ny/rlzy/grxx_xg.jsp").forward(request,response);
        }
    }

    //grxx.jsp 查看
    private void seenWorker(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String index=request.getParameter("index");
        String worker_name=request.getParameter("worker_name");
        String gender=request.getParameter("gender");
        int age=Integer.valueOf(request.getParameter("age"));
        String work_type=request.getParameter("work_type");
        String req_pay=request.getParameter("req_pay");
        String status=request.getParameter("status");
        String entry_time=request.getParameter("entry_time");
        Worker worker = new Worker(null, null, worker_name, gender, null,
                null, age, null, null, null, work_type, null,
                null, null, null, null, null, null,
                null, status, null, null, null, null, null,
                null, null, req_pay, null, null, entry_time, null);
        List<Worker> workerList = workerService.seenWorker(worker);
        request.setAttribute("workerList",workerList);
        request.getRequestDispatcher("ny/rlzy/grxx_ck.jsp").forward(request,response);
    }

    //grxx_ss.jsp  查看
    private void seeWorker(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String index=request.getParameter("index");
        String worker_name=request.getParameter("worker_name");
        String gender=request.getParameter("gender");
        int age=Integer.valueOf(request.getParameter("age"));
        String work_type=request.getParameter("work_type");
        String req_pay=request.getParameter("req_pay");
        String status=request.getParameter("status");
        String entry_time=request.getParameter("entry_time");
        int belong=Integer.valueOf(request.getParameter("belong"));
        Worker worker = new Worker(null, null, worker_name, gender, null,
                null, age, null, null, null, work_type, null,
                null, null, null, null, null, null,
                null, status, null, null, null, null, null,
                null, null, req_pay, null, null, entry_time, belong);
        List<Worker> workerList = workerService.seeWorker(worker);
        System.out.println(workerList);
        request.setAttribute("workerList",workerList);
        request.getRequestDispatcher("ny/rlzy/grxx_ck.jsp").forward(request,response);

    }

    private void higherFind(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int currentPage=Integer.valueOf(request.getParameter("currentPage"));//当前页
        if (currentPage<1){
            currentPage=1;
        }
        int pageSize=Integer.valueOf(getServletConfig().getInitParameter("pageSize"));//固定值
        String worker_name = request.getParameter("searchName");
        String gender = request.getParameter("radio");
        String str = request.getParameter("searchAge").trim();
        int age;
        if (str.isEmpty()) {
            age = -1;
        } else {
            age = Integer.valueOf(str);
        }
        String status = request.getParameter("select");
        String work_type = request.getParameter("select2");
        Worker worker = new Worker(null, null, worker_name, gender, null,
                null, age, null, null, null, work_type, null,
                null, null, null, null, null, null,
                null, status, null, null, null, null, null,
                null, null, null, null, null, null, null);
        //得到本页的所有记录的集合
        List<Worker> workerList = workerService.higherFindWorker(worker,currentPage,pageSize);
        //得到总记录数
        int totalRecording=workerService.findTotalRecording(worker);
        //得到总页数
        int totalPages;
        if (totalRecording%pageSize==0){
            totalPages=totalRecording/pageSize;
        }else{
            totalPages=totalRecording/pageSize+1;
        }
        request.setAttribute("workerlist", workerList);
        request.setAttribute("totalRecording", totalRecording);
        request.setAttribute("totalPages", totalPages);
        request.setAttribute("currentPage", currentPage);
        request.getRequestDispatcher("ny/rlzy/grxx_ss.jsp").forward(request,response);
    }

    private void findWorker(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int currentPage=Integer.valueOf(request.getParameter("currentPage"));//当前页
        if (currentPage<1){
            currentPage=1;
        }
        int pageSize=Integer.valueOf(getServletConfig().getInitParameter("pageSize"));//每页多少条记录
        String worker_name = request.getParameter("username");
        String gender = request.getParameter("sex");
        String str = request.getParameter("age").trim();
        int  age;
        if (str.isEmpty()) {
            age = -1;
        } else {
            age = Integer.valueOf(str);
        }
        String status = request.getParameter("status");
        String work_type = request.getParameter("job");
        Worker worker = new Worker(null, null, worker_name, gender, null,
                null, age, null, null, null, work_type, null,
                null, null, null, null, null, null,
                null, status, null, null, null, null, null,
                null, null, null, null, null, null, null);
        List<Worker> workerlist = workerService.findWorker(worker,currentPage,pageSize);
        //得到总记录数
        int totalRecording=workerService.findTotalRecording(worker);
        //得到总页数
        int totalPages;
        if (totalRecording%pageSize==0){
            totalPages=totalRecording/pageSize;
        }else{
            totalPages=totalRecording/pageSize+1;
        }
        request.setAttribute("workerlist", workerlist);
        request.setAttribute("totalRecording", totalRecording);
        request.setAttribute("totalPages", totalPages);
        request.setAttribute("currentPage", currentPage);
        request.getRequestDispatcher("ny/rlzy/grxx.jsp").forward(request,response);
    }
    private void addWorker(HttpServletRequest request, HttpServletResponse response){
        //上传文件
        //创建 FileItem 对象的工厂
        DiskFileItemFactory factory = new DiskFileItemFactory();
        //获取文件需要上传到的路径
        String path = getServletContext().getRealPath("/WEB-INF/upload");
        //指定临时文件目录
        factory.setRepository(new File(path));
        //设置内存缓冲区的大小
        factory.setSizeThreshold(1024*1024) ;
        //负责处理上传的文件数据，并将表单中每个输入项封装成一个 FileItem 对象中
        ServletFileUpload upload = new ServletFileUpload(factory);
        //ProgressListener显示上传进度
       /* ProgressListener progressListener = new ProgressListener() {
            public void update(long pBytesRead, long pContentLength, int pItems) {
                System.out.println("到现在为止,  " + pBytesRead + " 字节已上传，总大小为 "
                        + pContentLength);
            }
        };
        upload.setProgressListener(progressListener);*/

        List<FileItem> list;
        try {
            //调用Upload.parseRequest方法解析request对象，得到一个保存了所有上传内容的List对象。
            list = (List<FileItem>)upload.parseRequest(request);
            Worker worker=new Worker();
//			对list进行迭代，每迭代一个FileItem对象，调用其isFormField方法判断是否是上传文件
            for(FileItem item : list) {
                String name = item.getFieldName();
                if (item.isFormField()) {//为普通表单字段
                    String value = new String(item.getString().getBytes("iso-8859-1"), "utf-8");
                    //依据不同的表单控件来取值并写入到worker对象中
                    if (name.equals("worker_number")) {
                        worker.setWorker_number(Integer.valueOf(value));
                    } else if (name.equals("company_number")) {
                        worker.setCompany_number(Integer.valueOf(value));
                    } else if (name.equals("worker_name")) {
                        worker.setWorker_name(value);
                    } else if (name.equals("gender")) {
                        worker.setGender(value);
                    } else if (name.equals("idnumber")) {
                        worker.setIdnumber(value);
                    } else if (name.equals("birthday")) {
                        worker.setBirthday(value);
                    } else if (name.equals("age")) {
                        worker.setAge(Integer.valueOf(value));
                    } else if (name.equals("height")) {
                        worker.setHeight(Integer.valueOf(value));;
                    } else if (name.equals("mobile_phone")) {
                        worker.setMobile_phone(value);
                    } else if (name.equals("telephone")) {
                        worker.setTelephone(value);
                    } else if (name.equals("disadvantage")) {
                        worker.setDisadvantage(value);
                    } else if (name.equals("address")) {
                        worker.setAddress(value);
                    } else if (name.equals("current_address")) {
                        worker.setCurrent_address(value);
                    } else if (name.equals("bankcard")) {
                        worker.setBankcard(value);
                    } else if (name.equals("insurance")) {
                        worker.setInsurance(value);
                    } else if (name.equals("language")) {
                        worker.setLanguage(value);
                    } else if (name.equals("status")) {
                        worker.setStatus(value);
                    } else if (name.equals("marital")) {
                        worker.setMarital(value);
                    } else if (name.equals("license")) {
                        worker.setLicense(value);
                    } else if (name.equals("check_up")) {
                        worker.setCheck_up(value);
                    } else if (name.equals("check_up_time")) {
                        worker.setCheck_up_time(value);
                    } else if (name.equals("skill")) {
                        worker.setSkill(value);
                    } else if (name.equals("introduction")) {
                        worker.setIntroduction(value);
                    } else if (name.equals("req_time")) {
                        worker.setReq_time(value);
                    } else if (name.equals("req_pay")) {
                        worker.setReq_pay(value);
                    } else if (name.equals("stay_room")) {
                        worker.setStay_room(value);
                    } else if (name.equals("food")) {
                        worker.setFood(value);
                    } else if (name.equals("entry_time")) {
                        worker.setEntry_time(value);
                    } else {

                    }
                } else {//为上传文件，则调用item.write方法写文件
                    String value = item.getName();
                    int start = value.lastIndexOf("\\");
                    String filename = value.substring(start + 1);
                    worker.setPhoto(filename);
                    item.write(new File(path, filename));
                }
            }
            //把数据添加到表中
            boolean result = workerService.addWorker(worker);
            if (result){
                response.sendRedirect("ny/rlzy/grxx_xz.jsp");
            }else {
                request.setAttribute("info","添加失败");
                request.getRequestDispatcher("ny/rlzy/grxx_xz.jsp").forward(request,response);
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}











/*
worker_number;company_number;gender;idnumber;worker_name;birthday;age;height;mobile_phone;
telephone;work_type;work_time;disadvantage;photo;address;current_address;bankcard;
insurance;language;status;marital;license;check_up;check_up_time;skill;
introduction;req_time;req_pay;stay_room;food;entry_time;belong;
*/