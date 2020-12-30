package fftl.SpringbootCRUD2.repository;

import fftl.SpringbootCRUD2.model.Board;
import fftl.SpringbootCRUD2.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class UserRepository {

    private final EntityManager em;

    public void userSave(User user){
        em.persist(user);
    }

    public void boardSave(Board board){
        em.persist(board);
    }


}
