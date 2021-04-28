/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.accesoBaseDatos.service;

import com.example.accesoBaseDatos.dao.Tour;
import java.util.List;

/**
 *
 * @author JAR
 */
public interface TourService {
    public List<Tour> getAll();
    public Tour create (Tour dto);// <--- NUEVO
    public void eliminar (Integer id);// <--- NUEVO

    public Tour update(Tour Form);
}