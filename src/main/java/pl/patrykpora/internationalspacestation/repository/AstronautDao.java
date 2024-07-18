package pl.patrykpora.internationalspacestation.repository;

import jakarta.persistence.EntityManager;
import pl.patrykpora.internationalspacestation.database.DBConnectionProvider;
import pl.patrykpora.internationalspacestation.model.Astronaut;

public class AstronautDao implements Dao<Astronaut> {

    private EntityManager entityManager;

    public AstronautDao() {
        this.entityManager = DBConnectionProvider.getInstance().getEntityManager();
    }

    @Override
    public void save(Astronaut astronaut) {
        entityManager.persist(astronaut);
    }
}
