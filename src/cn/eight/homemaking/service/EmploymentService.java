package cn.eight.homemaking.service;

import cn.eight.homemaking.pojo.*;

import java.util.List;

public interface EmploymentService {
    List<Object> getNameByEmployer();

    List<Object> getNameByWorker();

    Employer getEmployer(String name);

    Worker getWorker(String name);

    void insertContract(Contract contract);

    List<Ddgl> queryContract( int page);

    EmployerDd queryAll(String name);

    void updateContract(Contract contract);


    List<Ddgl> selectByOther(String employer, String check_in_time, String c_time, String worker,String select);

    List<Worker> selectWorker(String name, String gender, String age1, String age2, String worker_time, String education, String hobby_sql, String lauge_sql, String otherLauge, String status, String status_, String marriage, String marriage_, String license_sql, String skills_sql);
}
