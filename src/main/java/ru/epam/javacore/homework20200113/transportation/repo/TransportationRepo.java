package ru.epam.javacore.homework20200113.transportation.repo;

import ru.epam.javacore.homework20200113.common.business.repo.CommonRepo;
import ru.epam.javacore.homework20200113.transportation.domain.Transportation;

import java.io.Serializable;

public interface TransportationRepo extends CommonRepo<Transportation, Long>, Serializable {

}

