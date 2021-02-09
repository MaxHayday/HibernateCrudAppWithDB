package com.maxhayday.hibernate;

import com.maxhayday.hibernate.view.observer.*;
import org.hibernate.SessionFactory;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, ParseException, IOException {
        MenuObserved menu = new MenuObserved();
        menu.addObserver(new PostViewObserver());
        menu.addObserver(new UserViewObserver());
        menu.addObserver(new RegionViewObserver());
        menu.showMenu();
    }
}
