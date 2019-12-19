package homework20191216.carrier.service;

import homework20191216.carrier.domain.Carrier;

public interface CarrierService {
    void add(Carrier carrier);

    Carrier[] getAll();

    Carrier[] getByName(String name);

    Carrier getById(Long id);

    Carrier remove(Long id);
}