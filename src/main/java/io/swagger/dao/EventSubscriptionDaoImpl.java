package io.swagger.dao;

import io.swagger.model.EventSubscription;
import io.swagger.service.BaseServiceImpl;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

@Repository
public class EventSubscriptionDaoImpl  extends BaseDaoImpl  {

    private static Logger log = Logger.getLogger(BaseServiceImpl.class.getName());

   private  Class<EventSubscription> tClass = EventSubscription.class;

   @Autowired
    public EventSubscriptionDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<EventSubscription> getAll() {
        log.info("Call getAll()");
        return openSession().createQuery("from Customer").list();
    }


    @Override
    public EventSubscription get(Serializable id) {
        log.info("Call find()");
        return openSession().find(tClass,id);

    }

}
