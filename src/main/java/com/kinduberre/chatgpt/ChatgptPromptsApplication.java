package com.kinduberre.chatgpt;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
//import org.springframework.context.ConfigurableApplicationContext;

//import com.kinduberre.chatgpt.models.Category;
//import com.kinduberre.chatgpt.services.CategoryService;

@SpringBootApplication
public class ChatgptPromptsApplication { //implements CommandLineRunner{

	@Autowired
//	private CategoryService categoryService;
	
	public static void main(String[] args) {
//		ConfigurableApplicationContext ctx = 
				SpringApplication.run(ChatgptPromptsApplication.class, args);
			
//		SpringApplication.exit(ctx, () -> 0);
	}

//	@Override
//	public void run(String... args) throws Exception {
//		
//		// Read categories from prompt file
//		List<Category> categories = categoryService.readPromptFile();
//		
//		// Save the categories to the database
//		categoryService.saveToDb(categories);
//		
//	}

}
