package io.swagger.dao;

import io.swagger.model.Customer;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

@Repository
public class CustomerDaoImpl extends BaseDaoImpl {

    private static Logger log = Logger.getLogger(CustomerDaoImpl.class.getName());

    private Class<Customer> tClass = Customer.class;

    @Autowired
    public CustomerDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Customer> getAll() {
        log.info("Call getAll()");
        return openSession().createQuery("from Customer").list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public Customer get(Serializable id) {
        return openSession().find(tClass,id);

    }


}




