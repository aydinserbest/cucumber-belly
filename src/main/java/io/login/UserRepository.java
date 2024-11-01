package io.login;

import java.util.HashMap;
import java.util.Map;

public class UserRepository {
    private Map<String, User> users =new HashMap<>();
    //Constructor-örnek kullanıcıları ekleyelim:
    public UserRepository() {
        users.put("user1@example.com", new User("user1@example.com", "pass123"));
        users.put("user2@example.com", new User("user2@example.com", "abc$1234"));
        users.put("user3@example.com", new User("user3@example.com", "xyz!7890"));
    }
    // Kullanıcı ekleme metodu
    public void addUser(User user) {
        // Bu kontrolü kaldırıyoruz; AuthService bu kontrolü zaten yapıyor
        users.put(user.getUsername(), user);
    }
    // Kullanıcıyı kullanıcı adına göre bulma metodu
    public User findByUsername(String username) {
        return users.get(username);
    }
}
