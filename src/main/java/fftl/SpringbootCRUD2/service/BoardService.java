package fftl.SpringbootCRUD2.service;

import fftl.SpringbootCRUD2.dto.BoardSaveRequestDto;
import fftl.SpringbootCRUD2.domain.Board;
import fftl.SpringbootCRUD2.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional
    public void boardSave(BoardSaveRequestDto boardDto){
        boardRepository.save(boardDto.toEntity());
    }

    public List<Board> findAll(){
        return boardRepository.findAll();
    }

    public Board getBoard(Long boardId){
        return boardRepository.findById(boardId).orElseThrow(NoClassDefFoundError::new);
    }
}
