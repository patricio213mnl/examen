package com.examen.mservice.controller;

import com.examen.mservice.entity.Producto;
import com.examen.mservice.service.ProdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/api/productos")
public class ProdController {

    @Autowired
    private ProdService prodService;

    //Nuevo Producto
    @PostMapping
    public ResponseEntity<?> create (@RequestBody Producto producto){
        return ResponseEntity.status(HttpStatus.CREATED).body(prodService.save(producto));
    }

    //busqueda personalizada
    @GetMapping("/{id}")
    public ResponseEntity<?> read(@PathVariable(value="id") Long userId){
        Optional<Producto> optionalUser=prodService.findById(userId);
        if(!optionalUser.isPresent()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(optionalUser);
    }
    //Modificar Usuario
    @PutMapping("/{id}")
    public ResponseEntity<?> update (@RequestBody Producto userDatails,@PathVariable(value = "id") Long userId){
        Optional<Producto> user =prodService.findById(userId);
        if(!user.isPresent()){
            return ResponseEntity.notFound().build();
        }
        user.get().setDescripcion((userDatails.getDescripcion()));
        user.get().setPrecio(userDatails.getPrecio());
        user.get().setCantidad(userDatails.getCantidad());
        return ResponseEntity.status(HttpStatus.CREATED).body(prodService.save(user.get()));
    }
    //eliminar usuario
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long userId){
        if(!prodService.findById(userId).isPresent()){
            return ResponseEntity.notFound().build();
        }
        prodService.deleteById(userId);
        return ResponseEntity.ok().build();
    }
    //Listar todos los usuarios
    @GetMapping
    public List<Producto> readAll(){
        List<Producto> productos= StreamSupport.stream(prodService.findAll().spliterator(),false).collect(Collectors.toList());
        return productos;
    }
}
