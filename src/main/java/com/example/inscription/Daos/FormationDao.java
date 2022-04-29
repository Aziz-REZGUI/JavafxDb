package com.example.inscription.Daos;

import com.example.inscription.Classes.Formation;
import com.example.inscription.Interfaces.Crud;

import java.util.List;

public class FormationDao implements Crud<Formation> {
    @Override
    public boolean create(Formation o) {
        return false;
    }

    @Override
    public boolean update(Formation o) {
        return false;
    }

    @Override
    public boolean delete(Formation o) {
        return false;
    }

    @Override
    public List<Formation> findAll() {
        return null;
    }

    @Override
    public boolean exists(Formation o) {
        return false;
    }
    //TODO
}
