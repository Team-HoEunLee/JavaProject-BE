package JavaProject.Dayoung.domain.user.service;

import JavaProject.Dayoung.domain.area.domain.Area;
import JavaProject.Dayoung.domain.area.repository.AreaRepository;
import JavaProject.Dayoung.domain.user.domain.User;
import JavaProject.Dayoung.domain.user.domain.type.Role;
import JavaProject.Dayoung.domain.user.exception.UserAlreadyExistException;
import JavaProject.Dayoung.domain.user.presentation.dto.request.SignupRequest;
import JavaProject.Dayoung.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class SignupService {

    private final UserRepository userRepository;
    private final AreaRepository areaRepository;
    private final PasswordEncoder passwordEncoder;

    public void signUp(SignupRequest signupRequest) {

        if (userRepository.existsByAccountId(signupRequest.getAccountId())) {
            throw UserAlreadyExistException.EXCEPTION;
        }

        String password = passwordEncoder.encode(signupRequest.getPassword());

        if (signupRequest.getAreaId() != null) {

            userRepository.save(
                User.builder()
                    .accountId(signupRequest.getAccountId())
                    .password(password)
                    .name(signupRequest.getName())
                    .introduction(signupRequest.getIntroduction())
                    .areaIds(signupRequest.getAreaId())
                    .role(Role.STUDENT)
                    .score(0)
                    .build()
            );
        } else {
            userRepository.save(
                User.builder()
                    .accountId(signupRequest.getAccountId())
                    .password(password)
                    .name(signupRequest.getName())
                    .introduction(signupRequest.getIntroduction())
                    .areaIds(null)
                    .role(Role.STUDENT)
                    .score(0)
                    .build()
            );
        }
    }
}
