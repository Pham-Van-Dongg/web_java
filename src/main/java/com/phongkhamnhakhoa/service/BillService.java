package com.phongkhamnhakhoa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phongkhamnhakhoa.model.Bills;
import com.phongkhamnhakhoa.repository.BillRepository;

@Service
public class BillService {

    @Autowired
    private BillRepository billRepository;

    public List<Bills> getAllBills() {
        return billRepository.findAll();
    }

    public Optional<Bills> getBillById(Long id) {
        return billRepository.findById(id);
    }

    public Bills createBill(Bills bill) {
        return billRepository.save(bill);
    }

    public Bills updateBill(Long id, Bills updatedBill) {
        return billRepository.findById(id).map(bill -> {
            bill.setAppointmentId(updatedBill.getAppointmentId());
            bill.setTotalAmount(updatedBill.getTotalAmount());
            return billRepository.save(bill);
        }).orElseThrow(() -> new RuntimeException("Bill not found with id " + id));
    }

    public void deleteBill(Long id) {
        billRepository.deleteById(id);
    }
}