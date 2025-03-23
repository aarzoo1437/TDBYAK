package td.com.example.tdbyak.auth.util;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

//@Slf4j
@Component
public class JwtFilter extends OncePerRequestFilter {

    private static final Logger logger = LoggerFactory.getLogger(JwtFilter.class);

    @Autowired
    private JwtUtil jwtUtil;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        logger.info("request received : {} ", request);
        String requestPath = request.getServletPath();
        logger.info("requestPath : {} ", requestPath);
        if (requestPath.contains("/login") || requestPath.contains("/signup")) {
            chain.doFilter(request, response);
            return;
        }
        logger.info("request received : {} ", request);
        String authHeader = request.getHeader("Authorization");

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            chain.doFilter(request, response);
            return;
        }
        String token = authHeader.substring(7);
        String username = jwtUtil.extractUsername(token);
        if (username != null && jwtUtil.validateToken(token, username)) {
            SecurityContextHolder.getContext().setAuthentication(null);
        }
        chain.doFilter(request, response);
    }
}
