package fftl.SpringbootCRUD2.service;

import fftl.SpringbootCRUD2.model.User;
import fftl.SpringbootCRUD2.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public void userJoin(User user){
         userRepository.userSave(user);
    }

}
