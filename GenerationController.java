package com.example.communitysolar.controller;

import com.example.communitysolar.model.Generation;
import com.example.communitysolar.service.GenerationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/generation")
public class GenerationController {

    private final GenerationService generationService;

    public GenerationController(GenerationService generationService) {
        this.generationService = generationService;
    }

    // CREATE
    @PostMapping
    public Generation createGeneration(@RequestBody Generation generation) {
        return generationService.saveGeneration(generation);
    }

    // GET ALL
    @GetMapping
    public List<Generation> getAllGeneration() {
        return generationService.getAllGeneration();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Generation> getGenerationById(@PathVariable Long id) {

        return generationService.getGenerationById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // UPDATE
    @PutMapping("/{id}")
    public Generation updateGeneration(
            @PathVariable Long id,
            @RequestBody Generation generation) {

        return generationService.updateGeneration(id, generation);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteGeneration(@PathVariable Long id) {

        generationService.deleteGeneration(id);

        return ResponseEntity.ok("Generation record deleted successfully");
    }
}
