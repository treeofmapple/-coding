package com.tom.tcc.backend.security.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.springframework.data.domain.Page;

import com.tom.tcc.backend.security.dto.admin.AdminLoginHistoryResponse;
import com.tom.tcc.backend.security.dto.admin.PageAdminLoginHistoryResponse;
import com.tom.tcc.backend.security.dto.user.LoginHistoryResponse;
import com.tom.tcc.backend.security.dto.user.PageLoginHistoryResponse;
import com.tom.tcc.backend.security.model.LoginHistory;


@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface LoginMapper {

	@Mapping(source = "user.username", target = "username")
	@Mapping(source = "user.email", target = "email")
	AdminLoginHistoryResponse toResponse(LoginHistory history);

	List<AdminLoginHistoryResponse> toAdminResponseList(List<LoginHistory> histories);

	default PageAdminLoginHistoryResponse toAdminResponse(Page<LoginHistory> page) {
		if (page == null) {
			return null;
		}

		List<AdminLoginHistoryResponse> content = toAdminResponseList(page.getContent());
		return new PageAdminLoginHistoryResponse(
				content, 
				page.getNumber(), 
				page.getSize(), 
				page.getTotalPages(),
				page.getTotalElements());
	}

	List<LoginHistoryResponse> toResponseList(List<LoginHistory> history);

	default PageLoginHistoryResponse toResponse(Page<LoginHistory> page) {
		if (page == null) {
			return null;
		}

		List<LoginHistoryResponse> content = toResponseList(page.getContent());
		return new PageLoginHistoryResponse(
				content, 
				page.getNumber(), 
				page.getSize(), 
				page.getTotalPages(),
				page.getTotalElements());
	}

}
