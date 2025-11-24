package com.tom.tcc.backend.grades.dto;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;

public record EvaluationRequest(
		
        @NotBlank(message = "The subject cannot be blank.")
        String subject,

        @NotBlank(message = "The description cannot be blank.")
        String description,

        @DecimalMin(value = "0.0", message = "The grade must be at least 0.")
        @DecimalMax(value = "10", message = "The grade must be at most 10.")
        double grade,

        @NotBlank(message = "The evaluator's name cannot be blank.")
        String name // or email 
) {

}
