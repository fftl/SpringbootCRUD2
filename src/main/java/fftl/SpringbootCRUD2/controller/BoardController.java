package fftl.SpringbootCRUD2.controller;

import fftl.SpringbootCRUD2.dto.BoardSaveRequestDto;
import fftl.SpringbootCRUD2.domain.Board;
import fftl.SpringbootCRUD2.domain.User;
import fftl.SpringbootCRUD2.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class BoardController {

    private final BoardService boardService;


    @GetMapping("/goBoard")
    public String goBoard(Model model) {
        List<Board> boards = boardService.findAll();

        model.addAttribute("boards", boards);

        return "board/boardList";
    }

    @GetMapping("/goBoardCreate")
    public String goBoardCreate(Model model, HttpServletRequest request) {

        HttpSession session = request.getSession(true);
        User user = (User) session.getAttribute("user");

        BoardSaveRequestDto boardSaveRequestDto = new BoardSaveRequestDto();

        model.addAttribute("boardDto", boardSaveRequestDto);

        return "board/boardCreate";
    }

    @PostMapping("/createBoard")
    public String createBoard(@ModelAttribute("boardDto") BoardSaveRequestDto boardDto) {
        LocalDateTime today = LocalDateTime.now();
        boardDto.setRegDate(today);
        boardService.createBoard(boardDto);

        return "redirect:/";
    }

    @GetMapping("/goUpdate/{boardId}")
    public String goUpdate(@PathVariable Long boardId, Model model) {

        model.addAttribute("boardDto", boardService.getBoard(boardId));

        return "board/boardUpdate";
    }

    @PostMapping("/updateBoard")
    public String updateBoard(@ModelAttribute("boardDto") BoardSaveRequestDto boardDto) {
        LocalDateTime today = LocalDateTime.now();
        boardDto.setRegDate(today);
        boardService.updateBoard(boardDto);

        return "redirect:/goBoard";
    }
}
