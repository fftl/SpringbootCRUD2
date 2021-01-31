package fftl.SpringbootCRUD2.repository;

import fftl.SpringbootCRUD2.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {
    List<Board> findAll();
}
