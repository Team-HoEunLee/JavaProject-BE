package JavaProject.Dayoung.domain.user.service;

import JavaProject.Dayoung.domain.quiz.domain.SolvedQuiz;
import JavaProject.Dayoung.domain.quiz.repository.SolvedQuizRepository;
import JavaProject.Dayoung.domain.user.domain.User;
import JavaProject.Dayoung.domain.user.facade.UserFacade;
import JavaProject.Dayoung.domain.user.presentation.dto.response.MyInfoResponse;
import JavaProject.Dayoung.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MyInfoService {

    private final UserFacade userFacade;
    private final UserRepository userRepository;
    private final SolvedQuizRepository solvedQuizRepository;

    public MyInfoResponse execute() {

        List<User> allUsers = userRepository.findAll(Sort.by(Sort.Direction.DESC, "score"));

        User currentUser = userFacade.getCurrentUser();

        int myRank = allUsers.indexOf(currentUser);

        List<SolvedQuiz> solvedQuizzes = solvedQuizRepository.findAllByUserId(currentUser.getId());
        List<Long> solvedQuizIds = solvedQuizzes.stream()
                .map(solvedQuiz -> solvedQuiz.getQuiz().getId())
                .collect(Collectors.toList());

        return MyInfoResponse.builder()
                .accountId(currentUser.getAccountId())
                .name(currentUser.getName())
                .introduction(currentUser.getIntroduction())
                .myRank(myRank)
                .area(currentUser.getAreaIds())
                .unsolvedQuizIds(solvedQuizIds)
                .build();
    }
}
