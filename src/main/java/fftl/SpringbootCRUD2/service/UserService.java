package fftl.SpringbootCRUD2.service;

import fftl.SpringbootCRUD2.dto.UserSaveRequsetDto;
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

    public User userLogin(String userName, String password){
        User user= userRepository.findByUserName(userName);

        if(user == null){
            User NotFoundUser = new User();
            return NotFoundUser;
        }

        if(!user.getPassword().equals(password)){
            User NotFoundUser = new User();
            return NotFoundUser;
        }

        return user;
    }

    public boolean idCheck(String idCheck){

        User user = userRepository.findByUserName(idCheck);

        if(user == null){
            return true;
        }

        return false;
    }
}
