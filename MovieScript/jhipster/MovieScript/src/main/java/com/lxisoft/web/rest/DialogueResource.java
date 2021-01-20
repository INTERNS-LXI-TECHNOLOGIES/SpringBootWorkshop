package com.lxisoft.web.rest;

import com.lxisoft.domain.Dialogue;
import com.lxisoft.repository.DialogueRepository;
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
 * REST controller for managing {@link com.lxisoft.domain.Dialogue}.
 */
@RestController
@RequestMapping("/api")
@Transactional
public class DialogueResource {

    private final Logger log = LoggerFactory.getLogger(DialogueResource.class);

    private static final String ENTITY_NAME = "dialogue";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final DialogueRepository dialogueRepository;

    public DialogueResource(DialogueRepository dialogueRepository) {
        this.dialogueRepository = dialogueRepository;
    }

    /**
     * {@code POST  /dialogues} : Create a new dialogue.
     *
     * @param dialogue the dialogue to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new dialogue, or with status {@code 400 (Bad Request)} if the dialogue has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/dialogues")
    public ResponseEntity<Dialogue> createDialogue(@RequestBody Dialogue dialogue) throws URISyntaxException {
        log.debug("REST request to save Dialogue : {}", dialogue);
        if (dialogue.getId() != null) {
            throw new BadRequestAlertException("A new dialogue cannot already have an ID", ENTITY_NAME, "idexists");
        }
        Dialogue result = dialogueRepository.save(dialogue);
        return ResponseEntity.created(new URI("/api/dialogues/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /dialogues} : Updates an existing dialogue.
     *
     * @param dialogue the dialogue to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated dialogue,
     * or with status {@code 400 (Bad Request)} if the dialogue is not valid,
     * or with status {@code 500 (Internal Server Error)} if the dialogue couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/dialogues")
    public ResponseEntity<Dialogue> updateDialogue(@RequestBody Dialogue dialogue) throws URISyntaxException {
        log.debug("REST request to update Dialogue : {}", dialogue);
        if (dialogue.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        Dialogue result = dialogueRepository.save(dialogue);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, dialogue.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /dialogues} : get all the dialogues.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of dialogues in body.
     */
    @GetMapping("/dialogues")
    public List<Dialogue> getAllDialogues() {
        log.debug("REST request to get all Dialogues");
        return dialogueRepository.findAll();
    }

    /**
     * {@code GET  /dialogues/:id} : get the "id" dialogue.
     *
     * @param id the id of the dialogue to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the dialogue, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/dialogues/{id}")
    public ResponseEntity<Dialogue> getDialogue(@PathVariable Long id) {
        log.debug("REST request to get Dialogue : {}", id);
        Optional<Dialogue> dialogue = dialogueRepository.findById(id);
        return ResponseUtil.wrapOrNotFound(dialogue);
    }

    /**
     * {@code DELETE  /dialogues/:id} : delete the "id" dialogue.
     *
     * @param id the id of the dialogue to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/dialogues/{id}")
    public ResponseEntity<Void> deleteDialogue(@PathVariable Long id) {
        log.debug("REST request to delete Dialogue : {}", id);
        dialogueRepository.deleteById(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
