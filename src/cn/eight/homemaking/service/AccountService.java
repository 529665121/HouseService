package cn.eight.homemaking.service;

import cn.eight.homemaking.pojo.Account;

import java.util.List;

public interface AccountService {
    boolean checkAccount(Account account);
    boolean addUser(Account account);
    List<Account> findUser(Account account,int currentPage,int pageSize);
    int totalRecord(Account account);
    boolean modUser(Account account);
}
