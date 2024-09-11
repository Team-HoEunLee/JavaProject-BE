package JavaProject.Dayoung.domain.user.service;

import JavaProject.Dayoung.domain.quiz.entity.Quiz;
import JavaProject.Dayoung.domain.quiz.entity.type.IsSolved;
import JavaProject.Dayoung.domain.user.entity.User;
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

    public MyInfoResponse execute() {

        List<User> allUsers = userRepository.findAll(Sort.by(Sort.Direction.DESC, "score"));

        User currentUser = userFacade.getCurrentUser();

        int myRank = allUsers.indexOf(currentUser);

        /*
        return MyInfoResponse.builder()
                .accountId(currentUser.getAccountId())
                .name(currentUser.getName())
                .introduction(currentUser.getIntroduction())
                .myRank(myRank)
                .build();


        List<Long> solvedQuizIds = currentUser.getQuizzes().stream()
                .filter(quiz -> quiz.getIsSolved() == IsSolved.TRUE)
                .map(Quiz::getId)
                .collect(Collectors.toList());


         */
        return MyInfoResponse.builder()
                .accountId(currentUser.getAccountId())
                .name(currentUser.getName())
                .introduction(currentUser.getIntroduction())
                .area(currentUser.getArea())
                .code(currentUser.getCode())
                //.solvedQuizIds(solvedQuizIds)
                .build();
    }
}
