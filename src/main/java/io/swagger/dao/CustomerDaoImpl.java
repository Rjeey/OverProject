package io.swagger.dao;

import io.swagger.model.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.threeten.bp.OffsetDateTime;

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


    public List<Customer> getAllForFilters(Serializable name,Serializable status, Serializable statusReason, OffsetDateTime  validForEndDateTime, OffsetDateTime  validForStartDateTime){
        log.info("Call getAllForFilter()");

        if (name != null){
            return getAllForName(name);
        }
        else if(status != null){
            return getAllForStatus(status);
        }
        else if(statusReason != null){
            return getAllForStatusReason(statusReason);
        }
        else if(validForEndDateTime != null){
            return getAllForEndTime(validForEndDateTime);
        }
        else if(validForStartDateTime != null){
            return getAllForStartTime(validForStartDateTime);
        }
        else
            return getAll();
    }



    @SuppressWarnings("unchecked")
    @Override
    public Customer get(Serializable id) {
        return openSession().find(tClass,id);
    }

    public List<Customer>getAllForName(Serializable name){
        log.info("Call getAllForName");
        return openSession().createQuery("from Customer where name = '"+name+"' ").list();
    }

    public List<Customer>getAllForStatus(Serializable status){
        log.info("Call getAllForStatus");
        return openSession().createQuery("from Customer where status = '"+status+"' ").list();
    }

    public List<Customer>getAllForField(String field){
        log.info("Call getAllForField");
        return openSession().createQuery("from Customer."+field+" ").list();
    }


    public List<Customer>getAllForStatusReason(Serializable statusReason){
        log.info("Call getAllForStatusReason");
        return openSession().createQuery("from Customer where statusReason = '"+statusReason+"' ").list();
    }

    public List<Customer>getAllForEndTime(OffsetDateTime validForEndDateTime){
        log.info("Call getAllForEndDateTime");
        return openSession().createQuery("from Customer where endDatTime = '"+validForEndDateTime+"' ").list();
    }

    public List<Customer>getAllForStartTime(OffsetDateTime validForStartDateTime){
        log.info("Call getAllForStartDateTime");
        return openSession().createQuery("from Customer where startDatTime = '"+validForStartDateTime+"' ").list();
    }

    public List<Customer>getAllForEnagatePartyName(String EngagedPartyName){
        log.info("Call getAllForEngagedPartyName");
        return openSession().createQuery("from Customer as c where c.engagedParty.name = '"+EngagedPartyName+"' ").list();
    }

    public List<Customer>getAllForTypeName(String TypeName){
        log.info("Call getAllTypeName");
        return openSession().createQuery("from Customer as c where c.type.name = '"+TypeName+"' ").list();
    }



}




