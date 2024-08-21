package JavaProject.Dayoung.domain.user.presentation.dto.request;

import JavaProject.Dayoung.domain.user.entity.type.Major;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
public class UpdateUserInfoRequest {

    @NotNull(message = "아이디을 입력하세요")
    private String accountId;

    @NotNull(message = "닉네임을 입력하세요")
    private String name;

    @NotNull(message = "전공을 선택해주세요")
    private Major major;
}
