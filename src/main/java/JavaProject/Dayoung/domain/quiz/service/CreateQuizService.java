package JavaProject.Dayoung.domain.quiz.service;

import JavaProject.Dayoung.domain.quiz.domain.Quiz;
import JavaProject.Dayoung.domain.quiz.presentation.dto.request.CreateQuizRequest;
import JavaProject.Dayoung.domain.quiz.repository.QuizRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Transactional
public class CreateQuizService {

    private final QuizRepository quizRepository;

    public void execute(CreateQuizRequest request) {

        quizRepository.save(Quiz.builder()
                //.area() 일단 보류
                //.code()
                .level(request.getLevel())
                .question(request.getQuestion())
                .title(request.getTitle())
                .createdAt(LocalDateTime.now())
                .build());
    }
}
