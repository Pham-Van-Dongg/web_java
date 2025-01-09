package com.phongkhamnhakhoa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phongkhamnhakhoa.model.Bill;
import com.phongkhamnhakhoa.repository.BillRepository;

@Service
public class BillService {

    @Autowired
    private BillRepository billRepository;

    public List<Bill> getAllBills() {
        return billRepository.findAll();
    }

    public void saveBill(Bill bill) {
        billRepository.save(bill);
    }

    public void deleteBillById(Long id) {
        billRepository.deleteById(id);
    }

    public List<Bill> searchBillsByCustomerName(String customerName) {
        return billRepository.findByCustomerNameContainingIgnoreCase(customerName);
    }
}
