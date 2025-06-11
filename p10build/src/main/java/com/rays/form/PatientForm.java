package com.rays.form;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.CartDTO;
import com.rays.dto.PatientDTO;

public class PatientForm  extends BaseForm{
	
	@NotEmpty(message = "Please enter name")
 	private String name;

	@NotEmpty(message = "Please enter decease")
	private String decease;
	
	@NotNull(message = "Please enter mobile")
	private Long mobile;
	
	
	  @NotNull(message = "Please enter visitedate")
	private Date visitedate;


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDecease() {
		return decease;
	}


	public void setDecease(String decease) {
		this.decease = decease;
	}


	public Long getMobile() {
		return mobile;
	}


	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}


	public Date getVisitedate() {
		return visitedate;
	}


	public void setVisitedate(Date visitedate) {
		this.visitedate = visitedate;
	}

	  
	@Override
	public BaseDTO getDto() {
		// SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		PatientDTO dto = initDTO(new PatientDTO());
		 dto.setName(name);
		 
		 
		dto.setVisitedate(visitedate);
		
		dto.setMobile(mobile);
		
		dto.setDecease(decease);
		
	

		return dto;
	}

}
