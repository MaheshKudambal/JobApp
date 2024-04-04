package com.Mahesh.JobApp.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    private String gender;
    private String college;
    private String school;
    private String permanent_address;
    private String temp_address;
    private List<String> skills;
    private List<String> projects;
    private List<String> achievements;
    private List<String> hobbies;
    private List<String> job_roles;
    private List<String> job_locations;

    public User() {
    }

    public User(Long id, String name, String email, String password,
                String gender, String college, String school, String permanent_address,
                String temp_address, List<String> skills, List<String> projects,
                List<String> achievements, List<String> hobbies, List<String> job_roles,
                List<String> job_locations) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.college = college;
        this.school = school;
        this.permanent_address = permanent_address;
        this.temp_address = temp_address;
        this.skills = skills;
        this.projects = projects;
        this.achievements = achievements;
        this.hobbies = hobbies;
        this.job_roles = job_roles;
        this.job_locations = job_locations;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getPermanent_address() {
        return permanent_address;
    }

    public void setPermanent_address(String permanent_address) {
        this.permanent_address = permanent_address;
    }

    public String getTemp_address() {
        return temp_address;
    }

    public void setTemp_address(String temp_address) {
        this.temp_address = temp_address;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public List<String> getProjects() {
        return projects;
    }

    public void setProjects(List<String> projects) {
        this.projects = projects;
    }

    public List<String> getAchievements() {
        return achievements;
    }

    public void setAchievements(List<String> achievements) {
        this.achievements = achievements;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    public List<String> getJob_roles() {
        return job_roles;
    }

    public void setJob_roles(List<String> job_roles) {
        this.job_roles = job_roles;
    }

    public List<String> getJob_locations() {
        return job_locations;
    }

    public void setJob_locations(List<String> job_locations) {
        this.job_locations = job_locations;
    }
}
