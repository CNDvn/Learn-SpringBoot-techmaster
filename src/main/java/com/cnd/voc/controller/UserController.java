package com.cnd.voc.controller;

import com.cnd.voc.entity.User;
import com.cnd.voc.model.dto.UserDto;
import com.cnd.voc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping()
    public ResponseEntity<?> getListUser() {
        List<UserDto> users = userService.getListUser();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable int id) {
        UserDto user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }
    @GetMapping("/search")
    public ResponseEntity<?> getUserById(@RequestParam(value = "name_user", required = false, defaultValue = "") String name) {
        List<UserDto> users = userService.searchUserByName(name);
        return ResponseEntity.ok(users);
    }

    @PostMapping()
    public ResponseEntity<?> createUser(@RequestBody User user) {
        UserDto dto = userService.craeteUser(user);
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@RequestBody User user) {
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser() {
        return null;
    }
}
