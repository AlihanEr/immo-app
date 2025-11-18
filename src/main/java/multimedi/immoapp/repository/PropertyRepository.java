package multimedi.immoapp.repository;

import multimedi.immoapp.model.Property;

import java.util.List;

public interface PropertyRepository {
    void save(Property property);

    List<Property> findAll();

    List<Property> findByAddress(String address);
}
