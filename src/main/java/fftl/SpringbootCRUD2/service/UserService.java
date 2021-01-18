package fftl.SpringbootCRUD2.service;

import fftl.SpringbootCRUD2.controller.dto.UserSaveRequsetDto;
import fftl.SpringbootCRUD2.domain.User;
import fftl.SpringbootCRUD2.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public void userSave(UserSaveRequsetDto userSaveRequsetDto){

        User user = userSaveRequsetDto.toEntity();
        userRepository.save(user);

    }

    public User userLogin(String username, String password){
        User user= userRepository.findByUsername(username).get();
        if(user.getPassword() != password){
            User NotFoundUser = new User();
            return NotFoundUser;
        }
        return user;
    }
}
