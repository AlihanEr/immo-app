package multimedi.immoapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import multimedi.immoapp.model.enums.EPC;
import multimedi.immoapp.model.enums.PropertyType;

import java.util.Objects;

@Entity
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String address;

    private double price;

    private PropertyType type;

    private EPC epc;

    private int interiorArea;

    private int plotArea;

    private int nrBedrooms;

    private int nrBathrooms;

    public Property() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public PropertyType getType() {
        return type;
    }

    public void setType(PropertyType type) {
        this.type = type;
    }

    public EPC getEpc() {
        return epc;
    }

    public void setEpc(EPC epc) {
        this.epc = epc;
    }

    public int getInteriorArea() {
        return interiorArea;
    }

    public void setInteriorArea(int interiorArea) {
        this.interiorArea = interiorArea;
    }

    public int getPlotArea() {
        return plotArea;
    }

    public void setPlotArea(int plotArea) {
        this.plotArea = plotArea;
    }

    public int getNrBedrooms() {
        return nrBedrooms;
    }

    public void setNrBedrooms(int nrBedrooms) {
        this.nrBedrooms = nrBedrooms;
    }

    public int getNrBathrooms() {
        return nrBathrooms;
    }

    public void setNrBathrooms(int nrBathrooms) {
        this.nrBathrooms = nrBathrooms;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Property property = (Property) o;
        return Double.compare(price, property.price) == 0 && interiorArea == property.interiorArea && plotArea == property.plotArea && nrBedrooms == property.nrBedrooms && nrBathrooms == property.nrBathrooms && Objects.equals(id, property.id) && Objects.equals(address, property.address) && type == property.type && epc == property.epc;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, address, price, type, epc, interiorArea, plotArea, nrBedrooms, nrBathrooms);
    }

    @Override
    public String toString() {
        return "Property{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", price=" + price +
                ", type=" + type +
                ", epc=" + epc +
                ", interiorArea=" + interiorArea +
                ", plotArea=" + plotArea +
                ", nrBedrooms=" + nrBedrooms +
                ", nrBathrooms=" + nrBathrooms +
                '}';
    }
}
