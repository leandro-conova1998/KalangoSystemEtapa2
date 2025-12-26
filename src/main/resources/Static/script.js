// Aguarda o carregamento do DOM
document.addEventListener('DOMContentLoaded', () => {
    
    const formReserva = document.getElementById('formReserva');
    const btnLogin = document.querySelector('.btn-login');

    // 1. Funcionalidade Dinâmica: Botão de Login
    btnLogin.addEventListener('click', () => {
        alert('Área restrita: Funcionalidade de Login será implementada no Back-end (Etapa 9).');
    });

    // 2. Validação do Formulário de Reserva
    if (formReserva) {
        formReserva.addEventListener('submit', (event) => {
            event.preventDefault(); // Impede o envio real para testar a validação

            const nome = document.getElementById('nome').value;
            const email = document.getElementById('email').value;

            // Validação simples de exemplo
            if (nome.length < 3) {
                alert('Por favor, insira um nome válido com pelo menos 3 caracteres.');
                return;
            }

            // Simulação de sucesso
            alert(`Obrigado, ${nome}! Sua solicitação de reserva foi enviada com sucesso para o e-mail: ${email}.`);
            formReserva.reset(); // Limpa o formulário
        });
    }
});