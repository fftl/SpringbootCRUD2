package fftl.SpringbootCRUD2.model;


import lombok.*;

import javax.persistence.*;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;
    private String password;
    private String nickname;
    private String email;

    @OneToMany(mappedBy = "user")
    private List<Board> boards = new ArrayList<>();

    @Builder
    public User(Long id, String username, String password, String nickname, String email) {
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.email = email;
    }
}
