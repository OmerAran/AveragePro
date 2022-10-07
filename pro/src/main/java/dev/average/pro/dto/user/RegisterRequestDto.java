package dev.average.pro.dto.user;

import dev.average.pro.model.Role;
import lombok.*;

import java.util.HashSet;
import java.util.Set;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RegisterRequestDto {

    private String username;
    private String email;
    private String password;
    private Set<Role> roles = new HashSet<>();


}
