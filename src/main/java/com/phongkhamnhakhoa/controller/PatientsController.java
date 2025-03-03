package com.phongkhamnhakhoa.controller;

import com.phongkhamnhakhoa.model.Patients;
import com.phongkhamnhakhoa.model.PatientsDto;
import com.phongkhamnhakhoa.repository.PatientsRepository;
import com.phongkhamnhakhoa.service.PatientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/patients")
public class PatientsController {

	@Autowired
	private PatientsRepository repo;

	@Autowired
	private PatientsService patientsService;

	@GetMapping("/list")
	public String showpatients(Model model) {
		List<Patients> patients = repo.findAll(Sort.by(Sort.Direction.ASC, "id"));
		if (patients.isEmpty()) {
			model.addAttribute("message", "No patients found");
		} else {
			model.addAttribute("patients", patients);
		}
		model.addAttribute("patients1", new PatientsDto());
		return "patients/form_patients";
	}

	@PostMapping("/save")
	public String createPatient(@ModelAttribute("patients1") PatientsDto patientsDto, Model model) {
		// Kiểm tra dữ liệu từ form
		if (patientsDto == null || patientsDto.getName_id() == null) {
			model.addAttribute("message", "Không có dữ liệu");
			return "patients/form_patients";
		}

		try {
			// Lưu DTO trực tiếp bằng service
			patientsService.saveDto(patientsDto);

			// Thêm thông báo thành công
			model.addAttribute("message", "Patient saved successfully");
			return "redirect:/patients";
		} catch (Exception e) {
			// Xử lý lỗi khi lưu
			model.addAttribute("message", "Error saving patient: " + e.getMessage());
			return "patients/form_patients";
		}
	}

	@PostMapping("/update/{id}")
	public String updatePatient(@PathVariable Long id, @ModelAttribute PatientsDto patientsDto) {

		try {
			// Gọi service để cập nhật thông tin bệnh nhân
			patientsService.updatePatient(patientsDto, id);
			// Trả về thông báo thành công
			return "redirect:/patients";
		} catch (Exception e) {
			// Trả về thông báo lỗi nếu có
			return "redirect:/patients";
		}
	}

	@PostMapping("/delete/{id}")
	public String deletePatient(@PathVariable Long id) {
		try {
			patientsService.deletePatientById(id);
			return "redirect:/patients";
		} catch (RuntimeException e) {
			return "redirect:/patients";
		}
	}

	// Tìm kiếm bệnh nhân theo tên
	@GetMapping("")
	public String searchPatients(@RequestParam(value = "keyword", required = false, defaultValue = "") String keyword,
	        @RequestParam(value = "page", required = false, defaultValue = "0") int page,
	        @RequestParam(value = "size", required = false, defaultValue = "10") int size, Model model) {
	    Pageable pageable = PageRequest.of(page, size);
	    Page<Patients> patientsPage = patientsService.searchPatients(keyword, pageable);

	    model.addAttribute("patients", patientsPage.getContent());
	    model.addAttribute("currentPage", page);
	    model.addAttribute("totalPages", patientsPage.getTotalPages());
	    model.addAttribute("keyword", keyword);

	    return "patients/form_patients"; 
	}

}
