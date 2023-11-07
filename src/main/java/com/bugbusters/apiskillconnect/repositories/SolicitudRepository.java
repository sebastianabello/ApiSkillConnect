package com.bugbusters.apiskillconnect.repositories;


import com.bugbusters.apiskillconnect.entity.Solicitud;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SolicitudRepository extends JpaRepository<Solicitud, Long> {
}
