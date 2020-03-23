package cn.eight.homemaking.dao;

import cn.eight.homemaking.pojo.CompanyForm;
import cn.eight.homemaking.util.DbPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CompanyFormDao {
    public  List<CompanyForm> queryCompanyFormList(){
        ResultSet rs=null;
        PreparedStatement pst=null;
        Connection con = DbPool.getConnection();
        List<CompanyForm> list=new ArrayList<>();
        BasicDao dao = new BasicDao();
        String sql="select company_number,company_account,company_name from company" ;
        try{
            pst = con.prepareStatement(sql);
            rs = dao.execQuery(pst);
            while (rs.next()&&rs!=null){
                CompanyForm cf=new CompanyForm();
                cf.setCompany_number(Integer.valueOf(rs.getString(1)));
                cf.setCompany_account(rs.getString(2));
                cf.setCompany_name(rs.getString(3));

                list.add(cf);

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
