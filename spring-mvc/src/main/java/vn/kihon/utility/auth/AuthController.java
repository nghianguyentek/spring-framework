package vn.kihon.utility.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.kihon.utility.Response;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
class AuthController {
    private final AuthRepository authRepository;

    @GetMapping("/2.0")
    Response<Auth> getAuth() {
        Auth auth = authRepository.findById("01").orElseThrow();
        return new Response<Auth>().setCode("OK")
                .setData(auth);
    }
}
