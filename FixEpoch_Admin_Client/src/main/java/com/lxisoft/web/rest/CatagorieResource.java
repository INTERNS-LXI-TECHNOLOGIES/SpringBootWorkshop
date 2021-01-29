package com.lxisoft.web.rest;

import com.lxisoft.domain.Catagorie;
import com.lxisoft.repository.CatagorieRepository;
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
 * REST controller for managing {@link com.lxisoft.domain.Catagorie}.
 */
@RestController
@RequestMapping("/api")
@Transactional
public class CatagorieResource {

    private final Logger log = LoggerFactory.getLogger(CatagorieResource.class);

    private static final String ENTITY_NAME = "catagorie";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final CatagorieRepository catagorieRepository;

    public CatagorieResource(CatagorieRepository catagorieRepository) {
        this.catagorieRepository = catagorieRepository;
    }

    /**
     * {@code POST  /catagories} : Create a new catagorie.
     *
     * @param catagorie the catagorie to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new catagorie, or with status {@code 400 (Bad Request)} if the catagorie has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/catagories")
    public ResponseEntity<Catagorie> createCatagorie(@RequestBody Catagorie catagorie) throws URISyntaxException {
        log.debug("REST request to save Catagorie : {}", catagorie);
        if (catagorie.getId() != null) {
            throw new BadRequestAlertException("A new catagorie cannot already have an ID", ENTITY_NAME, "idexists");
        }
        Catagorie result = catagorieRepository.save(catagorie);
        return ResponseEntity.created(new URI("/api/catagories/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /catagories} : Updates an existing catagorie.
     *
     * @param catagorie the catagorie to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated catagorie,
     * or with status {@code 400 (Bad Request)} if the catagorie is not valid,
     * or with status {@code 500 (Internal Server Error)} if the catagorie couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/catagories")
    public ResponseEntity<Catagorie> updateCatagorie(@RequestBody Catagorie catagorie) throws URISyntaxException {
        log.debug("REST request to update Catagorie : {}", catagorie);
        if (catagorie.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        Catagorie result = catagorieRepository.save(catagorie);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, catagorie.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /catagories} : get all the catagories.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of catagories in body.
     */
    @GetMapping("/catagories")
    public List<Catagorie> getAllCatagories() {
        log.debug("REST request to get all Catagories");
        return catagorieRepository.findAll();
    }

    /**
     * {@code GET  /catagories/:id} : get the "id" catagorie.
     *
     * @param id the id of the catagorie to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the catagorie, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/catagories/{id}")
    public ResponseEntity<Catagorie> getCatagorie(@PathVariable Long id) {
        log.debug("REST request to get Catagorie : {}", id);
        Optional<Catagorie> catagorie = catagorieRepository.findById(id);
        return ResponseUtil.wrapOrNotFound(catagorie);
    }

    /**
     * {@code DELETE  /catagories/:id} : delete the "id" catagorie.
     *
     * @param id the id of the catagorie to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/catagories/{id}")
    public ResponseEntity<Void> deleteCatagorie(@PathVariable Long id) {
        log.debug("REST request to delete Catagorie : {}", id);
        catagorieRepository.deleteById(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
