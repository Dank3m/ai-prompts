package com.kinduberre.chatgpt.services;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kinduberre.chatgpt.models.Category;
import com.kinduberre.chatgpt.models.Prompt;
import com.kinduberre.chatgpt.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository cateRepo;
	
	public List<Category> findAll() {
		return cateRepo.findAll();
	}

	public List<Category> readPromptFile() {
		List<Prompt> prompts = new ArrayList<Prompt>();
		List<Category> categories = new ArrayList<Category>();
		try {
			String file = "D:\\Work Progress\\output edited.txt";
			BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));

			String data = null;
			int count = 0;
			int previousCount = 0;
			String title = "";
			Category category = new Category();
			while ((data = reader.readLine()) != null) {
				
				if (data.contains(
						"-----------------------------------------------------------------------------------------")) {
					count++;
				}
				if (count % 2 != 0) {
					title = data;
				} else {

					if (!data.contains(
							"-----------------------------------------------------------------------------------------")) {
						Prompt prompt = new Prompt();
						prompt.setPromptName(data);
						prompts.add(prompt); 
						
						System.out.println("Count: " + count + ", Previous Count: " +previousCount);
						
						if(count > previousCount) {
							previousCount = count;
							category = new Category();
						}
						category.setCateName(title);
						category.getPrompts().add(prompt);
						categories.add(category);
							
					}
				}
				
			}
			reader.close();

			for (Prompt prompt : prompts) {
				System.out.println("Prompt: " + prompt.toString());
			}
			
			System.out.println("Categories size: " + categories.size());
			
			for (Category cate : categories) {
				
				System.out.println("Category: " + cate.toString());
			}

		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return categories;
	}

	public void saveToDb(List<Category> categories) {
		
		Set<Category> set = new HashSet<>(categories);
		categories.clear();
		categories.addAll(set);
		cateRepo.saveAllAndFlush(categories);
	}
}
