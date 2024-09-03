package JavaProject.Dayoung.domain.user.service;

import JavaProject.Dayoung.domain.user.entity.User;
import JavaProject.Dayoung.domain.user.facade.UserFacade;
import JavaProject.Dayoung.domain.user.presentation.dto.request.UpdateUserInfoRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UpdateUserInfoService {

    private final UserFacade userFacade;

    @Transactional
    public void modifyInfo(UpdateUserInfoRequest updateUserInfoRequest) {
        User user = userFacade.getCurrentUser();

        user.modifyInfo(updateUserInfoRequest.getAccountId(),
                updateUserInfoRequest.getName(),
                updateUserInfoRequest.getMajor(),
                updateUserInfoRequest.getIntroduction());
    }
}
