package ru.epam.javacore.homework20191213.carrier.repo;

import ru.epam.javacore.homework20191213.carrier.domain.Carrier;

public interface CarrierRepo {
    void add(Carrier carrier);

    Carrier[] getAll();

    Carrier[] getByName(String name);

    Carrier getById(long id);

    boolean remove(long id);
}
