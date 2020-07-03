package ppjh.sb.example.mvc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * SpringBoot MVC는 여러 기본 설정 및 기능을 제공
 * WebMVC 기본 설정 외 추가설정이 필요할 때
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

}
