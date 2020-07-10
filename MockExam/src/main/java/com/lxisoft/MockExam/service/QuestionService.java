package com.lxisoft.MockExam.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.lxisoft.MockExam.model.Question;
import com.lxisoft.MockExam.repository.QuestionRepository;

public class QuestionService {

	    @Autowired
	    QuestionRepository questionRepository;

	    public void saveQuestion(Question question)
	    {
	            questionRepository.save(question);
	    }

	    public Question get(long id)
	    {
	        return questionRepository.getOne(id);
	    }

	    public List<Question> getAll()
	    {

	        return  questionRepository.findAll();
	    }

	    public void deleteById(long id)
	    {
	        questionRepository.deleteById(id);
	    }
}
