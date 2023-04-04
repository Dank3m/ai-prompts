package com.kinduberre.chatgpt.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kinduberre.chatgpt.models.Prompt;
import com.kinduberre.chatgpt.services.PromptService;

@RestController
@RequestMapping("api/v1/prompt")
public class PromptController {
	@Autowired
	private PromptService promptService;
	
	@GetMapping("prompts")
	public List<Prompt> getAllPrompts() {
		return promptService.findAll();
	}
	
	@GetMapping("category/{id}")
	public List<Prompt> getPromptsByCategory(@PathVariable("id") Long cateId) {
		return promptService.findByCategory(cateId);
	}
	
	@GetMapping("prompt/{id}")
	public Prompt getPromptsById(@PathVariable("id") Long promptId) {
		return promptService.findById(promptId);
	}
	
	@PostMapping("prompt")
	public ResponseEntity<Prompt> createPrompt(@RequestBody Prompt prompt) {
		return new ResponseEntity<Prompt>(promptService.savePrompt(prompt), HttpStatus.CREATED);
	}
	
	@PutMapping("prompt/{id}")
	public ResponseEntity<Prompt> updatePrompt(@PathVariable("id") Long promptId, @RequestBody Prompt prompt) {
		
		Prompt promptFromDB = promptService.findById(promptId);
		promptFromDB.setPromptName(prompt.getPromptName());
		promptFromDB.getCategory().setCateId(prompt.getCategory().getCateId());
		
		return new ResponseEntity<Prompt>(promptService.savePrompt(promptFromDB), HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping("prompt/{id}")
	public ResponseEntity<Prompt> deletePrompt(@PathVariable("id") Long promptId) {
		promptService.deletePrompt(promptId);
		return new ResponseEntity<Prompt>(HttpStatus.NO_CONTENT);
	}
}
