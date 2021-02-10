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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="userId")
    private Long userId;

    private String userName;
    private String password;
    private String nickName;
    private String email;

    @OneToMany(mappedBy = "userId")
    private List<Board> boards = new ArrayList<>();

    @Builder
    public User(String userName, String password, String nickName, String email) {
        this.userName = userName;
        this.password = password;
        this.nickName = nickName;
        this.email = email;
    }
}
