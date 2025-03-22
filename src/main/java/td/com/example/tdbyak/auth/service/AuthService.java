package td.com.example.tdbyak.auth.service;

import td.com.example.tdbyak.identity.model.User;

public interface AuthService {

    public String signup(User user);

    public String login(String username, String password);
}
