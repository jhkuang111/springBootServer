package com.example.springServerDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class CompetitorService {

    @Autowired
    CompetitorSpringDataRepository repo;

    // Get all players
    public List<Competitor> getAllPlayers() {
        return repo.findAll();
    }

    // Get player by id
    public Competitor getCompetitor(int id) {
        Optional<Competitor> competitor = repo.findById(id);
        if (competitor.isEmpty()) {
            throw new CompetitorNotFoundException("Player with id {"+ id +"} not found");
        }
        return competitor.get();
    }

    // Add new player
    public Competitor addCompetitor(Competitor c) {
        return repo.save(c);
    }

    // Update current player
    public Competitor updateCompetitor(int id, Competitor c) {
        Competitor competitor = repo.getReferenceById(id);
        competitor.setName(c.getName());
        competitor.setNationality(c.getNationality());
        competitor.setBirthDate(c.getBirthDate());
        competitor.setTitles(c.getTitles());
        return repo.save(competitor);
    }

    // Patch current player
    public Competitor patchCompetitor(int id, Map<String, Object> partialCompetitor) {
        Optional<Competitor> competitor = repo.findById(id);
        if (competitor.isPresent()) {
            partialCompetitor.forEach((key, value) -> {
                System.out.println("Key: " + key + " Value: " + value);
                Field field = ReflectionUtils.findField(Competitor.class, key);
                ReflectionUtils.makeAccessible(field);
                ReflectionUtils.setField(field, competitor.get(), value);
            });
        } else {
            throw new CompetitorNotFoundException("Player with id {"+ id +"} not found");
        }
        return repo.save(competitor.get());
    }

    // Delete player
    public void deleteCompetitor(int id) {
        Optional<Competitor> competitor = repo.findById(id);
        if (competitor.isEmpty()) {
            throw new CompetitorNotFoundException("Player with id {"+ id +"} not found");
        }
        repo.delete(competitor.get());
    }
}
