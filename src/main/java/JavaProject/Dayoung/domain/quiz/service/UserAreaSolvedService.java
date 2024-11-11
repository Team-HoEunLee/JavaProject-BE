package JavaProject.Dayoung.domain.quiz.service;

import JavaProject.Dayoung.domain.quiz.presentation.dto.response.UserAreaSolvedResponse;
import JavaProject.Dayoung.domain.quiz.repository.SolvedQuizRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class UserAreaSolvedService {

    private final SolvedQuizRepository solvedQuizRepository;

    public List<UserAreaSolvedResponse> getUserAreaSolvedStats(Long userId) {
        return solvedQuizRepository.findAllByUserId(userId).stream()
                .map(userAreaSolved -> UserAreaSolvedResponse.builder()
                        .areaIds(userAreaSolved.getQuiz().getAreaIds())
                        .solvedCount(userAreaSolved.getSolvedCount())
                        .build())
                .collect(Collectors.toList());
    }
}
