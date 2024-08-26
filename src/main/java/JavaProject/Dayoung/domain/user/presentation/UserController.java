package JavaProject.Dayoung.domain.user.presentation;

import JavaProject.Dayoung.domain.user.presentation.dto.request.ChangePasswordRequest;
import JavaProject.Dayoung.domain.user.presentation.dto.request.LoginRequest;
import JavaProject.Dayoung.domain.user.presentation.dto.request.SignupRequest;
import JavaProject.Dayoung.domain.user.presentation.dto.request.UpdateUserInfoRequest;
import JavaProject.Dayoung.domain.user.presentation.dto.response.MyInfoResponse;
import JavaProject.Dayoung.domain.user.presentation.dto.response.RankReponse;
import JavaProject.Dayoung.domain.user.service.*;
import JavaProject.Dayoung.global.security.TokenResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Validated
//@Valid는 기본적으로 컨트롤러에서만 동작하며 기본적으로 다른 계층에서는 검증이 되지 않는다
//[@Validated]
//입력 파라미터의 유효성 검증은 컨트롤러에서 최대한 처리하고 넘겨주는 것이 좋다.
//하지만 개발을 하다보면 불가피하게 다른 곳에서 파라미터를 검증해야 할 수 있다.
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

    @PostMapping("/signup")
    public void signup(@RequestBody @Valid SignupRequest signupRequest) {
        signupService.signUp(signupRequest);
    }

    @PostMapping("/login")
    public TokenResponse login(@RequestBody @Valid LoginRequest loginRequest) {
        return loginService.login(loginRequest);
    }

    @PutMapping("/reissue")
    public TokenResponse reissue(@RequestHeader(name = "refresh-token") @NotNull String refreshToken) {
        return reissueService.reissue(refreshToken);
    }

    @PatchMapping("/modify/{user-id}")
    public void modifyInfo(@RequestBody @Valid UpdateUserInfoRequest updateUserInfoRequest) {
        updateUserInfoService.modifyInfo(updateUserInfoRequest);
    }

    @PatchMapping("/password")
    public void changePassword(@RequestBody @Valid ChangePasswordRequest changePasswordRequest) {
        changePasswordService.changePassword(changePasswordRequest);
    }

    @GetMapping("/my")
    public MyInfoResponse getMyInfo() {
        return myInfoService.execute();
    }

    @GetMapping("/rank")
    public List<RankReponse> getScoreRank() {
        return getScoreRankService.execute();
    }
}
