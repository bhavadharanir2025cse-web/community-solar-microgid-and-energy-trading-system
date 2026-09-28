package com.example.communitysolar.service;

import com.example.communitysolar.model.Generation;
import com.example.communitysolar.repository.GenerationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenerationService {

    private final GenerationRepository generationRepository;

    public GenerationService(GenerationRepository generationRepository) {
        this.generationRepository = generationRepository;
    }

    // Create generation record
    public Generation saveGeneration(Generation generation) {
        return generationRepository.save(generation);
    }

    // Get all generation records
    public List<Generation> getAllGeneration() {
        return generationRepository.findAll();
    }

    // Get generation by ID
    public Optional<Generation> getGenerationById(Long id) {
        return generationRepository.findById(id);
    }

    // Update generation
    public Generation updateGeneration(Long id, Generation generation) {

        Generation existingGeneration = generationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Generation record not found"));

        existingGeneration.setUserId(generation.getUserId());
        existingGeneration.setEnergyGenerated(generation.getEnergyGenerated());
        existingGeneration.setDate(generation.getDate());

        return generationRepository.save(existingGeneration);
    }

    // Delete generation
    public void deleteGeneration(Long id) {
        generationRepository.deleteById(id);
    }
}
