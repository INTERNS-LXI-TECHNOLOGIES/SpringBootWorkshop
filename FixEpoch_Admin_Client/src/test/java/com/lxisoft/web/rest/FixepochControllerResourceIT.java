package com.lxisoft.web.rest;

import com.lxisoft.FixEpochAdminClientApp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
/**
 * Test class for the FixepochControllerResource REST controller.
 *
 * @see FixepochControllerResource
 */
@SpringBootTest(classes = FixEpochAdminClientApp.class)
public class FixepochControllerResourceIT {

    private MockMvc restMockMvc;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        FixepochControllerResource fixepochControllerResource = new FixepochControllerResource();
        restMockMvc = MockMvcBuilders
            .standaloneSetup(fixepochControllerResource)
            .build();
    }

    /**
     * Test add
     */
    @Test
    public void testAdd() throws Exception {
        restMockMvc.perform(get("/api/fixepoch-controller/add"))
            .andExpect(status().isOk());
    }
}
