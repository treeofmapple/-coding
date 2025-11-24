package com.tom.tcc.backend.exception.global;

import java.util.Map;

public record ErrorResponse(Map<String, String> errorResponse) {

}
