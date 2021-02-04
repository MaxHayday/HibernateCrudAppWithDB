package com.maxhayday.hibernate.repository.hbn;

import com.maxhayday.hibernate.model.Region;
import com.maxhayday.hibernate.repository.RegionRepository;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public class HBRegionRepositoryImpl implements RegionRepository {


    @Override
    public Region getById(Long id) throws IOException, ParseException, ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public Region save(Region region) throws IOException, SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public Region update(Region region) throws IOException, ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public List<Region> getAll() throws IOException, ParseException, ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public void deleteById(Long id) throws IOException, ClassNotFoundException, SQLException {

    }
}
