package main.homework20200113.common.business.repo;


import java.util.List;

public interface CommonRepo<T, Id> {

    boolean deleteById(Id id);

    void add(T element);

    List<T> getAll();

    T getById(Id id);

    boolean update(T element);
}