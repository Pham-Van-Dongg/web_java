package com.phongkhamnhakhoa.repository;




import org.springframework.data.jpa.repository.JpaRepository;
import com.phongkhamnhakhoa.model.Bills;


public interface BillRepository extends JpaRepository<Bills, Long> {
}
