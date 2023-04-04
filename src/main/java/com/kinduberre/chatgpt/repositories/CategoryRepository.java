package com.kinduberre.chatgpt.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kinduberre.chatgpt.models.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

}
