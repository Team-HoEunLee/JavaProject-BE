package JavaProject.Dayoung.domain.user.service;

import JavaProject.Dayoung.domain.quiz.repository.QuizRepository;
import JavaProject.Dayoung.domain.user.entity.User;
import JavaProject.Dayoung.domain.user.presentation.dto.response.RankReponse;
import JavaProject.Dayoung.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class GetScoreRankService {

    private final UserRepository userRepository;

    public List<RankReponse> execute() {
        return userRepository.findTop10ByOrderByScoreDesc()
            .stream()
            .map(RankReponse::new)
            .collect(Collectors.toList());
    }
}
