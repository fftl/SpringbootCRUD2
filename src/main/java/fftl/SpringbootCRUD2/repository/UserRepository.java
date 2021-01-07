package fftl.SpringbootCRUD2.repository;

import fftl.SpringbootCRUD2.model.User;
import fftl.SpringbootCRUD2.controller.dto.UserSaveRequsetDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class UserRepository {

    private final EntityManager em;

    public void userSave(UserSaveRequsetDto userSaveRequsetDto){
        em.persist(userSaveRequsetDto.toEntity());
    }

    public User findOneUser(Long id){
        return em.find(User.class, id);
    }
}
