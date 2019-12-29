package homework20191227.storage.initor;

import homework20191227.application.serviceholder.ServiceHolder;
import homework20191227.cargo.domain.Cargo;
import homework20191227.cargo.domain.ClothesCargo;
import homework20191227.cargo.domain.ComputerCargo;
import homework20191227.cargo.domain.FoodCargo;
import homework20191227.cargo.service.CargoService;
import homework20191227.carrier.domain.Carrier;
import homework20191227.carrier.service.CarrierService;
import homework20191227.transportation.domain.Transportation;
import homework20191227.transportation.service.TransportationService;

import java.util.Date;

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
        transportation.setCargo(cargoRepo.getById(cargoId));
        transportation.setCarrier(carrierRepo.getById(carrierId));
        transportation.setDescription("descripton transportation" + (cargoId + carrierId));
        transportation.setBillTo("BillTo" + (cargoId + carrierId));
        transportation.setDate(new Date());
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
        return cargo;
    }

    private Carrier createCarrier(int i) {
        Carrier carrier = new Carrier();
        carrier.setName("Carrier name " + i);
        carrier.setAddress("Adress + " + i);
        return carrier;
    }
}