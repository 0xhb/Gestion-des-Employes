package com.hb.genstionemployes.service;

import com.hb.genstionemployes.entity.Employe;
import com.hb.genstionemployes.repository.EmployeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeService {
    private final EmployeRepository employeRepository;
    
    @Autowired
    public EmployeService(EmployeRepository employeRepository) {
        this.employeRepository = employeRepository;
    }
    
    public ResponseEntity<Employe> addEmploye(Employe employe){
        try {
            Employe newEmploye = employeRepository.save(employe);
            return new ResponseEntity<>(newEmploye, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    public ResponseEntity<Employe> getEmploye(long id){
        try {
            Employe employe = employeRepository.findById(id).get();
            return new ResponseEntity<>(employe, HttpStatus.FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    
    public ResponseEntity<List<Employe>> getAllEmployes(){
        try {
            List<Employe> employeList = employeRepository.findAll();
            return new ResponseEntity<>(employeList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    public ResponseEntity<Employe> updateEmploye(long id, Employe employe){
        try {
            Employe targetEmploye = employeRepository.findById(id).get();
            targetEmploye.setName(employe.getName());
            targetEmploye.setEmail(employe.getEmail());
            targetEmploye.setPhone(employe.getPhone());
            targetEmploye.setDepartment(employe.getDepartment());

            employeRepository.save(targetEmploye);

            return new ResponseEntity<>(targetEmploye, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<String> deleteEmploye(long id){
        try {
            employeRepository.deleteById(id);
            return new ResponseEntity<>("the user was deleted successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("An error was encountered", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
