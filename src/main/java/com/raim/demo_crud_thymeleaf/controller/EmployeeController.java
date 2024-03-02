package com.raim.demo_crud_thymeleaf.controller;

import com.raim.demo_crud_thymeleaf.entity.Employee;
import com.raim.demo_crud_thymeleaf.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/employees")
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }
    @GetMapping("/all")
    public String getAll(Model model){
        //get employees from db
        List<Employee> employeeList = employeeService.findAll();
        //add them to the model
        model.addAttribute("employees",employeeList);
        return "list_employees";
    }
    @GetMapping("/showAddForm")
    public String addEmployee(Model model){
        model.addAttribute("employee",new Employee());
        return "add_employee";
    }
    @GetMapping("/showUpdateForm")
    public String updateEmployee(@RequestParam("employeeId") int id, Model model){
        Employee employee = employeeService.findById(id);
        System.out.println("I AM IN THE METHOD!");
        model.addAttribute("employee",employee);
        return "update_employee";
    }
    @GetMapping("/showDeleteForm")
    public String deleteEmployee(@RequestParam("employeeId") int id){
        employeeService.deleteById(id);
        System.out.println("I AM IN THE DELETE METHOD!");
        return "redirect:/api/employees/all";
    }
    @PostMapping("/save")
    public String addEmployee(@ModelAttribute("employee") Employee employee){
        employeeService.save(employee);
        return "redirect:/api/employees/all";
    }
}
