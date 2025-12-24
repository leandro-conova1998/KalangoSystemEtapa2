package Entidades;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class ProdutoJPA {

    private EntityManager em;

    public ProdutoJPA(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(Produto p) {
        try {
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new RuntimeException("Erro ao persistir produto: " + e.getMessage());
        }
    }

    public List<Produto> listar() {
        TypedQuery<Produto> query = em.createQuery("SELECT p FROM Produto p", Produto.class);
        return query.getResultList();
    }

    public void excluir(int id) {
        try {
            em.getTransaction().begin();
            Produto produto = em.find(Produto.class, id);
            if (produto != null) {
                em.remove(produto);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            throw e;
        }
    }

    public void atualizar(Produto produto) {
        try {
            em.getTransaction().begin();
            em.merge(produto);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            throw e;
        }
    }

    public List<Produto> buscarPorNome(String nome) {
        return em.createQuery("SELECT p FROM Produto p WHERE p.nome LIKE :nome", Produto.class)
                 .setParameter("nome", "%" + nome + "%")
                 .getResultList();
    }
    
    public void editar(Produto p) {
        try {
            em.getTransaction().begin();
            em.merge(p); 
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            throw e;
        }
    }

    /**
     * CORREÇÃO: Em vez de lançar uma exceção, este método agora 
     * redireciona para o método 'cadastrar(p)' que já está pronto.
     */
    public void cadastrarProduto(Produto p) {
        this.cadastrar(p);
    }
}