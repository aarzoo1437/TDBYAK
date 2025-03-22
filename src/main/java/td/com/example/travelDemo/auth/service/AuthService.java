package td.com.example.travelDemo.auth.service;

import td.com.example.travelDemo.identity.model.User;

public interface AuthService {

    public String signup(User user);

    public String login(String username, String password);
}
