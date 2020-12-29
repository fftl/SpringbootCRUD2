package fftl.SpringbootCRUD2.domain;

import lombok.Getter;
import lombok.Setter;

import fftl.SpringbootCRUD2.domain.Member;
import java.time.LocalDateTime;

@Getter
@Setter
public class MemberTO {

    private Integer id;

    private String name;

    private String account;

    private String password;

    private LocalDateTime lastAccessDt;

    private LocalDateTime regDt;

    public Member toEntity() {
        return new Member(id, name, account, password);
    }
//getter,setter 생략
}