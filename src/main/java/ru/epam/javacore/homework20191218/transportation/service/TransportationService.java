package ru.epam.javacore.homework20191218.transportation.service;

import ru.epam.javacore.homework20191218.common.service.CommonService;
import ru.epam.javacore.homework20191218.transportation.domain.Transportation;

public interface TransportationService extends CommonService {
    void add(Transportation transportation);

    Transportation[] getAll();

    Transportation getById(Long id);

    boolean update(Transportation transportation);

}
