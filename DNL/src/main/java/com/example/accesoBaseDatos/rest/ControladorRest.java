/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.accesoBaseDatos.rest;

import com.example.accesoBaseDatos.dao.Tour;
import com.example.accesoBaseDatos.dao.Usuarios;
import com.example.accesoBaseDatos.service.TourService;
import com.example.accesoBaseDatos.service.UsuariosService;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
/**
 *
 * @author JAR
 */
@RestController
public class ControladorRest {
    
    @Resource
    UsuariosService userService;
    @Resource
    TourService dnlService;
    
    @GetMapping("/getUsuarios")
    @ResponseBody
    public List<Usuarios> getUsuarios() {
        return userService.getAll();
    }
    @GetMapping("/getTours")
    @ResponseBody
    public List<Tour> getTours() {
        return dnlService.getAll();
    }
    @PostMapping("/alta")
    public ResponseEntity altaUsuario(String request) {
        System.out.println("Entra al alta de usuario" + request);
        JSONObject usuarioJSON = new JSONObject(request);
        Usuarios nuevoUsuario = Usuarios.builder()
                .email(usuarioJSON.getString("email").toLowerCase())
                .nombre(usuarioJSON.getString("nombre"))
                .creacion(Calendar.getInstance().getTime())
                .password(usuarioJSON.getString("password")).build();
        userService.create(nuevoUsuario);
        return ResponseEntity.ok(generaRespuestaCorrecta());
    }
    @PostMapping("/cambio")
    public ResponseEntity cambioUsuario(String request) {
        System.out.println("Entra al alta de usuario" + request);
        JSONObject usuarioJSON = new JSONObject(request);
        Usuarios userForm = Usuarios.builder()
                .id(usuarioJSON.getInt("id"))
                .email(usuarioJSON.getString("email").toLowerCase())
                .nombre(usuarioJSON.getString("nombre"))
                .creacion(Calendar.getInstance().getTime())
                .password(usuarioJSON.getString("password")).build();
        userService.update(userForm);
        return ResponseEntity.ok(generaRespuestaCorrecta());
    }
    
    @PostMapping("/altaEvento")
    public ResponseEntity altaEvento(String request) {
        System.out.println("Entra al alta de usuario" + request);
        JSONObject usuarioJSON = new JSONObject(request);
        Tour nuevoTour = Tour.builder()
                .image(usuarioJSON.getString("image"))
                .description(usuarioJSON.getString("description"))
                .date(usuarioJSON.getString("date")).build();
        dnlService.create(nuevoTour);
        return ResponseEntity.ok(generaRespuestaCorrecta());
    }
    @PostMapping("/cambioEvento")
    public ResponseEntity cambioEvento(String request) {
        System.out.println("Entra al alta de usuario" + request);
        JSONObject usuarioJSON = new JSONObject(request);
        Tour Form = Tour.builder()
                .id(usuarioJSON.getInt("id"))
                .image(usuarioJSON.getString("image"))
                .description(usuarioJSON.getString("description"))
                .date(usuarioJSON.getString("date")).build();
        dnlService.update(Form);
        return ResponseEntity.ok(generaRespuestaCorrecta());
    }

    private JSONObject generaRespuestaCorrecta() {
        //Usuarios user = request.getRecord();
        //userService.create(user);
        Map resultadoJson = new HashMap(){{
            put("status", "success");
        }};
        JSONObject result = new JSONObject(resultadoJson);
        return result;
    }
    
    @PostMapping("/baja")
    public ResponseEntity bajaUsuario(String request) {
        System.out.println("Ejecuta una baja de usuario: " + request);
        JSONObject JSON = new JSONObject(request);
        JSONArray idsEliminar = JSON.getJSONArray("listaUsuarios");
        for (Object idObj : idsEliminar) {
            userService.eliminar(Integer.parseInt(idObj.toString()));
        }
        return ResponseEntity.ok(generaRespuestaCorrecta());
    }
    
    @PostMapping("/bajaEvento")
    public ResponseEntity bajaEvento(String request) {
        System.out.println("Ejecuta una baja de usuario: " + request);
        JSONObject JSON = new JSONObject(request);
        JSONArray idsEliminar = JSON.getJSONArray("listaTours");
        for (Object idObj : idsEliminar) {
            dnlService.eliminar(Integer.parseInt(idObj.toString()));
        }
        return ResponseEntity.ok(generaRespuestaCorrecta());
    }
}