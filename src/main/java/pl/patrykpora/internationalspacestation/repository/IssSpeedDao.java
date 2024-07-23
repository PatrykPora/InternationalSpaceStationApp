package pl.patrykpora.internationalspacestation.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.patrykpora.internationalspacestation.database.DBConnectionProvider;
import pl.patrykpora.internationalspacestation.model.IssSpeed;

public class IssSpeedDao implements Dao<IssSpeed> {

    public static final Logger logger = LoggerFactory.getLogger(IssSpeedDao.class);
    private final EntityManager entityManager;

    public IssSpeedDao() {
        this.entityManager = DBConnectionProvider.getInstance().getEntityManager();
    }

    @Override
    public void save(IssSpeed issSpeed) {
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            if (!transaction.isActive()) {
                transaction.begin();
            }
            entityManager.persist(issSpeed);
            transaction.commit();
        } catch (Exception e) {
            logger.error("error trying to persist {} to db", issSpeed, e);
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }
}
