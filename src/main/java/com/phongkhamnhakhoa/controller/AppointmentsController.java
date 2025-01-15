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

import com.phongkhamnhakhoa.model.Appointments;
import com.phongkhamnhakhoa.model.Services;
import com.phongkhamnhakhoa.service.AppointmentsService;
import com.phongkhamnhakhoa.service.ServicesService;

@Controller
@RequestMapping("/appointments")
public class AppointmentsController {

	@Autowired
	private AppointmentsService appointmentsService;

	@Autowired
	private ServicesService servicesService;

	@GetMapping
    public String showListAppointmentsAndAddForm(Model model) {
        // Lấy danh sách tất cả các cuộc hẹn
        List<Appointments> listAppointments = appointmentsService.getAllAppointments();
        model.addAttribute("listappointments", listAppointments);

        // Lấy danh sách tất cả các dịch vụ
        List<Services> servicesList = servicesService.getAllServices();
        model.addAttribute("services", servicesList); // Thêm danh sách dịch vụ vào model

        // Thêm đối tượng appointments mới vào model để hiển thị trong form
        model.addAttribute("appointments", new Appointments());

        // Trả về view cho trang chính
        return "appointments"; // Trả về trang danh sách các cuộc hẹn, cùng với modal để thêm mới
    }
	
	
	@GetMapping("/add")
    public String showAddAppointmentForm(Model model) {
        List<Services> servicesList = servicesService.getAllServices(); // Lấy danh sách dịch vụ
        model.addAttribute("services", servicesList);  // Thêm danh sách dịch vụ vào model
        model.addAttribute("appointments", new Appointments());  // Thêm một đối tượng rỗng Appointments vào model
        return "appointments :: addModal";  // Trả về một fragment để hiển thị trong popup
    }
	
	// Xử lý thêm lịch khám
	@PostMapping("/add")
	public String addServices(@ModelAttribute Appointments appointments) {
		appointmentsService.saveAppointments(appointments); // Lưu dịch vụ mới vào cơ sở dữ liệu
		return "redirect:/appointments"; // Quay về trang danh sách dịch vụ
	}

	// Hiển thị form sửa dịch vụ
	@PostMapping("/edit")
	public String editAppointments(@ModelAttribute Appointments appointments) {
		appointmentsService.saveAppointments(appointments); // Cập nhật dịch vụ
		return "redirect:/appointments"; // Quay về trang danh sách dịch vụ
	}

	// Xóa dịch vụ
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteAppointments(@PathVariable Long id) {
		try {
			appointmentsService.deleteAppointmentsById(id);
			return ResponseEntity.ok("Xóa dịch vụ thành công!"); // Trả về thông điệp thành công
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Không thể xóa dịch vụ: " + e.getMessage()); // Trả về thông điệp lỗi
		}
	}

	// Tìm kiếm dịch vụ theo tên
	@GetMapping("/search")
	public ResponseEntity<List<Appointments>> searchAppointments(@RequestParam("name") String name) {
	    List<Appointments> listAppointments = appointmentsService.searchAppointments(name);
	    return ResponseEntity.ok(listAppointments); // Trả về dữ liệu dưới dạng JSON
	}
}
