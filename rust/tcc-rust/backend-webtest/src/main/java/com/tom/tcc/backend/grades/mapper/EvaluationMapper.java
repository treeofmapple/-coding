package com.tom.tcc.backend.grades.mapper;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import com.tom.tcc.backend.grades.dto.EvaluationRequest;
import com.tom.tcc.backend.grades.dto.EvaluationResponse;
import com.tom.tcc.backend.grades.model.Evaluation;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
@DecoratedWith(EvaluationMapperDecorator.class)
public interface EvaluationMapper {

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "user", ignore = true)
	Evaluation build(EvaluationRequest request);
	
	@Mapp
	EvaluationResponse toResponse(Evaluation evaluation);
	
	
	
	/*
	
	
	private final UserRepository repository;

	public Evaluation toEvaluation(EvaluationRequest request) {
		if (request == null) {
			return null;
		}

		return repository.findByName(request.name())
				.map(user -> Evaluation.builder().subject(request.subject()).description(request.description())
						.grade(request.grade()).user(user).build())
				.orElseThrow(() -> new RuntimeException("User with requested name doesn't exist: " + request.name()));
	}

	public EvaluationResponse fromEvaluation(Evaluation evaluation) {
		if (evaluation == null) {
			return null;
		}
		return new EvaluationResponse(evaluation.getSubject(), evaluation.getDescription(), evaluation.getGrade(),
				evaluation.getUser());
	}

	public void mergeEvaluation(Evaluation evaluation, EvaluationUpdate request, User user) {
		evaluation.setSubject(request.subject());
		evaluation.setDescription(request.description());
		evaluation.setGrade(request.grade());
		evaluation.setUser(user);
	}

	 */
}
