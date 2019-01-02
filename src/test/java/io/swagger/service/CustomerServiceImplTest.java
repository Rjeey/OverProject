package io.swagger.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.configuration.HibernateXMLConfTest;
import io.swagger.model.Customer;
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
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = {HibernateXMLConfTest.class}, loader = AnnotationConfigContextLoader.class)
//@Transactional
public class CustomerServiceImplTest {

    @MockBean
    ObjectMapper objectMapper;

    @MockBean
    HttpServletRequest httpServletRequest;

    @Resource
    CustomerServiceImpl<Customer> objForTest;

    public Customer customer(String prefix) {

        Customer customer = new Customer();


        return customer;
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }


    @Test
    public void list() {
        Customer customer = customer("1");
        objForTest.save(customer);

        Serializable id = customer.getId();
        assertNotNull(id);

        List<Customer> customers = objForTest.list();
        assertEquals(1, customers.size());
        assertEquals(id, customers.get(0).getId());
    }
}