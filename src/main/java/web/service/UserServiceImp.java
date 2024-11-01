package web.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.model.User;
import web.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService {

@Autowired
    private UserRepository userRepository;



    @Override
    public void add(User user) {
        userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    @Override

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public void updateById(User user,Long id) {
        User updatedUser = userRepository.findById(id).get();
        updatedUser.setName(user.getName());
        updatedUser.setSurname(user.getSurname());
        updatedUser.setEmail(user.getEmail());
        userRepository.save(updatedUser);

    }

}
