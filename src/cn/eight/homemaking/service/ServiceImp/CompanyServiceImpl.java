package cn.eight.homemaking.service.ServiceImp;

import cn.eight.homemaking.dao.CompanyDao;
import cn.eight.homemaking.pojo.Company;
import cn.eight.homemaking.service.CompanyService;

import java.util.List;

public class CompanyServiceImpl implements CompanyService {
    private CompanyDao companyDao=new CompanyDao();
    @Override
    public boolean addCompany(Company company) {
        return companyDao.insertCompany(company);
    }

    @Override
    public List<Company> findCompany(Company company,int currentPage,int pageSize) {
        return companyDao.queryCompany(company,currentPage,pageSize);
    }

    @Override
    public int findTotalRecord(Company company) {
        return companyDao.queryTotalRecord(company);
    }

    @Override
    public boolean modCompany(Company company) {
        return companyDao.updateCompany(company);
    }

    @Override
    public boolean removeCompany(Company company) {
        return companyDao.deleteCompany(company);
    }
}
