package com.hb.genstionemployes.repository;

import com.hb.genstionemployes.entity.Employe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeRepository extends JpaRepository<Employe, Long> {

}
