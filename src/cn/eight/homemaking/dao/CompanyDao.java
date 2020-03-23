package cn.eight.homemaking.dao;

import cn.eight.homemaking.pojo.Company;
import cn.eight.homemaking.util.DbPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CompanyDao {
    private BasicDao dao=new BasicDao();
    //新增
    public boolean insertCompany(Company company) {
        boolean result=false;
        String sql="insert into company(company_account,company_name,instruction) values(?,?,?)";
        Connection con = DbPool.getConnection();
        PreparedStatement pst =null;
        try {
            con.setAutoCommit(false);
            pst = con.prepareStatement(sql);
            dao.execUpdate(pst,company.getCompany_account(),company.getCompany_name(),company.getInstruction());
            con.commit();
            result=true;
        } catch (SQLException e) {
            try {
                con.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            dao.releaseResource(con,null,pst);
        }
        return result;
    }
    //查询
    public List<Company> queryCompany(Company company,int currentPage,int pageSize){
        String sql="select account ,company_name from company";
        if (company.getCompany_account()!=""){
            sql+=" where account='"+company.getCompany_account()+"' ";
        }
        if (company.getCompany_name()!=""){
            sql+=" where company_name ='"+company.getCompany_name()+"' ";
        }
        sql+=" limit ?,?";

        Connection con = DbPool.getConnection();
        PreparedStatement pst =null;
        ResultSet rs =null;
        try {
            pst = con.prepareStatement(sql);
            rs = dao.execQuery( pst,(currentPage-1)*pageSize,pageSize);
            List<Company> companyList=new ArrayList<>();
            while (rs!=null&&rs.next()){
                Company company1=new Company();
                company1.setCompany_account(rs.getString(1));
                company1.setCompany_name(rs.getString(2));
                companyList.add(company1);
            }
            return companyList;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dao.releaseResource(con,rs,pst);
        }
        return null;
    }

    //查询总记录数
    public int queryTotalRecord(Company company){
        int result=0;
        String sql="select count(*) from company";
        if (company.getCompany_account()!=""){
           sql+=" where company_account="+company.getCompany_account()+"'";
        }
        if (company.getCompany_name()!=""){
            sql+=" where company_name ='"+company.getCompany_name()+"'";
        }
        Connection con = DbPool.getConnection();
        PreparedStatement pst =null;
        ResultSet rs =null;
        try {
            pst = con.prepareStatement(sql);
            rs = dao.execQuery( pst,null);
            if (rs!=null&&rs.next()){
               result=rs.getInt(1);
            }
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dao.releaseResource(con,rs,pst);
        }
        return 0;
    }
    //删除
    public boolean deleteCompany(Company company){
        boolean result=false;
        String sql="delete from company where company_account=?";
        Connection con = DbPool.getConnection();
        PreparedStatement pst =null;
        try {
            con.setAutoCommit(false);
            pst = con.prepareStatement(sql);
            dao.execUpdate(pst,company.getCompany_account());
            con.commit();
            result=true;
        } catch (SQLException e) {
            try {
                con.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            dao.releaseResource(con,null,pst);
        }
        return  result;
    }

    //修改
    public boolean updateCompany(Company company){
        boolean result=false;
        String sql="update company set company_name=?,instruction=? where company_account=?";
        Connection con = DbPool.getConnection();
        PreparedStatement pst =null;
        try {
            con.setAutoCommit(false);
            pst = con.prepareStatement(sql);
            dao.execUpdate(pst,company.getCompany_name(),company.getInstruction(),company.getCompany_account());
            con.commit();
            result=true;
        } catch (SQLException e) {
            try {
                con.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            dao.releaseResource(con,null,pst);
        }
        return  result;
    }
}
