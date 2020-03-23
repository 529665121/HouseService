package cn.eight.homemaking.dao;
import cn.eight.homemaking.pojo.RechargeQuery;
import cn.eight.homemaking.pojo.Xfcx;
import cn.eight.homemaking.util.DbPool;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RechargeDao {
    int count = 0;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<RechargeQuery> queryRechargeByOther(String company, String account) {
        String sql="select * from recharge_card c,recharge_record r,company com where com.company_number = c.company_number and r.record_number = (select record_number from recharge_record order by recharge_time desc limit 0,1) ";
        if (company!=""){
            sql=sql+" and com.company_name = '"+company+"'";
        }
        if (account!=""){
            sql=sql+" and com.account = '"+account+"'";
        }
        Connection con = DbPool.getConnection();
        java.sql.PreparedStatement pst =null;
        BasicDao dao = new BasicDao();
        ResultSet rs = null;
        List<RechargeQuery> list = new ArrayList<RechargeQuery>();
        try{
            pst = con.prepareStatement(sql);
            rs= dao.execQuery(pst);
            while (rs.next()&&rs!=null){
                String company_name = rs.getString(15);
                String user_name = rs.getString(14);
                int recharge_times = rs.getInt(2);
                int charge = rs.getInt(3);
                int consume = rs.getInt(4);
                int blance = rs.getInt(5);
                int operator = rs.getInt(10);
                String explain = rs.getString(12);
                RechargeQuery rq = new RechargeQuery(company_name,user_name,recharge_times,charge,consume,blance,operator,explain);
                list.add(rq);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dao.releaseResource(con,rs,pst);
        }
        return null;
    }

    public List<RechargeQuery> queryRecharge(int page) {
        String sql="select * from recharge_card c,recharge_record r,company com where com.company_number = c.company_number and r.record_number = (select record_number from recharge_record order by recharge_time desc limit 0,1) limit ?,5 ";
        Connection con = DbPool.getConnection();
        java.sql.PreparedStatement pst =null;
        BasicDao dao = new BasicDao();
        ResultSet rs = null;
        List<RechargeQuery> list = new ArrayList<RechargeQuery>();
        try{
            pst = con.prepareStatement(sql);
            rs= dao.execQuery(pst,page);
            int i = 0;
            while (rs.next()&&rs!=null){
                i++;
                String company_name = rs.getString(15);
                String user_name = rs.getString(14);
                int recharge_times = rs.getInt(2);
                int charge = rs.getInt(3);
                int consume = rs.getInt(4);
                int blance = rs.getInt(5);
                int operator = rs.getInt(10);
                String explain = rs.getString(12);
                RechargeQuery rq = new RechargeQuery(company_name,user_name,recharge_times,charge,consume,blance,operator,explain);
                list.add(rq);
            }
            setCount(i);
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dao.releaseResource(con,rs,pst);
        }
        return null;
    }

    public void insertRecrod(String money, String explain, String company_name,String operator) {
        String sql1="select company_number from company where company_name = ?";
        String sql2="insert into recharge_record(company_number,recharge_amount,operator,recharge_time,recharge_explain) VALUES (?,?,?,?,?)";
        Connection con = DbPool.getConnection();
        PreparedStatement pst =null;
        PreparedStatement p =null;
        BasicDao dao = new BasicDao();
        ResultSet rs = null;
        int company_number = 0;
        try{
            pst = con.prepareStatement(sql1);
            rs = dao.execQuery(pst, company_name);
            while (rs.next()&&rs!=null){
                company_number = rs.getInt(1);
            }
            p=con.prepareStatement(sql2);
            Date date = new Date();
            SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String datenow = sf.format(date);
            dao.execUpdate(p,company_number,money,operator,datenow,explain);
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dao.releaseResource(null,null,p);
            dao.releaseResource(con,rs,pst);
        }
    }

    public void updateRecrod(String money, String company_name) {
        String sql1="select company_number from company where company_name = ?";
        String sql2="update recharge_card set recharge_times = recharge_times+1 , balance = balance+? where company_number = ?";
        Connection con = DbPool.getConnection();
        PreparedStatement pst =null;
        PreparedStatement p =null;
        BasicDao dao = new BasicDao();
        ResultSet rs = null;
        int company_number = 0;
        try{
            con.setAutoCommit(false);
            pst = con.prepareStatement(sql1);
            rs = dao.execQuery(pst, company_name);
            while (rs.next()&&rs!=null){
                company_number = rs.getInt(1);
            }
            p = con.prepareStatement(sql2);
            dao.execUpdate(p,money,company_number);
            con.commit();
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dao.releaseResource(null,null,p);
            dao.releaseResource(con,rs,pst);
        }
    }

    public List<Xfcx> queryRecord(int page) {
        String sql="select company_name,account,orderform_consumedate,orderform_consumecount from company c, orderform r where r.orderform_companynumber = c.company_number limit ?,5";
        Connection con = DbPool.getConnection();
        java.sql.PreparedStatement pst =null;
        BasicDao dao = new BasicDao();
        ResultSet rs = null;
        List<Xfcx> list = new ArrayList<>();
        try{
            pst = con.prepareStatement(sql);
            rs= dao.execQuery(pst,page);
            int i = 0;
            while (rs.next()&&rs!=null){
                i++;
                String company_name = rs.getString(1);
                String account = rs.getString(2);
                String record_time = rs.getString(3);
                String charge = rs.getString(4);
                list.add(new Xfcx(company_name,account,record_time,charge));
            }
            setCount(i);
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dao.releaseResource(con,rs,pst);
        }
        return null;
    }

    public List<Xfcx> queryRecordByOther(String company, String account, String time_in, String time_out) {
        String sql="select company_name,account,orderform_consumedate,orderform_consumecount from company c, orderform r where r.orderform_companynumber = c.company_number ";
        if (company!=""){
            sql=sql+" and com.company_name = '"+company+"'";
        }
        if (account!=""){
            sql=sql+" and com.account = '"+account+"'";
        }
        if (time_in!=""){
            sql = sql+" and record_time > '" + time_in+"'";
        }
        if (time_out!=""){
            sql = sql+" and record_time < '"+time_out+"'";
        }
        Connection con = DbPool.getConnection();
        java.sql.PreparedStatement pst =null;
        BasicDao dao = new BasicDao();
        ResultSet rs = null;
        List<Xfcx> list = new ArrayList<>();
        try{
            pst = con.prepareStatement(sql);
            rs= dao.execQuery(pst);
            while (rs.next()&&rs!=null){
                String company_name = rs.getString(1);
                String accoun = rs.getString(2);
                String record_time = rs.getString(3);
                String charge = rs.getString(4);
                list.add(new Xfcx(company_name,accoun,record_time,charge));
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dao.releaseResource(con,rs,pst);
        }
        return null;
    }
}
