package fftl.SpringbootCRUD2.controller.dto;

import fftl.SpringbootCRUD2.model.Board;
import fftl.SpringbootCRUD2.model.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class BoardSaveRequestDto{

        private Long id;
        private User user;
        private String title;
        private String content;
        private LocalDateTime regDate;

        @Builder
        public BoardSaveRequestDto(Long id, User user, String title, String content, LocalDateTime regDate) {
            this.id = id;
            this.user = user;
            this.title = title;
            this.content = content;
            this.regDate = regDate;
        }

        public Board toEntity(){
            return Board.builder()
                    .content(content)
                    .title(title)
                    .regDate(regDate)
                    .build();
        }
    }


