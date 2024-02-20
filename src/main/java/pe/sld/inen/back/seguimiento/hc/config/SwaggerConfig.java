package pe.sld.inen.back.seguimiento.hc.config;
//package pe.sld.inen.back.seguimiento.hc.config;
//
//import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.ResponseEntity;
//
//import com.google.common.collect.Lists;
//
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.service.ApiKey;
//import springfox.documentation.service.AuthorizationScope;
//import springfox.documentation.service.Contact;
//import springfox.documentation.service.SecurityReference;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spi.service.contexts.SecurityContext;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
//import springfox.documentation.spring.web.plugins.Docket;
//import static springfox.documentation.builders.PathSelectors.regex;
//
//import java.util.Date;
//import java.util.List;
//
//@Configuration
//@EnableSwagger2
//public class SwaggerConfig {
//	
//	public static final String AUTHORIZATION_HEADER = "Authorization";
//
//    @Bean
//    public Docket defApi() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                   .select()                 
//                   .apis(RequestHandlerSelectors.basePackage("pe.sld.inen.back.seguimiento.hc"))
//                   .paths(regex("/servicio/v1.0.*"))
//                   .build().apiInfo(metaData())
//					.forCodeGeneration(true)
//					.genericModelSubstitutes(ResponseEntity.class).ignoredParameterTypes(Pageable.class)
//					.ignoredParameterTypes(java.sql.Date.class)
//					.directModelSubstitute(java.time.LocalDate.class, java.sql.Date.class)
//					.directModelSubstitute(java.time.ZonedDateTime.class, Date.class)
//					.directModelSubstitute(java.time.LocalDateTime.class, Date.class)
//					.securityContexts(Lists.newArrayList(securityContext())).securitySchemes(Lists.newArrayList(apiKey()))
//					.useDefaultResponseMessages(false);
//    }
//    
//    private ApiInfo metaData() {
//      	 return new ApiInfoBuilder()
//         		.title("API para la consulta del trabajador del hogar")
//                 .description("Api destinada a la consulta del trabajador del hogar")
//                 .termsOfServiceUrl("Términos del Servicio")
//                 .version("1.0")
//                 .contact(new Contact("Kevin Daniel. Pinchi García", "www.google.com", "kpinchi-prov@trabajo.gob.pe"))
//                 .license("Apache License Version 2.0")
//                 .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
//                 .build();  
//    }
//    
//	private ApiKey apiKey() {
//		return new ApiKey("JWT", AUTHORIZATION_HEADER, "header");
//	}
//
//	private SecurityContext securityContext() {
//		return SecurityContext.builder().securityReferences(defaultAuth()).forPaths(PathSelectors.regex("/servicio/v1.0.*"))
//				.build();
//	}
//
//	List<SecurityReference> defaultAuth() {
//		AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
//		AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
//		authorizationScopes[0] = authorizationScope;
//		return Lists.newArrayList(new SecurityReference("JWT", authorizationScopes));
//	}
//}
