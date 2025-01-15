package com.phongkhamnhakhoa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.phongkhamnhakhoa.model.BillDetailsDTO;
import com.phongkhamnhakhoa.model.Bills;
import com.phongkhamnhakhoa.service.BillsService;

@Controller
@RequestMapping("/bills")
public class BillsController {

    @Autowired
    private BillsService billsService;
    
    @GetMapping("")
	public String showListService(Model model) {
		List<Bills> listBills = billsService.getAllBills();
		model.addAttribute("listBills", listBills);
		model.addAttribute("bills", new Bills());
		return "bills"; // Trả về file templates/services.html
	}

    // Xử lý lấy thông tin chi tiết hóa đơn theo appointmentId
    @GetMapping("/{appointmentId}")
    public ResponseEntity<List<BillDetailsDTO>> getBillDetails(@PathVariable("appointmentId") String appointmentId) {
        List<BillDetailsDTO> billDetails = billsService.getBillDetailsByAppointmentId(appointmentId);
        
        // Kiểm tra nếu không có dữ liệu trả về
        if (billDetails.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        
        return ResponseEntity.ok(billDetails);
    }
    @GetMapping("/search")
    public ResponseEntity<List<Bills>> searchBills(@RequestParam("query") String query) {
        List<Bills> bills = billsService.searchBills(query);
        return ResponseEntity.ok(bills);
    }
}
