package com.lxisoft.mockexam.web.rest;

import com.lxisoft.mockexam.MockexamApp;
import com.lxisoft.mockexam.domain.Exam;
import com.lxisoft.mockexam.repository.ExamRepository;
import com.lxisoft.mockexam.repository.search.ExamSearchRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.elasticsearch.index.query.QueryBuilders.queryStringQuery;
import static org.hamcrest.Matchers.hasItem;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Integration tests for the {@link ExamResource} REST controller.
 */
@SpringBootTest(classes = MockexamApp.class)
@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
@WithMockUser
public class ExamResourceIT {

    private static final String DEFAULT_QUESTION = "AAAAAAAAAA";
    private static final String UPDATED_QUESTION = "BBBBBBBBBB";

    private static final String DEFAULT_OPT_1 = "AAAAAAAAAA";
    private static final String UPDATED_OPT_1 = "BBBBBBBBBB";

    private static final String DEFAULT_OPT_2 = "AAAAAAAAAA";
    private static final String UPDATED_OPT_2 = "BBBBBBBBBB";

    private static final String DEFAULT_OPT_3 = "AAAAAAAAAA";
    private static final String UPDATED_OPT_3 = "BBBBBBBBBB";

    private static final String DEFAULT_OPT_4 = "AAAAAAAAAA";
    private static final String UPDATED_OPT_4 = "BBBBBBBBBB";

    private static final String DEFAULT_ANSWER = "AAAAAAAAAA";
    private static final String UPDATED_ANSWER = "BBBBBBBBBB";

    @Autowired
    private ExamRepository examRepository;

    /**
     * This repository is mocked in the com.lxisoft.mockexam.repository.search test package.
     *
     * @see com.lxisoft.mockexam.repository.search.ExamSearchRepositoryMockConfiguration
     */
    @Autowired
    private ExamSearchRepository mockExamSearchRepository;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restExamMockMvc;

    private Exam exam;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Exam createEntity(EntityManager em) {
        Exam exam = new Exam()
            .question(DEFAULT_QUESTION)
            .opt1(DEFAULT_OPT_1)
            .opt2(DEFAULT_OPT_2)
            .opt3(DEFAULT_OPT_3)
            .opt4(DEFAULT_OPT_4)
            .answer(DEFAULT_ANSWER);
        return exam;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Exam createUpdatedEntity(EntityManager em) {
        Exam exam = new Exam()
            .question(UPDATED_QUESTION)
            .opt1(UPDATED_OPT_1)
            .opt2(UPDATED_OPT_2)
            .opt3(UPDATED_OPT_3)
            .opt4(UPDATED_OPT_4)
            .answer(UPDATED_ANSWER);
        return exam;
    }

    @BeforeEach
    public void initTest() {
        exam = createEntity(em);
    }

    @Test
    @Transactional
    public void createExam() throws Exception {
        int databaseSizeBeforeCreate = examRepository.findAll().size();
        // Create the Exam
        restExamMockMvc.perform(post("/api/exams")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(exam)))
            .andExpect(status().isCreated());

        // Validate the Exam in the database
        List<Exam> examList = examRepository.findAll();
        assertThat(examList).hasSize(databaseSizeBeforeCreate + 1);
        Exam testExam = examList.get(examList.size() - 1);
        assertThat(testExam.getQuestion()).isEqualTo(DEFAULT_QUESTION);
        assertThat(testExam.getOpt1()).isEqualTo(DEFAULT_OPT_1);
        assertThat(testExam.getOpt2()).isEqualTo(DEFAULT_OPT_2);
        assertThat(testExam.getOpt3()).isEqualTo(DEFAULT_OPT_3);
        assertThat(testExam.getOpt4()).isEqualTo(DEFAULT_OPT_4);
        assertThat(testExam.getAnswer()).isEqualTo(DEFAULT_ANSWER);

        // Validate the Exam in Elasticsearch
        verify(mockExamSearchRepository, times(1)).save(testExam);
    }

    @Test
    @Transactional
    public void createExamWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = examRepository.findAll().size();

        // Create the Exam with an existing ID
        exam.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restExamMockMvc.perform(post("/api/exams")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(exam)))
            .andExpect(status().isBadRequest());

        // Validate the Exam in the database
        List<Exam> examList = examRepository.findAll();
        assertThat(examList).hasSize(databaseSizeBeforeCreate);

        // Validate the Exam in Elasticsearch
        verify(mockExamSearchRepository, times(0)).save(exam);
    }


    @Test
    @Transactional
    public void getAllExams() throws Exception {
        // Initialize the database
        examRepository.saveAndFlush(exam);

        // Get all the examList
        restExamMockMvc.perform(get("/api/exams?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(exam.getId().intValue())))
            .andExpect(jsonPath("$.[*].question").value(hasItem(DEFAULT_QUESTION)))
            .andExpect(jsonPath("$.[*].opt1").value(hasItem(DEFAULT_OPT_1)))
            .andExpect(jsonPath("$.[*].opt2").value(hasItem(DEFAULT_OPT_2)))
            .andExpect(jsonPath("$.[*].opt3").value(hasItem(DEFAULT_OPT_3)))
            .andExpect(jsonPath("$.[*].opt4").value(hasItem(DEFAULT_OPT_4)))
            .andExpect(jsonPath("$.[*].answer").value(hasItem(DEFAULT_ANSWER)));
    }
    
    @Test
    @Transactional
    public void getExam() throws Exception {
        // Initialize the database
        examRepository.saveAndFlush(exam);

        // Get the exam
        restExamMockMvc.perform(get("/api/exams/{id}", exam.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(exam.getId().intValue()))
            .andExpect(jsonPath("$.question").value(DEFAULT_QUESTION))
            .andExpect(jsonPath("$.opt1").value(DEFAULT_OPT_1))
            .andExpect(jsonPath("$.opt2").value(DEFAULT_OPT_2))
            .andExpect(jsonPath("$.opt3").value(DEFAULT_OPT_3))
            .andExpect(jsonPath("$.opt4").value(DEFAULT_OPT_4))
            .andExpect(jsonPath("$.answer").value(DEFAULT_ANSWER));
    }
    @Test
    @Transactional
    public void getNonExistingExam() throws Exception {
        // Get the exam
        restExamMockMvc.perform(get("/api/exams/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateExam() throws Exception {
        // Initialize the database
        examRepository.saveAndFlush(exam);

        int databaseSizeBeforeUpdate = examRepository.findAll().size();

        // Update the exam
        Exam updatedExam = examRepository.findById(exam.getId()).get();
        // Disconnect from session so that the updates on updatedExam are not directly saved in db
        em.detach(updatedExam);
        updatedExam
            .question(UPDATED_QUESTION)
            .opt1(UPDATED_OPT_1)
            .opt2(UPDATED_OPT_2)
            .opt3(UPDATED_OPT_3)
            .opt4(UPDATED_OPT_4)
            .answer(UPDATED_ANSWER);

        restExamMockMvc.perform(put("/api/exams")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(updatedExam)))
            .andExpect(status().isOk());

        // Validate the Exam in the database
        List<Exam> examList = examRepository.findAll();
        assertThat(examList).hasSize(databaseSizeBeforeUpdate);
        Exam testExam = examList.get(examList.size() - 1);
        assertThat(testExam.getQuestion()).isEqualTo(UPDATED_QUESTION);
        assertThat(testExam.getOpt1()).isEqualTo(UPDATED_OPT_1);
        assertThat(testExam.getOpt2()).isEqualTo(UPDATED_OPT_2);
        assertThat(testExam.getOpt3()).isEqualTo(UPDATED_OPT_3);
        assertThat(testExam.getOpt4()).isEqualTo(UPDATED_OPT_4);
        assertThat(testExam.getAnswer()).isEqualTo(UPDATED_ANSWER);

        // Validate the Exam in Elasticsearch
        verify(mockExamSearchRepository, times(1)).save(testExam);
    }

    @Test
    @Transactional
    public void updateNonExistingExam() throws Exception {
        int databaseSizeBeforeUpdate = examRepository.findAll().size();

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restExamMockMvc.perform(put("/api/exams")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(exam)))
            .andExpect(status().isBadRequest());

        // Validate the Exam in the database
        List<Exam> examList = examRepository.findAll();
        assertThat(examList).hasSize(databaseSizeBeforeUpdate);

        // Validate the Exam in Elasticsearch
        verify(mockExamSearchRepository, times(0)).save(exam);
    }

    @Test
    @Transactional
    public void deleteExam() throws Exception {
        // Initialize the database
        examRepository.saveAndFlush(exam);

        int databaseSizeBeforeDelete = examRepository.findAll().size();

        // Delete the exam
        restExamMockMvc.perform(delete("/api/exams/{id}", exam.getId())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<Exam> examList = examRepository.findAll();
        assertThat(examList).hasSize(databaseSizeBeforeDelete - 1);

        // Validate the Exam in Elasticsearch
        verify(mockExamSearchRepository, times(1)).deleteById(exam.getId());
    }

    @Test
    @Transactional
    public void searchExam() throws Exception {
        // Configure the mock search repository
        // Initialize the database
        examRepository.saveAndFlush(exam);
        when(mockExamSearchRepository.search(queryStringQuery("id:" + exam.getId())))
            .thenReturn(Collections.singletonList(exam));

        // Search the exam
        restExamMockMvc.perform(get("/api/_search/exams?query=id:" + exam.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(exam.getId().intValue())))
            .andExpect(jsonPath("$.[*].question").value(hasItem(DEFAULT_QUESTION)))
            .andExpect(jsonPath("$.[*].opt1").value(hasItem(DEFAULT_OPT_1)))
            .andExpect(jsonPath("$.[*].opt2").value(hasItem(DEFAULT_OPT_2)))
            .andExpect(jsonPath("$.[*].opt3").value(hasItem(DEFAULT_OPT_3)))
            .andExpect(jsonPath("$.[*].opt4").value(hasItem(DEFAULT_OPT_4)))
            .andExpect(jsonPath("$.[*].answer").value(hasItem(DEFAULT_ANSWER)));
    }
}
