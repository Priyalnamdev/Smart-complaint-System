package com.example.ComplaintPortal.Controller;


import com.example.ComplaintPortal.Entity.User;
import com.example.ComplaintPortal.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class UserController {
    @Autowired
    private UserRepository repo;

//    post

    @PostMapping
    public User insertData(@RequestBody User user){
        return repo.save(user);
    }

    @GetMapping
    public List<User> allUser(){
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable int id){
        return repo.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable int id){
        User exist = repo.findById(id).orElse(null);
        if(exist != null){
            repo.deleteById(id);
            return "user is deleted";
        }else{
            return "user is not found";
        }
    }

    @PatchMapping("/{id}")
    public User patchData(@PathVariable int id , @RequestBody User user){
        User exist = repo.findById(id).orElse(null);
        if(exist != null){
            if(user.getNo() != 0){
                exist.setNo(user.getNo());
            }
            if(user.getDis() != null){
                exist.setDis(user.getDis());
            }
            repo.save(exist);
        }
        return null;
    }
}
