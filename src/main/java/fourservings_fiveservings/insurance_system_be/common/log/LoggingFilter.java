//package fourservings_fiveservings.insurance_system_be.common.log;
//
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpFilter;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.slf4j.MDC;
//
//import java.io.IOException;
//
//public class LoggingFilter extends HttpFilter {
//
//    @Override
//    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
//            throws IOException, ServletException {
//        try {
//            MDC.put("method", request.getMethod());
//            MDC.put("uri", request.getRequestURI());
//
//            // 요청 처리
//            chain.doFilter(request, response);
//
//            // 상태 코드 확인 후 로그 출력
//            MDC.put("status", String.valueOf(response.getStatus()));
//
//        } finally {
//            // MDC 정리
//            MDC.clear();
//        }
//    }
//}
