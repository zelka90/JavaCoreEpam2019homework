package main.homework20191216;

import main.homework20191216.cargo.domain.Cargo;
import main.homework20191216.cargo.domain.ClothesCargo;
import main.homework20191216.cargo.domain.ComputerCargo;
import main.homework20191216.cargo.domain.FoodCargo;
import main.homework20191216.cargo.repo.CargoCollectionRepoImpl;
import main.homework20191216.cargo.repo.CargoRepo;
import main.homework20191216.cargo.service.CargoServiceImpl;
import main.homework20191216.carrier.domain.Carrier;
import main.homework20191216.carrier.repo.CarrierCollectionRepoImpl;
import main.homework20191216.carrier.repo.CarrierRepo;
import main.homework20191216.carrier.service.CarrierServiceImpl;
import main.homework20191216.common.utils.ArrayUtils;
import main.homework20191216.transportation.domain.Transportation;
import main.homework20191216.transportation.repo.TransportationCollectionRepoImpl;
import main.homework20191216.transportation.repo.TransportationRepo;
import main.homework20191216.transportation.service.TransportationServiceImpl;

import java.util.Date;

public class Application {

    public static void main(String[] args) {
        int numberElements = 6;
        CargoCollectionRepoImpl cargoRepo = new CargoCollectionRepoImpl();
        initCargos(cargoRepo, numberElements);
        CarrierCollectionRepoImpl carrierRepo = new CarrierCollectionRepoImpl();
        initCarriers(carrierRepo, numberElements);
        TransportationCollectionRepoImpl transportationRepo = new TransportationCollectionRepoImpl();
        initTransportatons(transportationRepo, numberElements);
        printStorage(cargoRepo, carrierRepo, transportationRepo);

    }

    private static void printStorage(CargoCollectionRepoImpl cargoRepo,
                                     CarrierCollectionRepoImpl carrierRepo,
                                     TransportationCollectionRepoImpl transportationRepo) {
        ArrayUtils.printArray(cargoRepo.getAll());
        ArrayUtils.printArray(carrierRepo.getAll());
        ArrayUtils.printArray(transportationRepo.getAll());
    }

    private static void initCargos(CargoRepo cargoRepo, int number) {
        System.out.println("ADD CARGOS");
        CargoServiceImpl cargoService = new CargoServiceImpl(cargoRepo);
        for (int i = 0; i < number / 3; i++) {
            cargoService.add(createClothesCargo(i));
        }
        for (int i = 0; i < number / 3; i++) {
            cargoService.add(createComputersCargo(i));
        }
        for (int i = 0; i < number / 3; i++) {
            cargoService.add(createFoodCargo(i));
        }
        System.out.println("----------------");
    }

    private static void initCarriers(CarrierRepo carrierRepo, int numberElements) {
        System.out.println("ADD CARRIERS");
        CarrierServiceImpl carrierService = new CarrierServiceImpl(carrierRepo);
        for (int i = 0; i < numberElements; i++) {
            carrierService.add(createCarrier(i));
        }
        System.out.println("----------------");
    }

    private static void initTransportatons(TransportationRepo transportationRepo, int numberElements) {
        System.out.println("ADD TRANSPORTATIONS");
        TransportationServiceImpl transportationService = new TransportationServiceImpl(transportationRepo);
        for (int i = 0; i < numberElements; i++) {
            transportationService.add(createTransportation(i + 1, i + 1 + numberElements,
                    transportationService.getCargoRepo(),
                    transportationService.getCarrierRepo()));
        }
        System.out.println("----------------");
    }

    private static Transportation createTransportation(long cargoId, long carrierId,
                                                       CargoRepo cargoRepo, CarrierRepo carrierRepo) {
        Transportation transportation = new Transportation();
        transportation.setCargo(cargoRepo.getById(cargoId));
        transportation.setCarrier(carrierRepo.getById(carrierId));
        transportation.setDescription("descripton transportation" + (cargoId + carrierId));
        transportation.setBillTo("BillTo" + (cargoId + carrierId));
        transportation.setDate(new Date());
        return transportation;
    }


    private static ClothesCargo createClothesCargo(int i) {
        ClothesCargo cargo = new ClothesCargo();
        cargo.setSize("Clothes size " + i);
        cargo.setName("Clothes name " + i);
        cargo.setWeight(40 + i);
        return cargo;
    }

    private static Cargo createComputersCargo(int i) {
        ComputerCargo cargo = new ComputerCargo();
        cargo.setDescription("description computer" + i);
        cargo.setName("Computer name " + i);
        cargo.setWeight(50 + i);
        return cargo;
    }

    private static Cargo createFoodCargo(int i) {
        FoodCargo cargo = new FoodCargo();
        cargo.setWeight(33 + i);
        cargo.setName("Food name " + i);
        return cargo;
    }

    private static Carrier createCarrier(int i) {
        Carrier carrier = new Carrier();
        carrier.setName("Carrier name " + i);
        carrier.setAddress("Adress + " + i);
        return carrier;
    }

}