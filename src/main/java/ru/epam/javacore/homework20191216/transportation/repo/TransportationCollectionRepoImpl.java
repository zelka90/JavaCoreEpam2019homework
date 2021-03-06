package ru.epam.javacore.homework20191216.transportation.repo;

import ru.epam.javacore.homework20191216.storage.IdGenerator;
import ru.epam.javacore.homework20191216.transportation.domain.Transportation;

import java.util.Iterator;

import static ru.epam.javacore.homework20191216.storage.Storage.transportationList;

public class TransportationCollectionRepoImpl implements TransportationRepo {
    @Override
    public void add(Transportation transportation) {
        transportation.setId(IdGenerator.generateId());
        transportationList.add(transportation);
    }

    @Override
    public Transportation[] getAll() {
        return transportationList.toArray(new Transportation[transportationList.size()]);
    }

    @Override
    public Transportation getById(long id) {
        for (Transportation item : transportationList) {
            if (item.getId() != null && item.getId().equals(id)) {
                return item;
            }
        }
        return null;
    }

    @Override
    public boolean remove(long id) {
        Iterator<Transportation> iter = transportationList.iterator();
        while (iter.hasNext()) {
            Transportation element = iter.next();
            if (element.getId() != null && element.getId().equals(id)) {
                iter.remove();
                return true;
            }
        }
        return false;
    }
}
