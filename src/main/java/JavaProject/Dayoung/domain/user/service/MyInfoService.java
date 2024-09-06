package JavaProject.Dayoung.domain.user.service;

import JavaProject.Dayoung.domain.user.entity.User;
import JavaProject.Dayoung.domain.user.facade.UserFacade;
import JavaProject.Dayoung.domain.user.presentation.dto.response.MyInfoResponse;
import JavaProject.Dayoung.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
        
        return MyInfoResponse.builder()
            .accountId(currentUser.getAccountId())
            .name(currentUser.getName())
            .introduction(currentUser.getIntroduction())
            .major(currentUser.getMajor())
            .myRank(myRank)
            .build();
    }
}
