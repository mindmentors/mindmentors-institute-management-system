package com.mmc.app.platform.service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import com.mmc.app.platform.entity.StaffDetail;
import com.mmc.app.platform.model.StaffDetailDto;
import com.mmc.app.platform.model.StaffDetailRequest;
import com.mmc.app.platform.repos.StaffDetailRepository;
import com.mmc.app.platform.utils.ImageSaver;
import com.mmc.app.platform.utils.TDCObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;



@Service
public class StaffDetailServiceImpl implements StaffDetailService {

	private static final Logger LOGGER = LoggerFactory.getLogger(StaffDetailServiceImpl.class);

	@Autowired
	private StaffDetailRepository staffDetailRepository;
	
	@Autowired
	private TDCObjectMapper objectMapper;

	@Autowired
	private ImageSaver imageSaver;

	@Override
	public List<StaffDetailDto> getAllStaffDetails() {
		try {
			List<StaffDetailDto> detailBeansList = null;
			List<StaffDetail> dbDetails = staffDetailRepository.findAll();
			if (!CollectionUtils.isEmpty(dbDetails)) {
				detailBeansList = dbDetails.stream().map(detail -> {

					return objectMapper.mapEntityToDto(detail, StaffDetailDto.class);

				}).collect(Collectors.toList());
			}
			return detailBeansList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public StaffDetailDto getStaffDetailById(int staffDetailId) {
		// TODO Auto-generated method stub
		return objectMapper.mapEntityToDto(staffDetailRepository.findById(staffDetailId).get(), StaffDetailDto.class);
	}

	@Override
	public StaffDetailDto saveUpdateStaffDetails(String detailRequest, MultipartFile document,MultipartFile degreeCertificate) {
		StaffDetailRequest request = objectMapper.mapStringToDto(detailRequest,
				StaffDetailRequest.class);
		StaffDetailDto empDetails = null;
		try {
			String doc = imageSaver.saveImageToStorage(document);
			String degree = imageSaver.saveImageToStorage(degreeCertificate);
			request.setUploadDocument(doc);
			request.setDegreeCertificate(degree);
			// Inorder to map dto to entity pass dto object and entity class to same method
			StaffDetail entity = objectMapper.mapEntityToDto(request, StaffDetail.class);
			StaffDetail staffDetail = staffDetailRepository.save(entity);
			empDetails = objectMapper.mapEntityToDto(staffDetail, StaffDetailDto.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return empDetails;
	}

	
}
