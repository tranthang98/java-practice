package vn.thangjava.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import vn.thangjava.dto.request.UserRequestDTO;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @PostMapping(value = "/", headers = {"apiKey=v1.0"})
    public String addUser(@RequestBody UserRequestDTO userDTO) {
        return "User added";
    }

    @PutMapping("/{userId}")
    public String updateUser(@PathVariable("userId") int id, @RequestBody UserRequestDTO userDTO) {
        System.out.println("Request update userId = " + id);
        return "User updated";
    }

    @PatchMapping("/{userId}")
    public String changeStatus(@PathVariable int userId, @RequestParam boolean status) {
        System.out.println("Request change user status, userId = " + userId);
        return "User status changed";
    }

    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable int userId) {
        System.out.println("Request delete user, userId = " + userId);
        return "User deleted";
    }

    @GetMapping("/{userId}")
    public String getUser(@PathVariable int userId) {
        System.out.println("Request get user, userId = " + userId);
        return new UserRequestDTO("thangjava", "thang", "123456789", "thangjava@vn.com").getFirstName();
    }

    @GetMapping("/list")
    public List<UserRequestDTO> getAllUser(
            @RequestParam(required = false ) String email,
            @RequestParam(defaultValue = "0") int pageNo,
            @RequestParam(defaultValue = "10") int pageSize) {
        System.out.println("Request get all user");
        return List.of(new UserRequestDTO("thangjava", "thang", "123456789", "thangjava@vn.com"),
                new UserRequestDTO("thangjava", "thang", "123456789", "thangjava@vn.com"));
    }
}
