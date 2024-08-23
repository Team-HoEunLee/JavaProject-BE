package JavaProject.Dayoung.domain.user.presentation.dto.response;

import JavaProject.Dayoung.domain.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class RankReponse {

    private String name;

    private Integer score;

    public RankReponse(User user) {
        this.name = user.getName();
        this.score = user.getScore();
    }
}
