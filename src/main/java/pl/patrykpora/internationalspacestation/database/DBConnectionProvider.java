package pl.patrykpora.internationalspacestation.database;

import jakarta.persistence.EntityManager;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import pl.patrykpora.internationalspacestation.model.Astronaut;
import pl.patrykpora.internationalspacestation.model.IssPosition;
import pl.patrykpora.internationalspacestation.model.IssSpeed;


public class DBConnectionProvider {

    private static DBConnectionProvider dbConnectionProvider;
    private final SessionFactory sessionFactory;

    private DBConnectionProvider() {
        this.sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
    }

    public static synchronized DBConnectionProvider getInstance() {
        if (dbConnectionProvider == null) {
            dbConnectionProvider = new DBConnectionProvider();
        }
        return dbConnectionProvider;
    }

    public EntityManager getEntityManager() {
        return dbConnectionProvider.sessionFactory.createEntityManager();
    }


}
