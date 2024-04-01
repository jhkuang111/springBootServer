package com.example.springServerDemo;

import com.datastax.oss.driver.api.core.uuid.Uuids;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TutorialController {

    @Autowired
    TutorialService tutorialService;

    @GetMapping("/check")
    public String check() {
        return "JH checking server";
    }

    @GetMapping("/tutorials")
    public List<Tutorial> getAllTutorials() {
        return tutorialService.getAllTutorials();
    }

    @GetMapping("/tutorials/published")
    public List<Tutorial> getPublishedTutorials() {
        return tutorialService.getPublishedTutorials();
    }

    @PostMapping("/tutorials")
    public Tutorial addTutorial(@RequestBody Tutorial tutorial) {
        return tutorialService.createTutorial(new Tutorial(Uuids.timeBased(), tutorial.getTitle(), tutorial.getDescription(), tutorial.isPublished()));
    }
}
