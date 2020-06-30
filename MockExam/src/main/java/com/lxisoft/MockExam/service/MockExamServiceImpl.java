package com.lxisoft.MockExam.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lxisoft.MockExam.model.Question;
import com.lxisoft.MockExam.repository.QuestionRepository;


@Service
public class MockExamServiceImpl implements MockExamService {

	
	@Autowired
	private QuestionRepository questionRepository;
	
	@Override
	public List<Question> getAllQuestions() {
		return questionRepository.findAll();
	}
}
