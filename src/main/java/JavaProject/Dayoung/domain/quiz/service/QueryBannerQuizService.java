package JavaProject.Dayoung.domain.quiz.service;


import JavaProject.Dayoung.domain.area.repository.AreaRepository;
import JavaProject.Dayoung.domain.code.repository.CodeRepository;
import JavaProject.Dayoung.domain.quiz.repository.QuizRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class QueryBannerQuizService {

    private final CodeRepository codeRepository;
    private final AreaRepository areaRepository;
    private final QuizRepository quizRepository;

    public void execute(boolean beginner, boolean recent, boolean temporary, boolean mostSolved) {

    }
}
