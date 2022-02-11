package com.examen.mservice.service;

import com.examen.mservice.entity.Producto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface ProdService {
    @Transactional
    Iterable<Producto> findAll();

    @Transactional(readOnly = true)
    Page<Producto> findAll(Pageable pageable);

    @Transactional(readOnly = true)
    Optional<Producto> findById(Long id);

    @Transactional
    Producto save(Producto producto);

    void deleteById(Long id);
}
