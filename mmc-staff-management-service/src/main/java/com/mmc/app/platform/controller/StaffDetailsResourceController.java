package com.mmc.app.platform.controller;

import java.util.List;

import com.mmc.app.platform.exception.ErrorMessage;
import com.mmc.app.platform.exception.TDCServiceException;
import com.mmc.app.platform.model.StaffDetailDto;
import com.mmc.app.platform.model.StaffDetailResponse;
import com.mmc.app.platform.service.StaffDetailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(path = "api")
//, produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
@Tag(name = "StaffDetail", description = "The StaffDetail api")
public class StaffDetailsResourceController {

	@Autowired
	private StaffDetailService staffDetailService;

	private static final Logger LOGGER = LoggerFactory.getLogger(StaffDetailsResourceController.class);

	/**
	 * Get Staff Detail.gokulrajender@gmail.com
	 *
	 * @param staffDetId - to get particular designation
	 * @return the TDC response
	 * @throws TDCServiceException will thrown if anything went wrong
	 */
	@GetMapping("/detail/{staffDetId}")
	@Operation(summary = "Fetch staff detail by id", description = "fetches all staff detail entities and their data from data source by id")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "successful operation") })
	public StaffDetailResponse getStaffDetail(@PathVariable Integer staffDetId) throws TDCServiceException {
		StaffDetailResponse sdResponseDto = new StaffDetailResponse();
		try {
			final StaffDetailDto staffDetResponse = staffDetailService.getStaffDetailById(staffDetId);

			if (staffDetResponse != null) {
				sdResponseDto.setStatusCode("200");
				sdResponseDto.setData(staffDetResponse);
				sdResponseDto.setStatusMessage("Staff Detail value retrieved");
				LOGGER.info("Staff Detail data pulled successfully");
			}

		} catch (Exception ex) {
			sdResponseDto.setStatusCode("404");
			ErrorMessage error = new ErrorMessage();
			error.setErrorCode("404");
			error.setErrorMessage("Not able to fetch designation");
			sdResponseDto.setError(error);
			LOGGER.error("Staff detail list not found ", ex);
			ex.printStackTrace();
		}
		return sdResponseDto;
	}

	/**
	 * Get Staff details.
	 *
	 * @return the Staff details response
	 * @throws TDCServiceException will thrown if anything went wrong
	 */
	@GetMapping("/detail")
	@Operation(summary = "Fetch all Staff details", description = "fetches all staffdetails entities and their data from data source")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "successful operation") })
	public StaffDetailResponse getAllStaffDetails() throws TDCServiceException {
		StaffDetailResponse staffDetailResponse = new StaffDetailResponse();
		try {
			System.out.println("======================="+staffDetailService.getAllStaffDetails());
			final List<StaffDetailDto> staffDetailDto = staffDetailService.getAllStaffDetails();

			if (staffDetailDto != null) {
				staffDetailResponse.setStatusCode("200");
				staffDetailResponse.setDataList(staffDetailDto);
				staffDetailResponse.setStatusMessage("Staff details value retrieved");
				LOGGER.info("Staff details data pulled successfully");
			}

		} catch (Exception ex) {
			staffDetailResponse.setStatusCode("406");
			ErrorMessage error = new ErrorMessage();
			error.setErrorCode("405");
			error.setErrorMessage("Not able to fetch designation records");
			staffDetailResponse.setError(error);
			LOGGER.error("Designation list not found", ex);
		}
		return staffDetailResponse;
	}

	/**
	 * Save Staff employment details.
	 *
	 * @return the Staff details response
	 * @throws TDCServiceException will thrown if anything went wrong
	 */
	@PostMapping(value = "/detail", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@Operation(summary = "Persist Staff details", description = "persist staffdetails entities and their data to database")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "successful operation") })
	public StaffDetailResponse persistStaffDetails(
			@RequestParam(name = "document", required = false) MultipartFile document,
			@RequestParam(name = "document", required = false) MultipartFile degreeCertificate,
			@RequestParam String detailRequest) throws TDCServiceException {
		LOGGER.info("The incoming request is: {}", detailRequest);

		StaffDetailResponse staffDetailResponse = new StaffDetailResponse();
		try {
			final StaffDetailDto staffDetailDto = staffDetailService.saveUpdateStaffDetails(detailRequest, document,
					degreeCertificate);
			staffDetailResponse.setStatusCode("200");
			staffDetailResponse.setData(staffDetailDto);
			staffDetailResponse.setStatusMessage("Staff details value retrieved");

		} catch (Exception ex) {

			ErrorMessage error = new ErrorMessage();
			error.setErrorCode("500");
			error.setErrorMessage("Not able to save");
			staffDetailResponse.setError(error);
			LOGGER.error("StaffDetail not saved {}", ex);
		}
		return staffDetailResponse;
	}

}
