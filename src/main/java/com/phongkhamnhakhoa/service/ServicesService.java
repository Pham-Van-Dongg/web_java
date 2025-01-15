package com.phongkhamnhakhoa.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.phongkhamnhakhoa.model.Services;
import com.phongkhamnhakhoa.repository.ServicesRepository;

@Service
public class ServicesService {
    @Autowired
    private ServicesRepository servicesRepository;

    public List<Services> getAllServices() {
        return servicesRepository.findAll();
    }

    public Services getServiceById(Long id) {
        return servicesRepository.findById(id).orElse(null);
    }

    public Services saveService(Services services) {
        return servicesRepository.save(services);
    }
    
    public void deleteServiceById(Long id) {
        if (servicesRepository.existsById(id)) {
            servicesRepository.deleteById(id);
        } else {
            throw new RuntimeException("Service with ID " + id + " not found");
        }
    }
    public List<Services> searchServices(String name) {
        return servicesRepository.findByNameContaining(name);
    }
    public List<Services> getAllServices(int page, int size) {
        Pageable pageable = PageRequest.of(page - 1, size);
        return servicesRepository.findAll(pageable).getContent();
    }

    public long count() {
        return servicesRepository.count();
    }
}
