package JavaProject.Dayoung.domain.quiz.presentation;

import JavaProject.Dayoung.domain.area.entity.Area;
import JavaProject.Dayoung.domain.quiz.entity.type.IsSolved;
import JavaProject.Dayoung.domain.quiz.entity.type.Level;
import JavaProject.Dayoung.domain.quiz.presentation.dto.request.CreateQuizRequest;
import JavaProject.Dayoung.domain.quiz.presentation.dto.response.QuizDetailResponse;
import JavaProject.Dayoung.domain.quiz.presentation.dto.response.QuizListResponse;
import JavaProject.Dayoung.domain.quiz.service.CreateQuizService;
import JavaProject.Dayoung.domain.quiz.service.QueryQuizDetailService;
import JavaProject.Dayoung.domain.quiz.service.QueryQuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/quizes")
@RestController
public class QuizController {

    private final CreateQuizService createQuizService;
    private final QueryQuizDetailService queryQuizDetailService;
    private final QueryQuizService queryQuizService;

    @PostMapping
    public void createQuiz(@RequestBody @Valid CreateQuizRequest createQuizRequest) {
        createQuizService.createQuiz(createQuizRequest);
    }

    @GetMapping("/{quiz-id}")
    public QuizDetailResponse getQuizDetail(@PathVariable("quiz-id") Long quizId) {
        return queryQuizDetailService.getQuizDetail(quizId);
    }

    @GetMapping("/list")
    public List<QuizListResponse> getQuizList(
        @RequestParam(value = "title") String title,
        @RequestParam(value = "area") List<Area> area,
        @RequestParam(value = "level") List<Level> level,
        @RequestParam(value = "is_solved") IsSolved isSolved
    ) {
        return queryQuizService.getQuizList(title, area, level, isSolved);
    }
}
