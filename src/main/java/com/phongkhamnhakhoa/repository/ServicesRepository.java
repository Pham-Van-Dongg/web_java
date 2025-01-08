package com.phongkhamnhakhoa.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.phongkhamnhakhoa.model.Services;

@Repository
public interface ServicesRepository extends JpaRepository<Services, Long> {
    List<Services> findByNameContaining(String name);
}