package io.swagger.dao;

import io.swagger.model.*;
import io.swagger.service.BaseServiceImpl;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
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
    @SuppressWarnings("unchecked")
    public Customer findById(String id) {
        List<Customer> customers = find();
        System.out.println("List of customers: "+customers);
        for (Customer customer : customers){
            if (customer.getId() == id){
                return customer;
            }
        }
        return null;
    }


    public void save(T item){
        openSession().saveOrUpdate(item);
    }

    public void delete(String id){
        log.info("Call delete()");
        Session session = openSession();
        Customer customer = session.get(Customer.class,id);
        session.delete(customer);

    }


}
