package JavaProject.Dayoung.domain.quiz.service;


import JavaProject.Dayoung.domain.area.repository.AreaRepository;
import JavaProject.Dayoung.domain.code.repository.CodeRepository;
import JavaProject.Dayoung.domain.quiz.presentation.dto.response.QuizListResponse;
import JavaProject.Dayoung.domain.quiz.repository.QuizRepository;
import JavaProject.Dayoung.domain.quiz.repository.port.QuizPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class QueryBannerQuizService {

    private final CodeRepository codeRepository;
    private final AreaRepository areaRepository;
    private final QuizRepository quizRepository;
    private final QuizPort quizPort;

    public List<QuizListResponse> execute(boolean beginner, boolean recent, boolean temporary, boolean mostSolved) {

        if (beginner) {
            return quizPort.queryAllForBeginner()
                .stream()
                .map(QuizListResponse::new)
                .collect(Collectors.toList());
        } if(recent) {
            return quizPort.queryAllForRecent()
                .stream()
                .map(QuizListResponse::new)
                .collect(Collectors.toList());
        } if (temporary) {
            return quizPort.queryAllForTemporary()
                .stream()
                .map(QuizListResponse::new)
                .collect(Collectors.toList());
        } else {
            return quizPort.queryAllForMostSolved()
                .stream()
                .map(QuizListResponse::new)
                .collect(Collectors.toList());
        }
    }
}
