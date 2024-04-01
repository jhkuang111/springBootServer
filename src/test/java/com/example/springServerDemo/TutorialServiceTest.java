package com.example.springServerDemo;

import com.datastax.oss.driver.api.core.uuid.Uuids;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class TutorialServiceTest {

    @Mock
    TutorialRepository tutorialRepo;

    @InjectMocks
    TutorialService tutorialService;

    @Test
    void testGetAllTutorials() {
        Tutorial one = new Tutorial(Uuids.timeBased(), "TutorialOne", "TutorialOneDescription", true);
        Tutorial two = new Tutorial(Uuids.timeBased(), "TutorialTwo", "TutorialTwoDescription", false);
        when(tutorialRepo.findAll()).thenReturn(Arrays.asList(one, two));
        int expectedTutorials = 2;
        assertEquals(expectedTutorials,  tutorialService.getAllTutorials().size());
        assertEquals("TutorialOne", tutorialService.getAllTutorials().get(0).getTitle());
        assertEquals("TutorialTwo", tutorialService.getAllTutorials().get(1).getTitle());
        assertTrue(tutorialService.getAllTutorials().get(0).isPublished());
        assertFalse(tutorialService.getAllTutorials().get(1).isPublished());
    }
}
