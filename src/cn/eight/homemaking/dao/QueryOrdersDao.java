package cn.eight.homemaking.dao;

import cn.eight.homemaking.util.DbPool;
import cn.eight.homemaking.pojo.QueryOrders;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QueryOrdersDao {

    public List<QueryOrders> queryOrders(){
        ResultSet rs=null;
        PreparedStatement pst=null;
        Connection con = DbPool.getConnection();
        List<QueryOrders> list=new ArrayList<>();
        BasicDao dao = new BasicDao();
        String sql="select E.employer_name,E.gender,E.address,E.nation,E.hometown,E.education,E.idnumber,O.interveningact, W.worker_number,C.company_name,W.woker_name,W.birthday,O.expirydate,O.status from employer E,worker W,orders O,company C where C.company_number=E.company_number and C.company_number=W.company_number and O.woker_number=W.worker_number and O.employer_number=e.employer_number and O.company_number=C.company_number" ;
        try{
            pst = con.prepareStatement(sql);
            rs = dao.execQuery(pst);
            while (rs.next()&&rs!=null){
                QueryOrders qo=new QueryOrders();
                qo.setEmployer_name(rs.getString(1));
                qo.setGender(rs.getString(2));
                qo.setAge(Integer.valueOf(rs.getString(3)));
                qo.setNation(rs.getString(4));
                qo.setHometown(rs.getString(5));
             /*   dd.setBastic_id(Integer.valueOf(rs.getString(1)));
                dd.setBastic_name(rs.getString(2));*/
                qo.setEducation(rs.getString(6));
                qo.setIdnumber(Integer.valueOf(rs.getString(7)));
                qo.setInterveningact(Integer.valueOf(rs.getString(8)));
                qo.setWorker_number(Integer.valueOf(rs.getString(9)));
                qo.setCompany_name(rs.getString(10));
                qo.setWoker_name(rs.getString(11));
                qo.setBirthday(rs.getString(12));
                list.add(qo);

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
