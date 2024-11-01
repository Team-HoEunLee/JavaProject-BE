package JavaProject.Dayoung.domain.quiz.service;

import JavaProject.Dayoung.domain.area.domain.Area;
import JavaProject.Dayoung.domain.quiz.domain.SolvedQuiz;
import JavaProject.Dayoung.domain.quiz.domain.UserAreaSolved;
import JavaProject.Dayoung.domain.quiz.presentation.dto.response.UserAreaSolvedResponse;
import JavaProject.Dayoung.domain.quiz.repository.SolvedQuizRepository;
import JavaProject.Dayoung.domain.quiz.repository.UserAreaSolvedRepository;
import JavaProject.Dayoung.domain.user.domain.User;
import JavaProject.Dayoung.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class UserAreaSolvedService {

    private final UserAreaSolvedRepository userAreaSolvedRepository;
    private final SolvedQuizRepository solvedQuizRepository;
    private final UserRepository userRepository;

    public void updateUserAreaSolved(SolvedQuiz solvedQuiz) {
        User user = solvedQuiz.getUser();
        Area area = solvedQuiz.getQuiz().getArea().get(0);

        UserAreaSolved userAreaSolved = userAreaSolvedRepository.findByUserAndArea(user, area)
                .orElse(UserAreaSolved.builder()
                        .user(user)
                        .area(area)
                        .solvedCount(0L)
                        .build());

        userAreaSolved.incrementSolvedCount();
        userAreaSolvedRepository.save(userAreaSolved);
    }

    @Transactional(readOnly = true)
    public List<UserAreaSolvedResponse> getUserAreaSolvedStats(Long userId) {
        return userAreaSolvedRepository.findAllByUserId(userId).stream()
                .map(userAreaSolved -> UserAreaSolvedResponse.builder()
                        .area(userAreaSolved.getArea())
                        .solvedCount(userAreaSolved.getSolvedCount())
                        .build())
                .collect(Collectors.toList());
    }
}
