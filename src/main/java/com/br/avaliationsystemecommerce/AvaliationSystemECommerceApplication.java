package com.br.avaliationsystemecommerce;

import io.micrometer.core.aop.TimedAspect;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.composite.CompositeMeterRegistry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AvaliationSystemECommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AvaliationSystemECommerceApplication.class, args);
	}

	@Bean
	public MeterRegistry meterRegistry() {
        return new CompositeMeterRegistry();
	}

	@Bean
	public TimedAspect timedAspect(MeterRegistry registry) {
		return new TimedAspect(registry);
	}

}
