package by.pvt.main;

import by.pvt.bena.PersonImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");

        PersonImpl person = (PersonImpl) context.getBean("person");

        System.out.println(person.getAddress().getCity()
                + " " + person.getName() + " " + person.getSecondName() + " " + person.getAddress().getStreet());

    }
}
