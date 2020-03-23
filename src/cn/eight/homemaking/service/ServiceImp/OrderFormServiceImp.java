package cn.eight.homemaking.service.ServiceImp;

import cn.eight.homemaking.dao.OrderFormDao;
import cn.eight.homemaking.service.OrderFormService;
import cn.eight.homemaking.pojo.OrderForm;

import java.util.List;

public class OrderFormServiceImp implements OrderFormService {
    public OrderFormDao orderformDao;

    public OrderFormServiceImp() {
        orderformDao=new OrderFormDao();
    }

    @Override
    public List<OrderForm> findOrderFormList() {
        return  orderformDao.inquiryOrderFormList();
    }
}
