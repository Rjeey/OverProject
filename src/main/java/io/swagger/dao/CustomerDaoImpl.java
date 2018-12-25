package io.swagger.dao;

import io.swagger.model.*;
import io.swagger.service.BaseServiceImpl;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Repository
public class CustomerDaoImpl <T> extends BaseDaoImpl {

    private static Logger log = Logger.getLogger(BaseServiceImpl.class.getName());

    @Override
    public List find() {
        createTestData();

        Session session = openSession();
        List<T> list = session.createQuery("from Customer").list();
        session.close();
        return list;

    }
    private void createTestData() {
        Session session = openSession();
        try {
            session.beginTransaction();
            session.saveOrUpdate(createCustomer("1"));
            session.saveOrUpdate(createCustomer("2"));
            session.saveOrUpdate(createCustomer("3"));
            session.getTransaction().commit();
        } catch (Exception e) {
            log.log(Level.SEVERE, "Error during creation of test data", e);
            if (session.getTransaction() != null) session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    private T createCustomer(String prefix) {
        Customer customer = new Customer();
        PartyRef partyRef = new PartyRef();
        AccountRef accountRef = new AccountRef();
        AgreementRef agreementRef = new AgreementRef();
        RelatedPartyRef relatedPartyRef = new RelatedPartyRef();
        PaymentMethodRef paymentMethodRef = new PaymentMethodRef();
        RoleTypeRef roleTypeRef = new RoleTypeRef();

        roleTypeRef.setName("NameRoleTypeRef: " + prefix);
        roleTypeRef.setPartnershipName("RoleTypeRefPartnershipName:" + prefix );

        paymentMethodRef.setName("PaymentMethodRefName: " + prefix);

        relatedPartyRef.setName("NameRelatedRef: " + prefix);
        relatedPartyRef.setRole("RoleRelatedRef: " + prefix);

        agreementRef.setName("NameAgreementRef: " + prefix);


        accountRef.setName("NameAccountRef: " + prefix);
        accountRef.setDescription("DescriptionAccountRef: " + prefix);

        partyRef.setName("NamePartyRef: " + prefix);
        partyRef.setDescription("DescriptionPartyRef: " + prefix);

        customer.setName("Name: "+ prefix);
        customer.setStatus("Status: " + prefix);
        customer.setStatusReason("StatusReason: " + prefix);
        customer.setEngagedParty(partyRef);
        customer.setAccount(List.of(accountRef));
        customer.setAgreement(List.of(agreementRef));
        customer.setRelatedParty(List.of(relatedPartyRef));
        customer.setPaymentMethod(List.of(paymentMethodRef));
        customer.setType(roleTypeRef);




        return (T)customer;
    }
}
