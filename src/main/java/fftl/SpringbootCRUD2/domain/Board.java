package fftl.SpringbootCRUD2.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@NoArgsConstructor
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

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
}
