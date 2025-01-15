package com.phongkhamnhakhoa.service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phongkhamnhakhoa.model.BillDetailsDTO;
import com.phongkhamnhakhoa.model.Bills;
import com.phongkhamnhakhoa.repository.BillsRepository;

@Service
public class BillsService {

    @Autowired 
    private BillsRepository billsRepository;

    public List<Bills> getAllBills() {
        return billsRepository.findAll();
    }

    public List<BillDetailsDTO> getBillDetailsByAppointmentId(String appointmentId) {
        // Lấy dữ liệu từ repository dưới dạng Object[]
        List<Object[]> results = billsRepository.findBillDetailsByAppointmentId(appointmentId);
        List<BillDetailsDTO> billDetailsDTOList = new ArrayList<>();

        // Duyệt qua kết quả trả về
        for (Object[] result : results) {
            Long billId = (Long) result[0];
            String appointmentIdResult = (String) result[1];
            String patientName = (String) result[2];

            // Nếu result[3] là java.sql.Date, bạn có thể lấy nó trực tiếp
            Date appointmentDate = (Date) result[3];
            
            String doctor = (String) result[4];
            String serviceName = (String) result[5];

            // Kiểm tra kiểu của result[6] và chuyển đổi phù hợp
            Object servicePriceObject = result[6];
            BigDecimal servicePrice;
            
            // Nếu giá trị là BigDecimal
            if (servicePriceObject instanceof BigDecimal) {
                servicePrice = (BigDecimal) servicePriceObject;
            } else if (servicePriceObject instanceof Double) {
                // Nếu giá trị là Double, chuyển sang BigDecimal
                servicePrice = BigDecimal.valueOf((Double) servicePriceObject);
            } else {
                // Trường hợp khác, có thể ném lỗi hoặc xử lý tùy ý
                servicePrice = BigDecimal.ZERO; // Hoặc một giá trị mặc định
            }

            // Tạo đối tượng DTO và thêm vào danh sách
            BillDetailsDTO billDetailsDTO = new BillDetailsDTO(billId, appointmentIdResult, patientName, appointmentDate, doctor, serviceName, servicePrice);
            billDetailsDTOList.add(billDetailsDTO);
        }

        return billDetailsDTOList;
    }


    // Các phương thức khác như getAllBills, saveBills, etc.
    public List<Bills> searchBills(String query) {
        return billsRepository.findByAppointmentIdContainingOrPatientNameContaining(query, query);
    }
}
