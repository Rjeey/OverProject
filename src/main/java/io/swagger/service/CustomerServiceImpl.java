package io.swagger.service;

import io.swagger.dao.CustomerDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class CustomerServiceImpl <T> extends BaseServiceImpl {

    private static Logger log = Logger.getLogger(BaseServiceImpl.class.getName());

    @Autowired
    private CustomerDaoImpl customerDao;


    @Override
    public List<T> list() {
        log.info("CustomerDaoImpl" + customerDao);
        return customerDao.find();
    }
}
