package com.Mahesh.JobApp.service;

import com.Mahesh.JobApp.entity.User;

import java.util.List;

public interface UserService {
    void createUser(User user);
    User getUserById(Long id);
    boolean updateUser(Long id,User user);
    boolean deleteUser(Long id);
    boolean deleteSkill(Long id, List<String> skill);
    boolean deleteProject(Long id,List<String> project);
    boolean deleteAchievement(Long id,List<String> achievement);
    boolean deleteHobby(Long id,List<String> hobby);
    boolean deleteJob_role(Long id,List<String> job_role);
    boolean deleteJob_location(Long id,List<String> job_location);

}
