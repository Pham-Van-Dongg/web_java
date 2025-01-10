package com.phongkhamnhakhoa.controller;

import com.phongkhamnhakhoa.model.Bills;
import com.phongkhamnhakhoa.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/bills")
public class BillController {

    @Autowired
    private BillService billService;

    // Hiển thị danh sách tất cả hóa đơn
    @GetMapping
    public String showAllBills(Model model) {
        List<Bills> bills = billService.getAllBills();
        model.addAttribute("bills", bills);
        model.addAttribute("bill", new Bills()); // Đối tượng Bill mới cho form thêm
        return "bills"; // Trả về file templates/bills.html
    }

    // Thêm hóa đơn mới
    @PostMapping("/add")
    public String createBill(@ModelAttribute Bills bill) {
        billService.createBill(bill); // Lưu hóa đơn mới vào cơ sở dữ liệu
        return "redirect:/bills"; // Quay về trang danh sách hóa đơn
    }

    // Cập nhật hóa đơn
    @PostMapping("/edit/{id}")
    public String updateBill(@PathVariable Long id, @ModelAttribute Bills updatedBill) {
        billService.updateBill(id, updatedBill); // Cập nhật hóa đơn
        return "redirect:/bills"; // Quay về trang danh sách hóa đơn
    }

    // Xóa hóa đơn
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteBill(@PathVariable Long id) {
        try {
            billService.deleteBill(id); // Xóa hóa đơn theo ID
            return ResponseEntity.ok("Xóa hóa đơn thành công!"); // Trả về thông điệp thành công
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Không thể xóa hóa đơn: " + e.getMessage()); // Trả về thông điệp lỗi
        }
    }
}