package dev.average.pro.dto.user;

import dev.average.pro.model.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class UserDto {

    private String username;
    private String email;
    private Set<Role> roles = new HashSet<>();

}
