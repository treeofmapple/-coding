package com.tom.tcc.backend.grades.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tom.tcc.backend.exception.NotFoundException;
import com.tom.tcc.backend.grades.dto.EvaluationRequest;
import com.tom.tcc.backend.grades.model.Evaluation;
import com.tom.tcc.backend.security.repository.UserRepository;

@Component
public class EvaluationMapperDecorator implements EvaluationMapper {

    @Autowired
	private UserRepository userRepository;

	private final EvaluationMapper delegate;

    public EvaluationMapperDecorator(EvaluationMapper delegate) {
        this.delegate = delegate;
    }
	
	@Override
	public Evaluation build(EvaluationRequest request) {
		Evaluation evaluation = delegate.build(request);
		var user = userRepository.findByUsername(request.name()).or(() -> userRepository.findByEmail(request.name()))
				.orElseThrow(() -> new NotFoundException("User not found"));
		evaluation.setUser(user);
		return evaluation;
	}

}
