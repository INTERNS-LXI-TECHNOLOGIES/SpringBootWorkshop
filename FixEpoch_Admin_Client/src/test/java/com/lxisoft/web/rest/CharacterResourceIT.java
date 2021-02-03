package com.lxisoft.web.rest;

import com.lxisoft.FixEpochAdminClientApp;
import com.lxisoft.repository.CharacterRepository;

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
 * Integration tests for the {@link CharacterResource} REST controller.
 */
@SpringBootTest(classes = FixEpochAdminClientApp.class)
@AutoConfigureMockMvc
@WithMockUser
public class CharacterResourceIT {

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
    private CharacterRepository characterRepository;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restCharacterMockMvc;

    private Character character;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Character createEntity(EntityManager em) {
        Character character = new Character()
            .firmName(DEFAULT_FIRM_NAME)
            .phNumber(DEFAULT_PH_NUMBER)
            .adress(DEFAULT_ADRESS)
            .email(DEFAULT_EMAIL)
            .time(DEFAULT_TIME);
        return character;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Character createUpdatedEntity(EntityManager em) {
        Character character = new Character()
            .firmName(UPDATED_FIRM_NAME)
            .phNumber(UPDATED_PH_NUMBER)
            .adress(UPDATED_ADRESS)
            .email(UPDATED_EMAIL)
            .time(UPDATED_TIME);
        return character;
    }

    @BeforeEach
    public void initTest() {
        character = createEntity(em);
    }

    @Test
    @Transactional
    public void createCharacter() throws Exception {
        int databaseSizeBeforeCreate = characterRepository.findAll().size();
        // Create the Character
        restCharacterMockMvc.perform(post("/api/characters")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(character)))
            .andExpect(status().isCreated());

        // Validate the Character in the database
        List<Character> characterList = characterRepository.findAll();
        assertThat(characterList).hasSize(databaseSizeBeforeCreate + 1);
        Character testCharacter = characterList.get(characterList.size() - 1);
        assertThat(testCharacter.getFirmName()).isEqualTo(DEFAULT_FIRM_NAME);
        assertThat(testCharacter.getPhNumber()).isEqualTo(DEFAULT_PH_NUMBER);
        assertThat(testCharacter.getAdress()).isEqualTo(DEFAULT_ADRESS);
        assertThat(testCharacter.getEmail()).isEqualTo(DEFAULT_EMAIL);
        assertThat(testCharacter.getTime()).isEqualTo(DEFAULT_TIME);
    }

    @Test
    @Transactional
    public void createCharacterWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = characterRepository.findAll().size();

        // Create the Character with an existing ID
        character.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restCharacterMockMvc.perform(post("/api/characters")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(character)))
            .andExpect(status().isBadRequest());

        // Validate the Character in the database
        List<Character> characterList = characterRepository.findAll();
        assertThat(characterList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllCharacters() throws Exception {
        // Initialize the database
        characterRepository.saveAndFlush(character);

        // Get all the characterList
        restCharacterMockMvc.perform(get("/api/characters?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(character.getId().intValue())))
            .andExpect(jsonPath("$.[*].firmName").value(hasItem(DEFAULT_FIRM_NAME)))
            .andExpect(jsonPath("$.[*].phNumber").value(hasItem(DEFAULT_PH_NUMBER)))
            .andExpect(jsonPath("$.[*].adress").value(hasItem(DEFAULT_ADRESS)))
            .andExpect(jsonPath("$.[*].email").value(hasItem(DEFAULT_EMAIL)))
            .andExpect(jsonPath("$.[*].time").value(hasItem(DEFAULT_TIME)));
    }

    @Test
    @Transactional
    public void getCharacter() throws Exception {
        // Initialize the database
        characterRepository.saveAndFlush(character);

        // Get the character
        restCharacterMockMvc.perform(get("/api/characters/{id}", character.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(character.getId().intValue()))
            .andExpect(jsonPath("$.firmName").value(DEFAULT_FIRM_NAME))
            .andExpect(jsonPath("$.phNumber").value(DEFAULT_PH_NUMBER))
            .andExpect(jsonPath("$.adress").value(DEFAULT_ADRESS))
            .andExpect(jsonPath("$.email").value(DEFAULT_EMAIL))
            .andExpect(jsonPath("$.time").value(DEFAULT_TIME));
    }
    @Test
    @Transactional
    public void getNonExistingCharacter() throws Exception {
        // Get the character
        restCharacterMockMvc.perform(get("/api/characters/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateCharacter() throws Exception {
        // Initialize the database
        characterRepository.saveAndFlush(character);

        int databaseSizeBeforeUpdate = characterRepository.findAll().size();

        // Update the character
        Character updatedCharacter = characterRepository.findById(character.getId()).get();
        // Disconnect from session so that the updates on updatedCharacter are not directly saved in db
        em.detach(updatedCharacter);
        updatedCharacter
            .firmName(UPDATED_FIRM_NAME)
            .phNumber(UPDATED_PH_NUMBER)
            .adress(UPDATED_ADRESS)
            .email(UPDATED_EMAIL)
            .time(UPDATED_TIME);

        restCharacterMockMvc.perform(put("/api/characters")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(updatedCharacter)))
            .andExpect(status().isOk());

        // Validate the Character in the database
        List<Character> characterList = characterRepository.findAll();
        assertThat(characterList).hasSize(databaseSizeBeforeUpdate);
        Character testCharacter = characterList.get(characterList.size() - 1);
        assertThat(testCharacter.getFirmName()).isEqualTo(UPDATED_FIRM_NAME);
        assertThat(testCharacter.getPhNumber()).isEqualTo(UPDATED_PH_NUMBER);
        assertThat(testCharacter.getAdress()).isEqualTo(UPDATED_ADRESS);
        assertThat(testCharacter.getEmail()).isEqualTo(UPDATED_EMAIL);
        assertThat(testCharacter.getTime()).isEqualTo(UPDATED_TIME);
    }

    @Test
    @Transactional
    public void updateNonExistingCharacter() throws Exception {
        int databaseSizeBeforeUpdate = characterRepository.findAll().size();

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restCharacterMockMvc.perform(put("/api/characters")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(character)))
            .andExpect(status().isBadRequest());

        // Validate the Character in the database
        List<Character> characterList = characterRepository.findAll();
        assertThat(characterList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteCharacter() throws Exception {
        // Initialize the database
        characterRepository.saveAndFlush(character);

        int databaseSizeBeforeDelete = characterRepository.findAll().size();

        // Delete the character
        restCharacterMockMvc.perform(delete("/api/characters/{id}", character.getId())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<Character> characterList = characterRepository.findAll();
        assertThat(characterList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
