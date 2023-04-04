package com.kinduberre.chatgpt.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kinduberre.chatgpt.models.Prompt;

@Repository
public interface PromptRepository extends JpaRepository<Prompt, Long>{
}
