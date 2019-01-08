package io.swagger.dao;

import io.swagger.model.Customer;
import io.swagger.model.EventSubscription;
import io.swagger.service.BaseServiceImpl;
import org.hibernate.SessionFactory;
import org.hibernate.validator.constraints.pl.REGON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

@Repository
public class EventSubscriptionDaoImpl <EventSubscription> extends BaseDaoImpl  {

    private static Logger log = Logger.getLogger(BaseServiceImpl.class.getName());

    Class<EventSubscription> tClass;

    @SuppressWarnings("unchecked")
    @Override
    public List<EventSubscription> getAll() {
        log.info("Call getAll()");
        return openSession().createQuery("from PartyAccount").list();
    }


    @Override
    public EventSubscription get(Serializable id) {
        log.info("Call find()");
        return openSession().find(tClass,id);

    }


    public void deleteEvent(String  id) {
        EventSubscription eventSubscription = openSession().byId(tClass).load(id);
        openSession().delete(eventSubscription);
    }
}
