package ru.epam.javacore.homework20200129.carrier.service;

import ru.epam.javacore.homework20200129.carrier.domain.Carrier;
import ru.epam.javacore.homework20200129.common.business.service.CommonService;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface CarrierService extends CommonService<Carrier, Long>, Serializable {

    Optional<Carrier> getByIdFetchingTransportations(Long id);

    List<Carrier> getByName(String name);

}
