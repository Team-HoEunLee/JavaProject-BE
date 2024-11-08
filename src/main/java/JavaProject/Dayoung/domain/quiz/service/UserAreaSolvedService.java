package JavaProject.Dayoung.domain.quiz.service;

import JavaProject.Dayoung.domain.area.domain.Area;
import JavaProject.Dayoung.domain.quiz.domain.SolvedQuiz;
import JavaProject.Dayoung.domain.quiz.domain.UserAreaSolved;
import JavaProject.Dayoung.domain.quiz.presentation.dto.response.UserAreaSolvedResponse;
import JavaProject.Dayoung.domain.quiz.repository.UserAreaSolvedRepository;
import JavaProject.Dayoung.domain.user.domain.User;
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

    public void updateUserAreaSolved(SolvedQuiz solvedQuiz) {
        User user = solvedQuiz.getUser();
        List<Area> areas = solvedQuiz.getQuiz().getArea();
        if (areas.isEmpty()) {
            throw new IllegalStateException("퀴즈에 지정된 분야가 없습니다.");
        }
        Area area = areas.get(0);

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
