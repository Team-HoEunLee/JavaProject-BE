package JavaProject.Dayoung.domain.area.presentation;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@Tag(name = "분야", description = "분야 도메인")
@RequestMapping("/areas")
@RestController
public class AreaController {
}
