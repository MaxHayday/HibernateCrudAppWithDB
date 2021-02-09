package com.maxhayday.hibernate.repository.hbn;

import com.maxhayday.hibernate.Connection;
import com.maxhayday.hibernate.model.Region;
import com.maxhayday.hibernate.repository.RegionRepository;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class HBRegionRepositoryImpl implements RegionRepository {
    private Transaction transaction = null;
    private Region regionTmp = null;
    private List<Region> regionList = null;


    @Override
    public Region getById(Long id) throws IOException, ParseException, ClassNotFoundException, SQLException {
        Session session = Connection.sessionFactory.openSession();
        transaction = session.beginTransaction();
        regionTmp = session.get(Region.class, id);
        transaction.commit();
        session.close();
        return regionTmp;
    }

    @Override
    public Region save(Region region) throws IOException, SQLException, ClassNotFoundException {
        Session session = Connection.sessionFactory.openSession();
        transaction = session.beginTransaction();
        long idSavesRegion = (long) session.save(region);
        transaction.commit();
        regionTmp = session.get(Region.class, idSavesRegion);
        session.close();
        return regionTmp;
    }

    @Override
    public Region update(Region region) throws IOException, ClassNotFoundException, SQLException {
        Session session = Connection.sessionFactory.openSession();
        transaction = session.beginTransaction();
        regionTmp = session.get(Region.class, region.getId());
        regionTmp.setName(region.getName());
        session.update(regionTmp);
        regionTmp = session.get(Region.class, region.getId());
        transaction.commit();
        session.close();
        return regionTmp;
    }

    @Override
    public List<Region> getAll() throws IOException, ParseException, ClassNotFoundException, SQLException {
        Session session = Connection.sessionFactory.openSession();
        transaction = session.beginTransaction();
        regionList = new ArrayList<>();
        regionList = session.createQuery("FROM Region").list();
        session.close();
        return regionList;
    }

    @Override
    public void deleteById(Long id) throws IOException, ClassNotFoundException, SQLException {
        Session session = Connection.sessionFactory.openSession();
        transaction = session.beginTransaction();
        regionTmp = session.get(Region.class, id);
        session.delete(regionTmp);
        transaction.commit();
        session.close();
    }
}
