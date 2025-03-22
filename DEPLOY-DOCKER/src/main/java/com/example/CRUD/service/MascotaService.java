package com.example.CRUD.service;

import com.example.CRUD.model.Mascota;
import com.example.CRUD.repository.IMascotaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MascotaService implements IMascotaService {

    @Autowired
    private IMascotaRepository mascoRepo;

    @Override
    public List<Mascota> getMascotas() {
        List<Mascota> listaMascotas = mascoRepo.findAll();
        return listaMascotas;
    }

    @Override
    public void saveMascota(Mascota masco) {
        mascoRepo.save(masco);
    }

    @Override
    public void deleteMascota(Long id_mascota) {
        mascoRepo.deleteById(id_mascota);
    }

    @Override
    public Mascota findMascota(Long id_mascota) {
        Mascota masco = mascoRepo.findById(id_mascota).orElse(null);
        return masco;
    }

    @Override
    public void editMascota(Long idOriginal, Long id_mascotaNueva, String nuevoNombre, String nuevaEspecie, String nuevaRaza, String nuevoColor) {
        Mascota masco = this.findMascota(idOriginal);

        //proceso de modificacion a nivel logico
        masco.setId_mascota(id_mascotaNueva);
        masco.setNombre(nuevoNombre);
        masco.setEspecie(nuevaEspecie);
        masco.setRaza(nuevaRaza);
        masco.setColor(nuevoColor);

        //guardar cambios
        this.saveMascota(masco);
    }

    @Override
    public void editMascota(Mascota masco) {  
        this.saveMascota(masco);
        
    }    
}
