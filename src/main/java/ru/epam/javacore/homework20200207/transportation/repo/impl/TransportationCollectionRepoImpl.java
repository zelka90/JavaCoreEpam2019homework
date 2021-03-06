package ru.epam.javacore.homework20200207.transportation.repo.impl;

import ru.epam.javacore.homework20200207.common.solutions.utils.ListUtils;
import ru.epam.javacore.homework20200207.transportation.domain.Transportation;
import ru.epam.javacore.homework20200207.transportation.repo.TransportationRepo;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

import static ru.epam.javacore.homework20200207.storage.Storage.transportationList;

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
    public Optional<Transportation> getById(Long id) {
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
    public int countAll() {
        return getAll().size();
    }

    @Override
    public boolean deleteById(Long id) {
        return ListUtils.deleteByIdFromList(id, transportationList);
    }
}
