package com.mmc.app.platform.service;

import java.util.List;

import com.mmc.app.platform.model.DesigRequest;
import com.mmc.app.platform.exception.TDCServiceException;

public interface DesigService {

	List<DesigRequest> getAllDesigs() throws TDCServiceException;
	DesigRequest getDesigById(int desigId) throws TDCServiceException;
}
