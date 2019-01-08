package io.swagger.service;

import io.swagger.dao.EventSubscriptionDaoImpl;
import io.swagger.model.EventSubscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EventSubscriptionServiceImpl  {

    @Autowired
    EventSubscriptionDaoImpl eventSubscriptionDao;

    @Transactional(propagation =  Propagation.REQUIRES_NEW)
    public void save(EventSubscription eventSubscription){
        eventSubscriptionDao.save(eventSubscription);
    }

    @Transactional(propagation =  Propagation.REQUIRES_NEW)
    public void delete(String id){
        eventSubscriptionDao.deleteEvent(id);
    }


}
