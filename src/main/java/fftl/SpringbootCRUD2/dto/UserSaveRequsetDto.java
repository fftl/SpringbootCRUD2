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

        private String username;
        private String password;
        private String nickname;
        private String email;

        @Builder
        public UserSaveRequsetDto(String username, String password, String nickname, String email) {
            this.username = username;
            this.password = password;
            this.nickname = nickname;
            this.email = email;
        }

        public User toEntity(){
            return User.builder()
                    .username(username)
                    .password(password)
                    .nickname(nickname)
                    .email(email)
                    .build();
        }



}