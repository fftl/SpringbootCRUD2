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

    public User userLogin(String username, String password){
        User user= userRepository.findByUsername(username).get();
        System.out.println(password);
        System.out.println(user.getPassword());
        if(!user.getPassword().equals(password)){
            System.out.println("틀렸대");
            User NotFoundUser = new User();
            return NotFoundUser;
        }
        System.out.println("맞았대");
        return user;
    }
}
