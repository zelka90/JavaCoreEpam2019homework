package ru.epam.javacore.homework20191216.cargo.repo;

import ru.epam.javacore.homework20191216.cargo.domain.Cargo;
import ru.epam.javacore.homework20191216.storage.IdGenerator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static ru.epam.javacore.homework20191216.storage.Storage.cargoList;

public class CargoCollectionRepoImpl implements CargoRepo {
    @Override
    public void add(Cargo cargo) {
        cargo.setId(IdGenerator.generateId());
        cargoList.add(cargo);
    }

    @Override
    public Cargo[] getAll() {
        return cargoList.toArray(new Cargo[cargoList.size()]);
    }

    @Override
    public Cargo[] getByName(String name) {
        List<Cargo> result = new ArrayList<>();
        for (Cargo item : cargoList) {
            if (item.getName() != null && item.getName().equals(name)) {
                result.add(item);
            }
        }
        return (Cargo[]) result.toArray();
    }

    @Override
    public Cargo getById(long id) {
        for (Cargo item : cargoList) {
            if (item.getId() != null && item.getId().equals(id)) {
                return item;
            }
        }
        return null;
    }

    @Override
    public boolean remove(long id) {
        Iterator<Cargo> iter = cargoList.iterator();
        while (iter.hasNext()) {
            Cargo element = iter.next();
            if (element.getId() != null && element.getId().equals(id)) {
                iter.remove();
                return true;
            }
        }
        return false;
    }
}
