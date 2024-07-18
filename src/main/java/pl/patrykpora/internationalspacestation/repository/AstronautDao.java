package pl.patrykpora.internationalspacestation.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.patrykpora.internationalspacestation.database.DBConnectionProvider;
import pl.patrykpora.internationalspacestation.model.Astronaut;

public class AstronautDao implements Dao<Astronaut> {

    public static final Logger logger = LoggerFactory.getLogger(AstronautDao.class);
    private final EntityManager entityManager;

    public AstronautDao() {
        this.entityManager = DBConnectionProvider.getInstance().getEntityManager();
    }

    @Override
    public void save(Astronaut astronaut) {
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            if (!transaction.isActive()) {
                transaction.begin();
            }
            entityManager.persist(astronaut);
            transaction.commit();
        } catch (Exception e) {
            logger.error("error trying to persist [] to db", e);
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }
}
