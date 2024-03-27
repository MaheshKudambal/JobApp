package com.Mahesh.JobApp.controller;

import com.Mahesh.JobApp.entity.Company;
import com.Mahesh.JobApp.service.CompanyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    private CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public ResponseEntity<List<Company>> findAll(){
        return new ResponseEntity<>(companyService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> getCompanyById(@PathVariable long id){
        Company cmp = companyService.getCompanyById(id);
            if(cmp!=null) {
                return new ResponseEntity<>(cmp, HttpStatus.OK);
            }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<String> saveCompany(@RequestBody Company cmp){
        companyService.createCompany(cmp);
        return new ResponseEntity<>("Company Added Succesfully",HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCompany(@PathVariable long id){
        boolean flag = companyService.deleteCompany(id);
        if(flag)
            return new ResponseEntity<>("Company Deleted Successfully",HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCompany(@PathVariable long id,@RequestBody Company cmp){
        boolean flag = companyService.updateCompany(id,cmp);
        if(flag)
            return  new ResponseEntity<>("Company Updated Successfully",HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

}
