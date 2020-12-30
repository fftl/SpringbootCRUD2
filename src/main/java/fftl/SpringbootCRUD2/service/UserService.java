package fftl.SpringbootCRUD2.service;

import fftl.SpringbootCRUD2.model.Role;
import fftl.SpringbootCRUD2.model.UserEntity;
import fftl.SpringbootCRUD2.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService implements UserDetailsService{

    private final UserRepository userRepository;

    @Transactional //유저 회원가입 입니다.
    public void userJoin(UserEntity userEntity){
         userRepository.userSave(userEntity);
    }

    @Override
    public UserDetails loadUserByUsername(String uname) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByName(uname);

        List<GrantedAuthority> authorities = new ArrayList<>(); //권한을 생성해줍니다.

        if (("admin").equals(userEntity.getUname())) { //만약 회원가입된 유저의 이름이가 admin 이면 admin 권한을 준다.
            authorities.add(new SimpleGrantedAuthority(Role.ADMIN.getValue()));
        } else {    //아니라면 member 권한을 준다.
            authorities.add(new SimpleGrantedAuthority(Role.MEMBER.getValue()));
        }

        return new User(userEntity.getUid(), userEntity.getUpw(), authorities);
    }
}
