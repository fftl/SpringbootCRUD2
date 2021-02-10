package fftl.SpringbootCRUD2.dto;

import fftl.SpringbootCRUD2.domain.Board;
import fftl.SpringbootCRUD2.domain.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class BoardSaveRequestDto {

    private Long boardId;
    private Long userId;
    private String nickName;
    private String title;
    private String content;
    private LocalDateTime regDate;

    @Builder
    public BoardSaveRequestDto(Long boardId, Long userId, String nickName, String title, String content, LocalDateTime regDate) {
        this.boardId = boardId;
        this.userId = userId;
        this.nickName = nickName;
        this.title = title;
        this.content = content;
        this.regDate = regDate;
    }

    public Board toEntity() {
        return Board.builder()
                .userId(userId)
                .content(content)
                .nickName(nickName)
                .title(title)
                .regDate(regDate)
                .build();
    }
}


