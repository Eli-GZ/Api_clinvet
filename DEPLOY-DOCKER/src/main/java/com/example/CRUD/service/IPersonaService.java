package com.example.CRUD.service;

import com.example.CRUD.model.Persona;
import java.util.List;

public interface IPersonaService {

    //Traer todas las personas
    public List<Persona> getPersonas();

    //Guardar una personas 
    public void savePersona(Persona perso);

    //Borrar una persona
    public void deletePersona(Long id);

    //Encontrar una persona
    public Persona findPersona(Long id);

    //Editar persona
    public void editPersona(Long idOriginal, Long idNueva, String nuevoNombre, String nuevoApellido, int nuevaEdad);

    public void editPersona(Persona per);
}
