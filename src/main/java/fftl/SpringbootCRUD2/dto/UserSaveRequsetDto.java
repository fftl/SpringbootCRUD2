package fftl.SpringbootCRUD2.dto;

import com.sun.istack.NotNull;
import fftl.SpringbootCRUD2.domain.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
public class UserSaveRequsetDto {

        @NotEmpty(message = "빈값은안대!!")
        private String userName;

        @NotEmpty(message = "빈값은안대!!")
        private String password;

        @NotEmpty(message = "빈값은안대!!")
        private String passwordConfirm;

        @NotEmpty(message = "빈값은안대!!")
        private String nickName;

        @NotEmpty(message = "빈값은안대!!")
        private String email;

        @Builder
        public UserSaveRequsetDto(String userName, String password, String nickName, String email) {
            this.userName = userName;
            this.password = password;
            this.nickName = nickName;
            this.email = email;
        }

        public User toEntity(){
            return User.builder()
                    .userName(userName)
                    .password(password)
                    .nickName(nickName)
                    .email(email)
                    .build();
        }



}
