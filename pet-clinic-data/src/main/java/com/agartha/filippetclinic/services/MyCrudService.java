package com.agartha.filippetclinic.services;

import java.util.Set;

public interface MyCrudService<T, ID> {
    Set<T> findAll();
    T findById();
    <S extends T> S save(S var);
    void delete(T type);
    void deleteById(ID id);
}
