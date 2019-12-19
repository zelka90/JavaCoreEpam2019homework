package homework20191216.carrier.repo;

import homework20191216.carrier.domain.Carrier;
import homework20191216.common.repo.CommonRepo;

public interface CarrierRepo extends CommonRepo {
    void add(Carrier carrier);

    Carrier[] getAll();

    Carrier[] getByName(String name);

    Carrier getById(long id);

}