package fourservings_fiveservings.insurance_system_be.common.config;

import fourservings_fiveservings.insurance_system_be.auth.jwt.filter.JwtAuthenticationFilter;
import fourservings_fiveservings.insurance_system_be.auth.jwt.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtService jwtService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http,
        HandlerMappingIntrospector introspector) throws Exception {
        http
            .csrf(AbstractHttpConfigurer::disable)
            .formLogin(AbstractHttpConfigurer::disable)

            //http basic 인증 방식 disable
            .httpBasic(AbstractHttpConfigurer::disable)

            // 세션 생성하지 않음
            .sessionManagement(sessionManagement ->
                sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS))

            // 인증되지 않은 요청에 대해 401에러 -> exception 커스텀 가능
            .exceptionHandling(e -> e
                .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED)))

            /**
             * 아래 url은 인증 없이 접근 가능
             */
            .authorizeHttpRequests(authorizeHttpRequests ->
                authorizeHttpRequests
                    .requestMatchers(new MvcRequestMatcher(introspector, "/health"))
                    .permitAll()
                    .requestMatchers(new MvcRequestMatcher(introspector, "/api/auth/sign-up"))
                    .permitAll()
                    .requestMatchers(new MvcRequestMatcher(introspector, "/api/auth/sign-in"))
                    .permitAll()
                    .requestMatchers(new MvcRequestMatcher(introspector, "/api/auth/**"))
                    .permitAll()
                    .requestMatchers(HttpMethod.OPTIONS, "/**")
                    .permitAll()
                    .anyRequest().authenticated()) // 그 외는 접근x
            .cors(cors -> cors
                .configurationSource(corsConfigurationSource())
            )

            // jwtFilter 후 UsernamePasswordAuthenticationFilter 인증 처리
            .addFilterBefore(new JwtAuthenticationFilter(jwtService),
                UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();

        configuration.addAllowedOrigin("https://insurance-system-fe.vercel.app");
        configuration.addAllowedOrigin(
            "https://insurance-system-fe-git-main-kimwlyus-projects.vercel.app");
        configuration.addAllowedOrigin(
            "https://insurance-system-pr21ai5ml-kimwlyus-projects.vercel.app");
        configuration.addAllowedOrigin("http://localhost:3000");

        configuration.addAllowedOriginPattern("*");
        configuration.addAllowedHeader("*");
        configuration.addAllowedMethod("*");
        configuration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);

        return source;
    }
}