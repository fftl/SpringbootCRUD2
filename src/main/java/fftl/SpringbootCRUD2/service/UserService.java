package fftl.SpringbootCRUD2.service;

import fftl.SpringbootCRUD2.controller.dto.UserSaveRequsetDto;
import fftl.SpringbootCRUD2.model.User;
import fftl.SpringbootCRUD2.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public void userSave(UserSaveRequsetDto userSaveRequsetDto){
        User user = userSaveRequsetDto.toEntity();

        userRepository.userSave(user);
    }
}
