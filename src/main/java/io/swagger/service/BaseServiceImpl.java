package io.swagger.service;

import io.swagger.dao.BaseDaoImpl;
import io.swagger.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;


public abstract class  BaseServiceImpl <T>{

   private static Logger log = Logger.getLogger(BaseServiceImpl.class.getName());

    public abstract List<T> list();
}
