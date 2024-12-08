package fourservings_fiveservings.insurance_system_be.common.config;

import fourservings_fiveservings.insurance_system_be.common.log.HttpStatusInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class WebConfig implements WebMvcConfigurer {

    private final HttpStatusInterceptor httpStatusInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 모든 경로에 대해 인터셉터 추가
        registry.addInterceptor(httpStatusInterceptor).addPathPatterns("/**");
    }
}
