
package com.electriHome.electriHome.controller;

import com.electriHome.electriHome.models.User;
import com.electriHome.electriHome.services.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author elvis_agui0
 */
@CrossOrigin(origins = "http://localhost:4200",maxAge = 3600)
@RestController
@RequestMapping("/Electronic-Home")
public class Controlador {
    @Autowired
    UserService userServicio;
    
    @GetMapping(path = "/empleados")
    public List<User>list(){
        System.out.println("intento jadlfjasdlf ");
        System.out.println(userServicio.list().get(0).getNombre());
        return userServicio.list();
    }
    
}
