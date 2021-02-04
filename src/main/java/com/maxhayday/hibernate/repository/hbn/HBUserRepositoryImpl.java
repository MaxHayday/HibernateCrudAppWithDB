package com.maxhayday.hibernate.repository.hbn;

import com.maxhayday.hibernate.model.User;
import com.maxhayday.hibernate.repository.UserRepository;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public class HBUserRepositoryImpl implements UserRepository {

    @Override
    public User getById(Long id) throws IOException, ParseException, ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public User save(User user) throws IOException, ParseException, ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public User update(User user) throws IOException, ParseException, ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public List<User> getAll() throws IOException, ParseException, ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public void deleteById(Long id) throws IOException, ClassNotFoundException, SQLException {

    }
}
