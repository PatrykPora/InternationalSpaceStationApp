package pl.patrykpora.internationalspacestation.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.patrykpora.internationalspacestation.database.DBConnectionProvider;
import pl.patrykpora.internationalspacestation.model.IssPosition;

public class IssPositionDao implements Dao<IssPosition> {

    public static final Logger logger = LoggerFactory.getLogger(IssPositionDao.class);
    private final EntityManager entityManager;

    public IssPositionDao() {
        this.entityManager = DBConnectionProvider.getInstance().getEntityManager();
    }

    @Override
    public void save(IssPosition issPosition) {
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            if (!transaction.isActive()) {
                transaction.begin();
            }
            entityManager.persist(issPosition);
            transaction.commit();
        } catch (Exception e) {
            logger.error("error trying to persist {} to db", issPosition, e);
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }
}
