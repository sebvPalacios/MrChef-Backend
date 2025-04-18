package com.example.mrchefbackend;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/recetas")
public class RecetaController {

    @PostMapping("/crear")
    public ResponseEntity<String> crearReceta(@RequestBody RecetaDTO receta) {
        // Lógica para crear la receta
        return ResponseEntity.ok("Receta creada con éxito");
    }
}

