package com.lxisoft.web.rest;

import com.lxisoft.FixEpochAdminClientApp;
import com.lxisoft.repository.AdminRepository;
import com.lxisoft.repository.CategoryRepository;
import com.lxisoft.repository.FirmRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
/**
 * Test class for the FixEpochResource REST controller.
 *
 * @see FixEpochResource
 */
@SpringBootTest(classes = FixEpochAdminClientApp.class)
public class FixEpochResourceIT {

    private MockMvc restMockMvc;
    private final AdminRepository adminRepository;
    private final CategoryRepository categoryRepository;
    private final FirmRepository firmRepository;

    public FixEpochResourceIT(AdminRepository adminRepository, CategoryRepository categoryRepository, FirmRepository firmRepository) {
        this.adminRepository = adminRepository;
        this.categoryRepository = categoryRepository;
        this.firmRepository = firmRepository;
    }

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        FixEpochResource fixEpochResource = new FixEpochResource(adminRepository, categoryRepository, firmRepository);
        restMockMvc = MockMvcBuilders
            .standaloneSetup(fixEpochResource)
            .build();
    }

    /**
     * Test add
     */
    @Test
    public void testAdd() throws Exception {
        restMockMvc.perform(get("/api/fix-epoch/add"))
            .andExpect(status().isOk());
    }
}
