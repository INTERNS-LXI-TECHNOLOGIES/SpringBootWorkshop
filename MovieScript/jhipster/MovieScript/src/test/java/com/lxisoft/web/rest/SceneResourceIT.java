package com.lxisoft.web.rest;

import com.lxisoft.MovieScriptApp;
import com.lxisoft.domain.Scene;
import com.lxisoft.repository.SceneRepository;

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
 * Integration tests for the {@link SceneResource} REST controller.
 */
@SpringBootTest(classes = MovieScriptApp.class)
@AutoConfigureMockMvc
@WithMockUser
public class SceneResourceIT {

    private static final String DEFAULT_SCENE_DETAIL = "AAAAAAAAAA";
    private static final String UPDATED_SCENE_DETAIL = "BBBBBBBBBB";

    @Autowired
    private SceneRepository sceneRepository;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restSceneMockMvc;

    private Scene scene;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Scene createEntity(EntityManager em) {
        Scene scene = new Scene()
            .sceneDetail(DEFAULT_SCENE_DETAIL);
        return scene;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Scene createUpdatedEntity(EntityManager em) {
        Scene scene = new Scene()
            .sceneDetail(UPDATED_SCENE_DETAIL);
        return scene;
    }

    @BeforeEach
    public void initTest() {
        scene = createEntity(em);
    }

    @Test
    @Transactional
    public void createScene() throws Exception {
        int databaseSizeBeforeCreate = sceneRepository.findAll().size();
        // Create the Scene
        restSceneMockMvc.perform(post("/api/scenes")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(scene)))
            .andExpect(status().isCreated());

        // Validate the Scene in the database
        List<Scene> sceneList = sceneRepository.findAll();
        assertThat(sceneList).hasSize(databaseSizeBeforeCreate + 1);
        Scene testScene = sceneList.get(sceneList.size() - 1);
        assertThat(testScene.getSceneDetail()).isEqualTo(DEFAULT_SCENE_DETAIL);
    }

    @Test
    @Transactional
    public void createSceneWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = sceneRepository.findAll().size();

        // Create the Scene with an existing ID
        scene.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restSceneMockMvc.perform(post("/api/scenes")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(scene)))
            .andExpect(status().isBadRequest());

        // Validate the Scene in the database
        List<Scene> sceneList = sceneRepository.findAll();
        assertThat(sceneList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllScenes() throws Exception {
        // Initialize the database
        sceneRepository.saveAndFlush(scene);

        // Get all the sceneList
        restSceneMockMvc.perform(get("/api/scenes?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(scene.getId().intValue())))
            .andExpect(jsonPath("$.[*].sceneDetail").value(hasItem(DEFAULT_SCENE_DETAIL)));
    }
    
    @Test
    @Transactional
    public void getScene() throws Exception {
        // Initialize the database
        sceneRepository.saveAndFlush(scene);

        // Get the scene
        restSceneMockMvc.perform(get("/api/scenes/{id}", scene.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(scene.getId().intValue()))
            .andExpect(jsonPath("$.sceneDetail").value(DEFAULT_SCENE_DETAIL));
    }
    @Test
    @Transactional
    public void getNonExistingScene() throws Exception {
        // Get the scene
        restSceneMockMvc.perform(get("/api/scenes/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateScene() throws Exception {
        // Initialize the database
        sceneRepository.saveAndFlush(scene);

        int databaseSizeBeforeUpdate = sceneRepository.findAll().size();

        // Update the scene
        Scene updatedScene = sceneRepository.findById(scene.getId()).get();
        // Disconnect from session so that the updates on updatedScene are not directly saved in db
        em.detach(updatedScene);
        updatedScene
            .sceneDetail(UPDATED_SCENE_DETAIL);

        restSceneMockMvc.perform(put("/api/scenes")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(updatedScene)))
            .andExpect(status().isOk());

        // Validate the Scene in the database
        List<Scene> sceneList = sceneRepository.findAll();
        assertThat(sceneList).hasSize(databaseSizeBeforeUpdate);
        Scene testScene = sceneList.get(sceneList.size() - 1);
        assertThat(testScene.getSceneDetail()).isEqualTo(UPDATED_SCENE_DETAIL);
    }

    @Test
    @Transactional
    public void updateNonExistingScene() throws Exception {
        int databaseSizeBeforeUpdate = sceneRepository.findAll().size();

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restSceneMockMvc.perform(put("/api/scenes")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(scene)))
            .andExpect(status().isBadRequest());

        // Validate the Scene in the database
        List<Scene> sceneList = sceneRepository.findAll();
        assertThat(sceneList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteScene() throws Exception {
        // Initialize the database
        sceneRepository.saveAndFlush(scene);

        int databaseSizeBeforeDelete = sceneRepository.findAll().size();

        // Delete the scene
        restSceneMockMvc.perform(delete("/api/scenes/{id}", scene.getId())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<Scene> sceneList = sceneRepository.findAll();
        assertThat(sceneList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
