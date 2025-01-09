package com.phongkhamnhakhoa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.phongkhamnhakhoa.model.Bill;

@Repository
public interface BillRepository extends JpaRepository<Bill, Long> {
    List<Bill> findByCustomerNameContainingIgnoreCase(String customerName);
}
