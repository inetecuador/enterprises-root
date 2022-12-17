package com.base;

import com.base.config.BaseConfiguration;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * BaseApplication.
 *
 * @author vsangucho on 2022/12/15
 * @version 1.0
 */
@SpringBootApplication(scanBasePackages = { "com.base" })
@Import({ BaseConfiguration.class })
@OpenAPIDefinition(info = @Info(title = "Base app", version = "1.0.0", description = "Base app"))
public class BaseApplication implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(BaseApplication.class);
    }

    /**
     * ObjectMapper.
     *
     * @author vsangucho on 2022/12/15
     * @return ObjectMapper
     */
    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper().setSerializationInclusion(JsonInclude.Include.NON_NULL)
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("*").allowedMethods("GET", "POST", "PUT", "DELETE");
    }
}
