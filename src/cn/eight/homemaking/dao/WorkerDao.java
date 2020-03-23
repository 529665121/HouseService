package cn.eight.homemaking.dao;

import cn.eight.homemaking.pojo.Worker;
import cn.eight.homemaking.util.DbPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WorkerDao {
    private BasicDao dao = new BasicDao();

    //增加工人
    public boolean insertWorker(Worker worker) {
        boolean result = false;
        String sql = "insert into worker(worker_number,company_number,worker_name,gender,idnumber,birthday,age,height,mobile_phone,telephone,work_type,work_time,disadvantage,photo,address,current_address,bankcard,insurance,language,status,marital,license,check_up,check_up_time,skill,introduction,req_time,req_pay,stay_room,food,entry_time,belong) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        Connection con = DbPool.getConnection();
        PreparedStatement pst = null;
        try {
            con.setAutoCommit(false);
            pst = con.prepareStatement(sql);
            dao.execUpdate( pst, worker.getWorker_number(), worker.getCompany_number(), worker.getWorker_name(), worker.getGender(), worker.getIdnumber(), worker.getBirthday(), worker.getAge(), worker.getHeight(), worker.getMobile_phone(), worker.getTelephone(), worker.getWork_type(), worker.getWork_time(), worker.getDisadvantage(), worker.getPhoto(), worker.getAddress(), worker.getCurrent_address(), worker.getBankcard(), worker.getInsurance(), worker.getLanguage(), worker.getStatus(), worker.getMarital(), worker.getLicense(), worker.getCheck_up(), worker.getCheck_up_time(), worker.getSkill(), worker.getIntroduction(), worker.getReq_time(), worker.getReq_pay(), worker.getStay_room(), worker.getFood(), worker.getEntry_time(), worker.getBelong());
            con.commit();
            result = true;
        } catch (SQLException e) {
            try {
                con.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            dao.releaseResource(con, null, pst);
        }
        return result;
    }

    //查询工人信息
    public List<Worker> queryWorker(Worker worker, int currentPage, int pageSize) {
        String sql = "select worker_number,worker_name,gender,age,work_type,status,req_pay,entry_time from worker";
        if (worker.getWorker_name() != null) {
            sql += " where worker_name='" + worker.getWorker_name()+"' ";;
        }
        if (worker.getGender() != null) {
            sql += " where gender='" + worker.getGender()+" ";;
        }
        if (worker.getAge() != -1) {
            sql += " where age=" + worker.getAge()+" ";
        }
        if (!worker.getWork_type().equals("请选择")) {
            sql += " where work_type='" + worker.getWork_type()+"' ";;
        }
        if (!worker.getStatus().equals("请选择")) {
            sql += " where  status ='" + worker.getStatus()+"' ";
        }
        sql+=" limit ?,?";
        Connection con = DbPool.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = con.prepareStatement(sql);
            rs = dao.execQuery( pst, (currentPage - 1) * pageSize, pageSize);
            List<Worker> workerList = new ArrayList<>();
            while (rs != null && rs.next()) {
                Worker worker1 = new Worker();
                worker1.setWorker_number(rs.getInt(1));
                worker1.setWorker_name(rs.getString(2));
                worker1.setGender(rs.getString(3));
                worker1.setAge(rs.getInt(4));
                worker1.setWork_type(rs.getString(5));
                worker1.setStatus(rs.getString(6));
                worker1.setReq_pay(rs.getString(7));
                worker1.setEntry_time(rs.getString(8));
                workerList.add(worker1);
            }
            return workerList;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dao.releaseResource(con, rs, pst);
        }
        return null;
    }

    //高级查询工人信息
    public List<Worker> higherQueryWorker(Worker worker, int currentPage, int pageSize) {
        String sql = "select worker_number,worker_name,gender,age,work_type,status,req_pay,entry_time,belong from worker";
        if (worker.getWorker_name() != null) {
            sql += " where worker_name='" + worker.getWorker_name()+"' ";
        }
        if (worker.getGender() != null) {
            sql += "  where gender='" + worker.getGender()+"' ";
        }
        if (worker.getAge() != -1) {
            sql += " where age=" + worker.getAge()+" ";;
        }
        if (!worker.getWork_type().equals("请选择")) {
            sql += " where work_type='" + worker.getWork_type()+"' ";
        }
        if (!worker.getStatus().equals("请选择")) {
            sql += "  where  status ='" + worker.getStatus()+"' ";
        }
        sql+=" limit ?,?";

        Connection con = DbPool.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = con.prepareStatement(sql);
            rs = dao.execQuery(pst, (currentPage - 1) * pageSize, pageSize);
            List<Worker> workerList = new ArrayList<>();
            while (rs != null && rs.next()) {
                Worker worker1 = new Worker();
                worker1.setWorker_number(rs.getInt(1));
                worker1.setWorker_name(rs.getString(2));
                worker1.setGender(rs.getString(3));
                worker1.setAge(rs.getInt(4));
                worker1.setWork_type(rs.getString(5));
                worker1.setStatus(rs.getString(6));
                worker1.setReq_pay(rs.getString(7));
                worker1.setEntry_time(rs.getString(8));
                worker1.setBelong(rs.getInt(9));
                workerList.add(worker1);
            }
            return workerList;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dao.releaseResource(con, rs, pst);
        }
        return null;
    }

    //得到总记录数
    public int queryTotalRecording(Worker worker) {
        int result = 0;
        String sql = "select count(*) from worker";
        if (worker.getWorker_name() != null) {
            sql += " where worker_name='" + worker.getWorker_name()+"'";
        }
        if (worker.getGender() != null) {
            sql += " where gender='" + worker.getGender()+"'";
        }
        if (worker.getAge() != -1) {
            sql += " where age=" + worker.getAge();
        }
        if (!worker.getWork_type().equals("请选择")) {
            sql += " where work_type='" + worker.getWork_type()+"'";
        }
        if (!worker.getStatus().equals("请选择")) {
            sql += " where  status ='" + worker.getStatus()+"'";
        }
        Connection con = DbPool.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = con.prepareStatement(sql);
            rs = dao.execQuery( pst, null);
            if (rs != null && rs.next()) {
                result = rs.getInt(1);
            }
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dao.releaseResource(con, rs, pst);
        }
        return 0;
    }

    //grxx_ss.jsp 查看
    public List<Worker> QueryDescWorker(Worker worker) {
        String sql = "select worker_number,company_number,worker_name,gender,idnumber,birthday,age,height,mobile_phone,telephone,work_type,work_time,disadvantage,photo,address,current_address,bankcard,insurance,language,status,marital,license,check_up,check_up_time,skill,introduction,req_time,req_pay,stay_room,food,entry_time,belong from worker";
        if (worker.getWorker_name() != "") {
            sql += " where worker_name='" + worker.getWorker_name()+"'";
        }
        if (worker.getGender() != "") {
            sql += " where gender='" + worker.getGender()+"'";
        }
        if (worker.getAge() != -1) {
            sql += " where age=" + worker.getAge();
        }
        if (!worker.getWork_type().equals("请选择")) {
            sql += " where work_type='" + worker.getWork_type()+"'";
        }
        if (worker.getReq_pay()!="") {
            sql += " where and req_pay='" + worker.getReq_pay()+"'";
        }
        if (!worker.getStatus().equals("请选择")) {
            sql += " where  status ='" + worker.getStatus()+"'";
        }
        if (worker.getEntry_time()!="") {
            sql += " where entry_time ='" + worker.getEntry_time()+"'";
        }
        if (worker.getBelong() != -1) {
            sql += " where belong='" + worker.getBelong()+"'";
        }
        Connection con = DbPool.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = con.prepareStatement(sql);
            rs = dao.execQuery( pst, null);
            List<Worker> workerList = new ArrayList<>();
            while (rs != null && rs.next()) {
                Worker worker1 = new Worker();
                worker1.setWorker_number(rs.getInt(1));
                worker1.setCompany_number(rs.getInt(2));
                worker1.setWorker_name(rs.getString(3));
                worker1.setGender(rs.getString(4));
                worker1.setIdnumber(rs.getString(5));
                worker1.setBirthday(rs.getString(6));
                worker1.setAge(rs.getInt(7));
                worker1.setHeight(rs.getInt(8));
                worker1.setMobile_phone(rs.getString(9));
                worker1.setTelephone(rs.getString(10));
                worker1.setWork_type(rs.getString(11));
                worker1.setWork_time(rs.getString(12));
                worker1.setDisadvantage(rs.getString(13));
                worker1.setPhoto(rs.getString(14));
                worker1.setAddress(rs.getString(15));
                worker1.setCurrent_address(rs.getString(16));
                worker1.setBankcard(rs.getString(17));
                worker1.setInsurance(rs.getString(18));
                worker1.setLanguage(rs.getString(19));
                worker1.setStatus(rs.getString(20));
                worker1.setMarital(rs.getString(21));
                worker1.setLicense(rs.getString(22));
                worker1.setCheck_up(rs.getString(23));
                worker1.setCheck_up_time(rs.getString(24));
                worker1.setSkill(rs.getString(25));
                worker1.setIntroduction(rs.getString(26));
                worker1.setReq_time(rs.getString(27));
                worker1.setReq_pay(rs.getString(28));
                worker1.setStay_room(rs.getString(29));
                worker1.setFood(rs.getString(30));
                worker1.setEntry_time(rs.getString(31));
                worker1.setBelong(rs.getInt(32));
                workerList.add(worker1);
            }
            return workerList;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dao.releaseResource(con, rs, pst);
        }
        return null;
    }

    //grxx.jsp 查看
    public List<Worker> QueryDescribeWorker(Worker worker) {
        String sql = "select worker_number,company_number,worker_name,gender,idnumber,birthday,age,height,mobile_phone,telephone,work_type,work_time,disadvantage,photo,address,current_address,bankcard,insurance,language,status,marital,license,check_up,check_up_time,skill,introduction,req_time,req_pay,stay_room,food,entry_time,belong from worker";
        if (worker.getWorker_name() != "") {
            sql += " where worker_name='" + worker.getWorker_name()+"'";
        }
        if (worker.getGender() != "") {
            sql += " where gender='" + worker.getGender()+"'";
        }
        if (worker.getAge() != -1) {
            sql += " where age=" + worker.getAge();
        }
        if (!worker.getWork_type().equals("请选择")) {
            sql += " where work_type='" + worker.getWork_type()+"'";
        }
        if (worker.getReq_pay()!="") {
            sql += " where and req_pay='" + worker.getReq_pay()+"'";
        }
        if (!worker.getStatus().equals("请选择")) {
            sql += " where  status ='" + worker.getStatus()+"'";
        }
        if (worker.getEntry_time()!="") {
            sql += " where entry_time ='" + worker.getEntry_time()+"'";
        }
        Connection con = DbPool.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = con.prepareStatement(sql);
            rs = dao.execQuery( pst, null);
            List<Worker> workerList = new ArrayList<>();
            while (rs != null && rs.next()) {
                Worker worker1 = new Worker();
                worker1.setWorker_number(rs.getInt(1));
                worker1.setCompany_number(rs.getInt(2));
                worker1.setWorker_name(rs.getString(3));
                worker1.setGender(rs.getString(4));
                worker1.setIdnumber(rs.getString(5));
                worker1.setBirthday(rs.getString(6));
                worker1.setAge(rs.getInt(7));
                worker1.setHeight(rs.getInt(8));
                worker1.setMobile_phone(rs.getString(9));
                worker1.setTelephone(rs.getString(10));
                worker1.setWork_type(rs.getString(11));
                worker1.setWork_time(rs.getString(12));
                worker1.setDisadvantage(rs.getString(13));
                worker1.setPhoto(rs.getString(14));
                worker1.setAddress(rs.getString(15));
                worker1.setCurrent_address(rs.getString(16));
                worker1.setBankcard(rs.getString(17));
                worker1.setInsurance(rs.getString(18));
                worker1.setLanguage(rs.getString(19));
                worker1.setStatus(rs.getString(20));
                worker1.setMarital(rs.getString(21));
                worker1.setLicense(rs.getString(22));
                worker1.setCheck_up(rs.getString(23));
                worker1.setCheck_up_time(rs.getString(24));
                worker1.setSkill(rs.getString(25));
                worker1.setIntroduction(rs.getString(26));
                worker1.setReq_time(rs.getString(27));
                worker1.setReq_pay(rs.getString(28));
                worker1.setStay_room(rs.getString(29));
                worker1.setFood(rs.getString(30));
                worker1.setEntry_time(rs.getString(31));
                worker1.setBelong(rs.getInt(32));
                workerList.add(worker1);
            }
            return workerList;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dao.releaseResource(con, rs, pst);
        }
        return null;
    }

    public boolean updateWorker(Worker worker) {
        boolean result = false;
        String sql = "update worker set worker_number=?,company_number=?,gender=?,idnumber=?,birthday=?,age=?,height=?,mobile_phone=?,telephone=?,work_type=?,work_time=?,disadvantage=?,photo=?,address=?,current_address=?,bankcard=?,insurance=?,language=?,status=?,marital=?,license=?,check_up=?,check_up_time=?,skill=?,introduction=?,req_time=?,req_pay=?,stay_room=?,food=? where worker_name=?";
        Connection con = DbPool.getConnection();
        PreparedStatement pst = null;
        try {
            con.setAutoCommit(false);
            pst = con.prepareStatement(sql);
            dao.execUpdate( pst, worker.getWorker_number(), worker.getCompany_number(), worker.getGender(), worker.getIdnumber(), worker.getBirthday(), worker.getAge(), worker.getHeight(), worker.getMobile_phone(), worker.getTelephone(), worker.getWork_type(), worker.getWork_time(), worker.getDisadvantage(), worker.getPhoto(), worker.getAddress(), worker.getCurrent_address(), worker.getBankcard(), worker.getInsurance(), worker.getLanguage(), worker.getStatus(), worker.getMarital(), worker.getLicense(), worker.getCheck_up(), worker.getCheck_up_time(), worker.getSkill(), worker.getIntroduction(), worker.getReq_time(), worker.getReq_pay(), worker.getStay_room(), worker.getFood(), worker.getWorker_name());
            con.commit();
            result = true;
        } catch (SQLException e) {
            try {
                con.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            dao.releaseResource(con, null, pst);
        }
        return result;
    }
}
