package multimedi;

import multimedi.immoapp.model.*;
import multimedi.immoapp.model.enums.EPC;
import multimedi.immoapp.model.enums.PropertyType;
import multimedi.immoapp.repository.PropertyRepository;
import multimedi.immoapp.repository.PropertyRepositoryImpl;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //disable all spam logs of hibernate
        Logger log = Logger.getLogger("org.hibernate");
        log.setLevel(Level.OFF);

        PropertyRepository repository = new PropertyRepositoryImpl();

        var property = createProperty("rue neuve", 200000, PropertyType.APARTMENT, EPC.A, 1, 1, 2, 1);
        var property2 = createProperty(null, 0, null, null, 0, 0, 0, 0);

        repository.save(property);
        repository.save(property2);

        System.out.println("All properties:");
        listAllProperties(repository);

        System.out.println("Properties with address 'rue neuve':");
        listPropertiesByAddress(repository, "rue neuve");
    }

    public static Property createProperty(String address, double price, PropertyType type, EPC epc, int interiorArea, int plotArea, int nrBedrooms, int nrBathrooms) {
        Property property = new Property();
        property.setAddress(address);
        property.setPrice(price);
        property.setType(type);
        property.setEpc(epc);
        property.setInteriorArea(interiorArea);
        property.setNrBedrooms(nrBedrooms);
        property.setPlotArea(plotArea);
        property.setNrBathrooms(nrBathrooms);
        return property;
    }

    public static void listAllProperties(PropertyRepository repository) {
        repository.findAll().forEach(System.out::println);
    }

    public static void listPropertiesByAddress(PropertyRepository repository, String address) {
        repository.findByAddress(address).forEach(System.out::println);
    }
}