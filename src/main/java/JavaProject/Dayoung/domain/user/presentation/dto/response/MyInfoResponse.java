package JavaProject.Dayoung.domain.user.presentation.dto.response;

import JavaProject.Dayoung.domain.area.entity.Area;
import JavaProject.Dayoung.domain.code.entity.Code;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
@AllArgsConstructor
public class MyInfoResponse {

    private String accountId;

    private String name;

    private String introduction;

    private int myRank;

    private Area area;

    private Code code;

    private List<Long> solvedQuizIds;
}
