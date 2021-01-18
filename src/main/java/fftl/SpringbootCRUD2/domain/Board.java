package fftl.SpringbootCRUD2.domain;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Entity
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private String title;

    private String content;

    private LocalDateTime regDate;

    @Builder
    public Board(Long id, User user, String title, String content, LocalDateTime regDate) {
        this.id = id;
        this.user = user;
        this.title = title;
        this.content = content;
        this.regDate = regDate;
    }


}
