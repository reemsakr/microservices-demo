package gove.iti.jets.geteway;

import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import io.github.resilience4j.timelimiter.TimeLimiterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
//import org.springframework.cloud.gateway.route.RouteLocator;
//import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.circuitbreaker.resilience4j.ReactiveResilience4JCircuitBreakerFactory;
import org.springframework.cloud.client.circuitbreaker.Customizer;
import org.springframework.cloud.client.circuitbreaker.ReactiveCircuitBreakerFactory;
import org.springframework.cloud.gateway.filter.factory.SpringCloudCircuitBreakerFilterFactory;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
//import reactor.core.publisher.Mono;
//import reactor.netty.http.client.HttpClient;

@RestController
@SpringBootApplication
@Configuration
public class GetewayApplication {

	@Autowired(required = false)
	private List<Customizer<ReactiveResilience4JCircuitBreakerFactory>> customizers = new ArrayList<>();

	public static void main(String[] args) {

		SpringApplication.run(GetewayApplication.class, args);
	}

	@Bean
	public RouteLocator myRoutes(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(p -> p
						.path("/get")
						.filters(f -> f.addRequestHeader("Hello", "World"))
						.uri("http://httpbin.org:80"))
				.route(p -> p
						.host("*.circuitbreaker.com")
						.filters(f -> f.circuitBreaker(config -> config.setName("mycmd")))
						.uri("http://httpbin.org:80")).
				build();
	}

	@Bean
	@ConditionalOnMissingBean(ReactiveCircuitBreakerFactory.class)
	public ReactiveResilience4JCircuitBreakerFactory reactiveResilience4JCircuitBreakerFactory(
			CircuitBreakerRegistry circuitBreakerRegistry,
			TimeLimiterRegistry timeLimiterRegistry) {
		ReactiveResilience4JCircuitBreakerFactory factory = new ReactiveResilience4JCircuitBreakerFactory(
				circuitBreakerRegistry, timeLimiterRegistry);
		customizers.forEach(customizer -> customizer.customize(factory));
		return factory;
	}

	@RequestMapping("/fallback")
	public Mono<String> fallback() {
		return Mono.just("fallback");
	}

//	@Bean
//	public RouteLocator myRoutes(RouteLocatorBuilder builder) {
//
//		return builder.routes()
//				.route(p -> p
//						.path("/get")
//						.filters(f -> f.addRequestHeader("Hello", "World"))
//						.uri("http://httpbin.org:80"))
//				.route(p -> p
//						.host("*.circuitbreaker.com")
//						.filters(f -> f.circuitBreaker(config -> config.setName("mycmd")))
//						.uri("http://httpbin.org:80")).
//				build();
////				.route(p -> p
////						.path("/teacher")
////						.filters(f -> f.addRequestHeader("Hello", "World"))
////						.uri("http://localhost:5050"))
////						.route(p -> p
////						.path("/teacher")
////						.filters(f -> f.circuitBreaker(config -> config.setName("mycmd")))
////						.uri("http://localhost:5050"))
////						.build();
//
//	}




}
