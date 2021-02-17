package com.maxhayday.hibernate.repository.hbn;

import com.maxhayday.hibernate.Connection;
import com.maxhayday.hibernate.Main;
import com.maxhayday.hibernate.model.Post;
import com.maxhayday.hibernate.repository.PostRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class HBPostRepositoryImpl implements PostRepository {
    private Post postTmp = null;
    private List<Post> postList = null;
    private Transaction transaction = null;


    @Override
    public Post getById(Long id) throws IOException, ParseException, ClassNotFoundException, SQLException {
        Session session = Connection.sessionFactory.openSession();
        transaction = session.beginTransaction();
        postTmp = session.get(Post.class, id);
        transaction.commit();
        session.close();
        return postTmp;
    }

    @Override
    public Post save(Post post) throws IOException, SQLException, ClassNotFoundException {
        Session session = Connection.sessionFactory.openSession();
        transaction = session.beginTransaction();
        Long idOfPost = (Long) session.save(post);
        transaction.commit();
        postTmp = session.get(Post.class, idOfPost);
        session.close();

        return postTmp;
    }

    @Override
    public List<Post> getAll() throws IOException, ParseException, ClassNotFoundException, SQLException {
        Session session = Connection.sessionFactory.openSession();
        transaction = session.beginTransaction();
        postList = new ArrayList<>();
        postList = session.createQuery("From Post").list();
        session.close();

        return postList;
    }

    @Override
    public List<Post> getPostListOfUserId(Long id) throws ClassNotFoundException, SQLException, IOException, ParseException {
        postList = new ArrayList<>();
        postList = getAll();
        List<Post> postListOfUserId = new ArrayList<>();
        for (Post p :
                postList) {
            if (p.getUser().getId() == id) {
                postListOfUserId.add(p);
            }
        }
        return postList;
    }

    @Override
    public Post update(Post post) throws ClassNotFoundException, SQLException {
        Session session = Connection.sessionFactory.openSession();
        transaction = session.beginTransaction();
        postTmp = session.get(Post.class, post.getId());
        postTmp.setContent(post.getContent());
        postTmp.setCreated(post.getCreated());
        postTmp.setUpdated(post.getUpdated());
        session.update(postTmp);
        post = session.get(Post.class, post.getId());
        transaction.commit();
        session.close();
        return post;
    }

    @Override
    public void deleteById(Long id) throws IOException, ClassNotFoundException, SQLException {
        Session session = Connection.sessionFactory.openSession();
        transaction = session.beginTransaction();
        postTmp = session.get(Post.class, id);
        session.delete(postTmp);
        transaction.commit();
        session.close();
    }

    @Override
    public void deleteByUserId(Long id) throws ClassNotFoundException, SQLException {
        Session session = Connection.sessionFactory.openSession();
        transaction = session.beginTransaction();
        postTmp = session.get(Post.class, id);
        session.delete(postTmp.getUser());
        transaction.commit();
        session.close();
    }
}
