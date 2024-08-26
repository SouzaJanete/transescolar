package com.example.transescolar.repository;


import com.example.transescolar.model.Turno;
import org.hibernate.action.internal.EntityAction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TurnoRepository extends JpaRepository<Turno, Long> {
    Optional<Turno> findById(EntityAction updatedTurno2);
}
