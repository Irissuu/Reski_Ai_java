package com.example.demo.repository;

import com.example.demo.model.UsuarioJava;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<UsuarioJava, Long> {
    Optional<UsuarioJava> findByEmail(String email);
    boolean existsByEmail(String email);
    boolean existsByCpf(String cpf);
}
