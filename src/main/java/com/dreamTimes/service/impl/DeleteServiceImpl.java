package com.dreamTimes.service.impl;

import com.dreamTimes.dao.GoodsDao;
import com.dreamTimes.dao.TypeDao;
import com.dreamTimes.service.DeleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class DeleteServiceImpl implements DeleteService {
    @Autowired
    private GoodsDao goodsDao;
    @Autowired
    private TypeDao typeDao;
    @Override
    @Transactional
    public void deleteByTname(String tname) {
        goodsDao.deleteByTname(tname);
        typeDao.deleteByTname(tname);
    }
}
