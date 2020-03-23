package cn.eight.homemaking.dao;

import cn.eight.homemaking.util.DbPool;
import cn.eight.homemaking.pojo.OrderTest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDao {
    public List<OrderTest> queryOrderList(){
        ResultSet rs=null;
        PreparedStatement pst=null;
        Connection con = DbPool.getConnection();
        List<OrderTest> list=new ArrayList<>();
        BasicDao dao = new BasicDao();
        String sql="select O.order_number, E.employer_name,O.interveningact, O.completiondate,W.worker_name,C.company_name from company C,employer E,orders O,worker W where C.company_number=E.company_number and C.company_number=W.company_number and O.woker_number=W.worker_number and O.employer_number=e.employer_number and O.company_number=C.company_number";
        try{
            pst = con.prepareStatement(sql);
            rs = dao.execQuery(pst);
            while (rs.next()&&rs!=null){
               OrderTest ot=new OrderTest();
               ot.setOrder_number(Integer.valueOf(rs.getString(1)));
               ot.setEmployer_name(rs.getString(2));
               ot.setInterveningact(Integer.valueOf(rs.getString(3)));
               ot.setCompletiondate(rs.getString(4));
               ot.setWorker_name(rs.getString(5));
               ot.setCompany_name(rs.getString(6));
               list.add(ot);
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


