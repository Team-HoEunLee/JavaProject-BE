package JavaProject.Dayoung.domain.user.service;

import JavaProject.Dayoung.domain.user.entity.User;
import JavaProject.Dayoung.domain.user.entity.type.Role;
import JavaProject.Dayoung.domain.user.exception.UserAlreadyExistException;
import JavaProject.Dayoung.domain.user.presentation.dto.request.SignupRequest;
import JavaProject.Dayoung.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SignupService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void signUp(SignupRequest signupRequest) {

        if (userRepository.existsByAccountId(signupRequest.getAccountId())) {
            throw UserAlreadyExistException.EXCEPTION;
        }

        String password = passwordEncoder.encode(signupRequest.getPassword());

        userRepository.save(
                User.builder()
                        .accountId(signupRequest.getAccountId())
                        .email(signupRequest.getEmail())
                        .password(password)
                        .role(Role.STUDENT)
                        .build()
        );
    }
}
