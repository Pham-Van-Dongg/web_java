package com.phongkhamnhakhoa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phongkhamnhakhoa.model.Appointments;
import com.phongkhamnhakhoa.repository.AppointmentsRepository;

@Service
public class AppointmentsService {

	@Autowired
    private AppointmentsRepository appointmentsRepository;

    public List<Appointments> getAllAppointments() {
        return appointmentsRepository.findAll();
    }

    public Appointments getAppointmentsById(Long id) {
        return appointmentsRepository.findById(id).orElse(null);
    }

    public Appointments saveAppointments(Appointments appointments) {
        return appointmentsRepository.save(appointments);
    }
    
    public void deleteAppointmentsById(Long id) {
        if (appointmentsRepository.existsById(id)) {
        	appointmentsRepository.deleteById(id);
        } else {
            throw new RuntimeException("Service with ID " + id + " not found");
        }
    }
    public List<Appointments> searchAppointments(String name) {
        return appointmentsRepository.findByNameContaining(name);
    }
}
