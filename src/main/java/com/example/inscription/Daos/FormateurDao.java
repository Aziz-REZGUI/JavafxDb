package com.example.inscription.Daos;

import com.example.inscription.Classes.Formateur;
import com.example.inscription.Interfaces.Crud;

import java.util.List;

public class FormateurDao implements Crud<Formateur> {
    @Override
    public boolean create(Formateur o) {
        return false;
    }

    @Override
    public boolean update(Formateur o) {
        return false;
    }

    @Override
    public boolean delete(Formateur o) {
        return false;
    }

    @Override
    public List<Formateur> findAll() {
        return null;
    }

    @Override
    public boolean exists(Formateur o) {
        return false;
    }
    //TODO
}
