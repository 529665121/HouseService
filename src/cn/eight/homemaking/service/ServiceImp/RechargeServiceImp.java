package cn.eight.homemaking.service.ServiceImp;

import cn.eight.homemaking.dao.RechargeDao;
import cn.eight.homemaking.pojo.RechargeQuery;
import cn.eight.homemaking.pojo.Xfcx;
import cn.eight.homemaking.service.RechargeService;

import java.util.List;

public class RechargeServiceImp implements RechargeService {
    int count = 0;
    RechargeDao dao = new RechargeDao();

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public List<RechargeQuery> queryRecharge(int page) {
        List<RechargeQuery> rq= dao.queryRecharge(page);
        int count = dao.getCount();
        setCount(count);
        return rq;
    }

    @Override
    public void insertRecrod(String money, String explain, String company_name,String opertor) {
        dao.insertRecrod(money,explain,company_name,opertor);
    }

    @Override
    public void updateRecrod(String money, String company_name) {
        dao.updateRecrod(money,company_name);
    }

    @Override
    public List<Xfcx> queryRecord(int page) {
        List<Xfcx> list = dao.queryRecord(page);
        int count = dao.getCount();
        setCount(count);
        return list;
    }

    @Override
    public List<RechargeQuery> queryRechargeByOther(String company,String account) {
        List<RechargeQuery> rq= dao.queryRechargeByOther(company,account);
        return rq;
    }

    @Override
    public List<Xfcx> queryRecordByOther(String company, String account, String time_in, String time_out) {
        List<Xfcx> list = dao.queryRecordByOther(company,account,time_in,time_out);
        return list;
    }
}
