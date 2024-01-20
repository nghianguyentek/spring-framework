package vn.kihon.spring.boot.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.kihon.spring.boot.domain.User;
import vn.kihon.spring.boot.domain.UserRepository;

import java.util.List;

@RestController
@RequiredArgsConstructor
class UserController {
    private final UserRepository userRepository;

    @GetMapping("/users")
    public List<User> getAll() {
        return userRepository.getAll();
    }
}
