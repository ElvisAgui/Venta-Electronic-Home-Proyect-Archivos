package com.electriHome.electriHome.controller;

import com.electriHome.electriHome.models.User;
import com.electriHome.electriHome.models.empleados.Empleado;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.electriHome.electriHome.respositories.EmpleadoRepository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author elvis_agui0
 */
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/Electronic-Home")
public class Controlador {

    @Autowired
    EmpleadoRepository userRepositori;

    @GetMapping(path = "/empleados")
    public List<Empleado> list(@RequestParam String cui, @RequestParam String password) {
        System.out.println("intento jadlfjasdlf ");
        List<Empleado> empleados = new ArrayList<>();
        List<Object[]> result = userRepositori.getEmpleadoSecion(cui, password);
        for (Object[] obj : result) {
            Empleado emp = new Empleado((String) obj[0], (String) obj[1], (String) obj[2], (String) obj[3], (BigDecimal) obj[4], (java.lang.Short) obj[5], (String) obj[6], (Integer) obj[7]);
            empleados.add(emp);
        }
        return empleados;
    }

    @GetMapping(path = "/empleadoSecion")
    public Empleado empleadoSecion(@RequestParam String cui, @RequestParam String password) {
        System.out.println("intento jadlfjasdlf ");
        List<Object[]> result = userRepositori.getEmpleadoSecion(cui, password);
        if (!result.isEmpty()) {
            Empleado empleado = new Empleado((String) result.get(0)[0], (String) result.get(0)[1], (String) result.get(0)[2], (String) result.get(0)[3], (BigDecimal) result.get(0)[4],
                    (java.lang.Short) result.get(0)[5], (String) result.get(0)[6], (Integer) result.get(0)[7]);
            return empleado;
        }else{
            return null;
        }
        
    }

}
