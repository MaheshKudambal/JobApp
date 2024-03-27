package com.Mahesh.JobApp.Impl;

import com.Mahesh.JobApp.entity.Company;
import com.Mahesh.JobApp.repository.CompanyRepository;
import com.Mahesh.JobApp.service.CompanyService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {

    CompanyRepository companyRepository;


    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;

    }

    @Override
    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    @Override
    public void createCompany(Company company) {
    companyRepository.save(company);
    }

    @Override
    public Company getCompanyById(long id) {

        return companyRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteCompany(long id) {
        boolean flag = companyRepository.findById(id).isPresent();
        if(flag){
            companyRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateCompany(long id, Company updCompany) {
        Optional<Company> companyOptional = companyRepository.findById(id);
        if(companyOptional.isPresent()){
            Company company = companyOptional.get();
            if(updCompany.getName()!=null)
                company.setName(updCompany.getName());
            if(updCompany.getDescription()!=null)
                company.setDescription(updCompany.getDescription());
            if(updCompany.getJobs()!=null)
                company.setJobs(updCompany.getJobs());
            if(updCompany.getReviews()!=null)
                company.setReviews(updCompany.getReviews());
            companyRepository.save(company);
            return true;
        }
        return false;
    }
}
