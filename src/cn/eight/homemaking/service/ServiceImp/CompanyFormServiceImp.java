package cn.eight.homemaking.service.ServiceImp;

import cn.eight.homemaking.dao.CompanyFormDao;
import cn.eight.homemaking.service.CompanyFormService;
import cn.eight.homemaking.pojo.CompanyForm;

import java.util.List;

public class CompanyFormServiceImp implements CompanyFormService {

    public CompanyFormDao companyformDao;

    public CompanyFormServiceImp() {
        companyformDao=new CompanyFormDao();
    }

    @Override
    public List<CompanyForm> findCompanyFormList() {
        return  companyformDao.queryCompanyFormList() ;
    }
}
