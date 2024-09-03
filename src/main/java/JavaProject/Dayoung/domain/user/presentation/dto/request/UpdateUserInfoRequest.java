package JavaProject.Dayoung.domain.user.presentation.dto.request;

import JavaProject.Dayoung.domain.user.entity.type.Major;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UpdateUserInfoRequest {

    private String accountId;

    private String name;

    private Major major;

    private String introduction;
}
