package com.examen.mservice.repository;

import com.examen.mservice.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdRepo extends JpaRepository<Producto, Long> {
}
