package com.example.inscription.Daos;

import com.example.inscription.Classes.Admin;
import com.example.inscription.Classes.Domaine;
import com.example.inscription.Classes.Profil;
import com.example.inscription.Interfaces.Crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class AdminDao implements Crud<Admin> {
    @Override
    public boolean create(Admin o) {
        return false;
    }

    @Override
    public boolean update(Admin o) {
        return false;
    }

    @Override
    public boolean delete(Admin o) {
        return false;
    }

    @Override
    public List<Admin> findAll() {
        return null;
    }

    @Override
    public boolean exists(Admin o) {
        return false;
    }


//TODO class admin
}
