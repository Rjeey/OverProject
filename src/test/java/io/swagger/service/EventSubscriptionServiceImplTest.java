package io.swagger.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.configuration.HibernateXMLConfTest;
import io.swagger.model.EventSubscription;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import java.io.Serializable;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        classes = {HibernateXMLConfTest.class},
        loader = AnnotationConfigContextLoader.class)
@Transactional
public class EventSubscriptionServiceImplTest {

    @MockBean
    ObjectMapper objectMapper;
    @MockBean
    HttpServletRequest httpServletRequest;

    @Resource
    EventSubscriptionServiceImpl objUnderTest;



    private static EventSubscription eventSubscription(String prefix){
        EventSubscription eventSub = new EventSubscription();
        eventSub.setCallback("CallBack: " + prefix );
        eventSub.setQuery("Query: " + prefix);

        return eventSub;
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void saveAndDelete(){
     EventSubscription eventSub = eventSubscription("1");
     EventSubscription eventSub2 = eventSubscription("2");
     EventSubscription eventSub3 = eventSubscription("3");

     objUnderTest.save(eventSub);
     objUnderTest.save(eventSub2);
     objUnderTest.save(eventSub3);

     Serializable id = eventSub.getId();
     System.out.println("Id of first Subscription " + id);
     assertNotNull("This is Sub",id);
     Serializable id2 = eventSub2.getId();
     assertNotNull("This is Sub2",id2);
     Serializable id3 = eventSub3.getId();
     assertNotNull("This is Sub3",id3);

     objUnderTest.delete(id);
     objUnderTest.delete(id3);
    }
}