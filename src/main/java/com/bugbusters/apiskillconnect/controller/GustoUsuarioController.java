package com.bugbusters.apiskillconnect.controller;


import com.bugbusters.apiskillconnect.services.GustoUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/gustos")
public class GustoUsuarioController {
    private final GustoUsuarioService gustoUsuarioService;

    @Autowired
    public GustoUsuarioController(GustoUsuarioService gustoUsuarioService) {
        this.gustoUsuarioService = gustoUsuarioService;
    }
}
