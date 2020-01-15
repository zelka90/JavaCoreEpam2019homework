package main.homework20200113.transportation.domain;

import main.homework20200113.cargo.domain.Cargo;
import main.homework20200113.carrier.domain.Carrier;
import main.homework20200113.common.business.domain.BaseEntity;

import java.io.Serializable;
import java.util.Date;

public class Transportation extends BaseEntity implements Serializable {
    private Cargo cargo;
    private Carrier carrier;
    private String description;
    private String billTo;
    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBillTo() {
        return billTo;
    }

    public void setBillTo(String billTo) {
        this.billTo = billTo;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public Carrier getCarrier() {
        return carrier;
    }

    public void setCarrier(Carrier carrier) {
        this.carrier = carrier;
    }

    @Override
    public String toString() {
        return "Transportation{" +
                "id=" + id +
                ", cargoId=" + cargo.getId() +
                ", carrierId=" + carrier.getId() +
                ", description='" + description + '\'' +
                ", billTo='" + billTo + '\'' +
                ", date=" + date +
                '}';
    }
}