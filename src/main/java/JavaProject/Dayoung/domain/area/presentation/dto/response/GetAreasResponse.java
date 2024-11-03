package JavaProject.Dayoung.domain.area.presentation.dto.response;

import JavaProject.Dayoung.domain.area.domain.Area;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class GetAreasResponse {

    private List<Area> areaList;
}
