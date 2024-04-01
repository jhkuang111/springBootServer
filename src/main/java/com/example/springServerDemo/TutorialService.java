package com.example.springServerDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TutorialService {

    @Autowired
    TutorialRepository tutorialRepo;

    public List<Tutorial> getAllTutorials() {
        return tutorialRepo.findAll();
    }

    public List<Tutorial> getPublishedTutorials() {
        return tutorialRepo.findByPublished(true);
    }

    public Tutorial createTutorial(Tutorial t) {
        return tutorialRepo.save(t);
    }
}
