package JavaProject.Dayoung.infra.swagger;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.context.annotation.Configuration;

//http://localhost:8080/swagger-ui/index.html
//http://15.164.26.179/swagger-ui/index.html

@OpenAPIDefinition(
        info = @Info(
                title = "SWAGGER : Dayoung API 명세",
                description = "나는 김승원이다. 이 명세서를 해킹했지. \n 다들 수고해라~~!! \n 곧 있으면 이 명세서 날려버릴 거당 \\ (>.<) /"
        ),
        security = @SecurityRequirement(name = "bearerAuth")
)
@SecurityScheme(
        name = "bearerAuth",
        type = SecuritySchemeType.HTTP,
        scheme = "bearer",
        bearerFormat = "JWT"
)
@Configuration
public class SwaggerConfig {
}
