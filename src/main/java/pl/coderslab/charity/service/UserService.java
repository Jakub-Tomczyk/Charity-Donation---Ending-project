package pl.coderslab.charity.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.entity.Role;
import pl.coderslab.charity.repository.RoleRepository;
import pl.coderslab.charity.repository.UserRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }
    public void save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEnabled(1);
        // TODO :: First register than add ROLE_ADMIN
        if(user.getRoles() == null || user.getRoles().size()==0) {
            Set<Role> roles = new HashSet<>();
            roles.add(roleRepository.findOneByName("ROLE_USER"));
            user.setRoles(roles);
        }

        userRepository.save(user);
    }

    public List<User> readAll() {
        return this.userRepository.findAll();
    }

    public void deleteById(Long id) {
        User user = findById(id);
        this.userRepository.delete(user);
    }
    //tą metodę muszę zmodyfikować tak aby sprawdzała warunek. Jeśli password jest puste to wtedy wstawiaj mi automatycznie to hasło co
    // jest w bazie danych. A jeśli wstawi się nowe to wtedy je "haszuj" ponownie. Brzmi fajnie, ale nie wiem jak to zrobić..
    // ma to wyglądać trochę tak jak save.
    public void update(User user) {
        if(user.getPassword()==null){
            Set<Role> roles = new HashSet<>();
            roles.add(roleRepository.findOneByName("ROLE_USER"));
            user.setRoles(roles);
        }
        userRepository.save(user);
    }

    public User findById(Long id) {return this.userRepository.findById(id).orElse(null);}

    public User findByUserName(String username) {
        return userRepository.findByUsername(username);
    }
}
