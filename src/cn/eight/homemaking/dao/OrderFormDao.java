package cn.eight.homemaking.dao;

import cn.eight.homemaking.util.DbPool;
import cn.eight.homemaking.pojo.OrderForm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderFormDao {
    public  List<OrderForm> inquiryOrderFormList(){
        ResultSet rs=null;
        PreparedStatement pst=null;
        Connection con = DbPool.getConnection();
        List<OrderForm> list=new ArrayList<>();
        BasicDao dao = new BasicDao();
        String sql="select O.orderform_number,C.company_name,O.orderform_consumetype,O.orderform_consumecount,O.orderform_consumedate from company C,orderform O where C.company_number=O.orderform_number" ;
        try{
            pst = con.prepareStatement(sql);
            rs = dao.execQuery(pst);
            while (rs.next()&&rs!=null){
                OrderForm orf=new OrderForm();

                orf.setOrder_number(Integer.valueOf(rs.getString(1)));
                orf.setCompany_name(rs.getString(2));
                orf.setConsume_type(rs.getString(3));
                orf.setConsume_count(Integer.valueOf(rs.getString(4)));
                orf.setConsume_time(rs.getString(5));

                list.add(orf);
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
