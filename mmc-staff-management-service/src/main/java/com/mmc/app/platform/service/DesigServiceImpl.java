package com.mmc.app.platform.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.mmc.app.platform.entity.Desig;
import com.mmc.app.platform.exception.TDCServiceException;
import com.mmc.app.platform.model.DesigRequest;
import com.mmc.app.platform.repos.DesigRepository;
import com.mmc.app.platform.utils.TDCObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;



@Service
public class DesigServiceImpl implements DesigService {

	@Autowired
	private DesigRepository desigRepository;

	@Autowired
	private TDCObjectMapper objectMapper;

	@Override
	public List<DesigRequest> getAllDesigs() throws TDCServiceException {
		System.out.println("getAllDesigs");
		System.out.println("desigRepository.findAll() "+desigRepository.findAll());
		List<DesigRequest> desigBeansList = null;
		Optional<List<Desig>> dbDesignations = Optional.ofNullable(desigRepository.findAll());
		System.out.println("getAllDesigs");
		List<Desig> desigs=dbDesignations.get();
		if (!CollectionUtils.isEmpty(desigs)) {
			desigBeansList = desigs.stream().map(desig -> {

				return objectMapper.mapEntityToDto(desig, DesigRequest.class);

			}).collect(Collectors.toList());
		}
		return desigBeansList;
	}

	@Override
	public DesigRequest getDesigById(int desigId) throws TDCServiceException {
		// TODO Auto-generated method stub
		Optional<Desig> desig=Optional.ofNullable(desigRepository.findById(desigId).get());
		return objectMapper.mapEntityToDto(desig, DesigRequest.class);
	}

}
