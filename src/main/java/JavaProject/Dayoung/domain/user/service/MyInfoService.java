package JavaProject.Dayoung.domain.user.service;

import JavaProject.Dayoung.domain.user.entity.User;
import JavaProject.Dayoung.domain.user.facade.UserFacade;
import JavaProject.Dayoung.domain.user.presentation.dto.response.MyInfoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
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
