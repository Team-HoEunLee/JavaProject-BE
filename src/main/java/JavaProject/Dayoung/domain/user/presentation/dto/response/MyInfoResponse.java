package JavaProject.Dayoung.domain.user.presentation.dto.response;

import JavaProject.Dayoung.domain.user.entity.type.Major;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class MyInfoResponse {

    private String accountId;

    private String name;

    private String introduction;

    private Major major;

}
