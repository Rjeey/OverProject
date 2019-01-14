package io.swagger.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.sql.DataSourceDefinition;
import javax.xml.bind.annotation.XmlValue;
import java.io.Serializable;
import java.util.List;


public abstract class BaseDaoImpl <T> {

    @Autowired
    SessionFactory sessionFactory;

   public abstract List<T> getAll();

     abstract T get(Serializable id);

     public void save(T item){

         openSession().saveOrUpdate(item);
     }
     public void update(T item){

         openSession().update(item);
     }
     public void delete(T item){

         openSession().delete(item);
     }


    Session openSession(){
        return sessionFactory.getCurrentSession();
    }




}
