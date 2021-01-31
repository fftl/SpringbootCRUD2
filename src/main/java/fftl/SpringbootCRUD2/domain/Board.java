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

    private String content;

    private LocalDateTime regDate;

    @Builder
    public Board(Long id, Long userId, String title, String content, LocalDateTime regDate) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.content = content;
        this.regDate = regDate;
    }


}
