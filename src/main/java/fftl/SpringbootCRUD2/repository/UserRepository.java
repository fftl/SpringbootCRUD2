package fftl.SpringbootCRUD2.repository;

import fftl.SpringbootCRUD2.model.User;
import fftl.SpringbootCRUD2.controller.dto.UserSaveRequsetDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@RequiredArgsConstructor
@Repository
public class UserRepository {

    private final EntityManager em;

    public void userSave(User user){
            em.persist(user);
    }

    public User findOneUser(Long id){
        return em.find(User.class, id);
    }
}
