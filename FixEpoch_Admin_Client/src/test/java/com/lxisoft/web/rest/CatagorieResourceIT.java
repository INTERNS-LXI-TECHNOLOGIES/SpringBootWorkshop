package com.lxisoft.web.rest;

import com.lxisoft.FixEpochAdminClientApp;
import com.lxisoft.domain.Catagorie;
import com.lxisoft.repository.CatagorieRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Integration tests for the {@link CatagorieResource} REST controller.
 */
@SpringBootTest(classes = FixEpochAdminClientApp.class)
@AutoConfigureMockMvc
@WithMockUser
public class CatagorieResourceIT {

    private static final String DEFAULT_CATAGORIE_NAME = "AAAAAAAAAA";
    private static final String UPDATED_CATAGORIE_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_DETAILS = "AAAAAAAAAA";
    private static final String UPDATED_DETAILS = "BBBBBBBBBB";

    @Autowired
    private CatagorieRepository catagorieRepository;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restCatagorieMockMvc;

    private Catagorie catagorie;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Catagorie createEntity(EntityManager em) {
        Catagorie catagorie = new Catagorie()
            .catagorieName(DEFAULT_CATAGORIE_NAME)
            .details(DEFAULT_DETAILS);
        return catagorie;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Catagorie createUpdatedEntity(EntityManager em) {
        Catagorie catagorie = new Catagorie()
            .catagorieName(UPDATED_CATAGORIE_NAME)
            .details(UPDATED_DETAILS);
        return catagorie;
    }

    @BeforeEach
    public void initTest() {
        catagorie = createEntity(em);
    }

    @Test
    @Transactional
    public void createCatagorie() throws Exception {
        int databaseSizeBeforeCreate = catagorieRepository.findAll().size();
        // Create the Catagorie
        restCatagorieMockMvc.perform(post("/api/catagories")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(catagorie)))
            .andExpect(status().isCreated());

        // Validate the Catagorie in the database
        List<Catagorie> catagorieList = catagorieRepository.findAll();
        assertThat(catagorieList).hasSize(databaseSizeBeforeCreate + 1);
        Catagorie testCatagorie = catagorieList.get(catagorieList.size() - 1);
        assertThat(testCatagorie.getCatagorieName()).isEqualTo(DEFAULT_CATAGORIE_NAME);
        assertThat(testCatagorie.getDetails()).isEqualTo(DEFAULT_DETAILS);
    }

    @Test
    @Transactional
    public void createCatagorieWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = catagorieRepository.findAll().size();

        // Create the Catagorie with an existing ID
        catagorie.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restCatagorieMockMvc.perform(post("/api/catagories")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(catagorie)))
            .andExpect(status().isBadRequest());

        // Validate the Catagorie in the database
        List<Catagorie> catagorieList = catagorieRepository.findAll();
        assertThat(catagorieList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllCatagories() throws Exception {
        // Initialize the database
        catagorieRepository.saveAndFlush(catagorie);

        // Get all the catagorieList
        restCatagorieMockMvc.perform(get("/api/catagories?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(catagorie.getId().intValue())))
            .andExpect(jsonPath("$.[*].catagorieName").value(hasItem(DEFAULT_CATAGORIE_NAME)))
            .andExpect(jsonPath("$.[*].details").value(hasItem(DEFAULT_DETAILS)));
    }
    
    @Test
    @Transactional
    public void getCatagorie() throws Exception {
        // Initialize the database
        catagorieRepository.saveAndFlush(catagorie);

        // Get the catagorie
        restCatagorieMockMvc.perform(get("/api/catagories/{id}", catagorie.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(catagorie.getId().intValue()))
            .andExpect(jsonPath("$.catagorieName").value(DEFAULT_CATAGORIE_NAME))
            .andExpect(jsonPath("$.details").value(DEFAULT_DETAILS));
    }
    @Test
    @Transactional
    public void getNonExistingCatagorie() throws Exception {
        // Get the catagorie
        restCatagorieMockMvc.perform(get("/api/catagories/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateCatagorie() throws Exception {
        // Initialize the database
        catagorieRepository.saveAndFlush(catagorie);

        int databaseSizeBeforeUpdate = catagorieRepository.findAll().size();

        // Update the catagorie
        Catagorie updatedCatagorie = catagorieRepository.findById(catagorie.getId()).get();
        // Disconnect from session so that the updates on updatedCatagorie are not directly saved in db
        em.detach(updatedCatagorie);
        updatedCatagorie
            .catagorieName(UPDATED_CATAGORIE_NAME)
            .details(UPDATED_DETAILS);

        restCatagorieMockMvc.perform(put("/api/catagories")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(updatedCatagorie)))
            .andExpect(status().isOk());

        // Validate the Catagorie in the database
        List<Catagorie> catagorieList = catagorieRepository.findAll();
        assertThat(catagorieList).hasSize(databaseSizeBeforeUpdate);
        Catagorie testCatagorie = catagorieList.get(catagorieList.size() - 1);
        assertThat(testCatagorie.getCatagorieName()).isEqualTo(UPDATED_CATAGORIE_NAME);
        assertThat(testCatagorie.getDetails()).isEqualTo(UPDATED_DETAILS);
    }

    @Test
    @Transactional
    public void updateNonExistingCatagorie() throws Exception {
        int databaseSizeBeforeUpdate = catagorieRepository.findAll().size();

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restCatagorieMockMvc.perform(put("/api/catagories")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(catagorie)))
            .andExpect(status().isBadRequest());

        // Validate the Catagorie in the database
        List<Catagorie> catagorieList = catagorieRepository.findAll();
        assertThat(catagorieList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteCatagorie() throws Exception {
        // Initialize the database
        catagorieRepository.saveAndFlush(catagorie);

        int databaseSizeBeforeDelete = catagorieRepository.findAll().size();

        // Delete the catagorie
        restCatagorieMockMvc.perform(delete("/api/catagories/{id}", catagorie.getId())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<Catagorie> catagorieList = catagorieRepository.findAll();
        assertThat(catagorieList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
