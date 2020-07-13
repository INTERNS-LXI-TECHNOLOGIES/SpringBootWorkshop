package com.lxisoft.MockExam.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lxisoft.MockExam.model.Question;
import com.lxisoft.MockExam.repository.QuestionRepository;

@Service
public class QuestionService {

	    @Autowired
	    QuestionRepository questionRepository;

	    public void saveQuestion(Question question)
	    {
	            questionRepository.save(question);
	    }
	    
	    public Question get(int id)
	    {
	        return questionRepository.getOne(id);
	    }

	    public List<Question> getAll()
	    {

	        return  questionRepository.findAll();
	    }

	    public void deleteById(int id)
	    {
	        questionRepository.deleteById(id);
	    }
}
