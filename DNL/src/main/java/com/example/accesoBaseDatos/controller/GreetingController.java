package com.example.accesoBaseDatos.controller;

import com.example.accesoBaseDatos.dao.Usuarios;
import com.example.accesoBaseDatos.dto.UsuariosWrapper;
import com.example.accesoBaseDatos.service.UsuariosService;
import java.util.List;
import javax.annotation.Resource;
import org.json.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

    @Resource
    UsuariosService userService;
    
    @GetMapping("/greeting")
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
        
        // Ejemplo de uso de los datos de la BD
        List<Usuarios> usuarios = userService.getAll();
        if(name.equals("World")){
            name = usuarios.get(0).getNombre();
        }
        
        UsuariosWrapper wrapper = new UsuariosWrapper();
        wrapper.setUsers(usuarios);
        
        JSONArray list = new JSONArray(usuarios);
        
        
        model.addAttribute("list", list);
        model.addAttribute("wrapper", wrapper);
        model.addAttribute("name", name);
        return "greeting";
    }
    
    @RequestMapping("/perfom_login")
    public String login(Model model) {
        return "greeting";
    }
    
    @GetMapping("/form")
    public String formulario(Model model) {
        return "formulario";
    }
    
    @RequestMapping("/listadoUsuarios")
    public String listadoUsuarios(Model model) {
        return "listadoUsuarios";
    }
    
    @RequestMapping("/listadoTours")
    public String listadoTours(Model model) {
        return "listadoTours";
    }
    
    @RequestMapping("/tours")
    public String tours(Model model) {
        return "tours";
    }
    @RequestMapping("/bioparque")
    public String bioparque(Model model) {
        return "bioparque";
    }
    @RequestMapping("/caballo")
    public String caballo(Model model) {
        return "caballo";
    }
    @RequestMapping("/conoce")
    public String conoce(Model model) {
        return "conoce";
    }
    @RequestMapping("/contacto")
    public String contacto(Model model) {
        return "contacto";
    }
    @RequestMapping("/fundidora")
    public String fundidora(Model model) {
        return "fundidora";
    }
    @RequestMapping("/grutas")
    public String grutas(Model model) {
        return "grutas";
    }
    @RequestMapping("/index")
    public String index(Model model) {
        return "index";
    }
    @RequestMapping("/obispado")
    public String obispado(Model model) {
        return "obispado";
    }
    @RequestMapping("/psl")
    public String psl(Model model) {
        return "psl";
    }
    @RequestMapping("/santiago")
    public String santiago(Model model) {
        return "santiago";
    }
    

}
