package com.lxisoft.web.rest;

import com.lxisoft.MovieScriptApp;
import com.lxisoft.domain.Dialogue;
import com.lxisoft.repository.DialogueRepository;

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
 * Integration tests for the {@link DialogueResource} REST controller.
 */
@SpringBootTest(classes = MovieScriptApp.class)
@AutoConfigureMockMvc
@WithMockUser
public class DialogueResourceIT {

    private static final String DEFAULT_DIALOGUE = "AAAAAAAAAA";
    private static final String UPDATED_DIALOGUE = "BBBBBBBBBB";

    @Autowired
    private DialogueRepository dialogueRepository;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restDialogueMockMvc;

    private Dialogue dialogue;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Dialogue createEntity(EntityManager em) {
        Dialogue dialogue = new Dialogue()
            .dialogue(DEFAULT_DIALOGUE);
        return dialogue;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Dialogue createUpdatedEntity(EntityManager em) {
        Dialogue dialogue = new Dialogue()
            .dialogue(UPDATED_DIALOGUE);
        return dialogue;
    }

    @BeforeEach
    public void initTest() {
        dialogue = createEntity(em);
    }

    @Test
    @Transactional
    public void createDialogue() throws Exception {
        int databaseSizeBeforeCreate = dialogueRepository.findAll().size();
        // Create the Dialogue
        restDialogueMockMvc.perform(post("/api/dialogues")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(dialogue)))
            .andExpect(status().isCreated());

        // Validate the Dialogue in the database
        List<Dialogue> dialogueList = dialogueRepository.findAll();
        assertThat(dialogueList).hasSize(databaseSizeBeforeCreate + 1);
        Dialogue testDialogue = dialogueList.get(dialogueList.size() - 1);
        assertThat(testDialogue.getDialogue()).isEqualTo(DEFAULT_DIALOGUE);
    }

    @Test
    @Transactional
    public void createDialogueWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = dialogueRepository.findAll().size();

        // Create the Dialogue with an existing ID
        dialogue.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restDialogueMockMvc.perform(post("/api/dialogues")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(dialogue)))
            .andExpect(status().isBadRequest());

        // Validate the Dialogue in the database
        List<Dialogue> dialogueList = dialogueRepository.findAll();
        assertThat(dialogueList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllDialogues() throws Exception {
        // Initialize the database
        dialogueRepository.saveAndFlush(dialogue);

        // Get all the dialogueList
        restDialogueMockMvc.perform(get("/api/dialogues?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(dialogue.getId().intValue())))
            .andExpect(jsonPath("$.[*].dialogue").value(hasItem(DEFAULT_DIALOGUE)));
    }
    
    @Test
    @Transactional
    public void getDialogue() throws Exception {
        // Initialize the database
        dialogueRepository.saveAndFlush(dialogue);

        // Get the dialogue
        restDialogueMockMvc.perform(get("/api/dialogues/{id}", dialogue.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(dialogue.getId().intValue()))
            .andExpect(jsonPath("$.dialogue").value(DEFAULT_DIALOGUE));
    }
    @Test
    @Transactional
    public void getNonExistingDialogue() throws Exception {
        // Get the dialogue
        restDialogueMockMvc.perform(get("/api/dialogues/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateDialogue() throws Exception {
        // Initialize the database
        dialogueRepository.saveAndFlush(dialogue);

        int databaseSizeBeforeUpdate = dialogueRepository.findAll().size();

        // Update the dialogue
        Dialogue updatedDialogue = dialogueRepository.findById(dialogue.getId()).get();
        // Disconnect from session so that the updates on updatedDialogue are not directly saved in db
        em.detach(updatedDialogue);
        updatedDialogue
            .dialogue(UPDATED_DIALOGUE);

        restDialogueMockMvc.perform(put("/api/dialogues")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(updatedDialogue)))
            .andExpect(status().isOk());

        // Validate the Dialogue in the database
        List<Dialogue> dialogueList = dialogueRepository.findAll();
        assertThat(dialogueList).hasSize(databaseSizeBeforeUpdate);
        Dialogue testDialogue = dialogueList.get(dialogueList.size() - 1);
        assertThat(testDialogue.getDialogue()).isEqualTo(UPDATED_DIALOGUE);
    }

    @Test
    @Transactional
    public void updateNonExistingDialogue() throws Exception {
        int databaseSizeBeforeUpdate = dialogueRepository.findAll().size();

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restDialogueMockMvc.perform(put("/api/dialogues")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(dialogue)))
            .andExpect(status().isBadRequest());

        // Validate the Dialogue in the database
        List<Dialogue> dialogueList = dialogueRepository.findAll();
        assertThat(dialogueList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteDialogue() throws Exception {
        // Initialize the database
        dialogueRepository.saveAndFlush(dialogue);

        int databaseSizeBeforeDelete = dialogueRepository.findAll().size();

        // Delete the dialogue
        restDialogueMockMvc.perform(delete("/api/dialogues/{id}", dialogue.getId())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<Dialogue> dialogueList = dialogueRepository.findAll();
        assertThat(dialogueList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
