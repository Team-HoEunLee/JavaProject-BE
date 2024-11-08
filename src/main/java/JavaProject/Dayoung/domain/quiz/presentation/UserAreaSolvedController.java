package JavaProject.Dayoung.domain.quiz.presentation;

import JavaProject.Dayoung.domain.quiz.presentation.dto.response.UserAreaSolvedResponse;
import JavaProject.Dayoung.domain.quiz.service.UserAreaSolvedService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name = "사용자 분야별 문제 풀이 통계", description = "사용자가 푼 문제의 분야별 통계를 조회")
@RequestMapping("/user/area-solved")
public class UserAreaSolvedController {

    private final UserAreaSolvedService userAreaSolvedService;

    @GetMapping("/{user-id}")
    @Operation(summary = "사용자 분야별 문제 풀이 통계 조회", description = "특정 사용자의 분야별 문제 풀이 통계를 조회합니다.")
    public List<UserAreaSolvedResponse> getUserAreaSolvedStats(@PathVariable("user-id") Long userId) {
        return userAreaSolvedService.getUserAreaSolvedStats(userId);
    }
}
