package Entidades;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class ClienteJPA {

    private EntityManager em;

    public ClienteJPA(EntityManager em) {
        this.em = em;
    }

    public List<Cliente> listarClientes() {
        TypedQuery<Cliente> query = em.createQuery("SELECT c FROM Cliente c", Cliente.class);
        return query.getResultList();
    }

    public void cadastrarCliente(Cliente cliente) {
        try {
            em.getTransaction().begin();
            em.persist(cliente);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            throw new RuntimeException("Erro ao cadastrar: " + e.getMessage());
        }
    }

    public List<Cliente> buscarPorNome(String nome) {
        return em.createQuery("SELECT c FROM Cliente c WHERE c.nome LIKE :nome", Cliente.class)
                 .setParameter("nome", "%" + nome + "%")
                 .getResultList();
    }

    public void editar(Cliente cliente) {
        try {
            em.getTransaction().begin();
            em.merge(cliente);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            throw e;
        }
    }

    // CORREÇÃO AQUI: 
    // Em vez de 'throw UnsupportedOperationException', chamamos o seu método funcional.
    public List<Cliente> listarTodos() {
        return listarClientes(); 
    }
}