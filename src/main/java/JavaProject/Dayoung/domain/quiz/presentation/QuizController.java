package JavaProject.Dayoung.domain.quiz.presentation;

import JavaProject.Dayoung.domain.area.entity.Area;
import JavaProject.Dayoung.domain.quiz.entity.type.IsSolved;
import JavaProject.Dayoung.domain.quiz.entity.type.Level;
import JavaProject.Dayoung.domain.quiz.presentation.dto.request.CreateQuizRequest;
import JavaProject.Dayoung.domain.quiz.presentation.dto.response.CategoryListResponse;
import JavaProject.Dayoung.domain.quiz.presentation.dto.response.QuizDetailResponse;
import JavaProject.Dayoung.domain.quiz.presentation.dto.response.QuizListResponse;
import JavaProject.Dayoung.domain.quiz.service.CreateQuizService;
import JavaProject.Dayoung.domain.quiz.service.QueryCategoryService;
import JavaProject.Dayoung.domain.quiz.service.QueryQuizDetailService;
import JavaProject.Dayoung.domain.quiz.service.QueryQuizService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@Tag(name = "문제", description = "문제 엔티티입니다")
@RequestMapping("/quizzes")
@RestController
public class QuizController {

    private final CreateQuizService createQuizService;
    private final QueryQuizDetailService queryQuizDetailService;
    private final QueryQuizService queryQuizService;
    private final QueryCategoryService queryCategoryService;

    @PostMapping
    @Operation(summary = "문제 생성", description = "어드민이 문제를 등록할 때 사용하는 API")
    public void createQuiz(@RequestBody @Valid CreateQuizRequest request) {
        createQuizService.execute(request);
    }

    @GetMapping("/{quiz-id}")
    @Operation(summary = "문제 정보 상세 조회", description = "문제 정보 상세 조회 할 때 사용하는 API")
    public QuizDetailResponse getQuizDetail(@PathVariable("quiz-id") Long quizId) {
        return queryQuizDetailService.execute(quizId);
    }

    @GetMapping("/list")
    @Operation(summary = "문제 리스트 조회", description = "카테고리를 사용해 문제리스트를 조회")
    public List<QuizListResponse> getQuizList(
        @RequestParam(value = "title") String title,
        @RequestParam(value = "area") List<Area> area,
        @RequestParam(value = "level") List<Level> level,
        @RequestParam(value = "is_solved") IsSolved isSolved
    ) {
        return queryQuizService.execute(title, area, level, isSolved);
    }

    @GetMapping("/category")
    @Operation(summary = "카테고리 조회", description = "문제 리스트 조회에 필요한 area, code를 조회하는 api")
    public CategoryListResponse getQuizList() {
        return queryCategoryService.execute();
    }
}
