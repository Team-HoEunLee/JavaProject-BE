package JavaProject.Dayoung.domain.quiz.presentation;

import JavaProject.Dayoung.domain.quiz.presentation.dto.request.CreateQuizRequest;
import JavaProject.Dayoung.domain.quiz.presentation.dto.response.QuizDetailResponse;
import JavaProject.Dayoung.domain.quiz.presentation.dto.response.QuizListResponse;
import JavaProject.Dayoung.domain.quiz.service.CreateQuizService;
import JavaProject.Dayoung.domain.quiz.service.QueryQuizDetailService;
import JavaProject.Dayoung.domain.quiz.service.QueryQuizService;
import JavaProject.Dayoung.domain.quiz.service.SearchQuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Validated
@RequiredArgsConstructor
@RequestMapping("/quiz")
@RestController
public class QuizController {

    private final CreateQuizService createQuizService;
    private final QueryQuizDetailService queryQuizDetailService;
    private final QueryQuizService queryQuizService;
    private final SearchQuizService searchQuizService;

    @PostMapping
    public void createQuiz(@RequestBody @Valid CreateQuizRequest createQuizRequest) {
        createQuizService.createQuiz(createQuizRequest);
    }

    @GetMapping("/{quiz-id}")
    public QuizDetailResponse getQuizDetail(@PathVariable("quiz-id") Long quizId) {
        return queryQuizDetailService.getQuizDetail(quizId);
    }

    @GetMapping("/search/{title}")
    public List<QuizListResponse> searchQuiz(@PathVariable("title") String title) {
        return searchQuizService.searchQuiz(title);
    }
}
