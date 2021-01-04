package com.lxisoft.web.rest;

import com.lxisoft.MovieScriptApp;
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

    private MockMvc restMockMvc;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        MovieControllerResource movieControllerResource = new MovieControllerResource();
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
