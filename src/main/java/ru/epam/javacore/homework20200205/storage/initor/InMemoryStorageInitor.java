package ru.epam.javacore.homework20200205.storage.initor;

import ru.epam.javacore.homework20200205.application.serviceholder.ServiceHolder;
import ru.epam.javacore.homework20200205.cargo.domain.Cargo;
import ru.epam.javacore.homework20200205.cargo.domain.ClothesCargo;
import ru.epam.javacore.homework20200205.cargo.domain.ComputerCargo;
import ru.epam.javacore.homework20200205.cargo.domain.FoodCargo;
import ru.epam.javacore.homework20200205.cargo.service.CargoService;
import ru.epam.javacore.homework20200205.carrier.domain.Carrier;
import ru.epam.javacore.homework20200205.carrier.domain.CarrierType;
import ru.epam.javacore.homework20200205.carrier.service.CarrierService;
import ru.epam.javacore.homework20200205.transportation.domain.Transportation;
import ru.epam.javacore.homework20200205.transportation.service.TransportationService;

import java.time.LocalDate;

public class InMemoryStorageInitor implements StorageInitor {

    private static final int AMOUNT_OF_ELEMENTS = 6;

    private final CarrierService carrierService;
    private final CargoService cargoService;
    private final TransportationService transportationService;

    public InMemoryStorageInitor() {
        carrierService = ServiceHolder.getInstance().getCarrierService();
        cargoService = ServiceHolder.getInstance().getCargoService();
        transportationService = ServiceHolder.getInstance().getTransportationService();
    }

    @Override
    public void initStorage() {
        initCargos();
        initCarriers();
        initTransportatons();
    }

    private void initCargos() {
        System.out.println("ADD CARGOS");
        for (int i = 0; i < AMOUNT_OF_ELEMENTS / 3; i++) {
            cargoService.add(createClothesCargo(i));
        }
        for (int i = 0; i < AMOUNT_OF_ELEMENTS / 3; i++) {
            cargoService.add(createComputersCargo(i));
        }
        for (int i = 0; i < AMOUNT_OF_ELEMENTS / 3; i++) {
            cargoService.add(createFoodCargo(i));
        }
        System.out.println("----------------");
    }

    private void initCarriers() {
        System.out.println("ADD CARRIERS");
        for (int i = 0; i < AMOUNT_OF_ELEMENTS; i++) {
            carrierService.add(createCarrier(i));
        }
        System.out.println("----------------");
    }

    private void initTransportatons() {
        System.out.println("ADD TRANSPORTATIONS");
        for (int i = 0; i < AMOUNT_OF_ELEMENTS; i++) {
            transportationService.add(createTransportation(i + 1, i + 1 + AMOUNT_OF_ELEMENTS,
                    cargoService, carrierService));
        }
        System.out.println("----------------");
    }

    private Transportation createTransportation(long cargoId, long carrierId,
                                                CargoService cargoRepo, CarrierService carrierRepo) {
        Transportation transportation = new Transportation();
        transportation.setCargo(cargoRepo.getById(cargoId).orElse(null));
        transportation.setCarrier(carrierRepo.getById(carrierId).orElse(null));
        transportation.setDescription("descripton transportation" + (cargoId + carrierId));
        transportation.setBillTo("BillTo" + (cargoId + carrierId));
        transportation.setDate(LocalDate.now());
        return transportation;
    }


    private ClothesCargo createClothesCargo(int i) {
        ClothesCargo cargo = new ClothesCargo();
        cargo.setSize("Clothes size " + i);
        cargo.setName("Clothes name ");
        cargo.setWeight(40 - i);
        return cargo;
    }

    private Cargo createComputersCargo(int i) {
        ComputerCargo cargo = new ComputerCargo();
        cargo.setDescription("description computer" + i);
        cargo.setName("Computer name " + (5 - i));
        cargo.setWeight(50);
        return cargo;
    }

    private Cargo createFoodCargo(int i) {
        FoodCargo cargo = new FoodCargo();
        cargo.setWeight(33 + i);
        cargo.setName("Food name " + i);
        cargo.setExpirationDate(LocalDate.now());
        return cargo;
    }

    private Carrier createCarrier(int i) {
        Carrier carrier = new Carrier();
        carrier.setName("Carrier name " + i);
        carrier.setAddress("Adress + " + i);
        carrier.setCarrierType(CarrierType.values()[i % 4]);
        return carrier;
    }
}
