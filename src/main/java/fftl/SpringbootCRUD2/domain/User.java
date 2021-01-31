package fftl.SpringbootCRUD2.domain;


import lombok.*;
import org.springframework.stereotype.Controller;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="userId")
    private Long id;

    private String username;
    private String password;
    private String nickname;
    private String email;

    @OneToMany(mappedBy = "userId")
    private List<Board> boards = new ArrayList<>();

    @Builder
    public User(Long id, String username, String password, String nickname, String email) {
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.email = email;
    }
}
