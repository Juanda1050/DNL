/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.accesoBaseDatos.service;

import com.example.accesoBaseDatos.dao.Usuarios;
import com.example.accesoBaseDatos.repository.UsuariosRepository;
import java.util.List;
import java.util.Optional;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class UsuariosServiceImpl implements UsuariosService {

    @Resource
    private UsuariosRepository userRepo;
    
    @Override
    public List<Usuarios> getAll() {
        return userRepo.findAll();
    }
    
    @Override
    public Usuarios create(Usuarios dto) {
        return userRepo.save(dto);
    }

    @Override
    public void eliminar(Integer idUsuario) {
        userRepo.deleteById(idUsuario);
    }

    @Override
    public Usuarios update(Usuarios userForm) {
        
        Optional<Usuarios> userOpt = userRepo.findById(userForm.getId());
        if(userOpt.isPresent()) {
            Usuarios userBD = userOpt.get();
            userBD.setNombre(userForm.getNombre());
            userBD.setEmail(userForm.getEmail());
            userBD.setPassword(userForm.getPassword());
            return userRepo.save(userBD);
        }
        return null;
    }
}