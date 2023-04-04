package com.kinduberre.chatgpt.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name= "prompt")
public class Prompt {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long promptId;
	private String promptName;
	@ManyToOne
	@JoinColumn(name="cate_id")
	private Category category;
	
}
