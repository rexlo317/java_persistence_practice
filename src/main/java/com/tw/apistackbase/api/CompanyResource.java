package com.tw.apistackbase.api;

import com.tw.apistackbase.core.Company;
import com.tw.apistackbase.core.CompanyRepository;
import com.tw.apistackbase.core.Employee;
import com.tw.apistackbase.application.EmployeeService;
import com.tw.apistackbase.core.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/companies")
public class CompanyResource {
    private final Logger log = Logger.getLogger(this.getClass().getName());

    @Autowired
    private CompanyRepository companyRepository;

    @GetMapping(produces = {"application/json"})
    public Iterable<Company> list() {
        return companyRepository.findAll();
    }

    @PostMapping(produces = {"application/json"})
    public void add(@RequestBody Company company) {
        companyRepository.save(company);
    }
}
