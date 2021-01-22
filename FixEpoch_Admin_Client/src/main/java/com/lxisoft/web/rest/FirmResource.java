package com.lxisoft.web.rest;

import com.lxisoft.domain.Firm;
import com.lxisoft.repository.FirmRepository;
import com.lxisoft.web.rest.errors.BadRequestAlertException;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link com.lxisoft.domain.Firm}.
 */
@RestController
@RequestMapping("/api")
@Transactional
public class FirmResource {

    private final Logger log = LoggerFactory.getLogger(FirmResource.class);

    private static final String ENTITY_NAME = "firm";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final FirmRepository firmRepository;

    public FirmResource(FirmRepository firmRepository) {
        this.firmRepository = firmRepository;
    }

    /**
     * {@code POST  /firms} : Create a new firm.
     *
     * @param firm the firm to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new firm, or with status {@code 400 (Bad Request)} if the firm has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/firms")
    public ResponseEntity<Firm> createFirm(@Valid @RequestBody Firm firm) throws URISyntaxException {
        log.debug("REST request to save Firm : {}", firm);
        if (firm.getId() != null) {
            throw new BadRequestAlertException("A new firm cannot already have an ID", ENTITY_NAME, "idexists");
        }
        Firm result = firmRepository.save(firm);
        return ResponseEntity.created(new URI("/api/firms/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /firms} : Updates an existing firm.
     *
     * @param firm the firm to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated firm,
     * or with status {@code 400 (Bad Request)} if the firm is not valid,
     * or with status {@code 500 (Internal Server Error)} if the firm couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/firms")
    public ResponseEntity<Firm> updateFirm(@Valid @RequestBody Firm firm) throws URISyntaxException {
        log.debug("REST request to update Firm : {}", firm);
        if (firm.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        Firm result = firmRepository.save(firm);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, firm.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /firms} : get all the firms.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of firms in body.
     */
    @GetMapping("/firms")
    public List<Firm> getAllFirms() {
        log.debug("REST request to get all Firms");
        return firmRepository.findAll();
    }

    /**
     * {@code GET  /firms/:id} : get the "id" firm.
     *
     * @param id the id of the firm to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the firm, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/firms/{id}")
    public ResponseEntity<Firm> getFirm(@PathVariable Long id) {
        log.debug("REST request to get Firm : {}", id);
        Optional<Firm> firm = firmRepository.findById(id);
        return ResponseUtil.wrapOrNotFound(firm);
    }

    /**
     * {@code DELETE  /firms/:id} : delete the "id" firm.
     *
     * @param id the id of the firm to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/firms/{id}")
    public ResponseEntity<Void> deleteFirm(@PathVariable Long id) {
        log.debug("REST request to delete Firm : {}", id);
        firmRepository.deleteById(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
