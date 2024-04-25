package com.mmc.app.platform.service;

import java.util.List;

import com.mmc.app.platform.model.StaffDetailDto;
import org.springframework.web.multipart.MultipartFile;



public interface StaffDetailService {
	
	List<StaffDetailDto> getAllStaffDetails();
	StaffDetailDto getStaffDetailById(int staffDetailId);
	StaffDetailDto saveUpdateStaffDetails(String detailRequest, MultipartFile document, MultipartFile degreeCertificate);
}
