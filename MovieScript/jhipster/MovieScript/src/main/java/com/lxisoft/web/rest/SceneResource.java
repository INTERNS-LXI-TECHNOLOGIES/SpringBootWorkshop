package com.lxisoft.web.rest;

import com.lxisoft.domain.Scene;
import com.lxisoft.repository.SceneRepository;
import com.lxisoft.web.rest.errors.BadRequestAlertException;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link com.lxisoft.domain.Scene}.
 */
@RestController
@RequestMapping("/api")
@Transactional
public class SceneResource {

    private final Logger log = LoggerFactory.getLogger(SceneResource.class);

    private static final String ENTITY_NAME = "scene";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final SceneRepository sceneRepository;

    public SceneResource(SceneRepository sceneRepository) {
        this.sceneRepository = sceneRepository;
    }

    /**
     * {@code POST  /scenes} : Create a new scene.
     *
     * @param scene the scene to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new scene, or with status {@code 400 (Bad Request)} if the scene has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/scenes")
    public ResponseEntity<Scene> createScene(@RequestBody Scene scene) throws URISyntaxException {
        log.debug("REST request to save Scene : {}", scene);
        if (scene.getId() != null) {
            throw new BadRequestAlertException("A new scene cannot already have an ID", ENTITY_NAME, "idexists");
        }
        Scene result = sceneRepository.save(scene);
        return ResponseEntity.created(new URI("/api/scenes/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /scenes} : Updates an existing scene.
     *
     * @param scene the scene to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated scene,
     * or with status {@code 400 (Bad Request)} if the scene is not valid,
     * or with status {@code 500 (Internal Server Error)} if the scene couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/scenes")
    public ResponseEntity<Scene> updateScene(@RequestBody Scene scene) throws URISyntaxException {
        log.debug("REST request to update Scene : {}", scene);
        if (scene.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        Scene result = sceneRepository.save(scene);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, scene.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /scenes} : get all the scenes.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of scenes in body.
     */
    @GetMapping("/scenes")
    public List<Scene> getAllScenes() {
        log.debug("REST request to get all Scenes");
        return sceneRepository.findAll();
    }

    /**
     * {@code GET  /scenes/:id} : get the "id" scene.
     *
     * @param id the id of the scene to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the scene, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/scenes/{id}")
    public ResponseEntity<Scene> getScene(@PathVariable Long id) {
        log.debug("REST request to get Scene : {}", id);
        Optional<Scene> scene = sceneRepository.findById(id);
        return ResponseUtil.wrapOrNotFound(scene);
    }

    /**
     * {@code DELETE  /scenes/:id} : delete the "id" scene.
     *
     * @param id the id of the scene to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/scenes/{id}")
    public ResponseEntity<Void> deleteScene(@PathVariable Long id) {
        log.debug("REST request to delete Scene : {}", id);
        sceneRepository.deleteById(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
