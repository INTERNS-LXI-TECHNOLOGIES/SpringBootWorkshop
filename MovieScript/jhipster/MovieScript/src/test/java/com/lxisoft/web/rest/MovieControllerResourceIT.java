package com.lxisoft.web.rest;

import com.lxisoft.MovieScriptApp;
import com.lxisoft.repository.ActorRepository;
import com.lxisoft.repository.DialogueRepository;
import com.lxisoft.repository.MovieRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
/**
 * Test class for the MovieControllerResource REST controller.
 *
 * @see MovieControllerResource
 */
@SpringBootTest(classes = MovieScriptApp.class)
public class MovieControllerResourceIT {

    private final ActorRepository actorRepository;

    private final DialogueRepository dialogueRepository;

    private final MovieRepository movieRepository;
    private MockMvc restMockMvc;

    public MovieControllerResourceIT(ActorRepository actorRepository, DialogueRepository dialogueRepository, MovieRepository movieRepository) {
        this.actorRepository = actorRepository;
        this.dialogueRepository = dialogueRepository;
        this.movieRepository = movieRepository;
    }

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        MovieControllerResource movieControllerResource = new MovieControllerResource(actorRepository, dialogueRepository, movieRepository);
        restMockMvc = MockMvcBuilders
            .standaloneSetup(movieControllerResource)
            .build();
    }

    /**
     * Test add
     */
    @Test
    public void testAdd() throws Exception {
        restMockMvc.perform(get("/api/movie-controller/add"))
            .andExpect(status().isOk());
    }
}
