package com.tom.tcc.backend.telemetry;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.api.trace.Tracer;
import io.opentelemetry.sdk.trace.samplers.Sampler;

@Configuration
@ConditionalOnProperty(name = "otlp.tracing.enabled", havingValue = "true", matchIfMissing = false)
public class TelemetryConfig {

	@Value("${spring.application.name:unkown-service}")
	private String applicationName;

	@Bean
	Sampler alwaysSampler() {
		return Sampler.alwaysOn();
	}

	@Bean
	Tracer tracer(OpenTelemetry openTelemetry) {
		return openTelemetry.getTracer(applicationName);
	}
}
