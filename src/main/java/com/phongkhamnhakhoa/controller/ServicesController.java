package com.phongkhamnhakhoa.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.phongkhamnhakhoa.model.Services;
import com.phongkhamnhakhoa.service.ServicesService;

@Controller
@RequestMapping("/services")
public class ServicesController {

	@Autowired
	private ServicesService servicesService;

	// Hiển thị danh sách tất cả dịch vụ
	@GetMapping
	public String showListService(Model model) {
		List<Services> listServices = servicesService.getAllServices();
		model.addAttribute("listServices", listServices);
		model.addAttribute("services", new Services());
		return "services"; // Trả về file templates/services.html
	}

	// Xử lý thêm dịch vụ
	@PostMapping("/add")
	public String addServices(@ModelAttribute Services services) {
		servicesService.saveService(services); // Lưu dịch vụ mới vào cơ sở dữ liệu
		return "redirect:/services"; // Quay về trang danh sách dịch vụ
	}

	// Hiển thị form sửa dịch vụ
	@PostMapping("/edit")
	public String editService(@ModelAttribute Services services) {
		servicesService.saveService(services); // Cập nhật dịch vụ
		return "redirect:/services"; // Quay về trang danh sách dịch vụ
	}

	
	// Xóa dịch vụ
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteService(@PathVariable Long id) {
		try {
			servicesService.deleteServiceById(id);
			return ResponseEntity.ok("Xóa dịch vụ thành công!"); // Trả về thông điệp thành công
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Không thể xóa dịch vụ: " + e.getMessage()); // Trả về thông điệp lỗi
		}
	}

	// Tìm kiếm dịch vụ theo tên
	@GetMapping("/search")
	public String searchServices(@RequestParam("name") String name, Model model) {
		List<Services> listServices = servicesService.searchServices(name);
		model.addAttribute("listServices", listServices);
		return "services"; // Trả về file templates/services.html
	}
}
