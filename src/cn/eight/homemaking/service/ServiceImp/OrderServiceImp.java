package cn.eight.homemaking.service.ServiceImp;

import cn.eight.homemaking.dao.OrderDao;
import cn.eight.homemaking.service.OrderService;
import cn.eight.homemaking.pojo.OrderTest;

import java.util.List;

public class OrderServiceImp implements OrderService {
   public OrderDao orderDao;

    public OrderServiceImp() {
       orderDao=new OrderDao();
    }

    @Override
    public List<OrderTest> findOrderList() {
        return orderDao.queryOrderList();
    }
}
