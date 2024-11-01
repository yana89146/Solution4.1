package web.service;
import web.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    void add(User user);

    List<User> getAllUsers();

    void deleteById(Long id);

    Optional<User> findById(Long id);

    void updateById(User user, Long id);
}
