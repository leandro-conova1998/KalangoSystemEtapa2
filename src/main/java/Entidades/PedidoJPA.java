package Entidades;

import Entidades.Pedido;
import jakarta.persistence.EntityManager;
import java.util.List;

public class PedidoJPA {

    private EntityManager em;

    public PedidoJPA(EntityManager em) {
        this.em = em;
    }

    public void registrar(Pedido pedido) {
        try {
            em.getTransaction().begin();
            
            // SRP: A DAO apenas persiste o objeto raiz. 
            // O CascadeType.ALL configurado na Entidade Pedido 
            // salvará automaticamente todos os ItemPedido vinculados.
            em.persist(pedido);
            
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new RuntimeException("Erro ao registrar pedido: " + e.getMessage());
        }
    }

    public List<Pedido> listarTodos() {
        return em.createQuery("SELECT p FROM Pedido p", Pedido.class).getResultList();
    }

    public void excluir(int id) {
        try {
            em.getTransaction().begin();
            Pedido p = em.find(Pedido.class, id);
            if (p != null) {
                em.remove(p);
                em.getTransaction().commit();
            }
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            throw e;
        }
    }
    
    public void inserir(Pedido pedido) {
    try {
        em.getTransaction().begin();
        em.persist(pedido); // Grava o pedido
        
        // Se houver itens associados, o JPA persistirá se estiver configurado com Cascade
        // Caso contrário, você percorreria os itens aqui.
        
        em.getTransaction().commit();
    } catch (Exception e) {
        if (em.getTransaction().isActive()) {
            em.getTransaction().rollback();
        }
        throw new RuntimeException("Erro ao salvar pedido: " + e.getMessage());
    }
}
    public void editar(Pedido p) {
    try {
        em.getTransaction().begin();
        em.merge(p); // Atualiza o pedido existente no banco
        em.getTransaction().commit();
    } catch (Exception e) {
        if (em.getTransaction().isActive()) em.getTransaction().rollback();
        throw e;
    }
}
    
}