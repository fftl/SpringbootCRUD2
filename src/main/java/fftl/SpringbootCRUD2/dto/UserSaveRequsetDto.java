package fftl.SpringbootCRUD2.dto;

import fftl.SpringbootCRUD2.domain.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserSaveRequsetDto {

        private String userName;
        private String password;
        private String nickName;
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
