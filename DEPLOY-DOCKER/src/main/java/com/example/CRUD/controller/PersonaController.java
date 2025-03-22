package com.example.CRUD.controller;

import com.example.CRUD.model.Persona;
import com.example.CRUD.service.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonaController {

    @Autowired
    private IPersonaService interPersona;

    //ENDPOINT para obtener todas las personas
    @GetMapping("/personas/traer")
    public List<Persona> getPersonas() {
        return interPersona.getPersonas();
    }

    //ENDPOINT para crear una nueva persona
    @PostMapping("/personas/crear")
    public String createStudent(@RequestBody Persona perso) {
        interPersona.savePersona(perso);
        //mensaje de creacion correcta
        return "La persona fue creada correctamente";
    }

    //ENDPOINT para eliminar una nueva persona
    @DeleteMapping("/personas/borrar/{id}")
    public String deletePersona(@PathVariable Long id) {

        interPersona.deletePersona(id);

        //mensaje de eliminacion correcta
        return "La persona fue eliminada correctamente";
    }

    //ENDPOINT para modificar una nueva persona
    @PutMapping("/personas/editar/{id_original}")
    public Persona editPersona(@PathVariable Long id_original,
            @RequestParam(required = false, name = "id") Long nuevaId,
            @RequestParam(required = false, name = "nombre") String nuevoNombre,
            @RequestParam(required = false, name = "apellido") String nuevoApellido,
            @RequestParam(required = false, name = "edad") int nuevaEdad) {

        //Envio id original(para buscar)
        //Envio nuevos datos para modificar
        interPersona.editPersona(id_original, nuevaId, nuevoNombre, nuevoApellido, nuevaEdad);

        //busco la persoan editada para mostrarla
        Persona perso = interPersona.findPersona(nuevaId);

        return perso;
    }

    @PutMapping("/personas/editar")
    public Persona editPersona(@RequestBody Persona per) {
        interPersona.editPersona(per);
        return interPersona.findPersona(per.getId());
    }
}
