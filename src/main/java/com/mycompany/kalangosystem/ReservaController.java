package com.mycompany.kalangosystem;

import com.mycompany.kalangosystem.model.Reserva;
import com.mycompany.kalangosystem.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reservas")
public class ReservaController {

    @Autowired
    private ReservaRepository repository;

    @PostMapping
    public String salvar(@RequestBody Reserva reserva) {
        repository.save(reserva); // Salva no MySQL automaticamente
        return "Reserva realizada com sucesso!";
    }
}