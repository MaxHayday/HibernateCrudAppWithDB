package com.maxhayday.hibernate.repository.hbn;

import com.maxhayday.hibernate.Connection;
import com.maxhayday.hibernate.model.Post;
import com.maxhayday.hibernate.model.User;
import com.maxhayday.hibernate.repository.UserRepository;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class HBUserRepositoryImpl implements UserRepository {
    private User userTmp = null;
    private List userList = null;
    private Transaction transaction = null;


    @Override
    public User getById(Long id) throws IOException, ParseException, ClassNotFoundException, SQLException {
        Session session = Connection.sessionFactory.openSession();
        transaction = session.beginTransaction();
        userTmp = session.get(User.class, id);
        transaction.commit();
        session.close();
        return userTmp;
    }

    @Override
    public User save(User user) throws IOException, ParseException, ClassNotFoundException, SQLException {
        Session session = Connection.sessionFactory.openSession();
        transaction = session.beginTransaction();
        Long idOfUser = (Long) session.save(user);
        transaction.commit();
        userTmp = session.get(User.class, idOfUser);
        session.close();

        return userTmp;
    }

    @Override
    public User update(User user) throws IOException, ParseException, ClassNotFoundException, SQLException {
        Session session = Connection.sessionFactory.openSession();
        transaction = session.beginTransaction();
        userTmp = session.get(User.class, user.getId());
        userTmp.setName(user.getName());
        userTmp.setLastName(user.getLastName());
        userTmp.setRole(user.getRole());
        userTmp.setRegion(user.getRegion());
        session.update(userTmp);
        userTmp = session.get(User.class, user.getId());
        transaction.commit();
        session.close();
        return userTmp;
    }

    @Override
    public List<User> getAll() throws IOException, ParseException, ClassNotFoundException, SQLException {
        Session session = Connection.sessionFactory.openSession();
        transaction = session.beginTransaction();
        userList = new ArrayList<>();
        userList = (List<User>) session.createQuery("FROM User u LEFT JOIN FETCH u.posts").list();
        session.close();
        return userList;
    }

    @Override
    public void deleteById(Long id) throws IOException, ClassNotFoundException, SQLException {
        Session session = Connection.sessionFactory.openSession();
        transaction = session.beginTransaction();
        userTmp = session.get(User.class, id);
        session.delete(userTmp);
        transaction.commit();
        session.close();
    }
}
