package com.lxisoft.MockExam.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.lxisoft.MockExam.model.Options;
import com.lxisoft.MockExam.repository.OptionsRepository;

public class OptionService {
	
	@Autowired
	OptionsRepository optionRepository;
	
	public void saveOptions(List<Options> options)
	{
		optionRepository.saveAll(options);
	}

}
