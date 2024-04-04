package com.Mahesh.JobApp.Impl;

import com.Mahesh.JobApp.entity.User;
import com.Mahesh.JobApp.repository.UserRepository;
import com.Mahesh.JobApp.service.UserService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {

     UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void createUser(User user) {
        userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public boolean updateUser(Long id, User updatedUser) {
        User user=userRepository.findById(id).orElse(null);
        String name=updatedUser.getName();
        String email=updatedUser.getEmail();
        String password=updatedUser.getPassword();
        String gender=updatedUser.getGender();
        String college=updatedUser.getCollege();
        String school=updatedUser.getSchool();
        String perm_address=updatedUser.getPermanent_address();
        String temp_address=updatedUser.getTemp_address();
        List<String> skills=updatedUser.getSkills();
        List<String> projects=updatedUser.getProjects();
        List<String> achievements=updatedUser.getAchievements();
        List<String> hobbies=updatedUser.getHobbies();
        List<String> job_roles=updatedUser.getJob_roles();
        List<String> job_loations=updatedUser.getJob_locations();
        if(user!=null){
            if(name!=null)
                user.setName(name);
            if(email!=null)
                user.setEmail(email);
            if(password!=null)
                user.setPassword(password);
            if(gender!=null)
                user.setGender(gender);
            if(college!=null)
                user.setCollege(college);
            if (school!=null)
                user.setSchool(school);
            if (perm_address!=null)
                user.setPermanent_address(perm_address);
            if(temp_address!=null)
                user.setTemp_address(temp_address);
            if(skills!=null)
                addSkills(user,skills);
            if (projects!=null)
                addProjects(user,projects);
            if (projects!=null)
                addAchievements(user,achievements);
            if (projects!=null)
                addJob_roles(user,job_roles);
            if (projects!=null)
                addJob_locations(user,job_loations);
            if (projects!=null)
                addHobbies(user,hobbies);

            userRepository.save(user);
        }
        return false;
    }



    @Override
    public boolean deleteUser(Long id) {
        boolean flag=userRepository.findById(id).isPresent();
        if(flag)
        {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteSkill(Long id, List<String> skills) {
        User user=userRepository.findById(id).orElse(null);
        if(user!=null && skills!=null){
            for (String temp:skills) {
                if (user.getSkills().contains(temp)) {
                    user.getSkills().remove(temp);
                }
            }
            userRepository.save(user);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteProject(Long id, List<String> project) {
        User user=userRepository.findById(id).orElse(null);
        if(user!=null && project!=null){
            for (String temp:project) {
                if (user.getProjects().contains(temp)) {
                    user.getProjects().remove(temp);
                }
            }
            userRepository.save(user);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteAchievement(Long id, List<String> achievement) {
        User user=userRepository.findById(id).orElse(null);
        if(user!=null && achievement!=null){
            for (String temp:achievement) {
                if (user.getAchievements().contains(temp)) {
                    user.getAchievements().remove(temp);
                }
            }
            userRepository.save(user);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteHobby(Long id, List<String> hobbies) {
        User user=userRepository.findById(id).orElse(null);
        if(user!=null && hobbies!=null){
            for (String temp:hobbies) {
                if (user.getHobbies().contains(temp)) {
                    user.getHobbies().remove(temp);
                }
            }
            userRepository.save(user);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteJob_role(Long id, List<String> job_role) {
        User user=userRepository.findById(id).orElse(null);
        if(user!=null && job_role!=null){
            for (String temp:job_role) {
                if (user.getJob_roles().contains(temp)) {
                    user.getJob_roles().remove(temp);
                }
            }
            userRepository.save(user);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteJob_location(Long id, List<String> job_location) {
        User user=userRepository.findById(id).orElse(null);
        if(user!=null && job_location!=null){
            for (String temp:job_location) {
                if (user.getJob_locations().contains(temp)) {
                    user.getJob_locations().remove(temp);
                }
            }
            userRepository.save(user);
            return true;
        }
        return false;
    }

    private void addSkills(User user,List<String> skills){

        List<String> temp=user.getSkills();
        if(temp==null)
            temp=new ArrayList<>();
        for(String str:skills) {
            if(!temp.contains(str))
                temp.add(str);
        }
        user.setSkills(temp);

    }

    private void addProjects(User user,List<String> project){
        List<String> temp=user.getProjects();
        if(temp==null)
            temp=new ArrayList<>();
        for(String str:project){
            if( !temp.contains(str))
                temp.add(str);

        }
        user.setProjects(temp);
    }

    private void addHobbies(User user, List<String> hobbies) {
        List<String> temp=user.getHobbies();
        if(temp==null)
            temp=new ArrayList<>();
        for(String str:hobbies){
            if(!temp.contains(str))
                temp.add(str);

        }
        user.setHobbies(temp);
    }

    private void addJob_locations(User user, List<String> jobLoations) {
        List<String> temp=user.getJob_locations();
        if(temp==null)
            temp=new ArrayList<>();
        for(String str:jobLoations){
            if(!temp.contains(str))
                temp.add(str);

        }
        user.setJob_locations(temp);
    }

    private void addJob_roles(User user, List<String> jobRoles) {
        List<String> temp=user.getJob_roles();
        if(temp==null)
            temp=new ArrayList<>();
        for(String str:jobRoles){
            if(!temp.contains(str))
                temp.add(str);

        }
        user.setJob_roles(temp);
    }

    private void addAchievements(User user, List<String> achievements) {
        List<String> temp=user.getAchievements();
        if(temp==null)
            temp=new ArrayList<>();
        for(String str:achievements){
            if(!temp.contains(str))
                temp.add(str);

        }
        user.setAchievements(temp);
    }
}
