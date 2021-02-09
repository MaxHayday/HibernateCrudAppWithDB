package com.maxhayday.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Connection {
    public static SessionFactory sessionFactory;


    public static void buildSession() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public static void closeSession() {
        sessionFactory.close();
    }
}
