package pl.patrykpora.internationalspacestation.database;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import jakarta.persistence.EntityManager;
import pl.patrykpora.internationalspacestation.model.Astronaut;

public class DBConnectionProvider {

    private final EntityManager entityManager;
    private static final SessionFactory sessionFactory = new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(Astronaut.class)
            // add annotated classes here
            .buildSessionFactory();
    private static final DBConnectionProvider instance = new DBConnectionProvider();

    private DBConnectionProvider() {
        this.entityManager = sessionFactory.createEntityManager();
    }

    public static DBConnectionProvider getInstance() {
        return instance;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }
}
