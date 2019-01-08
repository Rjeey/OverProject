package io.swagger.service;

import io.swagger.dao.CustomerDaoImpl;
import io.swagger.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.logging.Logger;

@Service
@Transactional
public class CustomerServiceImpl  extends BaseServiceImpl {

    private static Logger log = Logger.getLogger(BaseServiceImpl.class.getName());

    @Autowired
    private CustomerDaoImpl<Customer>  customerDao;



    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<Customer> list() {
        log.info("CustomerDaoImpl" + customerDao);
        return customerDao.getAll();
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void save(Customer customer){
        customerDao.save(customer);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void delete(String  id){
        log.info("CustomerDaoImpl" + customerDao);
        customerDao.delete(id);
    }
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = true)
    public Customer retrieve(String  id){ return customerDao.get(id);}

    @Transactional(propagation = Propagation.REQUIRES_NEW, value = "txManager")
    public void create(Customer customer){

            customerDao.save(customer);
    }

    public void update(String id){
        customerDao.update(id);
    }
}
