package Entidades;

import Entidades.Fornecedor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class FornecedorJPA {

    public static List<Fornecedor> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private EntityManager em;

    // DIP: A classe recebe a conexão pronta via construtor
    public FornecedorJPA(EntityManager em) {
        this.em = em;
    }

    // Alterado para 'cadastrarFornecedor' para bater com a sua tela
    public void cadastrarFornecedor(Fornecedor f) {
        try {
            em.getTransaction().begin();
            em.persist(f);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            // Propagamos o erro para a Interface mostrar no JOptionPane
            throw new RuntimeException("Erro ao persistir fornecedor: " + e.getMessage());
        }
    }

    public List<Fornecedor> listarTodos() {
        // SQL corrigido para garantir compatibilidade
        TypedQuery<Fornecedor> query = em.createQuery("SELECT f FROM Fornecedor f", Fornecedor.class);
        return query.getResultList();
    }

    public Fornecedor buscarPorNome(String nome) {
        try {
            TypedQuery<Fornecedor> query = em.createQuery(
                "SELECT f FROM Fornecedor f WHERE f.nome = :nome", Fornecedor.class);
            query.setParameter("nome", nome);
            // Retorna o primeiro fornecedor encontrado ou null se não existir
            return query.getResultStream().findFirst().orElse(null);
        } catch (Exception e) {
            return null;
        }
    }
    public void editar(Fornecedor f) {
    try {
        em.getTransaction().begin();
        em.merge(f); // O merge identifica o ID e atualiza os dados no banco
        em.getTransaction().commit();
    } catch (Exception e) {
        if (em.getTransaction().isActive()) {
            em.getTransaction().rollback();
        }
        throw e; // Repassa o erro para a tela mostrar no JOptionPane
    }
}
    
}