package com.phongkhamnhakhoa.service;

import com.phongkhamnhakhoa.model.Patients;
import com.phongkhamnhakhoa.model.PatientsDto;
import com.phongkhamnhakhoa.repository.PatientsRepository;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PatientsService {

    @Autowired
    private PatientsRepository patientsRepository;

    // Create - Thêm bệnh nhân mới
    public void saveDto(PatientsDto patientsDto) {
        // Tạo thực thể ngay trong service (chỉ ở mức cục bộ)
        Patients patient = new Patients();
        patient.setFirstName(patientsDto.getFirstName());
        patient.setLastName(patientsDto.getLastName());
        patient.setBirthDate(patientsDto.getBirthDate());
        patient.setPhone(patientsDto.getPhone());
        patient.setEmail(patientsDto.getEmail());
        patient.setAddress(patientsDto.getAddress());

        // Lưu vào database
        patientsRepository.save(patient);
    }

    // Read - Lấy danh sách tất cả bệnh nhân
    public List<Patients> getAllPatients() {
        return patientsRepository.findAll();
    }
    
    
    public Patients updatePatient(PatientsDto patientsDto, Long id) {
        Patients patient = patientsRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Patient not found"));
        
        if (patientsDto.getFirstName() == null) {
            throw new IllegalArgumentException("first name không được để trống");
        }
        if (patientsDto.getLastName() == null) {
            throw new IllegalArgumentException("last name không được để trống");
        }
        if (patientsDto.getBirthDate() == null) {
            throw new IllegalArgumentException("birthday không được để trống");
        }
        if (patientsDto.getPhone() == null) {
            throw new IllegalArgumentException("phone không được để trống");
        }
        if (patientsDto.getEmail() == null) {
            throw new IllegalArgumentException("email không được để trống");
        }
        if (patientsDto.getAddress() == null) {
            throw new IllegalArgumentException("địa chỉ không được để trống");
        }
        // Chuyển đổi từ PatientDto sang Patient và cập nhật
        patient.setFirstName(patientsDto.getFirstName());
        patient.setLastName(patientsDto.getLastName());
        patient.setBirthDate(patientsDto.getBirthDate() != null ? patientsDto.getBirthDate() : new Date());
        patient.setPhone(patientsDto.getPhone());
        patient.setEmail(patientsDto.getEmail());
        patient.setAddress(patientsDto.getAddress());

        return patientsRepository.save(patient);
    }

    

    public void deletePatientById(Long id) {
        if (patientsRepository.existsById(id)) {
            patientsRepository.deleteById(id);
        } else {
            throw new RuntimeException("Patient with ID " + id + " not found");
        }
    }
    
}
