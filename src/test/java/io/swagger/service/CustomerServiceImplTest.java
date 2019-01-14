package io.swagger.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.configuration.HibernateXMLConfTest;
import io.swagger.model.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;
import org.threeten.bp.OffsetDateTime;
import org.threeten.bp.ZoneOffset;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {HibernateXMLConfTest.class}, loader = AnnotationConfigContextLoader.class)
@Transactional
public class CustomerServiceImplTest {

    @MockBean
    ObjectMapper objectMapper;

    @MockBean
    HttpServletRequest httpServletRequest;

    @Resource
    CustomerServiceImpl objForTest;


    public Customer customer(String prefix) {

        Customer customer = new Customer();
        customer.setName("Name: " + prefix);
        customer.setStatus("Status: " + prefix);
        customer.setStatusReason("StatusReason: " + prefix);
        customer.setValidFor(timePeriod());
        customer.setEngagedParty(partyRef());
        customer.setType(roleTypeRef());
        customer.setAccount(List.of(accountRef()));
        customer.setPaymentMethod(List.of(paymentMethodRef()));
        customer.setContactMedium(List.of(contactMedium()));
        customer.setCharacteristic(List.of(characteristic()));
        customer.setCreditProfile(List.of(creditProfile()));
        customer.setAgreement(List.of(agreementRef()));
        customer.setRelatedParty(List.of(relatedPartyRef()));
        return customer;
    }


    public TimePeriod timePeriod(){
        return new TimePeriod()
                .startDateTime(OffsetDateTime.now())
                .endDateTime(OffsetDateTime.of(2019,2,1,0,0,0,0, ZoneOffset.UTC));
    }


    public PartyRef partyRef(){
        return new PartyRef()
                .name("name")
                .href("localhost/ " + "6079")
                .description("description");
    }


    public RoleTypeRef roleTypeRef(){
        return new RoleTypeRef()
                .name("name")
                .partnershipHref("AnyPartnershipHref")
                .partnershipName("partnerShipName");
    }


    public AccountRef accountRef(){
        return  new AccountRef()
                .name("name")
                .description("Description")
                .href("href");
    }


    public PaymentMethodRef paymentMethodRef(){
        return new PaymentMethodRef()
                .name("name")
                .href("href");
    }

    public MediumCharacteristic mediumCharacteristic(){
        return new MediumCharacteristic()
                .city("city")
                .country("country")
                .emailAddress("email")
                .faxNumber("faxNumber")
                .phoneNumber("phoneNumber")
                .postCode("postCode")
                .stateOrProvince("stateOrProvince")
                .street1("street1")
                .street2("street2")
                .type("type");
    }


    public ContactMedium contactMedium(){
        return new ContactMedium()
                .type("Type")
                .preferred(false)
                .characteristic(mediumCharacteristic())
                .validFor(timePeriod());
    }

    public Characteristic characteristic(){
        return  new Characteristic()
                .name("Name")
                .value("value");
    }


    public CreditProfile creditProfile(){
        return  new CreditProfile()
                .creditProfileDate(OffsetDateTime.now())
                .creditRiskRating(5)
                .creditScore(5)
                .validFor(timePeriod());
    }


    public AgreementRef agreementRef(){
        return new AgreementRef()
                .name("name")
                .href("href");
    }


    public RelatedPartyRef relatedPartyRef(){
        return  new RelatedPartyRef()
                .name("name")
                .href("href")
                .role("role")
                .validFor(timePeriod());
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }


    @Test
    public void createAndDelete() {
        Customer customer = customer("1");
        Customer customer1 = customer("2");
        objForTest.save(customer);
        objForTest.save(customer1);

        Serializable id = customer.getId();
        assertNotNull(id);
        Serializable id2 = customer1.getId();
        assertNotNull(id2);

        objForTest.delete(id2);

    }

    @Test
    public void updateGetAndDelete(){
        Customer customer1 = customer("1");
        Customer customer2 = customer("2");

        objForTest.save(customer1);
        Serializable id = customer1.getId();
        assertNotNull(id);

        objForTest.save(customer2);
        Serializable id2 = customer2.getId();
        assertNotNull(id2);

        CustomerUpdate customerUpdate = new CustomerUpdate()
                .name("Artem")
                .statusReason("NiceStatus")
                .status("Normal")
                .type(new RoleTypeRef()
                .name("NewType")
                .partnershipHref("NewHref")
                .partnershipName("NewPartnerShip"));

        objForTest.update(id, customerUpdate);
        objForTest.update(id2,customerUpdate);

        Customer customer = objForTest.retrieve(id);
        assertNotNull(customer);
        assertEquals("Artem",customer.getName());
        assertEquals("NiceStatus", customer.getStatusReason());
        assertEquals("Normal", customer.getStatus());
        assertEquals("NewType", customer.getType().getName());
        assertEquals("NewHref", customer.getType().getPartnershipHref());
        assertEquals("NewPartnerShip", customer.getType().getPartnershipName());

        objForTest.delete(id);
    }
}