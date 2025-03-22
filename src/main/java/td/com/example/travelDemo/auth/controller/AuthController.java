package td.com.example.travelDemo.auth.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import td.com.example.travelDemo.auth.service.AuthService;
import td.com.example.travelDemo.identity.model.User;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @Autowired
    private  AuthService authService;

    @PostMapping("/signup")
    public String signup(@RequestBody User user) {
        return authService.signup(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody AuthRequest request) {
        return authService.login(request.getUsername(), request.getPassword());
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    class AuthRequest {
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

