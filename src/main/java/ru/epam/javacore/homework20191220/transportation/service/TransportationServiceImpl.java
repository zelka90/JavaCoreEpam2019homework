package ru.epam.javacore.homework20191220.transportation.service;

import ru.epam.javacore.homework20191220.cargo.repo.CargoArrayRepoImpl;
import ru.epam.javacore.homework20191220.cargo.repo.CargoCollectionRepoImpl;
import ru.epam.javacore.homework20191220.cargo.repo.CargoRepo;
import ru.epam.javacore.homework20191220.carrier.repo.CarrierArrayRepoImpl;
import ru.epam.javacore.homework20191220.carrier.repo.CarrierCollectionRepoImpl;
import ru.epam.javacore.homework20191220.carrier.repo.CarrierRepo;
import ru.epam.javacore.homework20191220.common.utils.ArrayUtils;
import ru.epam.javacore.homework20191220.transportation.domain.Transportation;
import ru.epam.javacore.homework20191220.transportation.repo.TransportationArrayRepoImpl;
import ru.epam.javacore.homework20191220.transportation.repo.TransportationCollectionRepoImpl;
import ru.epam.javacore.homework20191220.transportation.repo.TransportationRepo;

public class TransportationServiceImpl implements TransportationService {

    private TransportationRepo transportationRepo;
    private CargoRepo cargoRepo;
    private CarrierRepo carrierRepo;

    public TransportationServiceImpl(TransportationRepo transportationRepo) {
        this.transportationRepo = transportationRepo;
        if (transportationRepo.getClass() == TransportationArrayRepoImpl.class) {
            cargoRepo = new CargoArrayRepoImpl();
            carrierRepo = new CarrierArrayRepoImpl();
        } else if (transportationRepo.getClass() == TransportationCollectionRepoImpl.class) {
            cargoRepo = new CargoCollectionRepoImpl();
            carrierRepo = new CarrierCollectionRepoImpl();
        } else {
            System.out.println("fail transportationRepo type");
            return;
        }
    }

    @Override
    public void add(Transportation transportation) {
        System.out.println("Begin to add transportation!");
        if (transportation.getCargo() == null) {
            System.out.println("transportation must have a cargo!");
        } else if (cargoRepo.getById(transportation.getCargo().getId()) == null) {
            System.out.println("such cargo is not in storage");
        } else if (transportation.getCarrier() == null) {
            System.out.println("transportation must have a carrier!");
        } else if (carrierRepo.getById(transportation.getCarrier().getId()) == null) {
            System.out.println("such carrier is not in storage");
        } else if (transportation.getDescription() == null) {
            System.out.println("transportation must have a description!");
        } else if (transportation.getBillTo() == null) {
            System.out.println("transportation must have a BillTo!");
        } else if (transportation.getDate() == null) {
            System.out.println("transportation must have a date!");
        } else {
            transportationRepo.add(transportation);
            cargoRepo.getById(transportation.getCargo().getId()).setTransportations(
                    new Transportation[]{transportation}
            );
            carrierRepo.getById(transportation.getCarrier().getId()).setTransportations(
                    new Transportation[]{transportation}
            );
            System.out.println("transportation added!!!");
        }
    }

    @Override
    public Transportation[] getAll() {
        return transportationRepo.getAll();
    }

    @Override
    public Transportation getById(Long id) {
        if (id != null) {
            transportationRepo.getById(id);
        }
        return null;
    }

    @Override
    public boolean update(Transportation transportation) {
        if (transportation == null) {
            System.out.println("value NULL don't available!");
        } else if (transportation.getId() == null) {
            System.out.println("transportation must have a ID!");
        } else if (transportation.getCargo() == null) {
            System.out.println("transportation must have a cargo!");
        } else if (cargoRepo.getById(transportation.getCargo().getId()) == null) {
            System.out.println("such cargo is not in storage");
        } else if (transportation.getCarrier() == null) {
            System.out.println("transportation must have a carrier!");
        } else if (carrierRepo.getById(transportation.getCarrier().getId()) == null) {
            System.out.println("such carrier is not in storage");
        } else if (transportation.getDescription() == null) {
            System.out.println("transportation must have a description!");
        } else if (transportation.getBillTo() == null) {
            System.out.println("transportation must have a BillTo!");
        } else if (transportation.getDate() == null) {
            System.out.println("transportation must have a date!");
        } else if (transportationRepo.update(transportation)) {
            cargoRepo.getById(transportation.getCargo().getId()).setTransportations(
                    new Transportation[]{transportation}
            );
            carrierRepo.getById(transportation.getCarrier().getId()).setTransportations(
                    new Transportation[]{transportation}
            );
            System.out.println("transportation added!!!");
            return true;
        }
        System.out.println("transportation don't found");
        return false;
    }

    public TransportationRepo getTransportationRepo() {
        return transportationRepo;
    }

    public CargoRepo getCargoRepo() {
        return cargoRepo;
    }

    public CarrierRepo getCarrierRepo() {
        return carrierRepo;
    }

    @Override
    public boolean deleteById(Long id) {
        if (id != null) {
            Transportation element = transportationRepo.getById(id);
            if(element != null){
                cargoRepo.getById(element.getCargo().getId()).setTransportations(null);
                carrierRepo.getById(element.getCarrier().getId()).setTransportations(null);
                return transportationRepo.deleteById(id);
            }
        }
        return false;
    }

    @Override
    public void printAll() {
        ArrayUtils.printArray(transportationRepo.getAll());
    }
}
