package com.example.inscription.Interfaces;

import java.util.List;
import java.util.Objects;

public interface Crud<S> {
    boolean create(S o);

    boolean update(S o);

    boolean delete(S o);

    List<S> findAll();

    boolean exists(S o);

}
