package com.phongkhamnhakhoa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.phongkhamnhakhoa.model.Bill;
import com.phongkhamnhakhoa.service.BillService;

@Controller
@RequestMapping("/bills")
public class BillController {

    @Autowired
    private BillService billService;

    // Hiển thị danh sách tất cả hóa đơn
    @GetMapping
    public String showListBills(Model model) {
        List<Bill> listBills = billService.getAllBills();
        model.addAttribute("listBills", listBills);
        model.addAttribute("bill", new Bill());
        return "bills"; // Trả về file templates/bills.html
    }

    // Xử lý thêm hóa đơn
    @PostMapping("/add")
    public String addBill(@ModelAttribute Bill bill) {
        billService.saveBill(bill); // Lưu hóa đơn mới vào cơ sở dữ liệu
        return "redirect:/bills"; // Quay về trang danh sách hóa đơn
    }

    // Hiển thị form sửa hóa đơn
    @PostMapping("/edit")
    public String editBill(@ModelAttribute Bill bill) {
        billService.saveBill(bill); // Cập nhật hóa đơn
        return "redirect:/bills"; // Quay về trang danh sách hóa đơn
    }

    // Xóa hóa đơn
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteBill(@PathVariable Long id) {
        try {
            billService.deleteBillById(id);
            return ResponseEntity.ok("Xóa hóa đơn thành công!"); // Trả về thông điệp thành công
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Không thể xóa hóa đơn: " + e.getMessage()); // Trả về thông điệp lỗi
        }
    }
}
