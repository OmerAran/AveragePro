package dev.average.pro.controller;

import dev.average.pro.dto.user.RegisterRequestDto;
import dev.average.pro.dto.user.UserDto;
import dev.average.pro.model.User;
import dev.average.pro.service.abstracts.UserService;
import dev.average.pro.service.concretes.UserManager;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/users")
public class UserController {

    private ModelMapper modelMapper;
    private final UserManager userManager;

    @GetMapping()
    public List<UserDto>  getUsers(){
        return userManager.getUsers().stream()
                .map(user -> modelMapper.map(user, UserDto.class))
                .collect(Collectors.toList());

    }

    @GetMapping("{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable Long id){
        User user = userManager.getUser(id);

        UserDto userDto = modelMapper.map(user, UserDto.class);
        return ResponseEntity.ok().body(userDto);
    }


    @PostMapping()
    public ResponseEntity<RegisterRequestDto> newUser(@RequestBody RegisterRequestDto registerRequestDto){
        User userRequest = modelMapper.map(registerRequestDto, User.class);
        User user = userManager.newUser(userRequest);

        RegisterRequestDto userResponse = modelMapper.map(user, RegisterRequestDto.class);
        return new ResponseEntity(userResponse, HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<UserDto>updateUser(@PathVariable Long id , @RequestBody UserDto userDto){
        User requestUser = modelMapper.map(userDto, User.class);
        User user = userManager.updateUser(id,requestUser);
        UserDto responseUser = modelMapper.map(user, UserDto.class);

        return ResponseEntity.ok().body(responseUser) ;
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id){
        userManager.deleteUser(id);
    }

}
