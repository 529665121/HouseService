package cn.eight.homemaking.service;

import cn.eight.homemaking.pojo.Worker;

import java.util.List;

public interface WorkerService {
    boolean addWorker(Worker worker);
    List<Worker> findWorker(Worker worker,int currentPage,int pageSize);
    List<Worker> higherFindWorker(Worker worker,int currentPage,int pageSize);
    int findTotalRecording(Worker worker);
    List<Worker> seeWorker(Worker worker);
    List<Worker> seenWorker(Worker worker);
    boolean modWorker(Worker worker);
}
