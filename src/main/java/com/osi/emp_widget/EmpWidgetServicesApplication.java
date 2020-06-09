package com.osi.emp_widget;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class EmpWidgetServicesApplication {

	public static void main ( String[] args ) {
		SpringApplication.run( EmpWidgetServicesApplication.class, args );
	}

	@Bean
	public Docket productApi () {
		return new Docket( DocumentationType.SWAGGER_2 )
				.apiInfo( apiEndPointsInfo() )
				.select()
				.apis( RequestHandlerSelectors.any() )
				.paths( PathSelectors.any() )
				.build();
	}

	public static final Contact DEFAULT_CONTACT = new Contact(
			"OSI Digital Pvt Ltd - ET-DLY", "http://www.osidigital.com/", "dev.java@osidigital.com" );

	public static final ApiInfo DEFAULT_API_INFO = new ApiInfo(
			"Widget Services", "Curd operations on Employee widget service using Rest API with Spring Boot 1.4.2", "1.0",
			"urn:tos", DEFAULT_CONTACT,
			"Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0" );

	private ApiInfo apiEndPointsInfo () {
        return new ApiInfoBuilder().title( "Widget Services" )
                .description( "Curd operations on widget services using REST API with Spring Boot 1.4.2" )
                .version( "1.0" )
				.contact( DEFAULT_CONTACT )
                .build();
	}
}