package com.example.inscription.Daos;

import com.example.inscription.Classes.Organisme;
import com.example.inscription.Interfaces.Crud;

import java.util.List;

public class OrganismeDao implements Crud<Organisme> {
    @Override
    public boolean create(Organisme o) {
        return false;
    }

    @Override
    public boolean update(Organisme o) {
        return false;
    }

    @Override
    public boolean delete(Organisme o) {
        return false;
    }

    @Override
    public List<Organisme> findAll() {
        return null;
    }

    @Override
    public boolean exists(Organisme o) {
        return false;
    }
    //TODO
}
