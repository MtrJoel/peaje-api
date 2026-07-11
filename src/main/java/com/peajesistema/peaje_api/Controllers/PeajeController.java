package com.peajesistema.peaje_api.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/peaje")
public class PeajeController {
    @GetMapping("/estado")
    public String verificacionEstado(){
        return "El sistema de peajes automatizado está ONLINE. ¡Listo para cobrar!";
    }
}
