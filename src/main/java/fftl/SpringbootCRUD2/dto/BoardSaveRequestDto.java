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

    private Long id;
    private String nickname;
    private String title;
    private String content;
    private LocalDateTime regDate;

    @Builder
    public BoardSaveRequestDto(Long id, User user, String nickname, String title, String content, LocalDateTime regDate) {
        this.nickname = nickname;
        this.title = title;
        this.content = content;
        this.regDate = regDate;
    }


    public Board toEntity() {
        return Board.builder()
                .content(content)
                .title(title)
                .regDate(regDate)
                .build();
    }
}

