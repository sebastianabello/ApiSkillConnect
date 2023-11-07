package com.bugbusters.apiskillconnect.services;


import com.bugbusters.apiskillconnect.repositories.GustoUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GustoUsuarioService {
    private final GustoUsuarioRepository gustoUsuarioRepository;

    @Autowired
    public GustoUsuarioService(GustoUsuarioRepository gustoUsuarioRepository) {
        this.gustoUsuarioRepository = gustoUsuarioRepository;
    }
}
