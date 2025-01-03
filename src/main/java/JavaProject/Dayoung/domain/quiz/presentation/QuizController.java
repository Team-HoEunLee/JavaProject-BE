package JavaProject.Dayoung.domain.quiz.presentation;

import JavaProject.Dayoung.domain.quiz.domain.type.Level;
import JavaProject.Dayoung.domain.quiz.domain.type.QuizType;
import JavaProject.Dayoung.domain.quiz.presentation.dto.request.CreateQuizRequest;
import JavaProject.Dayoung.domain.quiz.presentation.dto.request.SolveQuizRequest;
import JavaProject.Dayoung.domain.quiz.presentation.dto.request.UpdateQuizRequest;
import JavaProject.Dayoung.domain.quiz.presentation.dto.response.CategoryListResponse;
import JavaProject.Dayoung.domain.quiz.presentation.dto.response.QuizDetailResponse;
import JavaProject.Dayoung.domain.quiz.presentation.dto.response.QuizListResponse;
import JavaProject.Dayoung.domain.quiz.service.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@Tag(name = "문제", description = "문제 엔티티입니다")
@RequestMapping("/quizzes")
public class QuizController {

    private final CreateQuizService createQuizService;
    private final QueryQuizDetailService queryQuizDetailService;
    private final QueryQuizListService queryQuizListService;
    private final QueryCategoryService queryCategoryService;
    private final SolveQuizService solveQuizService;
    private final UpdateQuizService updateQuizService;
    private final DeleteQuizService deleteQuizService;
    private final QueryBannerQuizService queryBannerQuizService;

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
    public QuizListResponse getQuizList(
            @RequestParam(value = "title", required = false) String title,
            @RequestParam(value = "area_ids", required = false) List<Long> areaIds,
            @RequestParam(value = "level", required = false) List<Level> level,
            @RequestParam(value = "is_solved", required = false) Boolean isSolved,
            @RequestParam(value = "page", defaultValue = "1") @Positive int page
    ) {
        return queryQuizListService.execute(title, areaIds, level, isSolved, page);
    }

    @GetMapping("/category")
    @Operation(summary = "카테고리 조회", description = "문제 리스트 조회에 필요한 area, code를 조회하는 api")
    public CategoryListResponse getQuizList() {
        return queryCategoryService.execute();
    }

    @PostMapping("/solve")
    @Operation(summary = "퀴즈 풀기", description = "문제를 풀면 AI가 문제의 답변을 반환합니다.")
    public Map<String, String> solveQuiz(
            @RequestParam(value = "quiz_id") Long quizId,
            @RequestBody SolveQuizRequest request) {
        return solveQuizService.execute(quizId, request);
    }

    @PatchMapping("/{quiz-id}")
    @Operation(summary = "퀴즈 수정", description = "문제를 수정하는 api")
    public void updateQuiz(@PathVariable("quiz-id") Long quizId, @RequestBody @Valid UpdateQuizRequest request) {
        updateQuizService.execute(quizId, request);
    }

    @DeleteMapping("/{quiz-id}")
    @Operation(summary = "퀴즈 삭제", description = "문제를 삭제하는 api")
    public void deleteQuiz(@PathVariable("quiz-id") Long quizId) {
        deleteQuizService.execute(quizId);
    }

    @GetMapping("/banner")
    @Operation(summary = "배너 조회", description = "웹사이트 상단의 배너 api")
    public QuizListResponse getBannerQuiz(@RequestParam(value = "quizType") QuizType quizType) {
        return queryBannerQuizService.execute(quizType);
    }
}
