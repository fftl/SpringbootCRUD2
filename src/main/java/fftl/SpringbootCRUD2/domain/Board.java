package fftl.SpringbootCRUD2.domain;

import fftl.SpringbootCRUD2.dto.BoardSaveRequestDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardId;

    private Long userId;
    private String title;
    private String nickName;
    private String content;

    private LocalDateTime regDate;

    @Builder
    public Board(Long userId, String title, String nickName, String content, LocalDateTime regDate) {
        this.userId = userId;
        this.title = title;
        this.nickName = nickName;
        this.content = content;
        this.regDate = regDate;
    }

    public void boardUpdate(BoardSaveRequestDto boardDto){
        this.title = boardDto.getTitle();
        this.content = boardDto.getContent();
        this.regDate = boardDto.getRegDate();
    }
}
