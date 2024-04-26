package com.mmc.app.platform.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
@Getter
@Setter
public class StaffDetailRequest implements Serializable {
	/**
	 * Serial Version Id
	 */
	private static final long serialVersionUID = 5577021807669558622L;

	private Integer staffDetailId;

	private String staffId;

	private String companyName;

	private String experience;

	private String documentDetail;

	private String uploadDocument;
	
	private String qualification;
	
	private String degreeCertificate;

}
