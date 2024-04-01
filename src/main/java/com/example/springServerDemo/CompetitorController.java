package com.example.springServerDemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class CompetitorController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    CompetitorService service;

    @GetMapping("/welcome")
    public String welcome() {
        return "Tennis Player REST API";
    }

    @GetMapping("/players")
    public List<Competitor> getAllPlayers() {
        return service.getAllPlayers();
    }

    @GetMapping("/players/{id}")
    public Competitor getPlayer(@PathVariable int id) {
        Competitor competitor = service.getCompetitor(id);
        if (competitor == null) {
            logger.warn("Player with id {} is not found", id);
        }
        return competitor;
    }

    @PostMapping("/players")
    public Competitor addPlayer(@RequestBody Competitor competitor) {
        competitor.setId(0);
        return service.addCompetitor(competitor);
    }

    @PutMapping("/players/{id}")
    public Competitor updatePlayer(@PathVariable int id, @RequestBody Competitor competitor) {
        return service.updateCompetitor(id, competitor);
    }

    @PatchMapping("/players/{id}")
    public Competitor partialUpdate(@PathVariable int id, @RequestBody Map<String, Object> playerPatch) {
        return service.patchCompetitor(id, playerPatch);
    }

    @DeleteMapping("/players/{id}")
    public void deletePlayer(@PathVariable int id) {
        service.deleteCompetitor(id);
    }

}
