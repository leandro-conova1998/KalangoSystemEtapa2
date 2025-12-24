package Entidades;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class FuncionarioJPA {

    private EntityManager em;

    public FuncionarioJPA(EntityManager em) {
        this.em = em;
    }

    public Funcionario buscarPorCpf(String cpf) {
        TypedQuery<Funcionario> query = em.createQuery(
            "SELECT f FROM Funcionario f WHERE f.cpf = :cpf", Funcionario.class);
        query.setParameter("cpf", cpf);
        return query.getResultStream().findFirst().orElse(null);
    }

    public void cadastrarFuncionario(Funcionario f) {
        try {
            em.getTransaction().begin();
            em.persist(f);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            throw new RuntimeException("Erro ao persistir funcionário: " + e.getMessage());
        }
    }

    public List<Funcionario> listarTodos() {
        return em.createQuery("SELECT f FROM Funcionario f", Funcionario.class).getResultList();
    }

    public void excluir(int id) {
        try {
            em.getTransaction().begin();
            Funcionario fun = em.find(Funcionario.class, id);
            if (fun != null) {
                em.remove(fun);
                em.getTransaction().commit();
            } else {
                em.getTransaction().rollback();
            }
        } catch (Exception ex) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            throw ex;
        }
    }

    public void editar(Funcionario f) {
        try {
            em.getTransaction().begin();
            em.merge(f);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            throw e;
        }
    }

    /**
     * MÉTODO CORRIGIDO PARA O LOGIN
     * Adicionado o caminho completo da classe para evitar o erro "cannot find symbol"
     */
    public static Entidades.Funcionario validarFuncionario(Entidades.Funcionario f) {
        // Criamos um EntityManager local para o método estático
        jakarta.persistence.EntityManager emStatic = infra.JPAUtil.getEntityManager();
        try {
            String jpql = "SELECT f FROM Funcionario f WHERE f.cpf = :cpf AND f.senha = :senha";
            return emStatic.createQuery(jpql, Entidades.Funcionario.class)
                     .setParameter("cpf", f.getCpf())
                     .setParameter("senha", f.getSenha())
                     .getSingleResult();
        } catch (jakarta.persistence.NoResultException e) {
            return null; 
        } finally {
            if (emStatic.isOpen()) {
                emStatic.close();
            }
        }
    }
}