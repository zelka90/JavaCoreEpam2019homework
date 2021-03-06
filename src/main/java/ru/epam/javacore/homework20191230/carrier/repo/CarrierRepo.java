package ru.epam.javacore.homework20191230.carrier.repo;

import ru.epam.javacore.homework20191230.carrier.domain.Carrier;
import ru.epam.javacore.homework20191230.common.business.repo.CommonRepo;

import java.util.List;

public interface CarrierRepo extends CommonRepo<Carrier, Long> {

    List<Carrier> getByName(String name);

}
