package JavaProject.Dayoung.domain.user.presentation;

import JavaProject.Dayoung.domain.user.presentation.dto.request.ChangePasswordRequest;
import JavaProject.Dayoung.domain.user.presentation.dto.request.LoginRequest;
import JavaProject.Dayoung.domain.user.presentation.dto.request.SignupRequest;
import JavaProject.Dayoung.domain.user.presentation.dto.request.UpdateUserInfoRequest;
import JavaProject.Dayoung.domain.user.presentation.dto.response.MyInfoResponse;
import JavaProject.Dayoung.domain.user.presentation.dto.response.RankListResponse;
import JavaProject.Dayoung.domain.user.service.*;
import JavaProject.Dayoung.global.security.TokenResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated
@Tag(name = "유저", description = "유저 엔티티입니다")
@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final SignupService signupService;
    private final LoginService loginService;
    private final ReissueService reissueService;
    private final UpdateUserInfoService updateUserInfoService;
    private final ChangePasswordService changePasswordService;
    private final MyInfoService myInfoService;
    private final GetScoreRankService getScoreRankService;
    private final WithdrawalService withdrawalService;

    @PostMapping("/signup")
    @Operation(summary = "유저 회원가입", description = "회원가입 할 때 사용하는 API")
    public void signup(@RequestBody @Valid SignupRequest request) {
        signupService.signUp(request);
    }

    @PostMapping("/login")
    @Operation(summary = "유저 로그인", description = "로그인 할 때 사용하는 API")
    public TokenResponse login(@RequestBody @Valid LoginRequest request) {
        return loginService.execute(request);
    }

    @PutMapping("/reissue")
    @Operation(summary = "유저 토큰 재발급", description = "토큰 재발급 할 때 사용하는 API")
    public TokenResponse reissue(@RequestHeader(name = "refresh-token") @NotNull String refreshToken) {
        return reissueService.execute(refreshToken);
    }

    @GetMapping("/info")
    @Operation(summary = "유저 정보 조회", description = "유저 정보 조회 할 때 사용하는 API")
    public MyInfoResponse getExecute() {
        return myInfoService.execute();
    }

    @PatchMapping //이거 수정해야함
    @Operation(summary = "유저 정보 수정", description = "유저 정보 수정 할 때 사용하는 API")
    public void modifyInfo(@RequestBody @Valid UpdateUserInfoRequest request) {
        updateUserInfoService.execute(request);
    }

    @PatchMapping("/password")
    @Operation(summary = "유저 비밀번호 변경", description = "유저 비밀번호 변경 할 때 사용하는 API")
    public void changePassword(@RequestBody @Valid ChangePasswordRequest request) {
        changePasswordService.execute(request);
    }

    @GetMapping("/rank")
    @Operation(summary = "유저 랭킹", description = "유저 랭킹 해주는 사용하는 API")
    public RankListResponse getScoreRank() {
        return getScoreRankService.execute();
    }

    @DeleteMapping
    @Operation(summary = "회원 탈퇴", description = "회원 탈퇴할 때 사용하는 API")
    public void WithdrawalUser() {
        withdrawalService.execute();
    }
}
