package fftl.SpringbootCRUD2.model;


import lombok.Data;
import lombok.Getter;

import javax.persistence.*;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="user")
@Getter
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String uid;
    private String upw;
    private String uname;
    private String email;

    @OneToMany(mappedBy = "user")
    private List<Board> boards = new ArrayList<>();
}
