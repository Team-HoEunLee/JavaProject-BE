package JavaProject.Dayoung.domain.quiz.service;

import JavaProject.Dayoung.domain.quiz.presentation.dto.response.QuizListResponse;
import JavaProject.Dayoung.domain.quiz.repository.QuizRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SearchQuizService {

    private final QuizRepository quizRepository;

    public List<QuizListResponse> searchQuiz(String title) {
        return quizRepository.findAllByTitleContaining(title)
                .stream()
                .map(QuizListResponse::new)
                .collect(Collectors.toList());
    }
}
