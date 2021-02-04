package com.maxhayday.hibernate.repository.hbn;

import com.maxhayday.hibernate.model.Post;
import com.maxhayday.hibernate.repository.PostRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class HBPostRepositoryImpl implements PostRepository {
    public static SessionFactory sessionFactory;
    private Post post;
    private List<Post> postList;


    @Override
    public Post getById(Long id) throws IOException, ParseException, ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public Post save(Post post) throws IOException, SQLException, ClassNotFoundException {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();
        Long idOfPost = (Long) session.save(post);
        transaction.commit();
        post = session.get(Post.class, idOfPost);
        session.close();

        return post;
    }

    @Override
    public List<Post> getAll() throws IOException, ParseException, ClassNotFoundException, SQLException {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();
        postList = session.createQuery("From Post").list();
        session.close();

        return postList;
    }

    @Override
    public List<Post> getPostListOfUserId(Long id) throws ClassNotFoundException, SQLException, IOException, ParseException {
        postList = getAll();
        List<Post> postListOfUserId = new ArrayList<>();
        for (Post p :
                postList) {
            if (p.getUser_id() == id) {
                postListOfUserId.add(p);
            }
        }
        return postList;
    }

    @Override
    public Post update(Post post) throws ClassNotFoundException, SQLException {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();
        Post postGetById = session.get(Post.class, post.getId());
        postGetById.setContent(post.getContent());
        postGetById.setCreated(post.getCreated());
        postGetById.setUpdated(post.getUpdated());
        session.update(postGetById);
        transaction.commit();
        session.close();
        return null;
    }

    @Override
    public void deleteById(Long id) throws IOException, ClassNotFoundException, SQLException {

    }

    @Override
    public void deleteByUserId(Long id) throws ClassNotFoundException, SQLException {

    }
}
