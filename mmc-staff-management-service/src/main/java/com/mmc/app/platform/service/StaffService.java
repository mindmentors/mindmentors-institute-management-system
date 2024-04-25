package com.mmc.app.platform.service;

import java.util.List;

import com.mmc.app.platform.model.StaffRequest;


public interface StaffService {

	StaffRequest saveUpdateStaff(StaffRequest staffDto);
	List<StaffRequest> deleteStaff(int staffId);
	StaffRequest getStaffById(int staffId);
	List<StaffRequest> getAllStaffs();
	List<StaffRequest> findAllStaffsOfADesig(int desigId);
	
}
