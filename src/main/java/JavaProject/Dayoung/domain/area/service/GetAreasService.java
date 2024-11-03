package JavaProject.Dayoung.domain.area.service;

import JavaProject.Dayoung.domain.area.domain.Area;
import JavaProject.Dayoung.domain.area.presentation.dto.response.GetAreasResponse;
import JavaProject.Dayoung.domain.area.repository.AreaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class GetAreasService {

    private final AreaRepository areaRepository;

    public GetAreasResponse execute() {

        List<Area> areaList = areaRepository.findAll();

        return new GetAreasResponse(areaList);
    }
}
