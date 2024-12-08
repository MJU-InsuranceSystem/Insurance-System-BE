package fourservings_fiveservings.insurance_system_be.common.log;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Slf4j
@Component
public class HttpStatusInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        MDC.put("method", request.getMethod());
        MDC.put("uri", request.getRequestURI());
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        try {
            String method = MDC.get("method");
            String uri = MDC.get("uri");
            String status;

            // 상태 코드 설정
            if (ex != null) {
                status = "500"; // 예외 발생 시
            } else {
                status = String.valueOf(response.getStatus()); // 정상 응답
            }
            MDC.put("status", status);

            // 상태 코드에 따른 로그 레벨 설정
            int statusCode = Integer.parseInt(status);
            if (statusCode >= 400) {
                log.error("Error Response - Method: {}, URI: {}, Status: {}", method, uri, status);
            } else if (statusCode >= 200) {
                log.info("Info Response - Method: {}, URI: {}, Status: {}", method, uri, status);
            } else {
                log.warn("Unhandled Response - Method: {}, URI: {}, Status: {}", method, uri, status);
            }
        } finally {
            // MDC 정리
            MDC.clear();
        }
    }
}