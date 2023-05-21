package com.example.login.Service.impl;

import com.example.login.DTO.EmployeeDTO;
import com.example.login.DTO.LoginDTO;
import com.example.login.Entity.Employee;
import com.example.login.Repo.EmployeeRepo;
import com.example.login.Service.EmployeeService;
import com.example.login.response.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeImpl implements EmployeeService {
    private final EmployeeRepo employeeRepo;

    private final PasswordEncoder passwordEncoder;

    public EmployeeImpl(EmployeeRepo employeeRepo, PasswordEncoder passwordEncoder) {
        this.employeeRepo = employeeRepo;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public String addEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee(

                employeeDTO.getEmployeeid(),
                employeeDTO.getEmployeename(),
                employeeDTO.getEmail(),

                this.passwordEncoder.encode(employeeDTO.getPassword())
        );

        employeeRepo.save(employee);

        return "added: "+employee.getEmployeename();
    }

    @Override
    public LoginResponse loginEmployee(LoginDTO loginDTO) {
        String msg = "";
        Employee employee1 = employeeRepo.findByEmail(loginDTO.getEmail());
        if (employee1 != null) {
            String password = loginDTO.getPassword();
            String encodedPassword = employee1.getPassword();
            Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
            if (isPwdRight) {
                Optional<Employee> employee = employeeRepo.findOneByEmailAndPassword(loginDTO.getEmail(), encodedPassword);
                if (employee.isPresent()) {
                    return new LoginResponse("Login Success", true);
                } else {
                    return new LoginResponse("Login Failed", false);
                }
            } else {

                return new LoginResponse("password Not Match", false);
            }
        }else {
            return new LoginResponse("Email not exits", false);
        }
    }


}
