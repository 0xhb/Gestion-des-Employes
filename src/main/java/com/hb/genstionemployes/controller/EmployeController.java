package com.hb.genstionemployes.controller;

import com.hb.genstionemployes.entity.Employe;
import com.hb.genstionemployes.service.EmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employee")
public class EmployeController {
    private final EmployeService employeService;

    @Autowired
    public EmployeController(EmployeService employeService) {
        this.employeService = employeService;
    }

    @PostMapping("/register")
    public ResponseEntity<Employe> add(@RequestBody Employe employe){
        return employeService.addEmploye(employe);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employe> getEmploye(@PathVariable int id){
        return employeService.getEmploye(id);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Employe> updateEmploye(@PathVariable int id, @RequestBody Employe employe){
        return employeService.updateEmploye(id, employe);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteEmploye(@PathVariable int id){
        return employeService.deleteEmploye(id);
    }
}
