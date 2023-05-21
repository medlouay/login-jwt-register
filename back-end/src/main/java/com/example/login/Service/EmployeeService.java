package com.example.login.Service;



import com.example.login.DTO.EmployeeDTO;
import com.example.login.DTO.LoginDTO;
import com.example.login.response.LoginResponse;

public interface EmployeeService {
    String addEmployee(EmployeeDTO employeeDTO);
    LoginResponse loginEmployee(LoginDTO loginDTO);



}
