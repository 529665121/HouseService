package cn.eight.homemaking.service.ServiceImp;

import cn.eight.homemaking.dao.QueryOrdersDao;
import cn.eight.homemaking.service.QueryOrdersService;
import cn.eight.homemaking.pojo.QueryOrders;

import java.util.List;

public class QueryOrdersServiceImp implements QueryOrdersService {
    public QueryOrdersDao queryordersDao;

    public QueryOrdersServiceImp() {
        queryordersDao=new QueryOrdersDao();
    }

    @Override
    public List<QueryOrders> findQueryOrdersList() {
        return queryordersDao.queryOrders();
    }
}
