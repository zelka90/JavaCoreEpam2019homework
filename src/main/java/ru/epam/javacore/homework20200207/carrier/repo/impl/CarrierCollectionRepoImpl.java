package ru.epam.javacore.homework20200207.carrier.repo.impl;

import ru.epam.javacore.homework20200207.carrier.domain.Carrier;
import ru.epam.javacore.homework20200207.carrier.repo.CarrierRepo;
import ru.epam.javacore.homework20200207.common.solutions.utils.ListUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static ru.epam.javacore.homework20200207.storage.Storage.carriersList;

public class CarrierCollectionRepoImpl implements CarrierRepo {

    @Override
    public void add(Carrier carrier) {
        ListUtils.addToList(carrier, carriersList);
    }

    @Override
    public void addList(List<Carrier> carriers) {
        for (Carrier item : carriers) {
            add(item);
        }
    }

    @Override
    public List<Carrier> getAll() {
        return carriersList;
    }

    @Override
    public Optional<Carrier> getByIdFetchingTransportations(long id) {
        return getById(id);
    }

    @Override
    public List<Carrier> getByName(String name) {
        List<Carrier> result = new ArrayList<>();
        for (Carrier item : carriersList) {
            if (item.getName() != null && item.getName().equals(name)) {
                result.add(item);
            }
        }
        return result;
    }


    @Override
    public Optional<Carrier> getById(Long id) {
        return ListUtils.getByIdFromList(id, carriersList);
    }

    @Override
    public boolean update(Carrier carrier) {
        for (int i = 0; i < carriersList.size(); i++) {
            if (carriersList.get(i).getId().equals(carrier.getId())) {
                carriersList.set(i, carrier);
                return true;
            }
        }
        return false;
    }

    @Override
    public int countAll() {
        return getAll().size();
    }

    @Override
    public boolean deleteById(Long id) {
        return ListUtils.deleteByIdFromList(id, carriersList);
    }
}
