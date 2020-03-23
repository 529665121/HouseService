package cn.eight.homemaking.dao;

import cn.eight.homemaking.pojo.DataDictionary;
import cn.eight.homemaking.util.DbPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DataDictionaryDao {
    public List<DataDictionary> queryDataDictionary(){
        ResultSet rs=null;
    PreparedStatement pst=null;
    Connection con = DbPool.getConnection();
    List<DataDictionary> list=new ArrayList<>();
    BasicDao dao = new BasicDao();
    String sql="select bastic_id,bastic_name,bastic_type from basticdata  " ;
        try{
        pst = con.prepareStatement(sql);
        rs = dao.execQuery(pst);
        while (rs.next()&&rs!=null){
            DataDictionary dd=new DataDictionary();
            dd.setBastic_id(Integer.valueOf(rs.getString(1)));
            dd.setBastic_name(rs.getString(2));
            dd.setBastic_type(rs.getString(3));
            list.add(dd);

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
