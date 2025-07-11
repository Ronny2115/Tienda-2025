package com.tienda.repositories;

import com.tienda.entities.Persona;
import org.springframework.data.repository.CrudRepository;

public interface PersonaRepository extends CrudRepository<Persona, Long> {

}
