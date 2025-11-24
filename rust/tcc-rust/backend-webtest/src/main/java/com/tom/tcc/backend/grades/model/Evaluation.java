package com.tom.tcc.backend.grades.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tom.tcc.backend.security.model.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "evaluation")
public class Evaluation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "subject", 
			nullable = false, 
			unique = false, 	
			updatable = true)
	private String subject;

	@Column(name = "description", 
			nullable = true, 
			unique = false, 
			updatable = true)
	private String description;

	@Min(value = 0)
	@Max(value = 10)
	@Column(name = "grade", 
			precision = 5,
			scale = 2,
			nullable = false, 
			unique = false, 
			updatable = true)
	private BigDecimal grade;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
	
}
