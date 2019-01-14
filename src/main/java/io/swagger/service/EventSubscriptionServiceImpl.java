package io.swagger.service;

import io.swagger.dao.EventSubscriptionDaoImpl;
import io.swagger.model.EventSubscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

@Service
@Transactional
public class EventSubscriptionServiceImpl extends BaseServiceImpl  {

    private static Logger log = Logger.getLogger(EventSubscriptionServiceImpl.class.getName());

    @Autowired
    EventSubscriptionDaoImpl eventSubscriptionDao;

    @Transactional(propagation =  Propagation.REQUIRES_NEW)
    public void save(EventSubscription eventSubscription){
        log.info("EventSave():"+ eventSubscription);
        eventSubscriptionDao.save(eventSubscription);
    }

    @Transactional(propagation =  Propagation.REQUIRES_NEW)
    public void delete(Serializable id)
    {
        EventSubscription item =  eventSubscriptionDao.get(id);
        eventSubscriptionDao.delete(item);
    }


    @Override
    public List list() {
        return null;
    }
}
