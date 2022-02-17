package com.coffee.coffee.Controllers;

import com.coffee.coffee.Models.ResponseObject;
import com.coffee.coffee.Models.User;
import com.coffee.coffee.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("list")
    public ResponseEntity<ResponseObject> getListUser(
            @RequestParam(name = "username", required = false) String username,
            @RequestParam(name = "email", required = false) String email,
            @RequestParam(name = "phone", required = false) String phone,
            @RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
            @RequestParam(name = "size", required = false, defaultValue = "5") Integer size,
            @RequestParam(name = "reverse", required = false, defaultValue = "ASC") String reverse,
            @RequestParam(name = "sort", required = false, defaultValue = "email") String sort
    ) {
        Sort sortable = null;
        if (reverse.equals("ASC")) {
            sortable = Sort.by(sort).ascending();
        }
        if (reverse.equals("DESC")) {
            sortable = Sort.by(sort).descending();
        }
        Pageable pageable = PageRequest.of(page,size,sortable);

        List<User> users = userRepository.findAllByUsernameContainsAndEmailContainsAndPhoneContains(username, email, phone,pageable);
        return users.isEmpty()
                ? ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED)
                .body(new ResponseObject(200, "Empty", null))
                : ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseObject(200, "List user", users));

    }


    @GetMapping("/{id}")
    public ResponseEntity<ResponseObject> getUserById(@PathVariable Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.isPresent() ? ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject(200, "success", user))
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponseObject(400, "Cannot find product id=" + id, null));
    }

    @PostMapping("insert")
    public ResponseEntity<ResponseObject> insertUser(@RequestBody User user) {
        List<User> products = userRepository.findByEmail(user.getEmail());
        return products.isEmpty() ? ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseObject(200, "insert user success", userRepository.save(user)))
                : ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED)
                .body(new ResponseObject(400, "User email already taken", ""));
    }

    @PutMapping("update/{id}")
    public ResponseEntity<ResponseObject> updateUser(@RequestBody User newUser, @PathVariable long id) {
        User user = userRepository.findById(id)
                .map(u -> {
                    u.setUsername(newUser.getUsername());
                    u.setEmail(newUser.getEmail());
                    u.setPassword(newUser.getPassword());
                    u.setGender(newUser.getGender());
                    u.setPhone(newUser.getPhone());
                    u.setRole(newUser.getRole());
                    return userRepository.save(u);
                }).orElseGet(() -> {
                    newUser.setId(id);
                    return userRepository.save(newUser);
                });
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject(200, "update user success", user));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseObject> deleteUserById(@PathVariable Long id) {
        boolean exists = userRepository.existsById(id);
        if (exists) {
            userRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject(200, "Delete product success", ""));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseObject(400, "Cannot find user with id =" + id, ""));
    }

}
