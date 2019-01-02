package io.swagger.service;

import io.swagger.dao.CustomerDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.logging.Logger;

@Service
@Transactional
public class CustomerServiceImpl <T> extends BaseServiceImpl {

    private static Logger log = Logger.getLogger(BaseServiceImpl.class.getName());

    @Autowired
    private CustomerDaoImpl<T> customerDao;


    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<T> list() {
        log.info("CustomerDaoImpl" + customerDao);
        return customerDao.find();
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void save(T item){
        customerDao.save(item);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void delete(T item){
        customerDao.delete(item);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW, value = "txManager")
    public void create(List<T> item){
        for (T t : item){
            customerDao.save(t);
        }
    }
}
