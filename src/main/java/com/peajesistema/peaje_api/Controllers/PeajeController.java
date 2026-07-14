package com.peajesistema.peaje_api.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.peajesistema.peaje_api.Services.PeajeService;

@RestController
@RequestMapping("api/peaje")
public class PeajeController {
    @Autowired
    private PeajeService peajeService;

    @GetMapping("/estado")
    public String verificacionEstado(){
        return "El sistema de peajes automatizado está ONLINE. ¡Listo para cobrar!";
    }

    @GetMapping("/cobrar")
    public String cobrarPeage(
        @RequestParam String tagId,
        @RequestParam double costo) {
            return peajeService.procesarPasoPeaje(tagId, costo);
    }

    @PutMapping("/{tagId}/recargar")
    public String recargarPeage(
        @PathVariable String tagId,
        @RequestBody double monto
    ){
        return peajeService.recargarCredito(tagId, monto);
    }


}
