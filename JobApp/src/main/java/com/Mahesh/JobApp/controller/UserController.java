package com.Mahesh.JobApp.controller;

import com.Mahesh.JobApp.entity.User;
import com.Mahesh.JobApp.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id){
        User user=userService.getUserById(id);
        if(user!=null)
            return new ResponseEntity<>(user, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping()
    public ResponseEntity<String> createUser(@RequestBody User user){
        try{
            userService.createUser(user);
            return new ResponseEntity<>("User Created Successfully",HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>("Something Went Wrong",HttpStatus.NOT_ACCEPTABLE);
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@PathVariable Long id,@RequestBody User user) {
        try {
            userService.updateUser(id, user);
            return new ResponseEntity<>("User Updated Successfully",HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(e.toString(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id){
        boolean flag=userService.deleteUser(id);
        if(flag)
            return new ResponseEntity<>("User Deleted Successfully",HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}/skills")
    public ResponseEntity<String> deleteSkills(@PathVariable Long id,@RequestBody List<String> skills){
        boolean flag=userService.deleteSkill(id,skills);
        if(flag)
            return new ResponseEntity<>("Skills Removed Successfully",HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/{id}/projects")
    public ResponseEntity<String> deleteProjects(@PathVariable Long id,@RequestBody List<String> projects){
        boolean flag=userService.deleteProject(id,projects);
        if(flag)
            return new ResponseEntity<>("Skills Removed Successfully",HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/{id}/achievements")
    public ResponseEntity<String> deleteAchievements(@PathVariable Long id,@RequestBody List<String> achievements){
        boolean flag=userService.deleteAchievement(id,achievements);
        if(flag)
            return new ResponseEntity<>("Skills Removed Successfully",HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/{id}/hobbies")
    public ResponseEntity<String> deleteHobbies(@PathVariable Long id,@RequestBody List<String> hobbies){
        boolean flag=userService.deleteHobby(id,hobbies);
        if(flag)
            return new ResponseEntity<>("Skills Removed Successfully",HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/{id}/job_role")
    public ResponseEntity<String> deleteJob_Role(@PathVariable Long id,@RequestBody List<String> job_role){
        boolean flag=userService.deleteJob_role(id,job_role);
        if(flag)
            return new ResponseEntity<>("Skills Removed Successfully",HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}/job_location")
    public ResponseEntity<String> deleteJob_Location(@PathVariable Long id,@RequestBody List<String> job_location){
        boolean flag=userService.deleteSkill(id,job_location);
        if(flag)
            return new ResponseEntity<>("Skills Removed Successfully",HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}
