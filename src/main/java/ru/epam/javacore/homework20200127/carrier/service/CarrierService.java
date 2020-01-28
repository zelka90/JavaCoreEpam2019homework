package ru.epam.javacore.homework20200127.carrier.service;

import ru.epam.javacore.homework20200127.carrier.domain.Carrier;
import ru.epam.javacore.homework20200127.common.business.service.CommonService;

import java.io.Serializable;
import java.util.List;

public interface CarrierService extends CommonService<Carrier, Long>, Serializable {

    List<Carrier> getByName(String name);

}
