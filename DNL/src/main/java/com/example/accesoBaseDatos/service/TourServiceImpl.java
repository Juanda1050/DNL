/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.accesoBaseDatos.service;

import com.example.accesoBaseDatos.dao.Tour;
import java.util.List;
import java.util.Optional;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.example.accesoBaseDatos.repository.TourRepository;

@Service
public class TourServiceImpl implements TourService {

    @Resource
    private TourRepository dnlRepo;
    
    @Override
    public List<Tour> getAll() {
        return dnlRepo.findAll();
    }
    
    @Override
    public Tour create(Tour dto) {
        return dnlRepo.save(dto);
    }

    @Override
    public void eliminar(Integer id) {
        dnlRepo.deleteById(id);
    }

    @Override
    public Tour update(Tour form) {
        
        Optional<Tour> userOpt = dnlRepo.findById(form.getId());
        if(userOpt.isPresent()) {
            Tour dnl = userOpt.get();
            dnl.setImage(form.getImage());
            dnl.setDescription(form.getDescription());
            dnl.setDate(form.getDate());
            return dnlRepo.save(dnl);
        }
        return null;
    }
}