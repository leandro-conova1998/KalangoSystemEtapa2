package Entidades; // Refatoração: Pacote de infraestrutura

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Conexao {

    private static final String PERSISTENCE_UNIT = "kalangosystem";
    private static EntityManagerFactory fabrica;

    // Estático apenas para a Fábrica (Singleton), pois ela é pesada e deve ser única
    static {
        try {
            fabrica = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        } catch (Throwable ex) {
            System.err.println("Falha ao criar a fábrica de conexões: " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static EntityManager getEntityManager() {
        // SRP: Esta classe agora apenas fornece o gerente, não o armazena estaticamente
        // Isso evita que dois usuários na web usem o mesmo gerente ao mesmo tempo
        return fabrica.createEntityManager();
    }

    public static void fecharFabrica() {
        if (fabrica != null && fabrica.isOpen()) {
            fabrica.close();
        }
    }
}