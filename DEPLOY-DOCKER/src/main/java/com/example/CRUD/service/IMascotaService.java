package com.example.CRUD.service;

import com.example.CRUD.model.Mascota;
import java.util.List;

public interface IMascotaService {
    //Traer todas las personas

    public List<Mascota> getMascotas();

    //Guardar una personas 
    public void saveMascota(Mascota masco);

    //Borrar una persona
    public void deleteMascota(Long id_mascota);

    //Encontrar una persona
    public Mascota findMascota(Long id_mascota);

    //Editar persona
    public void editMascota(Long idOriginal, Long id_mascotaNueva, String nuevoNombre, String nuevaEspecie, String nuevaRaza,String nuevoColor);
    
    public void editMascota(Mascota masco);
}
