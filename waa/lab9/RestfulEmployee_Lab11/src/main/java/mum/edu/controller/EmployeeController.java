package mum.edu.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import mum.edu.domain.Employee;
 
@RestController
public class EmployeeController {

    @RequestMapping(value = "/addEmp",method = RequestMethod.POST)
    public Employee addEmp(@Valid @RequestBody Employee employee){
        System.out.println(employee);
        return employee;
    }
	
 
	
	
}
