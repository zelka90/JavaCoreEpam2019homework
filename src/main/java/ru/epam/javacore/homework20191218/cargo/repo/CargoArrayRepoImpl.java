package ru.epam.javacore.homework20191218.cargo.repo;

import ru.epam.javacore.homework20191218.cargo.domain.Cargo;
import ru.epam.javacore.homework20191218.cargo.service.TypeSortCargo;
import ru.epam.javacore.homework20191218.common.utils.ArrayUtils;
import ru.epam.javacore.homework20191218.storage.IdGenerator;
import ru.epam.javacore.homework20191218.storage.Storage;

import java.util.Arrays;

import static ru.epam.javacore.homework20191218.storage.Storage.cargoArray;
import static ru.epam.javacore.homework20191218.storage.Storage.sizeCargo;

public class CargoArrayRepoImpl implements CargoRepo {

    private static final Cargo[] EMPTY_CARGO_ARRAY = new Cargo[0];

    @Override
    public void add(Cargo cargo) {
        if (sizeCargo == Storage.cargoArray.length) {
            Cargo[] newArrayCargo = new Cargo[(int) (sizeCargo * 1.5)];
            ArrayUtils.copyArray(Storage.cargoArray, newArrayCargo);
            Storage.cargoArray = newArrayCargo;
        }
        cargo.setId(IdGenerator.generateId());
        Storage.cargoArray[sizeCargo] = cargo;
        sizeCargo++;
    }

    @Override
    public Cargo[] getAll() {
        if (sizeCargo < cargoArray.length) {
            Cargo[] result = new Cargo[sizeCargo];
            ArrayUtils.copyArray(cargoArray, result, sizeCargo);
            return result;
        }
        return cargoArray;
    }

    @Override
    public Cargo[] getByName(String name) {
        Cargo[] arrayTheSameNames = new Cargo[sizeCargo];
        int index = 0;
        for (Cargo item : cargoArray) {
            if (item != null && item.getName() != null && item.getName().equals(name)) {
                arrayTheSameNames[index++] = item;
            }
        }
        if (index == 0) {
            return EMPTY_CARGO_ARRAY;
        } else {
            Cargo[] result = new Cargo[index];
            ArrayUtils.copyArray(arrayTheSameNames, result, index);
            return result;
        }
    }

    @Override
    public Cargo getById(long id) {
        for (Cargo item : cargoArray) {
            if (item != null && Long.valueOf(id).equals(item.getId())) {
                return item;
            }
        }
        return null;
    }

    @Override
    public boolean deleteById(long id) {
        for (int i = 0; i < sizeCargo; i++) {
            if (cargoArray[i] != null && cargoArray[i].getId() != null && cargoArray[i].getId().equals(id)) {
                System.arraycopy(cargoArray, i + 1, cargoArray, i, cargoArray.length - (i + 1));
                cargoArray[cargoArray.length - 1] = null;
                sizeCargo--;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean update(Cargo cargo) {
        for (int i = 0; i < sizeCargo; i++) {
            if (cargoArray[i].getId().equals(cargo.getId())) {
                cargoArray[i] = cargo;
                return true;
            }
        }
        return false;
    }

    @Override
    public Cargo[] getAllSortedItems(TypeSortCargo typeSortCargo) {
        Cargo[] sortCargoArray = new Cargo[sizeCargo];
        ArrayUtils.copyArray(cargoArray, sortCargoArray, sizeCargo);
        switch (typeSortCargo) {
            case NAME:
                Arrays.sort(sortCargoArray,CargoComparators.COMPARE_BY_NAME);
                break;
            case WEIGHT:
                Arrays.sort(sortCargoArray,CargoComparators.COMPARE_BY_WEIGHT);
                break;
            case NAME_WEIGHT:
                Arrays.sort(sortCargoArray,CargoComparators.COMPARE_BY_NAME_WEIGHT);
                break;
            default:
                Arrays.sort(sortCargoArray,CargoComparators.COMPARE_BY_WEIGHT_NAME);
        }
        return  sortCargoArray;
    }

}
