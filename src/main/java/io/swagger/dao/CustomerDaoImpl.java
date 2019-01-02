package io.swagger.dao;

import io.swagger.model.*;
import io.swagger.service.BaseServiceImpl;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Repository
public class CustomerDaoImpl<T> extends BaseDaoImpl {

    private static Logger log = Logger.getLogger(BaseServiceImpl.class.getName());

    public CustomerDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List find() {
        log.info("Call find()");
        return openSession().createQuery("from Customer").list();

    }

    public void save(T item){
        openSession().saveOrUpdate(item);
    }

    public void delete(T item){
        openSession().delete(item);
    }


}
