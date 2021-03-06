package ru.epam.javacore.homework20191213.transportation.repo;

import ru.epam.javacore.homework20191213.transportation.domain.Transportation;

public interface TransportationRepo {
    void add(Transportation transportation);

    Transportation[] getAll();

    Transportation getById(long id);

    boolean remove(long id);
}

