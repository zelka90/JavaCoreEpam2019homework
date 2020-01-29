package ru.epam.javacore.homework20200127.carrier.repo;

import ru.epam.javacore.homework20200127.carrier.domain.Carrier;
import ru.epam.javacore.homework20200127.common.business.repo.CommonRepo;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface CarrierRepo extends CommonRepo<Carrier, Long>, Serializable {

    Optional<Carrier> getByIdFetchingTransportations(long id);

    List<Carrier> getByName(String name);

}
