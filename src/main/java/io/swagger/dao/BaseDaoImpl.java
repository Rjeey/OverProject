package io.swagger.dao;



import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.sql.DataSourceDefinition;
import javax.xml.bind.annotation.XmlValue;
import java.util.List;


public abstract class BaseDaoImpl <T> {

    @Autowired

    private SessionFactory sessionFactory;

   public abstract List<T> find();

    public boolean add(List<T> iteam){
       return false;
    }


    Session openSession(){
        return sessionFactory.openSession();
    }




}
