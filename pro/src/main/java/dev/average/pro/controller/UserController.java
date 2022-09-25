package dev.average.pro.controller;


import dev.average.pro.exception.ResourceNotFoundException;
import dev.average.pro.model.User;
import dev.average.pro.service.concretes.UserManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/users")
public class UserController {

    private final UserManager userManager;


    @GetMapping()
    public List<User>  getUsers(){
        return userManager.getUsers();

    }

    @GetMapping("{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id){

        return ResponseEntity.ok()
                .body(userManager.getUser(id));
    }
    @GetMapping("name/{name}")
    public List<User> getUsersByUsername(@PathVariable String name){
        return  userManager.getUsersByName(name);
    }

    @GetMapping("count/{name}")
    public Integer getCountUsersByName(@PathVariable String name){
        return  userManager.countAllByUsername(name);
    }


    @PostMapping()
    public ResponseEntity<User> newUser(@RequestBody User user){

        return new ResponseEntity(
                userManager.newUser(user), HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<User>updateUser(@PathVariable Long id , @RequestBody User user){


        return ResponseEntity.ok().
                body(userManager.updateUser(id,user)) ;
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id){
        userManager.deleteUser(id);
    }

}
