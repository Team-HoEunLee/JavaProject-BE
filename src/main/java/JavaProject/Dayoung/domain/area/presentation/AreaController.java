package JavaProject.Dayoung.domain.area.presentation;

import JavaProject.Dayoung.domain.area.presentation.dto.request.CreateAreaRequest;
import JavaProject.Dayoung.domain.area.presentation.dto.response.GetAreasResponse;
import JavaProject.Dayoung.domain.area.service.CreateAreaService;
import JavaProject.Dayoung.domain.area.service.GetAreasService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@Tag(name = "분야", description = "분야 도메인")
@RequestMapping("/areas")
@RestController
public class AreaController {

    private final CreateAreaService createAreaService;
    private final GetAreasService getAreasService;

    @PostMapping
    @Operation(summary = "분야 생성", description = "분야를 어드민이 추가하는 API")
    public void createArea(@RequestBody @Valid CreateAreaRequest request) {
        createAreaService.execute(request);
    }

    @GetMapping
    @Operation(summary = "분야 조회", description = "분야들을 조회하는 API")
    public GetAreasResponse getAllAreas() {
        return getAreasService.execute();
    }
}
