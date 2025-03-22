package com.example.CRUD.controller;

import com.example.CRUD.model.Mascota;
import com.example.CRUD.service.IMascotaService;
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
public class MascotaController {

    @Autowired
    private IMascotaService mascoServ;

    //ENDPOINT para obtener todas las personas
    @GetMapping("/mascotas/traer")
    public List<Mascota> getMascotas() {
        return mascoServ.getMascotas();
    }
    
    //ENDPOINT para crear una nueva persona
    @PostMapping("/mascotas/crear")
    public String createMascota(@RequestBody Mascota masco) {
        mascoServ.saveMascota(masco);
        //mensaje de creacion correcta
        return "La mascota fue creada correctamente";
    }
    

    //ENDPOINT para eliminar una nueva persona
    @DeleteMapping("/mascotas/borrar/{id}")
    public String deleteMascota(@PathVariable Long id) {

        mascoServ.deleteMascota(id);

        //mensaje de eliminacion correcta
        return "La Mascota fue eliminada correctamente";
    }

    //ENDPOINT para modificar una nueva persona
    @PutMapping("/mascotas/editar/{id_original}")
    public Mascota editMascota (@PathVariable Long id_original,
            @RequestParam(required = false, name = "id") Long nuevaId,
            @RequestParam(required = false, name = "nombre") String nuevoNombre,
            @RequestParam(required = false, name = "especie") String nuevoEspecie,
            @RequestParam(required = false, name = "raza") String nuevaRaza,
            @RequestParam(required = false, name = "color") String nuevoColor) {

        //Envio id original(para buscar)
        //Envio nuevos datos para modificar
       mascoServ.editMascota(id_original, id_original, nuevoNombre, nuevoEspecie, nuevaRaza, nuevoColor);

        //busco la persoan editada para mostrarla
        Mascota masco =mascoServ.findMascota(nuevaId);

        return masco;
    }

    @PutMapping("/mascotas/editar")
    public Mascota editMascota(@RequestBody Mascota masco) {
mascoServ.editMascota(masco);
        return mascoServ.findMascota(masco.getId_mascota());
    }
}
