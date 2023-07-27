package com.employee.repository;

import com.employee.model.Leave;
import com.employee.model.Lookup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LookupRepository extends JpaRepository<Lookup, Long> {
    @Query("from Lookup a where a.group_name = :GroupName")
    public List<Lookup> findAllLookup(@Param("GroupName") String group_name);
}
