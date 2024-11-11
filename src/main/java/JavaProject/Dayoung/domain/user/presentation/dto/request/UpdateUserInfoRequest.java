package JavaProject.Dayoung.domain.user.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class UpdateUserInfoRequest {

    private String accountId;

    private String name;

    private List<Long> areaIds;

    private String introduction;
}
