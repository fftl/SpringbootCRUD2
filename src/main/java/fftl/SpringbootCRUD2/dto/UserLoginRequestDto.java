package fftl.SpringbootCRUD2.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserLoginRequestDto {

    private String userName;
    private String password;

    @Builder
    public UserLoginRequestDto(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

}
