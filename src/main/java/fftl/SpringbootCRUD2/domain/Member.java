package fftl.SpringbootCRUD2.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_member")
@Getter
@Setter
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 255, nullable = false)
    private String name;

    @Column(length = 255, nullable = false, unique = true)
    private String account;

    @Column(length = 255, nullable = false)
    private String password;

    @Column(name = "last_access_dt")
    private LocalDateTime lastAccessDt;

    @Column(name = "reg_dt")
    private LocalDateTime regDt;

    public Member() {
    }

    public Member(Integer id, String name, String account, String password) {
        this.id = id;
        this.name = name;
        this.account = account;
        this.password = password;
    }

    //getter,setter 생략
}