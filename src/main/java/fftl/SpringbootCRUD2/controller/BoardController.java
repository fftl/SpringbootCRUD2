package fftl.SpringbootCRUD2.controller;

import fftl.SpringbootCRUD2.controller.dto.BoardSaveRequestDto;
import fftl.SpringbootCRUD2.domain.Board;
import fftl.SpringbootCRUD2.domain.User;
import fftl.SpringbootCRUD2.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Controller
public class BoardController {

    private final BoardService boardService;
    LocalDateTime today = LocalDateTime.now();

    @GetMapping("/goBoard")
    public String goBoard(Model model){
        List<Board> boards = boardService.findAll();

        return "/board/boardList";
    }

    @GetMapping("/goBoardCreate")
    public String goBoard(Model model, HttpSession session){
        User user = (User)session.getAttribute("userInfo");
        BoardSaveRequestDto boardSaveRequestDto = new BoardSaveRequestDto();

        boardSaveRequestDto.setNickname(user.getNickname());
        model.addAttribute("boardDto", boardSaveRequestDto);

        return "/board/boardList";
    }

    @PostMapping("/createBoard")
    public String userLogin(@ModelAttribute("boardDto") BoardSaveRequestDto boardDto, HttpSession session, HttpServletRequest request){
        boardDto.setRegDate(today);
        boardService.boardSave(boardDto);

        return "redirect:/goBoard";
    }
}
