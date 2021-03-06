package ru.epam.javacore.homework20191223.transportation.repo;

import ru.epam.javacore.homework20191223.common.solutions.utils.ListUtils;
import ru.epam.javacore.homework20191223.transportation.domain.Transportation;

import java.util.List;

import static ru.epam.javacore.homework20191223.storage.Storage.transportationList;

public class TransportationCollectionRepoImpl implements TransportationRepo {
    @Override
    public void add(Transportation transportation) {
        ListUtils.addToList(transportation, transportationList);
    }

    @Override
    public List<Transportation> getAll() {
        return transportationList;
    }

    @Override
    public Transportation getById(long id) {
        return ListUtils.getByIdFromList(id, transportationList);
    }

    @Override
    public boolean update(Transportation transportation) {
        for (int i = 0; i < transportationList.size(); i++) {
            if (transportationList.get(i).getId().equals(transportation.getId())) {
                transportationList.set(i, transportation);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deleteById(long id) {
        return ListUtils.deleteByIdFromList(id, transportationList);
    }
}
