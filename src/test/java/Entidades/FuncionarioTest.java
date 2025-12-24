package Entidades;

// Imports corrigidos para JUnit 5 (Jupiter)
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FuncionarioTest {

    @Test
    public void testValidarSenhaSegura() {
        Funcionario f = new Funcionario();
        
        // Teste com senha curta
        f.setSenha("123");
        boolean senhaCurtaValida = f.getSenha().length() >= 6;
        assertFalse(senhaCurtaValida, "Senha com menos de 6 caracteres não deveria ser aceita");
        
        // Teste com senha aceitável
        f.setSenha("admin123");
        boolean senhaLongaValida = f.getSenha().length() >= 6;
        assertTrue(senhaLongaValida, "Senha com 8 caracteres deveria ser aceita");
    }

    @Test
    public void testValidarCpfCompleto() {
        Funcionario f = new Funcionario();
        f.setCpf("12345678901");
        
        assertEquals(11, f.getCpf().length());
    }

    @Test
    public void testVerificarCargoGerente() {
        Funcionario f = new Funcionario();
        f.setCargo("Gerente");
        
        assertTrue("GERENTE".equalsIgnoreCase(f.getCargo()));
    }
}