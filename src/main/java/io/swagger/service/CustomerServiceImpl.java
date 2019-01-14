package io.swagger.service;

import io.swagger.dao.CustomerDaoImpl;
import io.swagger.model.Customer;
import io.swagger.model.CustomerUpdate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

@Service
@Transactional
public class CustomerServiceImpl extends BaseServiceImpl {

    private static Logger log = Logger.getLogger(CustomerServiceImpl.class.getName());

    private final CustomerDaoImpl customerDao;

    @Autowired
    public CustomerServiceImpl(CustomerDaoImpl customerDao) {
        this.customerDao = customerDao;
    }


    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<Customer> list() {
        log.info("list() CustomerDaoImpl" + customerDao);
        return customerDao.getAll();
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void save(Customer customer) {
        log.info("save():" + customer);
        customerDao.save(customer);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void delete(Serializable id) {
        Customer item = customerDao.get(id);
        customerDao.delete(item);
    }

    public void update(Serializable id, CustomerUpdate customerUpdate) {
        Customer customer = customerDao.get(id);
        BeanUtils.copyProperties(customerUpdate, customer);
        customerDao.save(customer);
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public Customer retrieve(Serializable id) {
        return customerDao.get(id);
    }

}
