package cn.eight.homemaking.dao;

import cn.eight.homemaking.pojo.Account;
import cn.eight.homemaking.pojo.Company;
import cn.eight.homemaking.pojo.Worker;
import cn.eight.homemaking.util.DbPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountDao {
    private BasicDao dao=new BasicDao();
    //登录
    public boolean queryAccount(Account account){
        boolean result=false;
        String sql="select count(*) from account where accountcode=? and password=?";
        Connection con = DbPool.getConnection();
        PreparedStatement pst =null;
        ResultSet rs =null;
        try {
            pst = con.prepareStatement(sql);
            rs = dao.execQuery(pst, account.getAccountcode(), account.getPassword());
            if (rs!=null&&rs.next()&&rs.getInt(1)==1){
                result=true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dao.releaseResource(con,rs,pst);
        }
        return  result;
    }

    //添加用户
    public boolean insertAccount(Account account){
        boolean result=false;
        String sql="insert into account(accountcode,username,email,password,enable,level,belong) values(?,?,?,?,?,?,?)";
        Connection con = DbPool.getConnection();
        PreparedStatement pst =null;
        try {
            con.setAutoCommit(false);
            pst = con.prepareStatement(sql);
            dao.execUpdate(pst,account.getAccountcode(),account.getUsername(),account.getEmail(),account.getPassword(),account.getEnable(),account.getLevel(),account.getBelong());
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

    //查询用户
    public List<Account> queryAccount(Account account,int currentPage,int pageSize){
        String sql="select account_id,accountcode,username,email,enable from account";
        if (account.getUsername()!=""){
            sql+=" where username = '"+account.getUsername()+"' limit ?,?";
        }else{
            sql+=" limit ?,?";
        }
        Connection con = DbPool.getConnection();
        PreparedStatement pst =null;
        ResultSet rs =null;
        try {
            pst = con.prepareStatement(sql);
            rs = dao.execQuery( pst,(currentPage-1)*pageSize,pageSize);
            List<Account> accountList=new ArrayList<>();
            while (rs!=null&&rs.next()){
                Account account1=new Account();
                account1.setAccount_id(rs.getInt(1));
                account1.setAccountcode(rs.getString(2));
                account1.setUsername(rs.getString(3));
                account1.setEmail(rs.getString(4));
                account1.setEnable(rs.getString(5));
                accountList.add(account1);
            }
            return accountList;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dao.releaseResource(con,rs,pst);
        }
        return null;
    }

    //查询总记录数
    public int queryTotalRecord(Account account){
        int result=0;
        String sql1="select count(*) from account";
        if (account.getUsername()!=""){
            sql1+=" where username='"+account.getUsername()+"'";
        }
        Connection con = DbPool.getConnection();
        PreparedStatement pst =null;
        ResultSet rs =null;
        try {
            pst = con.prepareStatement(sql1);
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

    //修改用户信息
    public boolean updateAccount(Account account){
        boolean result=false;
        String sql="update account set accountcode=?,username=?,email=?,password=?,enable=?,level=?,belong=? where account_id=?";
        Connection con = DbPool.getConnection();
        PreparedStatement pst =null;
        try {
            con.setAutoCommit(false);
            pst = con.prepareStatement(sql);
            dao.execUpdate(pst,account.getAccountcode(),account.getUsername(),account.getEmail(),account.getPassword(),account.getEnable(),account.getLevel(),account.getBelong(),account.getAccount_id());
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

    //删除用户信息

    /*

    //删除
    public boolean deleteCompany(Company company){
        boolean result=false;
        String sql="delete from company where company_account=?";
        Connection con = DbPool.getConnection();
        PreparedStatement pst =null;
        try {
            con.setAutoCommit(false);
            pst = con.prepareStatement(sql);
            dao.execUpdate(con,pst,company.getCompany_account());
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
            dao.execUpdate(con,pst,company.getCompany_name(),company.getInstruction(),company.getCompany_account());
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
    }*/


}
