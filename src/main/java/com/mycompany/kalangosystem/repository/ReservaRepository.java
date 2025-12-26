package com.mycompany.kalangosystem.repository;

// O caminho deve ser exatamente onde o arquivo Reserva.java está
import com.mycompany.kalangosystem.model.Reserva; 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {
}