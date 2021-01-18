package fftl.SpringbootCRUD2.repository;

import fftl.SpringbootCRUD2.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {

}
