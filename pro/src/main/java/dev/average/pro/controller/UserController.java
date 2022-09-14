package dev.average.pro.controller;


import dev.average.pro.model.User;
import dev.average.pro.service.concretes.UserManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
                .body( userManager.getUser(id));
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
