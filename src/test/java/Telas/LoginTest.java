package Telas;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

/**
 * Teste unitário para a classe Login
 * @author flavio
 */
public class LoginTest {
    
    public LoginTest() {
    }

    @BeforeAll
    public static void setUpClass() throws Exception {
    }

    @AfterAll
    public static void tearDownClass() throws Exception {
    }

    @BeforeEach
    public void setUp() throws Exception {
    }

    @AfterEach
    public void tearDown() throws Exception {
    }

    /**
     * Teste para verificar se a tela de Login é instanciada corretamente
     */
    @Test
    public void testLoginInitialization() {
        System.out.println("Verificando inicialização da tela de Login...");
        
        // Instancia a tela
        Login instance = new Login();
        
        // Verifica se o objeto não é nulo
        assertNotNull(instance, "A tela de Login não deveria ser nula.");
        
        // Verifica se a tela inicia com o título ou visibilidade correta
        // (Isso garante que o initComponents rodou sem erros)
        instance.setVisible(true);
        assertTrue(instance.isVisible(), "A tela deveria estar visível.");
        
        // Fecha a tela após o teste
        instance.dispose();
    }

    /**
     * Teste do método main da classe Login
     */
    @Test
    public void testMain() {
        System.out.println("Executando main da Login...");
        String[] args = {};
        
        // Tenta executar o main. Se houver erro de inicialização, o teste falhará aqui.
        assertDoesNotThrow(() -> {
            Login.main(args);
        }, "O método main deveria executar sem lançar exceções.");
    }
}