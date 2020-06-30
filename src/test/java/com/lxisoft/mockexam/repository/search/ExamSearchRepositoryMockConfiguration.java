package com.lxisoft.mockexam.repository.search;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Configuration;

/**
 * Configure a Mock version of {@link ExamSearchRepository} to test the
 * application without starting Elasticsearch.
 */
@Configuration
public class ExamSearchRepositoryMockConfiguration {

    @MockBean
    private ExamSearchRepository mockExamSearchRepository;

}
