package cn.eight.homemaking.service;

import cn.eight.homemaking.pojo.Company;

import java.util.List;

public interface CompanyService {
    boolean addCompany(Company company);
    List<Company> findCompany(Company company,int currentPage,int pageSize);
    int findTotalRecord(Company company);
    boolean modCompany(Company company);
    boolean removeCompany(Company company);
}
