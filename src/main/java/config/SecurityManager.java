package config;

import com.vuelos.User.application.UserService;
import com.vuelos.User.domain.entity.User;
import java.util.Optional;

public class SecurityManager {
    private static UserService userService;

    public static void setUserService(UserService userService) {
        SecurityManager.userService = userService;
    }

    public static Optional<User> authenticate(String username, String password) {
        Optional<User> userOpt = userService.findByUsername(username);
        if (userOpt.isPresent() && userOpt.get().getPassword().equals(password)) {
            return userOpt;
        }
        return Optional.empty();
    }

    public static boolean authorize(User user, String permission) {
        return user.getRoles().stream()
            .flatMap(role -> role.getPermissions().stream())
            .anyMatch(perm -> perm.getName().equals(permission));
    }
}