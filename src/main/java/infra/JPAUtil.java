package infra;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtil {
    // O nome "kalangosystem" deve ser o mesmo que está no seu persistence.xml
    private static EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("kalangosystem");

    public static EntityManager getEntityManager() {
        return fabrica.createEntityManager();
    }
}
