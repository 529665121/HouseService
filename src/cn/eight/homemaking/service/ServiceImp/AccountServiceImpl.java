package cn.eight.homemaking.service.ServiceImp;

import cn.eight.homemaking.dao.AccountDao;
import cn.eight.homemaking.pojo.Account;
import cn.eight.homemaking.service.AccountService;

import java.util.List;

public class AccountServiceImpl implements AccountService {
    private AccountDao accountDao=new AccountDao();
    @Override
    public boolean checkAccount(Account account) {
        return accountDao.queryAccount(account);
    }

    @Override
    public boolean addUser(Account account) {
        return accountDao.insertAccount(account);
    }

    @Override
    public List<Account> findUser(Account account,int currentPage,int pageSize) {
        return accountDao.queryAccount(account,currentPage,pageSize);
    }

    @Override
    public int totalRecord(Account account) {
        return accountDao.queryTotalRecord(account);
    }

    @Override
    public boolean modUser(Account account) {
        return accountDao.updateAccount(account);
    }
}
