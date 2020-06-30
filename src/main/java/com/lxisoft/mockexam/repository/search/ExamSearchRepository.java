package com.lxisoft.mockexam.repository.search;

import com.lxisoft.mockexam.domain.Exam;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;


/**
 * Spring Data Elasticsearch repository for the {@link Exam} entity.
 */
public interface ExamSearchRepository extends ElasticsearchRepository<Exam, Long> {
}
