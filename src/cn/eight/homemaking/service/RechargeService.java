package cn.eight.homemaking.service;

import cn.eight.homemaking.pojo.RechargeQuery;
import cn.eight.homemaking.pojo.Xfcx;

import java.util.List;

public interface RechargeService {
    List<RechargeQuery> queryRecharge(int page);

    void insertRecrod(String money, String explain, String company_name,String opertor);

    void updateRecrod(String money, String company_name);

    List<Xfcx> queryRecord(int page);

    List<RechargeQuery> queryRechargeByOther(String company,String account);

    List<Xfcx> queryRecordByOther(String company, String account, String time_in, String time_out);

}
