package com.bugbusters.apiskillconnect.auth;


import com.bugbusters.apiskillconnect.exceptions.UsernameAlreadyExistsException;
import com.bugbusters.apiskillconnect.jwt.JwtService;
import com.bugbusters.apiskillconnect.user.Role;
import com.bugbusters.apiskillconnect.user.User;
import com.bugbusters.apiskillconnect.user.UserRepository;
import com.bugbusters.apiskillconnect.exceptions.BadCredentialsException;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthResponse login(LoginRequest request) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
            UserDetails user = userRepository.findByUsername(request.getUsername()).orElseThrow();
            String token = jwtService.getToken(user);
            return AuthResponse.builder().token(token).build();
        } catch (AuthenticationException e) {
            // Manejo de autenticación fallida
            throw new BadCredentialsException("Credenciales inválidas");
        }
    }


    public AuthResponse register(RegisterRequest request) {
        if (userRepository.existsByUsername(request.getUsername())) {
            // Manejo de nombre de usuario duplicado
            throw new UsernameAlreadyExistsException("El nombre de usuario ya está en uso.");
        }
        User user = User.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .country(request.getCountry())
                .role(Role.USER)
                .build();
        userRepository.save(user);
        return AuthResponse.builder()
                .token(jwtService.getToken(user))
                .build();
    }

}
