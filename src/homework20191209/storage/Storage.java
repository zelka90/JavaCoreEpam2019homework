package homework20191209.storage;

import homework20191209.cargo.Cargo;
import homework20191209.carrier.Carrier;
import homework20191209.transportation.Transportation;

import static java.lang.System.*;

public class Storage {
    private Cargo[] cargo;
    private Carrier[] carriers;
    private Transportation[] transportation;

    private int sizeCargo;
    private int sizeCarrier;
    private int sizeTransportation;

    public void addCargo(Cargo cargo){
        if(this.cargo == null){
            this.cargo = new Cargo[10];
        }
        if(sizeCargo == this.cargo.length){
            Cargo[] newArrayCargo = new Cargo[(int) (sizeCargo * 1.5)];
            arraycopy(this.cargo, 0, newArrayCargo, 0, sizeCargo);
            this.cargo = newArrayCargo;
        }
        this.cargo[sizeCargo] = cargo;
        sizeCargo++;
    }

    public void addCarrier(Carrier carrier){
        if(this.carriers == null){
            this.carriers = new Carrier[10];
        }
        if(sizeCarrier == this.carriers.length){
            Carrier[] newArrayCarrier = new Carrier[(int) (sizeCarrier*1.5)];
            arraycopy(this.carriers, 0, newArrayCarrier, 0, sizeCarrier);
            this.carriers = newArrayCarrier;
        }
        this.carriers[sizeCarrier] = carrier;
        sizeCarrier++;

    }

    public void addTransportation(Transportation transportation){
        if (this.transportation == null){
            this.transportation = new Transportation[10];
        }
        if(sizeTransportation == this.transportation.length){
            Transportation[] newArrayTrans = new Transportation[(int) (sizeTransportation * 1.5)];
            arraycopy(this.transportation, 0, newArrayTrans, 0, sizeTransportation);
            this.transportation = newArrayTrans;
        }
        this.transportation[sizeTransportation] = transportation;
        sizeTransportation++;
    }

    public void printAllCargo(){
        for (int i = 0; i < sizeCargo; i++) {
            out.println(cargo[i]);
        }
    }

    public void printAllCarrier(){
        for (int i = 0; i < sizeCarrier; i++) {
            out.println(carriers[i]);
        }
    }

    public void printAllTransportation(){
        for (int i = 0; i < sizeTransportation; i++) {
            out.println(transportation[i]);
        }
    }
}
