package com.lxisoft.web.rest;

import com.lxisoft.FixEpochAdminClientApp;
import com.lxisoft.domain.Firm;
import com.lxisoft.repository.FirmRepository;

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
 * Integration tests for the {@link FirmResource} REST controller.
 */
@SpringBootTest(classes = FixEpochAdminClientApp.class)
@AutoConfigureMockMvc
@WithMockUser
public class FirmResourceIT {

    private static final String DEFAULT_FIRM_NAME = "AAAAAAAAAA";
    private static final String UPDATED_FIRM_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_PH_NUMBER = "AAAAAAAAAA";
    private static final String UPDATED_PH_NUMBER = "BBBBBBBBBB";

    private static final String DEFAULT_ADRESS = "AAAAAAAAAA";
    private static final String UPDATED_ADRESS = "BBBBBBBBBB";

    private static final String DEFAULT_EMAIL = "AAAAAAAAAA";
    private static final String UPDATED_EMAIL = "BBBBBBBBBB";

    private static final String DEFAULT_TIME = "AAAAAAAAAA";
    private static final String UPDATED_TIME = "BBBBBBBBBB";

    @Autowired
    private FirmRepository firmRepository;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restFirmMockMvc;

    private Firm firm;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Firm createEntity(EntityManager em) {
        Firm firm = new Firm()
            .firmName(DEFAULT_FIRM_NAME)
            .phNumber(DEFAULT_PH_NUMBER)
            .adress(DEFAULT_ADRESS)
            .email(DEFAULT_EMAIL)
            .time(DEFAULT_TIME);
        return firm;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Firm createUpdatedEntity(EntityManager em) {
        Firm firm = new Firm()
            .firmName(UPDATED_FIRM_NAME)
            .phNumber(UPDATED_PH_NUMBER)
            .adress(UPDATED_ADRESS)
            .email(UPDATED_EMAIL)
            .time(UPDATED_TIME);
        return firm;
    }

    @BeforeEach
    public void initTest() {
        firm = createEntity(em);
    }

    @Test
    @Transactional
    public void createFirm() throws Exception {
        int databaseSizeBeforeCreate = firmRepository.findAll().size();
        // Create the Firm
        restFirmMockMvc.perform(post("/api/firms")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(firm)))
            .andExpect(status().isCreated());

        // Validate the Firm in the database
        List<Firm> firmList = firmRepository.findAll();
        assertThat(firmList).hasSize(databaseSizeBeforeCreate + 1);
        Firm testFirm = firmList.get(firmList.size() - 1);
        assertThat(testFirm.getFirmName()).isEqualTo(DEFAULT_FIRM_NAME);
        assertThat(testFirm.getPhNumber()).isEqualTo(DEFAULT_PH_NUMBER);
        assertThat(testFirm.getAdress()).isEqualTo(DEFAULT_ADRESS);
        assertThat(testFirm.getEmail()).isEqualTo(DEFAULT_EMAIL);
        assertThat(testFirm.getTime()).isEqualTo(DEFAULT_TIME);
    }

    @Test
    @Transactional
    public void createFirmWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = firmRepository.findAll().size();

        // Create the Firm with an existing ID
        firm.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restFirmMockMvc.perform(post("/api/firms")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(firm)))
            .andExpect(status().isBadRequest());

        // Validate the Firm in the database
        List<Firm> firmList = firmRepository.findAll();
        assertThat(firmList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllFirms() throws Exception {
        // Initialize the database
        firmRepository.saveAndFlush(firm);

        // Get all the firmList
        restFirmMockMvc.perform(get("/api/firms?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(firm.getId().intValue())))
            .andExpect(jsonPath("$.[*].firmName").value(hasItem(DEFAULT_FIRM_NAME)))
            .andExpect(jsonPath("$.[*].phNumber").value(hasItem(DEFAULT_PH_NUMBER)))
            .andExpect(jsonPath("$.[*].adress").value(hasItem(DEFAULT_ADRESS)))
            .andExpect(jsonPath("$.[*].email").value(hasItem(DEFAULT_EMAIL)))
            .andExpect(jsonPath("$.[*].time").value(hasItem(DEFAULT_TIME)));
    }
    
    @Test
    @Transactional
    public void getFirm() throws Exception {
        // Initialize the database
        firmRepository.saveAndFlush(firm);

        // Get the firm
        restFirmMockMvc.perform(get("/api/firms/{id}", firm.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(firm.getId().intValue()))
            .andExpect(jsonPath("$.firmName").value(DEFAULT_FIRM_NAME))
            .andExpect(jsonPath("$.phNumber").value(DEFAULT_PH_NUMBER))
            .andExpect(jsonPath("$.adress").value(DEFAULT_ADRESS))
            .andExpect(jsonPath("$.email").value(DEFAULT_EMAIL))
            .andExpect(jsonPath("$.time").value(DEFAULT_TIME));
    }
    @Test
    @Transactional
    public void getNonExistingFirm() throws Exception {
        // Get the firm
        restFirmMockMvc.perform(get("/api/firms/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateFirm() throws Exception {
        // Initialize the database
        firmRepository.saveAndFlush(firm);

        int databaseSizeBeforeUpdate = firmRepository.findAll().size();

        // Update the firm
        Firm updatedFirm = firmRepository.findById(firm.getId()).get();
        // Disconnect from session so that the updates on updatedFirm are not directly saved in db
        em.detach(updatedFirm);
        updatedFirm
            .firmName(UPDATED_FIRM_NAME)
            .phNumber(UPDATED_PH_NUMBER)
            .adress(UPDATED_ADRESS)
            .email(UPDATED_EMAIL)
            .time(UPDATED_TIME);

        restFirmMockMvc.perform(put("/api/firms")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(updatedFirm)))
            .andExpect(status().isOk());

        // Validate the Firm in the database
        List<Firm> firmList = firmRepository.findAll();
        assertThat(firmList).hasSize(databaseSizeBeforeUpdate);
        Firm testFirm = firmList.get(firmList.size() - 1);
        assertThat(testFirm.getFirmName()).isEqualTo(UPDATED_FIRM_NAME);
        assertThat(testFirm.getPhNumber()).isEqualTo(UPDATED_PH_NUMBER);
        assertThat(testFirm.getAdress()).isEqualTo(UPDATED_ADRESS);
        assertThat(testFirm.getEmail()).isEqualTo(UPDATED_EMAIL);
        assertThat(testFirm.getTime()).isEqualTo(UPDATED_TIME);
    }

    @Test
    @Transactional
    public void updateNonExistingFirm() throws Exception {
        int databaseSizeBeforeUpdate = firmRepository.findAll().size();

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restFirmMockMvc.perform(put("/api/firms")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(firm)))
            .andExpect(status().isBadRequest());

        // Validate the Firm in the database
        List<Firm> firmList = firmRepository.findAll();
        assertThat(firmList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteFirm() throws Exception {
        // Initialize the database
        firmRepository.saveAndFlush(firm);

        int databaseSizeBeforeDelete = firmRepository.findAll().size();

        // Delete the firm
        restFirmMockMvc.perform(delete("/api/firms/{id}", firm.getId())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<Firm> firmList = firmRepository.findAll();
        assertThat(firmList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
