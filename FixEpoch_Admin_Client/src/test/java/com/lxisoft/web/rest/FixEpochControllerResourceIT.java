package com.lxisoft.web.rest;

import com.lxisoft.FixEpochAdminClientApp;
import com.lxisoft.domain.Categorie;
import com.lxisoft.domain.Firm;
import com.lxisoft.domain.User;
import com.lxisoft.repository.AdminRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
/**
 * Test class for the FixEpochControllerResource REST controller.
 *
 * @see FixEpochControllerResource
 */
@SpringBootTest(classes = FixEpochAdminClientApp.class)
public class FixEpochControllerResourceIT {
    private final AdminRepository adminRepository;
    private final Categorie categorie;
    private final Firm firm;
    private final User user;
    private MockMvc restMockMvc;

    public FixEpochControllerResourceIT(AdminRepository adminRepository, Categorie categorie, Firm firm, User user) {
        this.adminRepository = adminRepository;
        this.categorie = categorie;
        this.firm = firm;
        this.user = user;
    }

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        FixEpochControllerResource fixEpochControllerResource = new FixEpochControllerResource(adminRepository, categorie, firm, user);
        restMockMvc = MockMvcBuilders
            .standaloneSetup(fixEpochControllerResource)
            .build();
    }

    /**
     * Test add
     */
    @Test
    public void testAdd() throws Exception {
        restMockMvc.perform(post("/api/fix-epoch-controller/add"))
            .andExpect(status().isOk());
    }
}
