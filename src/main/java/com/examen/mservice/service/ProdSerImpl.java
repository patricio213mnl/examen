package com.examen.mservice.service;

import com.examen.mservice.entity.Producto;
import com.examen.mservice.repository.ProdRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ProdSerImpl implements ProdService {

    @Autowired
    private ProdRepo prodRepo;

    @Override
    @Transactional
    public Iterable<Producto> findAll() {
        return prodRepo.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Producto> findAll(Pageable pageable) {
        return prodRepo.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Producto> findById(Long id) {
        return prodRepo.findById(id);
    }

    @Override
    @Transactional
    public Producto save(Producto producto) {
        return prodRepo.save(producto);
    }

    @Override
    public void deleteById(Long id) {
        prodRepo.deleteById(id);
    }
}
