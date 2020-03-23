package cn.eight.homemaking.service.ServiceImp;

import cn.eight.homemaking.dao.EmploymentDao;
import cn.eight.homemaking.pojo.*;
import cn.eight.homemaking.service.EmploymentService;

import java.util.List;

public class EmploymentServiceImp implements EmploymentService {
    EmploymentDao dao = new EmploymentDao();
    int count= 0;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public List<Object> getNameByEmployer() {
        List<Object> nameByEmployer = dao.getNameByEmployer();
        return nameByEmployer;
    }

    @Override
    public List<Object> getNameByWorker() {
        List<Object> nameByWorker = dao.getNameByWorker();
        return nameByWorker;
    }

    @Override
    public Employer getEmployer(String name) {
       Employer employer = dao.getEmployer(name);
        return employer;
    }

    @Override
    public Worker getWorker(String name) {
        Worker worker = dao.getWorker(name);
        return worker;
    }

    @Override
    public void insertContract(Contract contract) {
        dao.insertContract(contract);
    }

    @Override
    public List<Ddgl> queryContract(int page) {
        List<Ddgl> list = dao.getDdgl(page);
        int count = dao.getCount();
        setCount(count);
        return list;
    }

    @Override
    public EmployerDd queryAll(String name) {
        EmployerDd employerDd = dao.queryAllCustomer(name);
        return employerDd;
    }

    @Override
    public void updateContract(Contract contract) {
        dao.updateContract(contract);
    }

    @Override
    public List<Ddgl> selectByOther(String employer, String check_in_time, String c_time, String worker,String select) {
        List<Ddgl> list = dao.getDdglByOther(employer,check_in_time,c_time,worker,select);
        return list;
    }

    @Override
    public List<Worker> selectWorker(String name, String gender, String age1, String age2, String worker_time, String education, String hobby_sql, String lauge_sql, String otherLauge, String status, String status_, String marriage, String marriage_, String license_sql, String skills_sql) {
        int count = dao.getCount();
        setCount(count);
        List<Worker> worker = dao.selectWorker(name,gender,age1,age2,worker_time,education,hobby_sql,lauge_sql,otherLauge,status,status_,marriage,marriage_,license_sql,skills_sql);

        return worker;
    }


}
