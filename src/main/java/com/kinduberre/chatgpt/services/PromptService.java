package com.kinduberre.chatgpt.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kinduberre.chatgpt.models.Category;
import com.kinduberre.chatgpt.models.Prompt;
import com.kinduberre.chatgpt.repositories.CategoryRepository;
import com.kinduberre.chatgpt.repositories.PromptRepository;

@Service
public class PromptService {

	@Autowired
	private PromptRepository promptRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	public List<Prompt> findAll() {
		return promptRepository.findAll();
	}
	
	public List<Prompt> findByCategory(Long cateId) {
		Category category = categoryRepository.findById(cateId).get();
		return category.getPrompts();
	}
	
	public Prompt findById(Long promptId) {
		
		Optional<Prompt> prompt = promptRepository.findById(promptId);
		
		if (prompt.isPresent()) {
			return promptRepository.findById(promptId).get();
		}
		return new Prompt();
	}
	
	public Prompt savePrompt(Prompt prompt) {
		return promptRepository.save(prompt);
	}
	
	public void deletePrompt(Long promptId) {
		promptRepository.deleteById(promptId);
	}
	
}
