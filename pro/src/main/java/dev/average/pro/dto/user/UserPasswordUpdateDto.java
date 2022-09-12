package dev.average.pro.dto.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserPasswordUpdateDto {

    private String username;
    private String password;
    private String newPassword;
}
