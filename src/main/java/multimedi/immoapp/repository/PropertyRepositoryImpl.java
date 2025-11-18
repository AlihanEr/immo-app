package multimedi.immoapp.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import multimedi.immoapp.model.Property;

import java.util.List;

public class PropertyRepositoryImpl implements PropertyRepository {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("immo-app");
    EntityManager entityManager = entityManagerFactory.createEntityManager();


    @Override
    public void save(Property property) {
        entityManager.getTransaction().begin();
        entityManager.persist(property);
        entityManager.getTransaction().commit();
    }

    @Override
    public List<Property> findAll() {
        return entityManager.createQuery("SELECT p FROM Property p", Property.class).getResultList();
    }

    @Override
    public List<Property> findByAddress(String address) {
        return entityManager.createQuery("SELECT p FROM Property p WHERE p.address LIKE :searchTerms", Property.class)
                .setParameter("searchTerms", "%" + address + "%").getResultList();
    }
}
