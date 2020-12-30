package fftl.SpringbootCRUD2.repository;

import fftl.SpringbootCRUD2.model.Board;
import fftl.SpringbootCRUD2.model.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class UserRepository {

    private final EntityManager em;

    public void userSave(UserEntity userEntity){
        em.persist(userEntity);
    }

    public void boardSave(Board board){
        em.persist(board);
    }

    public UserEntity findByName(String uname){
        return em.find(UserEntity.class, uname);
    }


}
