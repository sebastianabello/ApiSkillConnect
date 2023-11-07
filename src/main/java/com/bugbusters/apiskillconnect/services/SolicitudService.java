package com.bugbusters.apiskillconnect.services;

import com.bugbusters.apiskillconnect.repositories.SolicitudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SolicitudService {
    private final SolicitudRepository solicitudRepository;

    @Autowired
    public SolicitudService(SolicitudRepository solicitudRepository) {
        this.solicitudRepository = solicitudRepository;
    }
}
