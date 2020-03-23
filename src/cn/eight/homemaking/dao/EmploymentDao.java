package cn.eight.homemaking.dao;

import cn.eight.homemaking.pojo.*;
import cn.eight.homemaking.util.DbPool;
import com.sun.org.apache.bcel.internal.generic.DDIV;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmploymentDao {
    int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Object> getNameByEmployer() {
        String sql = "select employer_name from employer  ";
        Connection con = DbPool.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;
        BasicDao dao = new BasicDao();
        List<Object> list = new ArrayList<Object>();
        try{
            pst = con.prepareStatement(sql);
            rs = dao.execQuery(pst);
            while (rs.next()&&rs!=null){
                String name = rs.getString(1);
                list.add(name);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dao.releaseResource(con,rs,pst);
        }
        return null;
    }

    public List<Object> getNameByWorker() {
        String sql = "select worker_name from worker  ";
        Connection con = DbPool.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;
        BasicDao dao = new BasicDao();
        List<Object> list = new ArrayList<Object>();
        try{
            pst = con.prepareStatement(sql);
            rs = dao.execQuery(pst);
            while (rs.next()&&rs!=null){
                String name = rs.getString(1);
                list.add(name);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dao.releaseResource(con,rs,pst);
        }
        return null;
    }


    public Employer getEmployer(String name) {
        String sql = "select * from employer where employer_name = ? ";
        Connection con = DbPool.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;
        BasicDao dao = new BasicDao();

        try{
            pst = con.prepareStatement(sql);
            rs = dao.execQuery(pst,name);
            Employer employer = new Employer();
            while (rs.next()&&rs!=null){
                String employer_number = Integer.valueOf(rs.getInt(1)).toString();
                String company_number = Integer.valueOf(rs.getInt(2)).toString();
                String employer_name = rs.getString(3);
                String gender= rs.getString(4);
                String age = Integer.valueOf(rs.getString(5)).toString();
                String nation = rs.getString(6);
                String hometown = rs.getString(7);
                String education = rs.getString(8);
                String idnumber = rs.getString(9);
                String worker_unit = rs.getString(10);
                String profession = rs.getString(11);
                String contract = rs.getString(12);
                String period = rs.getString(13);
                String telephone = rs.getString(14);
                String house = rs.getString(15);
                String address = rs.getString(16);
                String service_address = rs.getString(17);
                String home_current_address = rs.getString(18);
                String home_people_number = rs.getString(19);
                String home_service = rs.getString(20);
                String home_size = rs.getString(21);
                String home_food = rs.getString(22);
                String home_other = rs.getString(23);
                String max_pay = Float.valueOf(rs.getFloat(24)).toString();
                String min_pay = Float.valueOf(rs.getFloat(25)).toString();
                String claim = rs.getString(26);
                String manager = rs.getString(27);
                String check_in_time = rs.getString(28);
                employer.setEmployer_number(employer_number);
                employer.setCompany_number(company_number);
                employer.setEmployer_name(employer_name);
                employer.setGender(gender);
                employer.setAge(age);
                employer.setNation(nation);
                employer.setHometown(hometown);
                employer.setEducation(education);
                employer.setIdnumber(idnumber);
                employer.setWorker_unit(worker_unit);
                employer.setProfession(profession);
                employer.setContract(contract);
                employer.setPeriod(period);
                employer.setTelephone(telephone);
                employer.setHouse(house);
                employer.setAddress(address);
                employer.setService_address(service_address);
                employer.setHome_current_address(home_current_address);
                employer.setHome_people_number(home_people_number);
                employer.setHome_service(home_service);
                employer.setHome_size(home_size);
                employer.setHome_food(home_food);
                employer.setHome_other(home_other);
                employer.setMax_pay(max_pay);
                employer.setMin_pay(min_pay);
                employer.setClaim(claim);
                employer.setManager(manager);
                employer.setCheck_in_time(check_in_time);
            }
            return employer;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dao.releaseResource(con,rs,pst);
        }
        return null;
    }

    public Worker getWorker(String name) {
        String sql = "select * from worker where worker_name = ? ";
        Connection con = DbPool.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;
        BasicDao dao = new BasicDao();
        try {
            pst = con.prepareStatement(sql);
            rs = dao.execQuery(pst, name);
            Worker worker = null;
            while (rs.next() && rs != null) {
                int worker_number = rs.getInt(1);
                int company_number = rs.getInt(2);
                String worker_name = rs.getString(3);
                String gender = rs.getString(4);
                String idnumber = rs.getString(5);
                String birthday = rs.getString(6);
                int age = rs.getInt(7);
                int height = rs.getInt(8);
                String mobile_phone = rs.getString(9);
                String telephone = rs.getString(10);
                String work_type = rs.getString(11);
                String work_time = rs.getString(12);
                String disadvantage = rs.getString(13);
                String photo = rs.getString(14);
                String address = rs.getString(15);
                String current_address = rs.getString(16);
                String bankcard = rs.getString(17);
                String insurance = rs.getString(18);
                String language = rs.getString(19);
                String status = rs.getString(20);
                String marital = rs.getString(21);
                String license = rs.getString(22);
                String check_up = rs.getString(23);
                String check_up_time = rs.getString(24);
                String skill = rs.getString(25);
                String introduction = rs.getString(26);
                String req_time = rs.getString(27);
                String req_pay = rs.getString(28);
                String stay_room = rs.getString(29);
                String food = rs.getString(30);
                String entry_time = rs.getString(31);
                int belong = rs.getInt(32);
                worker = new Worker(worker_number, company_number, worker_name, gender, idnumber, birthday, age, height, mobile_phone, telephone, work_type, work_time, disadvantage, photo, address, current_address, bankcard, insurance, language, status, marital, license, check_up, check_up_time, skill, introduction, req_time, req_pay, stay_room, food, entry_time, belong);
            }
            return worker;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dao.releaseResource(con, rs, pst);
        }
        return null;
    }

    public void insertContract(Contract contract) {
        String sql = "INSERT INTO contract(company_number,employer_number,worker_number,manager_number,period,status_,pay,employment_type,referral_fee,closing_date) VALUES (?,?,?,?,?,?,?,?,?,?)";
        Connection con = DbPool.getConnection();
        PreparedStatement pst = null;
        BasicDao dao = new BasicDao();
        try {
            con.setAutoCommit(false);
            pst = con.prepareStatement(sql);
            dao.execUpdate(pst, contract.getCompany_number(), contract.getEmployer_number(), contract.getWorker_number(), contract.getManager_number(), contract.getPeriod(), contract.getStatus_(), contract.getPay(), contract.getEmployment_type(), contract.getReferral_fee(), contract.getColsing_date());
            con.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dao.releaseResource(con, null, pst);
        }
    }

    public List<Ddgl> getDdgl(int page) {
        String sql = "select e.employer_name,e.telephone,w.worker_name,w.mobile_phone,c.pay,c.employment_type,c.status_,c.contract_number from employer e,worker w,contract c where e.employer_number = c.employer_number and c.worker_number = w.worker_number limit ?,5";
        Connection con = DbPool.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;
        BasicDao dao = new BasicDao();
        try {
            pst = con.prepareStatement(sql);
            rs = dao.execQuery(pst,page);
            List<Ddgl> list = new ArrayList<Ddgl>();
            int i = 0;
            while (rs.next() && rs != null) {
                i++;
                String e_name = rs.getString(1);
                String e_telephone = rs.getString(2);
                String w_name = rs.getString(3);
                String w_telephone = rs.getString(4);
                String pay = rs.getString(5);
                String type = rs.getString(6);
                String status = rs.getString(7);
                String dd_number = rs.getString(8);
                Ddgl ddgl = new Ddgl(e_name,e_telephone,w_name,w_telephone,pay,type,status,dd_number);
                list.add(ddgl);
            }
            setCount(i);
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dao.releaseResource(con, rs, pst);
        }
        return null;
    }

    public EmployerDd queryAllCustomer(String name){
        String sql = "select * from employer e,contract c where e.employer_number = c.employer_number and employer_name = ? ";
        Connection con = DbPool.getConnection();
        PreparedStatement pst =null;
        BasicDao dao = new BasicDao();
        ResultSet rs = null;
        EmployerDd employer = new EmployerDd();
        try{
            pst = con.prepareStatement(sql);
            rs= dao.execQuery(pst,name);
            while (rs.next()&&rs!=null) {
                String employer_number = Integer.valueOf(rs.getInt(1)).toString();
                String company_number = Integer.valueOf(rs.getInt(2)).toString();
                String employer_name = rs.getString(3);
                String gender= rs.getString(4);
                String age = Integer.valueOf(rs.getString(5)).toString();
                String nation = rs.getString(6);
                String hometown = rs.getString(7);
                String education = rs.getString(8);
                String idnumber = rs.getString(9);
                String worker_unit = rs.getString(10);
                String profession = rs.getString(11);
                String contract = rs.getString(12);
                String per = rs.getString(13);
                String telephone = rs.getString(14);
                String house = rs.getString(15);
                String address = rs.getString(16);
                String service_address = rs.getString(17);
                String home_current_address = rs.getString(18);
                String home_people_number = rs.getString(19);
                String home_service = rs.getString(20);
                String home_size = rs.getString(21);
                String home_food = rs.getString(22);
                String home_other = rs.getString(23);
                String max_pay = Float.valueOf(rs.getFloat(24)).toString();
                String min_pay = Float.valueOf(rs.getFloat(25)).toString();
                String claim = rs.getString(26);
                String manager = rs.getString(34);
                String check_in_time = rs.getString(35);
                String  period= rs.getString(36);
                String  status= rs.getString(37);
                String  fee= rs.getString(40);
                String c_number = rs.getString(30);
                employer.setC_number(c_number);
                employer.setPeriods(period);
                employer.setStatus(status);
                employer.setFee(fee);
                employer.setEmployer_number(employer_number);
                employer.setCompany_number(company_number);
                employer.setEmployer_name(employer_name);
                employer.setGender(gender);
                employer.setAge(age);
                employer.setNation(nation);
                employer.setHometown(hometown);
                employer.setEducation(education);
                employer.setIdnumber(idnumber);
                employer.setWorker_unit(worker_unit);
                employer.setProfession(profession);
                employer.setContract(contract);
                employer.setPeriod(per);
                employer.setTelephone(telephone);
                employer.setHouse(house);
                employer.setAddress(address);
                employer.setService_address(service_address);
                employer.setHome_current_address(home_current_address);
                employer.setHome_people_number(home_people_number);
                employer.setHome_service(home_service);
                employer.setHome_size(home_size);
                employer.setHome_food(home_food);
                employer.setHome_other(home_other);
                employer.setMax_pay(max_pay);
                employer.setMin_pay(min_pay);
                employer.setClaim(claim);
                employer.setManager(manager);
                employer.setCheck_in_times(check_in_time);
            }
            return employer;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dao.releaseResource(con,rs,pst);
        }
        return null;
    }

    public void updateContract(Contract contract) {
        String sql = "update contract set company_number = ?,employer_number= ?,worker_number= ?,manager_number= ?,period= ?,status_= ?,pay= ?,employment_type= ?,referral_fee= ?,closing_date=? where contract_number = ?";
        Connection con = DbPool.getConnection();
        PreparedStatement pst = null;
        BasicDao dao = new BasicDao();
        try {
            con.setAutoCommit(false);
            pst = con.prepareStatement(sql);
            dao.execUpdate(pst, contract.getCompany_number(), contract.getEmployer_number(), contract.getWorker_number(), contract.getManager_number(), contract.getPeriod(), contract.getStatus_(), contract.getPay(), contract.getEmployment_type(), contract.getReferral_fee(), contract.getColsing_date(),contract.getContract_number());
            con.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dao.releaseResource(con, null, pst);
        }
    }

    public List<Ddgl> getDdglByOther(String employer, String check_in_time, String c_time, String worker,String select) {
        Connection con = DbPool.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;
        BasicDao dao = new BasicDao();
        String sql = "select e.employer_name,e.telephone,w.worker_name,w.mobile_phone,c.pay,c.employment_type,c.status_,c.contract_number from employer e,worker w,contract c where e.employer_number = c.employer_number and c.worker_number = w.worker_number ";
        if (employer!=""){
            sql=sql+" and e.employer_name =  '"+employer +"'";
        }
        if (check_in_time!=""){
            sql = sql + " and c.check_in_time > '"+check_in_time +"'";
        }
        if (c_time!=""){
            sql = sql + " and c.check_in_time < '"+c_time +"'";
        }
        if (worker!=""){
            sql = sql + " and w.worker_name = '"+ worker+"'";
        }
        if (!select.equals("请选择")) {
            sql = sql + " and c.status_ = '"+select+"'";
        }

        try {
            pst = con.prepareStatement(sql);
            rs = dao.execQuery(pst);
            List<Ddgl> list = new ArrayList<Ddgl>();
            while (rs.next() && rs != null) {
                String e_name = rs.getString(1);
                String e_telephone = rs.getString(2);
                String w_name = rs.getString(3);
                String w_telephone = rs.getString(4);
                String pay = rs.getString(5);
                String type = rs.getString(6);
                String status = rs.getString(7);
                String dd_number = rs.getString(8);
                Ddgl ddgl = new Ddgl(e_name,e_telephone,w_name,w_telephone,pay,type,status,dd_number);
                list.add(ddgl);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dao.releaseResource(con, rs, pst);
        }
        return null;
    }

    public List<Worker> selectWorker(String name, String gender, String age1, String age2, String worker_time, String education, String hobby_sql, String lauge_sql, String otherLauge, String status, String status_, String marriage, String marriage_, String license_sql, String skills_sql) {
        Connection con = DbPool.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;
        BasicDao dao = new BasicDao();
        String sql = "select worker_number,company_number,worker_name,gender,idnumber,birthday,age,height,mobile_phone,telephone,work_type,work_time,disadvantage,photo,address,current_address,bankcard,insurance,language,status,marital,license,check_up,check_up_time,skill,introduction,req_time,req_pay,stay_room,food,entry_time,belong from worker ";
        String sqlOther ="";
        if (name!=""){
            sqlOther += "  worker_name = '"+name+"' and";
        }if (gender!=null){
            sqlOther += "  gender = '"+ gender +"' and";
        }if (age1!=""){
            sqlOther += "  age > " +age1 +" and";
        }if (age2!=""){
            sqlOther += " age < " +age2+" and";
        }if (worker_time!=""){
            sqlOther += " work_time = '" +worker_time+"' and";
    /*    }if (education!=""){
            sqlOther+= " and education='"+ education+"'";
        }if (hobby_sql!=""){
     */
        }if (lauge_sql!=""){
            sqlOther+=" "+lauge_sql;
        }if (otherLauge!=""){
            sqlOther+= " language like '%"+otherLauge+"%' and";
        }if (status!=null){
            sqlOther+=" status =  '"+ status +"' and";
        }if (status_!=""){
            sqlOther+=" status= '"+ status_ +"' and";
        }if (marriage!=null){
            sqlOther+=" marital='"+marriage+"' and";
        }if (marriage_!=""){
            sqlOther+=" marital='"+marriage_+"' and";
        }if (license_sql!=""){
            sqlOther+=" "+ license_sql;
        }if (skills_sql!=""){
            sqlOther+=" "+skills_sql;
        }
        if (sqlOther!=""){
            int and = sqlOther.lastIndexOf("and");
            sqlOther = sqlOther.substring(0,and);
            sql = sql+" where "+sqlOther;
        }
        try {
            pst = con.prepareStatement(sql);
            con.setAutoCommit(false);
            rs = dao.execQuery(pst);
            List<Worker> workerList=new ArrayList<>();
            while (rs.next() && rs != null) {
                    Worker worker1=new Worker();
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
            con.commit();
            return workerList;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dao.releaseResource(con, rs, pst);
        }
        return null;
    }
}

