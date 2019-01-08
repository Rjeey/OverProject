package io.swagger.dao;

import io.swagger.model.*;
import io.swagger.service.BaseServiceImpl;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.OneToOne;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Repository
public class CustomerDaoImpl<Customer> extends BaseDaoImpl {

    Class<Customer> tClass;

    private static Logger log = Logger.getLogger(BaseServiceImpl.class.getName());

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
        log.info("Call find()");
        return openSession().find(tClass,id);

    }



//    public void delete(String id){
//        log.info("Call delete()");
//        Customer customer = openSession().get(tClass,id);
//        openSession().delete(customer);

}




