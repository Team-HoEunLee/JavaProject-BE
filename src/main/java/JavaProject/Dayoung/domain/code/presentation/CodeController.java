package JavaProject.Dayoung.domain.code.presentation;

import JavaProject.Dayoung.domain.code.presentation.dto.request.CreateCodeRequest;
import JavaProject.Dayoung.domain.code.service.CreateCodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/codes")
@RestController
public class CodeController {

    private final CreateCodeService createCodeService;

    @PostMapping
    public void createCode(@RequestBody @Valid CreateCodeRequest createQuizRequest) {
        createCodeService.execute(createQuizRequest);
    }
}
