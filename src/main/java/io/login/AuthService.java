package io.login;

public class AuthService {
    private UserRepository userRepository;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean register(String username, String password) {
        // Eğer kullanıcı sistemde mevcutsa, kaydı reddet
        if (userRepository.findByUsername(username) != null) {
            return false;
        }

        // Yeni kullanıcıyı oluştur ve UserRepository'ye ekle
        User newUser = new User(username, password);
        userRepository.addUser(newUser);
        return true;
    }
    // Kullanıcı giriş yapma (login) metodu
    public boolean login(String username, String password) {
        User user = userRepository.findByUsername(username);
        return user != null && user.getPassword().equals(password);
    }
}
