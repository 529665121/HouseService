package cn.eight.homemaking.service.ServiceImp;

import cn.eight.homemaking.dao.WorkerDao;
import cn.eight.homemaking.pojo.Worker;
import cn.eight.homemaking.service.WorkerService;

import java.util.List;

public class WorkerServiceImpl implements WorkerService {
    private WorkerDao workerDao=new WorkerDao();

    @Override
    public boolean addWorker(Worker worker) {
        return workerDao.insertWorker(worker);
    }

    @Override
    public List<Worker> findWorker(Worker worker,int currentPage,int pageSize) {
        return workerDao.queryWorker(worker,currentPage,pageSize);
    }

    @Override
    public List<Worker> higherFindWorker(Worker worker,int currentPage,int pageSize) {
        return workerDao.higherQueryWorker(worker,currentPage,pageSize);
    }

    @Override
    public int findTotalRecording(Worker worker) {
        return workerDao.queryTotalRecording(worker);
    }

    @Override
    public List<Worker> seeWorker(Worker worker) {
        return workerDao.QueryDescWorker(worker);
    }

    @Override
    public List<Worker> seenWorker(Worker worker) {
        return workerDao.QueryDescribeWorker(worker);
    }

    @Override
    public boolean modWorker(Worker worker) {
        return workerDao.updateWorker(worker);
    }


}
