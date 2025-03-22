
package com.example.CRUD.repository;

import com.example.CRUD.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonaRepository extends JpaRepository<Persona,Long>{
    
    
}
