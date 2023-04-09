package iti.jets.repository.connection;

import jakarta.persistence.*;

public final class DBMananger {
    private static EntityManagerFactory entityManagerFactory = null;

    private DBMananger() {}

    public static synchronized EntityManagerFactory getInstance() {
        if (entityManagerFactory == null) {
            entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
        }
        return entityManagerFactory;
    }
}

