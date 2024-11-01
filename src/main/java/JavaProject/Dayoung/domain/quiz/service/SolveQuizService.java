package JavaProject.Dayoung.domain.quiz.service;

import JavaProject.Dayoung.domain.quiz.domain.Quiz;
import JavaProject.Dayoung.domain.quiz.domain.SolvedQuiz;
import JavaProject.Dayoung.domain.quiz.presentation.dto.request.SolveQuizRequest;
import JavaProject.Dayoung.domain.quiz.repository.QuizRepository;
import JavaProject.Dayoung.domain.quiz.repository.SolvedQuizRepository;
import JavaProject.Dayoung.domain.user.facade.UserFacade;
import JavaProject.Dayoung.infra.openai.config.TemplateConfig;
import JavaProject.Dayoung.infra.openai.domain.ChatGPTResponse;
import JavaProject.Dayoung.infra.openai.repository.ChatGPTRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
@Transactional
@RequiredArgsConstructor
public class SolveQuizService {

    private final UserFacade userFacade;
    private final TemplateConfig templateConfig;
    private final QuizRepository quizRepository;
    private final SolvedQuizRepository solvedQuizRepository;
    private final UserAreaSolvedService userAreaSolvedService;

    public Map<String, String> execute(Long quizId, SolveQuizRequest request) {

        Quiz quiz = quizRepository.findQuizById(quizId);

        ChatGPTRequest gptRequest = templateConfig.promptMapping(quiz.getQuestion(), request);
        ResponseEntity<ChatGPTResponse> gptResponse = templateConfig.responseMapping(gptRequest);

        String responseContent = gptResponse.getBody().getChoices().get(0).getMessage().getContent();

        String correctRate = templateConfig.correctRateMatcher(responseContent);
        String feedback = templateConfig.feedbackMatcher(responseContent);

        Map<String, String> result = new HashMap<>();
        result.put("정답률", correctRate);
        result.put("피드백", feedback);

        solvedQuizRepository.save(SolvedQuiz.builder()
                .user(userFacade.getCurrentUser())
                .quiz(quiz)
                .receivedScore(Long.valueOf(correctRate))
                .build());

//        SolvedQuiz solvedQuiz
//                = userAreaSolvedService.updateUserAreaSolved(solvedQuiz);
        return result;
    }
}
