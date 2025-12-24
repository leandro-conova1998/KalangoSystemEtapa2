package Service;

import Entidades.Funcionario;

public class FuncionarioService {
    public void validarFuncionario(Funcionario f) {
        if (f.getNome().isEmpty() || f.getCpf().isEmpty() || f.getCargo().isEmpty()) {
            throw new IllegalArgumentException("Todos os campos do funcionário devem ser preenchidos!");
        }
        
        if (f.getCpf().length() != 11) {
            throw new IllegalArgumentException("CPF inválido! Deve conter 11 dígitos.");
        }
    }
}