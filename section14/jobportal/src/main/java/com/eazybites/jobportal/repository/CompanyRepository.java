package com.eazybites.jobportal.repository;

import com.eazybites.jobportal.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository// Optional
public interface CompanyRepository extends JpaRepository<Company, Long> {

    //JPQL Queries
    @Query("SELECT DISTINCT c FROM Company c JOIN FETCH c.jobs j WHERE j.status = :status")
    List<Company> findAllWithJobsByStatus(@Param("status") String status);

    //Native SQL Queries = pure sql
    @Query(value = "SELECT DISTINCT c.* FROM companies c JOIN jobs j ON c.id = j.company_id WHERE j.status = ?1",
    nativeQuery = true)
    List<Company> findAllWithJobsByStatusNative(@Param("status") String status);
}
