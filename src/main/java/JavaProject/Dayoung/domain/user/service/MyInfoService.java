package JavaProject.Dayoung.domain.user.service;

import JavaProject.Dayoung.domain.user.entity.User;
import JavaProject.Dayoung.domain.user.facade.UserFacade;
import JavaProject.Dayoung.domain.user.presentation.dto.response.MyInfoResponse;
import JavaProject.Dayoung.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
@RequiredArgsConstructor
public class MyInfoService {

    private final UserFacade userFacade;

    public MyInfoResponse execute() {

        User currentUser = userFacade.getCurrentUser();

        return MyInfoResponse.builder()
            .accountId(currentUser.getAccountId())
            .name(currentUser.getName())
            .introduction(currentUser.getIntroduction())
            .major(currentUser.getMajor())
            .build();
    }
}
