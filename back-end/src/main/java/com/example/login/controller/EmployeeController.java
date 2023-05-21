package com.example.login.controller;

import com.example.login.DTO.EmployeeDTO;
import com.example.login.DTO.LoginDTO;
import com.example.login.Service.EmployeeService;
import com.example.login.response.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping(path = "/save")
    public String saveEmployee(@RequestBody EmployeeDTO employeeDTO){
        String id = employeeService.addEmployee(employeeDTO);
        System.out.println("done adding");
        return id;
    }
    @PostMapping(path = "/login")
    public ResponseEntity<?> loginEmployee(@RequestBody LoginDTO loginDTO){
        LoginResponse loginResponse = employeeService.loginEmployee(loginDTO);
        return ResponseEntity.ok(loginResponse);
    }
}
