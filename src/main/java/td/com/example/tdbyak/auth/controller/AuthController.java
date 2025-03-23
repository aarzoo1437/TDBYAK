package td.com.example.tdbyak.auth.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import td.com.example.tdbyak.auth.service.AuthService;
import td.com.example.tdbyak.auth.util.JwtUtil;
import td.com.example.tdbyak.identity.model.User;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);
    @Autowired
    private AuthService authService;

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final UserDetailsService userDetailsService;

    public AuthController(AuthenticationManager authenticationManager, JwtUtil jwtUtil, UserDetailsService userDetailsService) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.userDetailsService = userDetailsService;
    }

    @PostMapping("/signup")
    public String signup(@RequestBody User user) {
        logger.info("user: {} ", user);
        return authService.signup(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody AuthRequest request) {
        return authService.login(request.getUsername(), request.getPassword());
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class AuthRequest {
        private String username;
        private String password;

        public String getUsername(){
            return this.username;
        }
        public String getPassword(){
            return this.password;
        }
    }
}

