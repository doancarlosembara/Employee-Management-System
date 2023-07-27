package com.employee.repository;

import com.employee.model.Leave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface LeaveRepository extends JpaRepository<Leave, Long> {


    @Query("from Leave a where a.employee_id = :employeeId")
    public List<Leave> findByEmployeeId(@Param("employeeId") Long employeeId);
}
