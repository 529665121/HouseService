package cn.eight.homemaking.service.ServiceImp;

import cn.eight.homemaking.dao.DataDictionaryDao;
import cn.eight.homemaking.service.DataDictionaryService;
import cn.eight.homemaking.pojo.DataDictionary;

import java.util.List;

public class DataDictionaryServiceImp implements DataDictionaryService {
    public DataDictionaryDao datadictionaryDao;

    public DataDictionaryServiceImp() {
        datadictionaryDao=new DataDictionaryDao();
    }

    @Override
    public List<DataDictionary> findDataDictionaryList() {
        return datadictionaryDao.queryDataDictionary();
    }
}
