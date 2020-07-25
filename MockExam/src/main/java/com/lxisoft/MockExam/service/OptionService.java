package com.lxisoft.MockExam.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lxisoft.MockExam.model.Options;
import com.lxisoft.MockExam.repository.OptionsRepository;

@Service
public class OptionService {
	
	@Autowired
	OptionsRepository optionRepository;
	
	public void saveOptions(List<Options> options)
	{
		optionRepository.saveAll(options);
	}

}
